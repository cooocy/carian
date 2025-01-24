package er.carian.response;

public enum Codes implements CM {

    Ok(0, "OK"),

    ServerError(10001, "Server Error."),

    ApiNotFound(10002, "Api Not Found."),

    MethodNotSupport(10003, "Method Not Support."),

    TokenInvalid(10004, "Token Not Found or Invalid"),

    ProfileNotSupport(10005, "Profile Not Support"),

    ArgsIllegal(10006, "Args Illegal."),

    RecordNotFound(10101, "Record not found."),

    ;


    private final int code;

    private final String message;

    Codes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
