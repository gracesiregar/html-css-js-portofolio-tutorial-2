import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mahasiswa{
    private static Map<String, String> mahasiswaMap = new HashMap<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n---MENU DATA MAHASISWA---");
            System.out.println("\n1.Buat Data mahasiswa");
            System.out.println("\n2.Lihat Data Mahasiswa");
            System.out.println("\n3.Edit Data Mahasiswa");
            System.out.println("\n4.Hapus Data Mahasiswa");
            System.out.println("\n5.Quit");
            System.out.print("\nPilih nomor: ");

            int nomor =input.nextInt();
            input.nextLine(); 

            switch (nomor) {
                case 1:
                    createData();
                    break;
                case 2:
                    readData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    deleteData();
                    break;
                case 5:
                    running = false;
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
    private static void createData() {
        System.out.print("Nim: ");
        String nim = input.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            System.out.println("Nim sudah terdaftar. Silakan coba lagi.");
            return;
        }
        System.out.print("Nama: ");
        String nama = input.nextLine();
        mahasiswaMap.put(nim, nama);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void readData() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Mahasiswa belum terdaftar.");
        } else {
            System.out.println("\n---DATA MAHASISWA---");
            for (Map.Entry<String, String> entry : mahasiswaMap.entrySet()) {
                System.out.println("\nNim: " + entry.getKey() + "\nNama: " + entry.getValue());
            }
        }
    }
    private static void updateData() {
        System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
        String nim = input.nextLine();
        if (!mahasiswaMap.containsKey(nim)) {
            System.out.println("NIM tidak ditemukan. Silakan coba lagi.");
            return;
        }
        System.out.print("Nama diedit manjadi: ");
        String namaBaru = input.nextLine();
        mahasiswaMap.put(nim, namaBaru);
        System.out.println("Data Mahasiswa Berhasil diedit.");
    }
    private static void deleteData() {
        System.out.print("Nim yang akan dihapus: ");
        String nim = input.nextLine();
        if (!mahasiswaMap.containsKey(nim)) {
            System.out.println("NIM Belum terdaftar.");
            return;
        }

        mahasiswaMap.remove(nim);
        System.out.println("data Mahasiswa sudah dihapus.");
    }
}
 
    

