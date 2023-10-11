import java.util.Scanner;

public class PenggajianGuru {
    public static void main(String[] args) {
        // Deklarasi Scanner
        Scanner penggajian = new Scanner(System.in);

        // variabel input
        String NamaGuru, Jabatan, TingkatPendidikan="" ;
        int NIP, Lama_mengajar;
        long Gaji_pokok_1 = 10000000, Gaji_pokok_2 =4000000, total1=0, total2=0, tunjangan1, tunjangan2;
        
        // Isi variable
        // Gaji_pokok_1 = 10000000;
        // Gaji_pokok_2 = 4000000;  
        //hapus variabel                             

        System.out.print("Masukkan nama guru: ");
        NamaGuru = penggajian.next();
        System.out.print("Masukkan NIP: ");
        NIP = penggajian.nextInt();
        System.out.print("Masukkan jabatan: ");
        Jabatan = penggajian.next();
        System.out.print("Masukkan lama mengajar: ");
        Lama_mengajar = penggajian.nextInt();
        // System.out.println();h
        // if condition tingkat pendidikan guru
        // nextLine()
        penggajian.nextLine();
        System.out.print("Masukkan tingkat pendidikan (ex. S1/S2) = ");
        TingkatPendidikan += penggajian.nextLine();
        // System.out.println("jabatanmyu"+TingkatPendidikan);

        if (TingkatPendidikan.equals("S2")) {
            System.out.println("Tingkat pendidikan = " + TingkatPendidikan);
            System.out.println("Dengan gaji pokok = " + Gaji_pokok_1);
        } else  if (TingkatPendidikan.equals("S1")){
            System.out.println("Tingkat pendidikan = " + TingkatPendidikan);
            System.out.println("Dengan gaji pokok = " + Gaji_pokok_2);
        } else {
            System.out.println("Undifined");
        }

        // tunjangan dari lama mengajar
        if (Lama_mengajar >= 60) {
            tunjangan1 = 4000000;
            System.out.println("Tunjangan anda adalah = " + tunjangan1);
            total1 = Gaji_pokok_1 * Lama_mengajar;
            System.out.println("Gaji anda adalah = " + total1);

        } else {
            tunjangan2 = 2500000;
            System.out.println("Tunjangan anda adalah = " + tunjangan2);
            total2 = Gaji_pokok_2 * Lama_mengajar;
            System.out.println("Gaji anda adalah = " + total2);

        }
        // System.out.println((int)total1);
     
        // perhitungan total
        // total = Gaji_pokok * Lama_mengajar;

        // output
        System.out.println("=====Selamat Menikmati Gaji");
        System.out.println("Nama Guru:: " + NamaGuru);
        System.out.println("NIP: " + NIP);
        System.out.println("Jabatan: " + Jabatan);
        System.out.println("Lama Mengajar: " + Lama_mengajar + " Bulan");
        System.out.println("Total Gaji: Rp " + total1);
        System.out.println("Total Gaji = " + total2);
        System.out.println(
                "Gunakan Gaji Anda Dengan Penuh Manfaat \nKarena Hasil Kerja Kerasmu Tidak Pantas Untuk Di Sia-Siakan");
        System.out.println("selesai proses");
    }

}