package er.carian.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractBizExceptionTest {

    @Test
    void testConstructor() {
        int expectedCode = 1;
        String expectedMessage = "x";

        BizException bizException = new BizException(expectedCode, expectedMessage);

        assertEquals(expectedCode, bizException.code);
        assertEquals(expectedMessage, bizException.message);
    }

}