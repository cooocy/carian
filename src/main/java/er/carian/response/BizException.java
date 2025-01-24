package er.carian.response;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false, of = "code")
public class BizException extends RuntimeException {

    public final int code;

    public final String message;

    public BizException(CM cm) {
        this.code = cm.code();
        this.message = cm.message();
    }

    public BizException(CM cm, String message) {
        this.code = cm.code();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
