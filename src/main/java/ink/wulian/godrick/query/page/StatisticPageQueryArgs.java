package ink.wulian.godrick.query.page;

import ink.wulian.godrick.query.Order;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * statistic page 分页查询参数.
 */
public class StatisticPageQueryArgs {

    /**
     * 第几页
     * [1, +∞]
     */
    public long page;

    /**
     * 每页几条
     * [1, 501]
     */
    public int limit;

    /**
     * 若 order 为 null, 由 Repository.impl 决定默认顺序.
     */
    @Nullable
    public final Order order;

    public StatisticPageQueryArgs(long page, int limit) {
        this.page = page;
        this.limit = limit;
        this.order = null;
    }

    public StatisticPageQueryArgs(long page, int limit, @Nonnull Order order) {
        this.page = page;
        this.limit = limit;
        this.order = order;
    }

}
