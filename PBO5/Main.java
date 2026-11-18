package PBO5;

public class Main {
    public static void main(String[] args) {
        String garis =
                "+--------------+--------------------+--------------------+--------------+";

        System.out.println("HASIL PERBANDINGAN NILAI GENERIC");
        System.out.println(garis);
        System.out.printf("| %-12s | %-18s | %-18s | %-12s |%n",
                "Tipe", "Nilai A", "Nilai B", "Hasil");
        System.out.println(garis);

        CompareUtil.printComparison("Integer", 5, 5);
        CompareUtil.printComparison("String", "Halo", "Dunia");
        CompareUtil.printComparison("Double", 3.14, 3.14);
        CompareUtil.printComparison("Double", 3.14, 3.15);
        CompareUtil.printComparison("Character", 'A', 'A');
        CompareUtil.printComparison("Character", 'A', 'B');

        System.out.println(garis);
        System.out.println("SAMA     = kedua nilai memiliki isi yang sama.");
        System.out.println("BERBEDA  = kedua nilai memiliki isi yang berbeda.");
    }
}

class CompareUtil {
    public static <T extends Comparable<? super T>> boolean isEqual(T a, T b) {
        if (a == null || b == null) {
            return a == b;
        }

        return a.compareTo(b) == 0;
    }

    public static <T extends Comparable<? super T>> void printComparison(
            String type, T a, T b) {
        String result = isEqual(a, b) ? "SAMA" : "BERBEDA";

        System.out.printf("| %-12s | %-18s | %-18s | %-12s |%n",
                type, String.valueOf(a), String.valueOf(b), result);
    }
}