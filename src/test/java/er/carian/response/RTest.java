package er.carian.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RTest {

    @Test
    void testOk() {
        R<Void> r1 = R.ok();
        assertNotNull(r1);
        assertTrue(r1.success);
        assertEquals(0, r1.code);
        assertNotNull(r1.message);
        assertNull(r1.data);

        String data2 = "x";
        R<String> r2 = R.ok(data2);
        assertNotNull(r2);
        assertTrue(r2.success);
        assertEquals(0, r2.code);
        assertNotNull(r2.message);
        assertEquals(data2, r2.data);
    }

    @Test
    void testErr() {
        BizException be = new BizException(Codes.Ok);
        R<Void> r = R.err(be);
        assertNotNull(r);
        assertFalse(r.success);
        assertEquals(be.code, r.code);
        assertEquals(be.message, r.message);
        assertNull(r.data);
    }

}