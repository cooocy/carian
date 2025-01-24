package er.carian.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BizExceptionTest {

    @Test
    void testConstructor() {
        Codes ok = Codes.Ok;

        BizException bizException = new BizException(ok);

        assertEquals(ok.code(), bizException.code);
        assertEquals(ok.message(), bizException.message);
    }

}