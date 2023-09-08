package er.carian.response;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractBizException extends RuntimeException {

    public final int code;

    public final String message;

    public AbstractBizException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
