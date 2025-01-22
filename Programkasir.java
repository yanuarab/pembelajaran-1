import java.util.Scanner;

public class Programkasir {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int maxItems = 100; // Maksimum jumlah barang yang bisa ditampung
        String[] namaBarang = new String[maxItems];
        int[] jumlahBarang = new int[maxItems];
        double[] hargaBarang = new double[maxItems];
        int itemCount = 0;
        boolean running = true;
        System.out.println("=== Program Kasir Sederhana ===");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Keranjang");
            System.out.println("3. Checkout");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    if (itemCount >= maxItems) {
                        System.out.println("Keranjang penuh! Tidak bisa menambah barang lagi.");
                        break;
                    }
                    System.out.print("Masukkan nama barang: ");
                    namaBarang[itemCount] = sc.nextLine();
                    System.out.print("Masukkan jumlah barang: ");
                    jumlahBarang[itemCount] = sc.nextInt();
                    System.out.print("Masukkan harga barang: ");
                    hargaBarang[itemCount] = sc.nextDouble();
                    sc.nextLine(); // Membersihkan newline
                    itemCount++;
                    System.out.println("Barang berhasil ditambahkan ke keranjang.");
                    break;

                case 2:
                    System.out.println("\n=== Keranjang Belanja ===");
                    if (itemCount == 0) {
                        System.out.println("Keranjang kosong.");
                    } else {
                        for (int i = 0; i < itemCount; i++) {
                            double totalHarga = jumlahBarang[i] * hargaBarang[i];
                            System.out.printf("%d. %s (x%d) - Rp%.2f\n", 
                                    i + 1, namaBarang[i], jumlahBarang[i], totalHarga);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n=== Checkout ===");
                    if (itemCount == 0) {
                        System.out.println("Keranjang kosong. Tidak ada yang perlu dibayar.");
                    } else {
                        double totalBayar = 0;
                        for (int i = 0; i < itemCount; i++) {
                            totalBayar += jumlahBarang[i] * hargaBarang[i];
                        }
                        System.out.printf("Total yang harus dibayar: Rp%.2f\n", totalBayar);
                        System.out.print("Masukkan jumlah pembayaran: Rp");
                        double pembayaran = sc.nextDouble();
                        if (pembayaran >= totalBayar) {
                            System.out.printf("Pembayaran berhasil. Kembalian: Rp%.2f\n", pembayaran - totalBayar);
                            itemCount = 0; // Kosongkan keranjang setelah checkout
                        } else {
                            System.out.println("Uang tidak cukup. Silakan coba lagi.");
                        }
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan program kasir.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        sc.close();
    }
}