package ink.wulian.godrick.response;

import ink.wulian.er.godrick.response.AbstractBizException;

import javax.annotation.Nonnull;

public class BizException extends AbstractBizException {

    public BizException(int code, @Nonnull String message) {
        super(code, message);
    }

}
