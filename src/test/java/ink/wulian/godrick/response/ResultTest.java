package ink.wulian.godrick.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testOk() {
        Result<Void> r1 = Result.ok();
        assertNotNull(r1);
        assertTrue(r1.success);
        assertEquals(0, r1.code);
        assertNotNull(r1.message);
        assertNull(r1.data);

        String data2 = "x";
        Result<String> r2 = Result.ok(data2);
        assertNotNull(r2);
        assertTrue(r2.success);
        assertEquals(0, r2.code);
        assertNotNull(r2.message);
        assertEquals(data2, r2.data);
    }

    @Test
    void testErr() {
        int code = 2;
        String message = "x";
        Result<Void> r = Result.err(code, message);
        assertNotNull(r);
        assertFalse(r.success);
        assertEquals(code, r.code);
        assertEquals(message, r.message);
        assertNull(r.data);
    }

}