package chalmers.tda367.testing.date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

class MyDateTest {

    

    MyDate dater = new MyDate(2023,11, 8);
    MyDate datercopy = new MyDate(2023,11,8);
    MyDate dater2 = new MyDate(2011,11,8);

    @Test
    void testConstructor1() {
        MyDate date = new MyDate(2023, 11, 8);

        assertEquals(date.getYear(), 2023);
        assertEquals(date.getMonth(), 11);
        assertEquals(date.getDay(), 8);
    }
    
    @Test
    void testConstructorThrows() {
        assertThrows(IllegalArgumentException.class, () -> new MyDate(2023, 13, 8));
    }

    @Test
    void testConstructorIllegalLeapYear() {
        assertThrows(IllegalArgumentException.class, () -> new MyDate(2023, 2, 29));
    }

    @Test
    void testToString() {
        assertEquals(dater.toString(), "2023-11-08");
    }

    @Test
    void testEquals() {
        MyDate date = new MyDate(2023,11,8);
        MyDate same = new MyDate(2023,11,8);
        MyDate notsame = new MyDate(2011,11,11);

        assertTrue(date.equals(same));
        assertFalse(date.equals(notsame));
    }

    @Test
    void testCompareTo() {
        MyDate earlier = new MyDate(1999,9,6);
        MyDate later = new MyDate(2030,1,1);
        MyDate date = new MyDate(2023,11,8);
        MyDate samedate = new MyDate(2023,11,8);


        assertEquals(-1, earlier.compareTo(date));
        assertEquals(1, later.compareTo(date));
        assertEquals(0, date.compareTo(samedate));
    }

    @Test
    void testNext() {
        MyDate date = new MyDate(2023,11,8);
        MyDate nextdate= new MyDate(2023, 11, 9);

        assertTrue(date.next().equals(nextdate));
    }
}