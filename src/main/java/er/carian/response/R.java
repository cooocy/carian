package er.carian.response;

import lombok.ToString;

import javax.annotation.Nullable;

@ToString
public class R<T> {

    public final boolean success;

    public final int code;

    public final String message;

    @Nullable
    public final T data;

    public static R<Void> ok() {
        return new R<>(true, 0, "ok", null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(true, 0, "ok", data);
    }

    public static R<Void> err(int code, String message) {
        return new R<>(false, code, message, null);
    }

    private R(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}