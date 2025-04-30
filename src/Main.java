import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Kamar[] daftarKamar = isiDataKamar();
        System.out.println("Selamat datang di Hotel XYZ.");
        System.out.print("Berapa malam anda akan menginap?: ");
        int lamaMenginap = input.nextInt();
        System.out.println("Silahkan memesan kamar yang tersedia:\n");
        tampilkanDaftarKamar(daftarKamar);
        System.out.println();

        System.out.println("Pilih kamar dengan mengetikan nomor kamar.");
        System.out.println("Untuk memilih lebih dari 1 kamar, pisahkan dengan koma (contoh: 101,102)");
        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");

        String pilihan = input.next();
        String[] daftarNomorKamar = pilihan.split(",");
        int jumlahPilihan = daftarNomorKamar.length;
        System.out.println();

        if (jumlahPilihan == 1) {
            Kamar kamarPilihan = pilihKamar(daftarKamar, Integer.parseInt(daftarNomorKamar[0]));

            if (kamarPilihan != null) {
                Kamar[] kamarPesanan = {kamarPilihan};
                memesanKamar(kamarPesanan, lamaMenginap);
                cetakStruk(kamarPesanan, lamaMenginap);
            } else {
                System.out.println("Kamar tidak ada");
            }
        } else if (jumlahPilihan == 2) {
            Kamar kamar1 = pilihKamar(daftarKamar, Integer.parseInt(daftarNomorKamar[0]));
            Kamar kamar2 = pilihKamar(daftarKamar, Integer.parseInt(daftarNomorKamar[1]));

            if (kamar1 != null && kamar2 != null) {
                Kamar[] kamarPesanan = {kamar1, kamar2};
                memesanKamar(kamarPesanan, lamaMenginap);
                cetakStruk(kamarPesanan, lamaMenginap);
            } else {
                System.out.println("Terdapat Kamar yang tidak ada");
            }
        } else if (jumlahPilihan == 3) {
            Kamar kamar1 = pilihKamar(daftarKamar, Integer.parseInt(daftarNomorKamar[0]));
            Kamar kamar2 = pilihKamar(daftarKamar, Integer.parseInt(daftarNomorKamar[1]));
            Kamar kamar3 = pilihKamar(daftarKamar, Integer.parseInt(daftarNomorKamar[2]));

            if (kamar1 != null && kamar2 != null && kamar3 != null) {
                Kamar[] kamarPesanan = {kamar1, kamar2, kamar3};
                memesanKamar(kamarPesanan, lamaMenginap);
                cetakStruk(kamarPesanan, lamaMenginap);
            } else {
                System.out.println("Terdapat Kamar yang tidak ada");
            }
        } else {
            System.out.println("Tidak bisa memesan lebih dari 3 kamar");
        }

    }

    public static void cetakStruk(Kamar[] kamarPesanan, int lamaMenginap) {
        System.out.println("Struk Pemesanan:");
        int jumlahKamar = kamarPesanan.length;
        double[] daftarBiaya = hitungTotalBiayaKamar(kamarPesanan, lamaMenginap);
        double biayaKamar = daftarBiaya[0];
        double pajak = daftarBiaya[1];
        double biayaKenaPajak = daftarBiaya[2];
        double biayaLayanan = daftarBiaya[3];
        double totalBiaya = daftarBiaya[4];
        double totalBiayaSetelahDiskon = daftarBiaya[5];
        double diskon = daftarBiaya[6];
        if (jumlahKamar == 1) {
            System.out.println("Nomor Kamar: " + kamarPesanan[0].getNomor() + ", Tipe Kamar: " + kamarPesanan[0].getTipe() +
                ", Lama Menginap: " + lamaMenginap + " malam, Harga per Malam: Rp" +
                    formatBiaya(kamarPesanan[0].getHargaPerMalam()) + ", Total Harga: " +
                    formatBiaya(kamarPesanan[0].getHargaPerMalam() * lamaMenginap));
            System.out.println("Total Biaya Reservasi: " + formatBiaya(biayaKamar) + "\n" +
                    "Biaya Layanan: Rp" + formatBiaya(biayaLayanan) + "\n" +
                    "Pajak: 10%" + "\n" +
                    "Biaya Pajak: Rp" + formatBiaya(pajak) + "\n" +
                    "Total Biaya: Rp" + formatBiaya(totalBiaya));
            if (totalBiayaSetelahDiskon != 0) {
                System.out.println("Diskon 15%: " + formatBiaya(diskon));
                System.out.println("Total Biaya Setelah Diskon: Rp" + formatBiaya(totalBiayaSetelahDiskon));
            }

        } else if (jumlahKamar == 2) {
            System.out.println("Nomor Kamar: " + kamarPesanan[0].getNomor() + ", Tipe Kamar: " + kamarPesanan[0].getTipe() +
                    ", Lama Menginap: " + lamaMenginap + " malam, Harga per Malam: Rp" +
                    formatBiaya(kamarPesanan[0].getHargaPerMalam()) + ", Total Harga: " +
                    formatBiaya(kamarPesanan[0].getHargaPerMalam() * lamaMenginap));
            System.out.println("Nomor Kamar: " + kamarPesanan[1].getNomor() + ", Tipe Kamar: " + kamarPesanan[1].getTipe() +
                    ", Lama Menginap: " + lamaMenginap + " malam, Harga per Malam: Rp" +
                    formatBiaya(kamarPesanan[1].getHargaPerMalam()) + ", Total Harga: " +
                    formatBiaya(kamarPesanan[1].getHargaPerMalam() * lamaMenginap));


            System.out.println("Total Biaya Reservasi: " + formatBiaya(biayaKamar) + "\n" +
                    "Biaya Layanan: Rp" + formatBiaya(biayaLayanan) + "\n" +
                    "Pajak: 10%" + "\n" +
                    "Biaya Pajak: Rp" + formatBiaya(pajak) + "\n" +
                    "Total Biaya: Rp" + formatBiaya(totalBiaya));
            if (totalBiayaSetelahDiskon != 0) {
                System.out.println("Diskon 15%: " + formatBiaya(diskon));
                System.out.println("Total Biaya Setelah Diskon: Rp" + formatBiaya(totalBiayaSetelahDiskon));
            }
        } else if (jumlahKamar == 3) {
            System.out.println("Nomor Kamar: " + kamarPesanan[0].getNomor() + ", Tipe Kamar: " + kamarPesanan[0].getTipe() +
                    ", Lama Menginap: " + lamaMenginap + " malam, Harga per Malam: Rp" +
                    formatBiaya(kamarPesanan[0].getHargaPerMalam()) + ", Total Harga: " +
                    formatBiaya(kamarPesanan[0].getHargaPerMalam() * lamaMenginap));
            System.out.println("Nomor Kamar: " + kamarPesanan[1].getNomor() + ", Tipe Kamar: " + kamarPesanan[1].getTipe() +
                    ", Lama Menginap: " + lamaMenginap + " malam, Harga per Malam: Rp" +
                    formatBiaya(kamarPesanan[1].getHargaPerMalam()) + ", Total Harga: " +
                    formatBiaya(kamarPesanan[1].getHargaPerMalam() * lamaMenginap));
            System.out.println("Nomor Kamar: " + kamarPesanan[2].getNomor() + ", Tipe Kamar: " + kamarPesanan[2].getTipe() +
                    ", Lama Menginap: " + lamaMenginap + " malam, Harga per Malam: Rp" +
                    formatBiaya(kamarPesanan[2].getHargaPerMalam()) + ", Total Harga: " +
                    formatBiaya(kamarPesanan[2].getHargaPerMalam() * lamaMenginap));

            System.out.println("Total Biaya Reservasi: " + formatBiaya(biayaKamar) + "\n" +
                    "Biaya Layanan: Rp" + formatBiaya(biayaLayanan) + "\n" +
                    "Pajak: 10%" + "\n" +
                    "Biaya Pajak: Rp" + formatBiaya(pajak) + "\n" +
                    "Total Biaya: Rp" + formatBiaya(totalBiaya));
            if (totalBiayaSetelahDiskon != 0) {
                System.out.println("Diskon 15%: " + formatBiaya(diskon));
                System.out.println("Total Biaya Setelah Diskon: Rp" + formatBiaya(totalBiayaSetelahDiskon));
            }
        }
    }

    public static String formatBiaya(double biaya) {
        return String.format("%,.2f", biaya).replace(",", ".");
    }
    public static String formatBiaya(int biaya) {
        return String.format("%,d", biaya).replace(",", ".");
    }

    public static Kamar pilihKamar(Kamar[] daftarKamar, int nomorPilihan) {
        Kamar kamarPilihan = null;
        if (nomorPilihan == daftarKamar[0].getNomor() && daftarKamar[0].isKetersediaan()) {
            kamarPilihan = daftarKamar[0];
        } else if (nomorPilihan == daftarKamar[1].getNomor() && daftarKamar[1].isKetersediaan()) {
            kamarPilihan = daftarKamar[1];
        } else if (nomorPilihan == daftarKamar[2].getNomor() && daftarKamar[2].isKetersediaan()) {
            kamarPilihan = daftarKamar[2];
        } else if (nomorPilihan == daftarKamar[3].getNomor() && daftarKamar[3].isKetersediaan()) {
            kamarPilihan = daftarKamar[3];
        }

        return kamarPilihan;
    }

    public static void memesanKamar(Kamar[] daftarKamarPilihan, int lamaMenginap) {
        int jumlahKamar = daftarKamarPilihan.length;

        if (jumlahKamar == 1) {
            Kamar kamarPilihan = daftarKamarPilihan[0];
            cekKetersediaanKamar(kamarPilihan, lamaMenginap);
        } else if (jumlahKamar == 2) {
            Kamar kamarPilihan1 = daftarKamarPilihan[0];
            Kamar kamarPilihan2 = daftarKamarPilihan[1];
            cekKetersediaanKamar(kamarPilihan1, lamaMenginap);
            cekKetersediaanKamar(kamarPilihan2, lamaMenginap);
        } else if (jumlahKamar == 3) {
            Kamar kamarPilihan1 = daftarKamarPilihan[0];
            Kamar kamarPilihan2 = daftarKamarPilihan[1];
            Kamar kamarPilihan3 = daftarKamarPilihan[2];
            cekKetersediaanKamar(kamarPilihan1, lamaMenginap);
            cekKetersediaanKamar(kamarPilihan2, lamaMenginap);
            cekKetersediaanKamar(kamarPilihan3, lamaMenginap);
        }

    }

    public static void cekKetersediaanKamar(Kamar kamarPilihan, int lamaMenginap) {
        if (kamarPilihan.isKetersediaan()) {
            System.out.println("Kamar tersedia");

            System.out.println("Pesanan anda: ");
            System.out.println("Nomor Kamar: " + kamarPilihan.getNomor() + ", Lama Menginap: " + lamaMenginap + " malam");
            double totalBiaya = kamarPilihan.getHargaPerMalam() * lamaMenginap;

            if (totalBiaya > 300000) {
                System.out.println("Anda mendapat sarapan gratis");
            }

            System.out.println("Pesanan anda:");
            System.out.println("Nomor kamar: " + kamarPilihan.getNomor() + ", Tipe Kamar: " +
                    kamarPilihan.getTipe() + ", Lama menginap: " + lamaMenginap + ", Harga per malam: Rp" +
                    String.format("%,d", kamarPilihan.getHargaPerMalam()).replace(",", "."));
            System.out.println("Total Biaya: Rp" + String.format("%,.2f", totalBiaya).replace(",", "."));
            System.out.println();
        } else {
            System.out.println("Kamar tidak tersedia");
        }
    }

    public static double[] hitungTotalBiayaKamar(Kamar[] kamarPilihan, int lamaMenginap) {
        // Menghitung total biaya
        double biayaKamar = 0;
        int jumlahKamar = kamarPilihan.length;
        if (jumlahKamar == 1) {
            biayaKamar = kamarPilihan[0].getHargaPerMalam() * lamaMenginap;
        } else if (jumlahKamar == 2) {
            biayaKamar = (kamarPilihan[0].getHargaPerMalam() * lamaMenginap) +
                    (kamarPilihan[1].getHargaPerMalam() * lamaMenginap);
        } else if (jumlahKamar == 3) {
            biayaKamar = (kamarPilihan[0].getHargaPerMalam() * lamaMenginap) +
                    (kamarPilihan[1].getHargaPerMalam() * lamaMenginap) +
                    (kamarPilihan[2].getHargaPerMalam() * lamaMenginap);
        }

        double pajak = biayaKamar * 0.1;
        double biayaKenaPajak = biayaKamar + pajak;
        double biayaLayanan = 50000 * jumlahKamar;
        double totalBiaya = biayaKenaPajak + biayaLayanan;
        double totalBiayaSetelahDiskon = 0;
        double diskon = 0;

        if (biayaKamar > 500000) {
            diskon = totalBiaya * 0.15;
            totalBiayaSetelahDiskon = totalBiaya - diskon;
        }

        double[] daftarBiaya = {biayaKamar, pajak, biayaKenaPajak, biayaLayanan, totalBiaya, totalBiayaSetelahDiskon, diskon};
        return daftarBiaya;
    }

    public static Kamar[] isiDataKamar() {
        Kamar standar1 = new Kamar(101, "Standar", 250000, true);
        Kamar superior1 = new Kamar(103, "Superior", 500000, true);
        Kamar deluxe1 = new Kamar(201, "Deluxe", 1000000, false);
        Kamar suite1 = new Kamar(203, "Suite", 1500000, true);


        Kamar[] daftarKamar = {standar1,  superior1,  deluxe1, suite1 };
        return daftarKamar;
    }

    public static void tampilkanDaftarKamar(Kamar[] daftarKamar) {
        tampilkanKamar(daftarKamar[0]);
        tampilkanKamar(daftarKamar[1]);
        tampilkanKamar(daftarKamar[2]);
        tampilkanKamar(daftarKamar[3]);
    }

    public static void tampilkanKamar(Kamar kamar) {
        System.out.println("Nomor: " + kamar.getNomor() + ", Tipe: " + kamar.getTipe() +
                ", Harga Per Malam: Rp" + String.format("%,d", kamar.getHargaPerMalam()).replace(",", ".") +
                ", Ketersediaan: " + (kamar.isKetersediaan() ? "Tersedia" : "Tidak Tersedia") );
    }


}

class Kamar {
    private int nomor;
    private String tipe;
    private int hargaPerMalam;
    private boolean ketersediaan;

    public Kamar(int nomor, String tipe, int hargaPerMalam, boolean ketersediaan) {
        this.nomor = nomor;
        this.tipe = tipe;
        this.hargaPerMalam = hargaPerMalam;
        this.ketersediaan = ketersediaan;
    }

    public int getNomor() {
        return nomor;
    }

    public String getTipe() {
        return tipe;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public boolean isKetersediaan() {
        return ketersediaan;
    }
}