package chalmers.tda367.testing.date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDateTest {

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
    }

    @Test
    void testEquals() {
    }

    @Test
    void testCompareTo() {
    }

    @Test
    void testNext() {
    }
}