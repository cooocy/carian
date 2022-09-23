package ink.wulian.godrick.response;

import lombok.ToString;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@ToString
public class Result<T> {

    public final boolean success;

    public final int code;

    @Nonnull
    public final String message;

    @Nullable
    public final T data;

    public static Result<Void> ok() {
        return new Result<>(true, 0, "ok", null);
    }

    public static <T> Result<T> ok(@Nonnull T data) {
        return new Result<>(true, 0, "ok", data);
    }

    public static Result<Void> err(int code, @Nonnull String message) {
        return new Result<>(false, code, message, null);
    }

    private Result(boolean success, int code, @Nonnull String message, @Nullable T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}