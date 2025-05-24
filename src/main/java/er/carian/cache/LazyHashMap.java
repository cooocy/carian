package er.carian.cache;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * A lazy hash map that allows for temporary storage of key-value pairs with expiration.
 * Keys can be set to expire after a specified duration.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class LazyHashMap<K, V> {

    private final HashMap<K, V> map;

    private final HashMap<K, Long> key2expirationMs;

    /**
     * Constructs a new LazyHashMap with empty maps for storing key-value pairs and their expiration times.
     */
    public LazyHashMap() {
        this.map = new HashMap<>();
        this.key2expirationMs = new HashMap<>();
    }

    /**
     * Puts a key-value pair into the map without expiration.
     *
     * @param key   the key to be added
     * @param value the value to be associated with the key
     */
    public void put(K key, V value) {
        map.put(key, value);
    }

    /**
     * Puts a key-value pair into the map with a specified expiration time.
     *
     * @param key      the key to be added
     * @param value    the value to be associated with the key
     * @param expire   the duration after which the key should expire
     * @param timeUnit the time unit of the expiration duration
     */
    public void put(K key, V value, int expire, TimeUnit timeUnit) {
        long expirationMs = System.currentTimeMillis() + timeUnit.toMillis(expire);
        key2expirationMs.put(key, expirationMs);
        map.put(key, value);
    }

    /**
     * Retrieves the value associated with the specified key.
     * If the key has expired or not found, returns null.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the key, or null if the key does not exist or has expired
     */
    @Nullable
    public V get(K key) {
        V v = map.get(key);
        if (Objects.isNull(v)) {
            key2expirationMs.remove(key);
            return null;
        }
        Long expirationMs = key2expirationMs.get(key);
        if (Objects.isNull(expirationMs)) {
            return v;
        }
        long current = System.currentTimeMillis();
        if (current > expirationMs) {
            key2expirationMs.remove(key);
            map.remove(key);
            return null;
        }
        return v;
    }

    public void remove(K key) {
        map.remove(key);
        key2expirationMs.remove(key);
    }

}
