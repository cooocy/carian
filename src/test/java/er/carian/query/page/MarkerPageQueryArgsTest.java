package er.carian.query.page;

import er.carian.query.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkerPageQueryArgsTest {

    @Test
    void testConstructor1() {
        MarkerPageQueryArgs p = new MarkerPageQueryArgs(-1);
        assertNotNull(p);
        assertEquals(1, p.limit);
        assertNull(p.order);
        assertNull(p.idMarker);

        p = new MarkerPageQueryArgs(1000);
        assertNotNull(p);
        assertEquals(501, p.limit);
        assertNull(p.order);
        assertNull(p.idMarker);

        p = new MarkerPageQueryArgs(200);
        assertNotNull(p);
        assertEquals(200, p.limit);
        assertNull(p.order);
        assertNull(p.idMarker);
    }

    @Test
    void testConstructor2() {
        MarkerPageQueryArgs<Integer> p = new MarkerPageQueryArgs<>(200, 2);
        assertNotNull(p);
        assertEquals(200, p.limit);
        assertNull(p.order);
        assertEquals(2, p.idMarker);
    }

    @Test
    void testConstructor3() {
        MarkerPageQueryArgs<Integer> p = new MarkerPageQueryArgs<>(200, Order.ASC);
        assertNotNull(p);
        assertEquals(200, p.limit);
        assertEquals(Order.ASC, p.order);
        assertNull(p.idMarker);
    }

    @Test
    void testConstructor4() {
        MarkerPageQueryArgs<Integer> p = new MarkerPageQueryArgs<>(200, 2, Order.DESC);
        assertNotNull(p);
        assertEquals(200, p.limit);
        assertEquals(Order.DESC, p.order);
        assertEquals(2, p.idMarker);
    }

}