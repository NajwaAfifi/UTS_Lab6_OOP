import java.util.Scanner;

// Program ini mengelola informasi karyawan di sebuah perusahaan.
// Program ini menunjukkan penggunaan class, object, constructor, method overloading, method overriding, setter dan getter.

public class Perusahaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta masukan dari pengguna untuk membuat objek Karyawan
        System.out.println("Masukkan nama karyawan:");
        String nama = scanner.nextLine();
        System.out.println("Masukkan usia karyawan:");
        int usia = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        System.out.println("Masukkan departemen karyawan:");
        String departemen = scanner.nextLine();

        // Membuat objek Karyawan dengan constructor yang berbeda
        Karyawan karyawan1 = new Karyawan(nama, usia, departemen);
        Karyawan karyawan2 = new Karyawan(nama, usia);

        // Menampilkan informasi karyawan
        karyawan1.displayInfo();
        karyawan2.displayInfo();

        // Menggunakan setter untuk mengubah departemen karyawan
        System.out.println("Masukkan departemen baru untuk karyawan kedua:");
        String departemenBaru = scanner.nextLine();
        karyawan2.setDepartemen(departemenBaru);
        System.out.println("Departemen baru untuk karyawan kedua: " + karyawan2.getDepartemen());

        // Membuat objek Manajer, subclass dari Karyawan
        System.out.println("Masukkan bonus untuk manajer:");
        double bonus = scanner.nextDouble();
        Manajer manajer1 = new Manajer(nama, usia, departemen, bonus);
        manajer1.displayInfo();

        scanner.close();
    }
}

// Kelas Karyawan yang memiliki atribut nama, usia, dan departemen
class Karyawan {
    private String nama;
    private int usia;
    private String departemen;

    // Constructor dengan tiga parameter
    public Karyawan(String nama, int usia, String departemen) {
        this.nama = nama;
        this.usia = usia;
        this.departemen = departemen;
    }

    // Constructor dengan dua parameter (overloading)
    public Karyawan(String nama, int usia) {
        this.nama = nama;
        this.usia = usia;
        this.departemen = "Tidak Diketahui";
    }

    // Method untuk menampilkan informasi karyawan
    public void displayInfo() {
        System.out.println("Nama: " + nama + ", Usia: " + usia + ", Departemen: " + departemen);
    }

    // Getter dan Setter untuk atribut departemen
    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
}

// Subclass dari Karyawan yang menambahkan atribut bonus
class Manajer extends Karyawan {
    private double bonus;

    // Constructor untuk Manajer yang memanggil constructor dari superclass (Karyawan)
    public Manajer(String nama, int usia, String departemen, double bonus) {
        super(nama, usia, departemen);
        this.bonus = bonus;
    }

    // Overriding method displayInfo untuk menambahkan informasi bonus
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: " + bonus);
    }
}
