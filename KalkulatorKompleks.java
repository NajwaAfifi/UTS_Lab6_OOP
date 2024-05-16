import java.util.Scanner;


public class KalkulatorKompleks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta pengguna memilih rumus yang ingin dihitung
        System.out.println("Pilih rumus yang ingin dihitung:");
        System.out.println("1. Momentum Relativistik");
        System.out.println("2. Energi Total dalam Relativitas");
        System.out.println("3. Integral dari fungsi kuadrat");
        System.out.println("4. Turunan dari fungsi kuadrat");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                // Menghitung Momentum Relativistik
                System.out.println("Masukkan massa (kg):");
                double massa = scanner.nextDouble();
                System.out.println("Masukkan kecepatan (m/s):");
                double kecepatan = scanner.nextDouble();
                FisikaRelativitas momentum = new FisikaRelativitas(massa, kecepatan);
                System.out.println("Momentum Relativistik: " + momentum.hitungMomentumRelativistik() + " kg·m/s");
                break;

            case 2:
                // Menghitung Energi Total dalam Relativitas
                System.out.println("Masukkan massa (kg):");
                massa = scanner.nextDouble();
                System.out.println("Masukkan kecepatan (m/s):");
                kecepatan = scanner.nextDouble();
                FisikaRelativitas energi = new FisikaRelativitas(massa, kecepatan, true);
                System.out.println("Energi Total dalam Relativitas: " + energi.hitungEnergiTotal() + " Joule");
                break;

            case 3:
                // Menghitung Integral dari Fungsi Kuadrat
                System.out.println("Masukkan koefisien a:");
                double a = scanner.nextDouble();
                System.out.println("Masukkan koefisien b:");
                double b = scanner.nextDouble();
                System.out.println("Masukkan koefisien c:");
                double c = scanner.nextDouble();
                System.out.println("Masukkan batas bawah integral:");
                double batasBawah = scanner.nextDouble();
                System.out.println("Masukkan batas atas integral:");
                double batasAtas = scanner.nextDouble();
                Matematika integral = new Matematika(a, b, c, batasBawah, batasAtas);
                System.out.println("Hasil Integral: " + integral.hitungIntegral() + " unit^2");
                break;

            case 4:
                // Menghitung Turunan dari Fungsi Kuadrat
                System.out.println("Masukkan koefisien a:");
                a = scanner.nextDouble();
                System.out.println("Masukkan koefisien b:");
                b = scanner.nextDouble();
                System.out.println("Masukkan koefisien c:");
                c = scanner.nextDouble();
                Matematika turunan = new Matematika(a, b, c);
                System.out.println("Fungsi Turunan: " + turunan.hitungTurunan());
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}

// Kelas FisikaRelativitas untuk menghitung rumus dalam relativitas
class FisikaRelativitas {
    private double massa;
    private double kecepatan;
    private final double c = 299792458; // Kecepatan cahaya dalam m/s

    // Constructor untuk momentum relativistik
    public FisikaRelativitas(double massa, double kecepatan) {
        this.massa = massa;
        this.kecepatan = kecepatan;
    }

    // Constructor untuk energi total dalam relativitas
    public FisikaRelativitas(double massa, double kecepatan, boolean isEnergi) {
        this.massa = massa;
        this.kecepatan = kecepatan;
    }

    // Method untuk menghitung momentum relativistik
    public double hitungMomentumRelativistik() {
        double gamma = 1 / Math.sqrt(1 - (kecepatan * kecepatan) / (c * c));
        return massa * kecepatan * gamma;
    }

    // Method untuk menghitung energi total dalam relativitas
    public double hitungEnergiTotal() {
        double gamma = 1 / Math.sqrt(1 - (kecepatan * kecepatan) / (c * c));
        return massa * c * c * gamma;
    }
}

// Kelas Matematika untuk menghitung integral dan turunan fungsi kuadrat
class Matematika {
    private double a, b, c;
    private double batasBawah, batasAtas;

    // Constructor untuk integral fungsi kuadrat
    public Matematika(double a, double b, double c, double batasBawah, double batasAtas) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.batasBawah = batasBawah;
        this.batasAtas = batasAtas;
    }

    // Constructor untuk turunan fungsi kuadrat
    public Matematika(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Method untuk menghitung integral fungsi kuadrat
    public double hitungIntegral() {
        return (a/3 * Math.pow(batasAtas, 3) + b/2 * Math.pow(batasAtas, 2) + c * batasAtas) - 
               (a/3 * Math.pow(batasBawah, 3) + b/2 * Math.pow(batasBawah, 2) + c * batasBawah);
    }

    // Method untuk menghitung turunan fungsi kuadrat
    public String hitungTurunan() {
        double turunanA = 2 * a;
        double turunanB = b;
        return turunanA + "x + " + turunanB;
    }
}
