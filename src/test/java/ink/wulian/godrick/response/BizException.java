package ink.wulian.godrick.response;

import javax.annotation.Nonnull;

public class BizException extends AbstractBizException {

    public BizException(int code, @Nonnull String message) {
        super(code, message);
    }

}
