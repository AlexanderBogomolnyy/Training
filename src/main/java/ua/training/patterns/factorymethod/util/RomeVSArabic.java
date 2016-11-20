package ua.training.patterns.factorymethod.util;

/**
 * This class converts Arabic numbers to Rome
 *
 * @author Sergej Komlach
 *         adapted by Alexander Bogomolnyy
 * @see <a href = "https://habrahabr.ru/post/136646/"> From Barsa to Rome </a>
 */

public class RomeVSArabic {

    /* Main numbers:
    I - 1
    V - 5
    X - 10
    L - 50
    C - 100
    D - 500
    M - 1000
    Zero is absent
    */

    // From 1 to 9
    private static String basic(int in) {
        String[] a = {
                "",
                "I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX"
        };
        return a[in];
    }

    /**
     * This method converts numbers from Arabic to Rome style
     *
     * @param in - input Arabic number
     * @return - Rome number
     */
    public static String convert(int in) {
        StringBuffer a = new StringBuffer("");
        // Extract thousands
        int m1 = in / 1000;
        a.append(M(m1));
        // Remainder after extracting thousands
        int m2 = in % 1000;

        // Extract five hundred from the remainder
        int d1 = m2 / 500;
        a.append(D(d1));
        // Remainder after extracting five hundred
        int d2 = m2 % 500;

        // Extract hundreds from the remainder
        int c1 = d2 / 100;
        a.append(C(c1));
        // Remainder after extracting hundreds
        int c2 = d2 % 100;

        // Extract fifties from the remainder
        int l1 = c2 / 50;
        a.append(L(l1));
        // Remainder after extracting fifties
        int l2 = c2 % 50;

        // Extract tens from the remainder
        int x1 = l2 / 10;
        a.append(X(x1));
        // Remainder after extracting tens
        int x2 = l2 % 10;

        // Extract the rest
        a.append(basic(x2));
        return a.toString();
    }

    // convert hole thousands with values aliquot to ten but not to five
    private static String M(int in) {
        StringBuilder a = new StringBuilder("");
        int i = 0;
        while (i < in) {
            a.append("M");
            i++;
        }
        return a.toString();
    }

    // convert hole hundreds
    private static String C(int in) {
        if (in == 4) return "CD"; //если 400, то 500-100
        else if ((in != 0) && (in < 4)) {
            StringBuilder a = new StringBuilder("");
            int i = 0;
            while (i < in) {
                a.append("C");
                i++;
            }
            return a.toString();
        } else return "";
    }

    // convert hole tens
    private static String X(int in) {
        if (in == 4) return "XL"; // if 40 then 50-10
        else if ((in != 0) && (in < 4)) {
            StringBuilder a = new StringBuilder("");
            int i = 0;
            while (i < in) {
                a.append("X");
                i++;
            }
            return a.toString();
        } else return "";
    }

    // convert five hundred
    private static String D(int in) {
        if (in == 0) return "";
        if (in == 4) return "CM"; // if 900 then 1000-100
        else return "D";
    }

    // convert hundreds
    private static String L(int in) {
        if (in == 0) return "";
        if (in == 4) return "XC"; // if 90 then 100 - 10
        return "L";
    }

}
