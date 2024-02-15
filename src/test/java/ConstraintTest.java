import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConstraintTest {
    public static final Interval i_1_2 = new Interval( 1, 2 );
    public static final Interval i_1_3 = new Interval( 1, 3 );
    public static final Interval i_1_4 = new Interval( 1, 4 );
    public static final Interval i_1_5 = new Interval( 1, 5 );
    public static final Interval i_1_6 = new Interval( 1, 6 );
    public static final Interval i_1_7 = new Interval( 1, 7 );
    public static final Interval i_1_8 = new Interval( 1, 8 );
    public static final Interval i_1_9 = new Interval( 1, 9 );
    public static final Interval i_1_10 = new Interval( 1, 10 );
    public static final Interval i_2_3 = new Interval( 2, 3 );
    public static final Interval i_2_5 = new Interval( 2, 5 );
    public static final Interval i_2_10 = new Interval( 2, 10 );
    public static final Interval i_3_4 = new Interval( 3, 4 );
    public static final Interval i_4_5 = new Interval( 4, 5 );
    public static final Interval i_4_6 = new Interval( 4, 6 );
    public static final Interval i_4_7 = new Interval( 4, 7 );
    public static final Interval i_4_8 = new Interval( 4, 8 );
    public static final Interval i_4_9 = new Interval( 4, 9 );
    public static final Interval i_5_6 = new Interval( 5, 6 );
    public static final Interval i_5_7 = new Interval( 5, 7 );
    public static final Interval i_6_7 = new Interval( 6, 7 );
    public static final Interval i_6_8 = new Interval( 6, 8 );
    public static final Interval i_6_9 = new Interval( 6, 9 );
    public static final Interval i_7_8 = new Interval( 7, 8 );
    public static final Interval i_7_9 = new Interval( 7, 9 );
    public static final Interval i_8_9 = new Interval( 8, 9 );
    public static final Interval i_9_10 = new Interval( 9, 10 );
    public static final Interval i_10_11 = new Interval( 10, 11 );
    public static final Interval i_11_12 = new Interval( 11, 12 );
    public static final Interval i_12_13 = new Interval( 12, 13 );
    public static final Interval i_14_15 = new Interval( 14, 15 );

    @Test
    void testContrainte1() {
        Constraint c = new Constraint();

        assertTrue( c.isEmpty() );
    }

    @Test
    void testContrainteCollectionOfIntervalle1() {
        List<Interval> xs = Arrays.asList( i_1_2 );
        Constraint c = new Constraint( xs );

        assertIterableEquals( xs, c );
    }

    @Test
    void testContrainteCollectionOfIntervalle2() {
        List<Interval> xs = Arrays.asList( i_1_2, i_4_5 );
        Constraint c = new Constraint( xs );

        assertIterableEquals( xs, c );
    }

    @Test
    void testContrainteCollectionOfIntervalle3() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_4_5, i_7_8 );
        Constraint c = new Constraint( xs );

        assertIterableEquals( xs, c );
    }

    @Test
    void testContrainteCollectionOfIntervalle4() {
        List<Interval> xs =
                Arrays.asList( i_7_8, i_4_5, i_1_2 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_4_5, i_7_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle1() {
        Constraint c = new Constraint();
        List<Interval> r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle2() {
        List<Interval> xs =
                Arrays.asList( i_1_2 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle3() {
        List<Interval> xs =
                Arrays.asList( i_1_4 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle4() {
        List<Interval> xs =
                Arrays.asList( i_1_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle5() {
        List<Interval> xs =
                Arrays.asList( i_1_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle6() {
        List<Interval> xs =
                Arrays.asList( i_4_5 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle7() {
        List<Interval> xs =
                Arrays.asList( i_4_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle8() {
        List<Interval> xs =
                Arrays.asList( i_4_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle9() {
        List<Interval> xs =
                Arrays.asList( i_7_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle10() {
        List<Interval> xs =
                Arrays.asList( i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle11() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_4_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle12() {
        List<Interval> xs =
                Arrays.asList( i_1_4, i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle13() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_7_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle14() {
        List<Interval> xs =
                Arrays.asList( i_1_4, i_7_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle15() {
        List<Interval> xs =
                Arrays.asList( i_1_5, i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle16() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_6_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle17() {
        List<Interval> xs =
                Arrays.asList( i_1_5, i_6_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle18() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_7 );

        c.add( i_1_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle19() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_7 );

        c.add( i_1_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle20() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_8 );

        c.add( i_1_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle21() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        c.add( i_4_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle22() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle23() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_8 );

        c.add( i_4_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle24() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        c.add( i_5_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle25() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_8 );

        c.add( i_4_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle1() {
        Constraint c = new Constraint();

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle2() {
        List<Interval> xs =
                Arrays.asList( i_1_2 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle3() {
        List<Interval> xs =
                Arrays.asList( i_1_4 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle4() {
        List<Interval> xs =
                Arrays.asList( i_1_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle5() {
        List<Interval> xs =
                Arrays.asList( i_1_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle6() {
        List<Interval> xs =
                Arrays.asList( i_4_5 );
        Constraint c = new Constraint( xs );

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle7() {
        List<Interval> xs =
                Arrays.asList( i_4_7 );
        Constraint c = new Constraint( xs );

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle8() {
        List<Interval> xs =
                Arrays.asList( i_4_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle9() {
        List<Interval> xs =
                Arrays.asList( i_7_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle10() {
        List<Interval> xs =
                Arrays.asList( i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle11() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle12() {
        List<Interval> xs =
                Arrays.asList( i_1_4, i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4, i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle13() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_7_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle14() {
        List<Interval> xs =
                Arrays.asList( i_1_4, i_7_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle15() {
        List<Interval> xs =
                Arrays.asList( i_1_5, i_8_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4, i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle16() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_6_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_2, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle17() {
        List<Interval> xs =
                Arrays.asList( i_1_5, i_6_9 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_1_4, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle18() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_6_7 );

        c.remove( i_1_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle19() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );

        c.remove( i_1_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle20() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );

        c.remove( i_1_8 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle21() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_6_7 );

        c.remove( i_4_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle22() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle23() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );

        c.remove( i_4_8 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle24() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );
        List<Interval> r =
                Arrays.asList( i_4_5 );

        c.remove( i_5_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle25() {
        List<Interval> xs =
                Arrays.asList( i_4_5, i_6_7 );
        Constraint c = new Constraint( xs );

        c.remove( i_4_8 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testAppartient1() {
        Constraint c = new Constraint();

        assertFalse( c.appartient( 2 ) );
    }

    @Test
    void testAppartient2() {
        List<Interval> xs = Arrays.asList( i_4_7 );
        Constraint c = new Constraint( xs );

        assertFalse( c.appartient( 3 ) );
        assertTrue( c.appartient( 4 ) );
        assertTrue( c.appartient( 5 ) );
        assertTrue( c.appartient( 6 ) );
        assertFalse( c.appartient( 7 ) );
        assertFalse( c.appartient( 8 ) );
    }

    @Test
    void testAppartient3() {
        List<Interval> xs =
                Arrays.asList( i_1_4, i_6_9 );
        Constraint c = new Constraint( xs );

        assertFalse( c.appartient( 0 ) );
        assertTrue( c.appartient( 1 ) );
        assertTrue( c.appartient( 2 ) );
        assertTrue( c.appartient( 3 ) );
        assertFalse( c.appartient( 4 ) );
        assertFalse( c.appartient( 5 ) );
        assertTrue( c.appartient( 6 ) );
        assertTrue( c.appartient( 7 ) );
        assertTrue( c.appartient( 8 ) );
        assertFalse( c.appartient( 9 ) );
    }

    @Test
    void testAppartient4() {
        List<Interval> xs =
                Arrays.asList( i_1_4, i_5_7 );
        Constraint c = new Constraint( xs );

        assertTrue( c.appartient( 3 ) );
        assertFalse( c.appartient( 4 ) );
        assertTrue( c.appartient( 5 ) );
    }

    @Test
    void testAppartient5() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_4_5, i_7_8 );
        Constraint c = new Constraint( xs );

        assertFalse( c.appartient( 3 ) );
        assertTrue( c.appartient( 4 ) );
        assertFalse( c.appartient( 5 ) );
        assertFalse( c.appartient( 6 ) );
    }

    @Test
    void testTaille1() {
        Constraint c = new Constraint();

        assertEquals( 0, c.taille() );
    }

    @Test
    void testTaille2() {
        List<Interval> xs =
                Arrays.asList( i_4_7 );
        Constraint c = new Constraint( xs );

        assertEquals( 3, c.taille() );
    }

    @Test
    void testTaille3() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_4_7 );
        Constraint c = new Constraint( xs );

        assertEquals( 4, c.taille() );
    }

    @Test
    void testTaille4() {
        List<Interval> xs =
                Arrays.asList( i_1_2, i_4_7, i_8_9 );
        Constraint c = new Constraint( xs );

        assertEquals( 5, c.taille() );
    }

    @Test
    void testIntersection1() {
        Constraint c1 = new Constraint();
        Constraint c2 = new Constraint();

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection2() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint();

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection3() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint();
        Constraint c2 = new Constraint( xs1 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection4() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs1 );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testIntersection5() {
        List<Interval> xs1 =
                Arrays.asList( i_2_3 );
        List<Interval> xs2 =
                Arrays.asList( i_1_2 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection6() {
        List<Interval> xs1 =
                Arrays.asList( i_1_2, i_3_4 );
        List<Interval> xs2 =
                Arrays.asList( i_2_3, i_4_5 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection7() {
        List<Interval> xs1 =
                Arrays.asList( i_1_2, i_5_6 );
        List<Interval> xs2 =
                Arrays.asList( i_3_4, i_7_8 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection8() {
        List<Interval> xs1 =
                Arrays.asList( i_1_3, i_4_6, i_7_8 );
        List<Interval> xs2 =
                Arrays.asList( i_2_5, i_9_10 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_2_3, i_4_5 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testIntersection9() {
        List<Interval> xs1 =
                Arrays.asList( i_1_3, i_4_5, i_6_7, i_8_9, i_11_12 );
        List<Interval> xs2 =
                Arrays.asList( i_2_10 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_2_3, i_4_5, i_6_7, i_8_9 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testIntersection10() {
        List<Interval> xs1 =
                Arrays.asList( i_2_3, i_4_6, i_7_9, i_10_11, i_12_13 );
        List<Interval> xs2 =
                Arrays.asList( i_1_5, i_6_8, i_14_15 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_2_3, i_4_5, i_7_8 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testUnion1() {
        Constraint c1 = new Constraint();
        Constraint c2 = new Constraint();

        assertTrue( c1.union( c2 ).isEmpty() );
    }

    @Test
    void testUnion2() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint();
        List<Interval> r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion3() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint();
        Constraint c2 = new Constraint( xs1 );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion4() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs1 );
        List<Interval> r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion5() {
        List<Interval> xs1 =
                Arrays.asList( i_2_3 );
        List<Interval> xs2 =
                Arrays.asList( i_1_2 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_3 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion6() {
        List<Interval> xs1 =
                Arrays.asList( i_1_2, i_3_4 );
        List<Interval> xs2 =
                Arrays.asList( i_2_3, i_4_5 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_5 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion7() {
        List<Interval> xs1 =
                Arrays.asList( i_1_2, i_5_6 );
        List<Interval> xs2 =
                Arrays.asList( i_3_4, i_7_8 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_2, i_3_4, i_5_6, i_7_8 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion8() {
        List<Interval> xs1 =
                Arrays.asList( i_1_3, i_4_6, i_7_8 );
        List<Interval> xs2 =
                Arrays.asList( i_2_5, i_9_10 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_6, i_7_8, i_9_10 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion9() {
        List<Interval> xs1 =
                Arrays.asList( i_1_3, i_4_5, i_6_7, i_8_9, i_11_12 );
        List<Interval> xs2 =
                Arrays.asList( i_2_10 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_10, i_11_12 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion10() {
        List<Interval> xs1 =
                Arrays.asList( i_2_3, i_4_6, i_7_9, i_10_11, i_12_13 );
        List<Interval> xs2 =
                Arrays.asList( i_1_5, i_6_8, i_14_15 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_9, i_10_11, i_12_13, i_14_15 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testSoustraction1() {
        Constraint c1 = new Constraint();
        Constraint c2 = new Constraint();

        assertTrue( c1.soustraction( c2 ).isEmpty() );
    }

    @Test
    void testSoustraction2() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint();
        List<Interval> r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction3() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint();
        Constraint c2 = new Constraint( xs1 );

        assertTrue( c1.soustraction( c2 ).isEmpty() );
    }

    @Test
    void testSoustraction4() {
        List<Interval> xs1 =
                Arrays.asList( i_4_7 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs1 );

        assertTrue( c1.soustraction( c2 ).isEmpty() );
    }

    @Test
    void testSoustraction5() {
        List<Interval> xs1 =
                Arrays.asList( i_2_3 );
        List<Interval> xs2 =
                Arrays.asList( i_1_2 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_2_3 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction6() {
        List<Interval> xs1 =
                Arrays.asList( i_1_2, i_3_4 );
        List<Interval> xs2 =
                Arrays.asList( i_2_3, i_4_5 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_2, i_3_4 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction7() {
        List<Interval> xs1 =
                Arrays.asList( i_1_2, i_5_6 );
        List<Interval> xs2 =
                Arrays.asList( i_3_4, i_7_8 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_2, i_5_6 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction8() {
        List<Interval> xs1 =
                Arrays.asList( i_1_3, i_4_6, i_7_8 );
        List<Interval> xs2 =
                Arrays.asList( i_2_5, i_9_10 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_2, i_5_6, i_7_8 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction9() {
        List<Interval> xs1 =
                Arrays.asList( i_1_3, i_4_5, i_6_7, i_8_9, i_11_12 );
        List<Interval> xs2 =
                Arrays.asList( i_2_10 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_1_2, i_11_12 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction10() {
        List<Interval> xs1 =
                Arrays.asList( i_2_3, i_4_6, i_7_9, i_10_11, i_12_13 );
        List<Interval> xs2 =
                Arrays.asList( i_1_5, i_6_8, i_14_15 );
        Constraint c1 = new Constraint( xs1 );
        Constraint c2 = new Constraint( xs2 );
        List<Interval> r =
                Arrays.asList( i_5_6, i_8_9, i_10_11, i_12_13 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }
}
