import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {
    @Test
    void testAppartient1() {
        Interval i = new Interval( 1, 2 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( 0 ) );
        assertTrue( i.appartient( 1 ) );
        assertFalse( i.appartient( 2 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient2() {
        Interval i = new Interval( -2, -1 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( -3 ) );
        assertTrue( i.appartient( -2 ) );
        assertFalse( i.appartient( -1 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient3() {
        Interval i = new Interval( 0, 1 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( -1 ) );
        assertTrue( i.appartient( 0 ) );
        assertFalse( i.appartient( 1 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient4() {
        Interval i = new Interval( -3, 3 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( -4 ) );
        assertTrue( i.appartient( -3 ) );
        assertTrue( i.appartient( -2 ) );
        assertTrue( i.appartient( -1 ) );
        assertTrue( i.appartient( 0 ) );
        assertTrue( i.appartient( 1 ) );
        assertTrue( i.appartient( 2 ) );
        assertFalse( i.appartient( 3 ) );
        assertFalse( i.appartient( 4 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient5() {
        Interval i = new Interval( Integer.MIN_VALUE, 3 );

        assertTrue( i.appartient( Integer.MIN_VALUE ) );
        assertTrue( i.appartient( Integer.MIN_VALUE + 1 ) );
        assertTrue( i.appartient( 2 ) );
        assertFalse( i.appartient( 3 ) );
    }

    @Test
    void testAppartient6() {
        Interval i = new Interval( -3, Integer.MAX_VALUE );

        assertFalse( i.appartient( -4 ) );
        assertTrue( i.appartient( -3 ) );
        assertTrue( i.appartient( Integer.MAX_VALUE - 1 ) );
        assertFalse( i.appartient( Integer.MAX_VALUE ) );
    }

    @Test
    void testEquals1() {
        Interval i = new Interval( 1, 2 );
        assertFalse( i.equals( null ) );
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void testEquals2() {
        Interval i = new Interval( 1, 2 );
        Integer x = new Integer( 2 );

        assertFalse( i.equals( x ) );
    }

    @Test
    void testEquals3() {
        Interval i = new Interval( 1, 2 );

        assertTrue( i.equals( i ) );
    }

    @Test
    void testEquals4() {
        Interval i1 = new Interval( 1, 2 );
        Interval i2 = new Interval( 1, 2 );

        assertTrue( i1.equals( i2 ) );
    }

    @Test
    void testEquals5() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 2, 3 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals6() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 4 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals7() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 5 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals8() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 6 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals9() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals10() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 5 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals11() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 6 );

        assertTrue( i1.equals( i2 ) );
    }

    @Test
    void testEquals12() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals13() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 6 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals14() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals15() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 6, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals16() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 7, 8 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testUnion1() {
        Interval i = new Interval( 4, 6 );

        assertEquals( i, i.union( i ).get( 0 ) );
    }

    @Test
    void testUnion2() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 6 );

        assertEquals( i1, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion3() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 4 );
        Interval ir = new Interval( 3, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion4() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 5 );
        Interval ir = new Interval( 3, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion5() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 6 );
        Interval ir = new Interval( 3, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion6() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 7 );
        Interval ir = new Interval( 3, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion7() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 5 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion8() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 7 );
        Interval ir = new Interval( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion9() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 6 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion10() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 7 );
        Interval ir = new Interval( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion11() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 6, 7 );
        Interval ir = new Interval( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion12() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 2, 3 );

        Constraint c = i1.union( i2 );

        assertEquals( i2, c.get( 0 ) );
        assertEquals( i1, c.get( 1 ) );
    }

    @Test
    void testUnion13() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 7, 8 );

        Constraint c = i1.union( i2 );

        assertEquals( i1, c.get( 0 ) );
        assertEquals( i2, c.get( 1 ) );
    }

    @Test
    void testUnion14() {
        Interval i1 = new Interval( 4, 7 );
        Interval i2 = new Interval( 5, 6 );
        Interval ir = new Interval( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection1() {
        Interval i = new Interval( 4, 6 );

        assertEquals( i, i.intersection( i ).get( 0 ) );
    }

    @Test
    void testIntersection2() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 6 );

        assertEquals( i1, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection3() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 4 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection4() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 5 );
        Interval ir = new Interval( 4, 5 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection5() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 6 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection6() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 7 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection7() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 5 );
        Interval ir = new Interval( 4, 5 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection8() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 7 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection9() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 6 );
        Interval ir = new Interval( 5, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection10() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 7 );
        Interval ir = new Interval( 5, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection11() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 6, 7 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection12() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 2, 3 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection13() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 7, 8 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection14() {
        Interval i1 = new Interval( 4, 7 );
        Interval i2 = new Interval( 5, 6 );
        Interval ir = new Interval( 5, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction1() {
        Interval i = new Interval( 4, 6 );

        assertTrue( i.soustraction( i ).isEmpty() );
    }

    @Test
    void testSoustraction2() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 6 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction3() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 4 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction4() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 5 );
        Interval ir = new Interval( 5, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction5() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 6 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction6() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 3, 7 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction7() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 5 );
        Interval ir = new Interval( 5, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction8() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 4, 7 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction9() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 6 );
        Interval ir = new Interval( 4, 5 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction10() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 5, 7 );
        Interval ir = new Interval( 4, 5 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction11() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 6, 7 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction12() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 2, 3 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction13() {
        Interval i1 = new Interval( 4, 6 );
        Interval i2 = new Interval( 7, 8 );
        Interval ir = new Interval( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction14() {
        Interval i1 = new Interval( 4, 7 );
        Interval i2 = new Interval( 5, 6 );
        Interval ir1 = new Interval( 4, 5 );
        Interval ir2 = new Interval( 6, 7 );

        Constraint c = i1.soustraction( i2 );

        assertEquals( ir1, c.get( 0 ) );
        assertEquals( ir2, c.get( 1 ) );
    }
}
