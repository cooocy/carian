package ink.wulian.godrick.query.page;

import ink.wulian.godrick.query.Order;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * marker page 分页查询参数.
 */
public class MarkerPageQueryArgs<M> {

    /**
     * [1, 501]
     */
    public int limit;

    /**
     * id offset 标记.
     * 若 order = asc, where id >= idMarker;
     * 若 order = desc, where id <= idMarker;
     * 若 order = null, 由 Repository.impl 决定默认顺序.
     *
     * @see Order
     */
    @Nullable
    public final M idMarker;

    /**
     * 若 order 为 null, 由 Repository.impl 决定默认顺序.
     */
    @Nullable
    public final Order order;

    /**
     * @param limit 不在范围内的, 会被强制赋值到 [1, 501]
     */
    public MarkerPageQueryArgs(int limit) {
        this.limit = limit;
        this.idMarker = null;
        this.order = null;
    }

    /**
     * @param limit    不在范围内的, 会被强制赋值到 [1, 501]
     * @param idMarker x
     */
    public MarkerPageQueryArgs(int limit, @Nonnull M idMarker) {
        this.limit = limit;
        this.idMarker = idMarker;
        this.order = null;
    }

    /**
     * @param limit 不在范围内的, 会被强制赋值到 [1, 501]
     * @param order x
     */
    public MarkerPageQueryArgs(int limit, @Nonnull Order order) {
        this.limit = limit;
        this.idMarker = null;
        this.order = order;
    }

    /**
     * @param limit    不在范围内的, 会被强制赋值到 [1, 501]
     * @param idMarker x
     * @param order    x
     */
    public MarkerPageQueryArgs(int limit, @Nonnull M idMarker, @Nonnull Order order) {
        this.limit = limit;
        this.idMarker = idMarker;
        this.order = order;
    }

}
