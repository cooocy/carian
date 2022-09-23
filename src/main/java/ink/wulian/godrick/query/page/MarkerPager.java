package ink.wulian.godrick.query.page;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * marker page 分页查询结果.
 */
public class MarkerPager<R, M> {

    public final List<R> records;

    public final M nextMarker;

    public MarkerPager(@Nonnull List<R> records) {
        this.records = records;
        this.nextMarker = null;
    }

    public MarkerPager(@Nonnull List<R> records, @Nonnull M nextMarker) {
        this.records = records;
        this.nextMarker = nextMarker;
    }

}
