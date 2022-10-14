package ink.wulian.er.godrick.response;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Nonnull;

@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractBizException extends RuntimeException {

    public final int code;

    public final String message;

    public AbstractBizException(int code, @Nonnull String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
