package er.carian.query.page;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * statistic page 分页查询结果.
 */
public class StatisticPager<R> {

    public final List<R> records;

    /**
     * 第几页
     */
    public final long page;

    /**
     * 每页几条
     */
    public final long limit;

    /**
     * 总条数
     */
    public final long totalCnt;

    /**
     * 总页数
     */
    public final long totalPage;

    /**
     * @param records  数据
     * @param page     第几页
     * @param limit    每页几条
     * @param totalCnt 总条数
     */
    public StatisticPager(@Nonnull List<R> records, long page, long limit, long totalCnt) {
        this.records = records;
        this.page = page;
        this.limit = limit;
        this.totalCnt = totalCnt;
        this.totalPage = (totalCnt + limit - 1) / limit;
    }

    /**
     * @param records   数据
     * @param queryArgs 原始查询参数
     * @param totalCnt  总条数
     */
    public StatisticPager(@Nonnull List<R> records, @Nonnull StatisticPageQueryArgs queryArgs, long totalCnt) {
        this(records, queryArgs.page, queryArgs.limit, totalCnt);
    }

    /**
     * 使用 originalPager 的分页字段和 newRecords 组装成一个新的 pager.
     *
     * @param originalPager 原分页结果
     * @param newRecords    新 records
     */
    public static <N, R> StatisticPager<N> copyAndAssemble(@Nonnull StatisticPager<R> originalPager, @Nonnull List<N> newRecords) {
        return new StatisticPager<>(newRecords, originalPager.page, originalPager.limit, originalPager.totalCnt, originalPager.totalPage);
    }

    private StatisticPager(@Nonnull List<R> records, long page, long limit, long totalCnt, long totalPage) {
        this.records = records;
        this.page = page;
        this.limit = limit;
        this.totalCnt = totalCnt;
        this.totalPage = totalPage;
    }

}
