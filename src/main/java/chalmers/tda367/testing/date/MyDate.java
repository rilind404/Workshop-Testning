package chalmers.tda367.testing.date;

public class MyDate {
    
    private int y;
    private int m;
    private int d;

    /** Skapar ett nytt MyDate objekt för dagen: year, month, day.
        Exempel datumet 2029-07-15 skapas med new MyDate(2029,7,15).
        @throws IllegalArgumentException ett exception ifall datumet inte är ett giltigt datum (t.ex. 2003-02-29). */
    public MyDate(int year, int month, int day) {
        if(year < 0) throw new IllegalArgumentException();
        if(month < 1 || month > 12) throw new IllegalArgumentException();
        if(day < 1 || day > daysInMonth(month, year)) throw new IllegalArgumentException();

        y = year;
        m = month;
        d = day;
    }

    /** Returnerar värdet av year som gavs till construktorn */
    public int getYear() { return y; }

    /** Returnerar värdet av month som gavs till construktorn */
    public int getMonth() { return m; }

    /** Returnerar värdet av day som gavs till construktorn */
    public int getDay() { return d; }

    /** Returnerar en sträng representation av datumet */
    public String toString() {
        String res = y + "-";
        if (m < 10) { res = res + "0"; };
        res = res + m + "-";
        if (d < 10) { res = res + "0"; };
        res = res + d;
        return res;
    }

    /** Returnerar true ifall det givna objektet representerar samma datum */
    public boolean equals(Object other) {
        if (other == null) { return false; }
        if (this.getClass() != other.getClass()) { return false; }
        MyDate x = (MyDate) other;
        return (this.y == x.y && this.m == x.m && this.d == x.d);
    }

    /** Returnerar -1 ifall this är ett tidigare datum än other.
        Returnerar 1 ifall other är ett tidigare datum än this.
        Returnerar 0 ifall this och other representerar samma datum. */
    public int compareTo(MyDate other) {
        if(this.y < other.y) return -1;
        if(this.y > other.y) return 1;

        if(this.m < other.m) return -1;
        if(this.m > other.m) return 1;

        if(this.d < other.d) return -1;
        if(this.d > other.d) return 1;

        return 0;
    }

    /** Ger true ifall year är ett skottår */
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /** Returnerar hur många dagar det finns i månad m för år y */
    private static int daysInMonth(int m, int y) {
        switch (m) {
          case 4: // apr
          case 6: // jun
          case 9: // sep
          case 11: // nov
              return 30;
          case 2: // feb
              if (isLeapYear(y)) {
                  return 29;
              } else {
                  return 28;
              }
          default: // resten
              return 31;
        }
    }

    /** Returnerar datumet av dagen som kommer direkt efter detta datum */
    public MyDate next() {
        if ((m == 12) && (d == 31)) {
            return new MyDate(y+1,1,1);
        }
        if (d == daysInMonth(m,y)) {
            return new MyDate(y,m+1,1);
        }
        return new MyDate(y,m,d+1);
    }
}
