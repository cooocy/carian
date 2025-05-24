package er.carian.cache;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LazyHashMapTest {

    @Test
    void testPermanentlyPutAndGet() {
        LazyHashMap<String, String> lazyHashMap = new LazyHashMap<>();
        lazyHashMap.put("name", "foo");
        String value = lazyHashMap.get("name");
        assertEquals("foo", value);
        assertNull(lazyHashMap.get("age"));
    }

    @Test
    void testTemporaryPutAndGet() {
        LazyHashMap<String, String> lazyHashMap = new LazyHashMap<>();
        lazyHashMap.put("name", "foo", 2, TimeUnit.SECONDS);

        String v1 = lazyHashMap.get("name");
        assertEquals("foo", v1);

        // Wait for the key to expire
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            fail("Test interrupted during sleep.");
        }

        String v2 = lazyHashMap.get("name");
        assertNull(v2);
    }

    @Test
    void testRemove() {
        LazyHashMap<String, String> lazyHashMap = new LazyHashMap<>();
        lazyHashMap.put("name", "foo");

        assertEquals("foo", lazyHashMap.get("name"));

        lazyHashMap.remove("name");
        assertNull(lazyHashMap.get("name"));
    }

}