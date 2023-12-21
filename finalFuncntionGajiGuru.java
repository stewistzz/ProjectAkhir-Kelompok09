import java.util.Arrays;
import java.util.Scanner;

public class finalFuncntionGajiGuru {

    static String[][] dataGuru; // array untuk menyimpan data guru
    static String status, jawaban, namaGuru, NIP, masuk, bulan, check, pendidikan; // data string yang akan digunakan
    static double tunjangan = 0, tarifPerJam = 0, gaji, totalGaji, potonganPajak = 0, slipGaji, hitungAbsen = 0; // data//
                                                                                                                 // double//
                                                                                                                 // yang//
                                                                                                                 // akan
                                                                                                                 // //
                                                                                                                 // digunakan
    static int jumlahJam, tarif = 0, kehadiran = 0, golongan = 0, jmlHariAbsen = 0, barisGuru = 0,
            kolomGuru = 0;// data int yang akan digunakan
    static Scanner inputUser = new Scanner(System.in); // scanner untuk input

    // array jadwal gaji guru
    static String[][] jadwalGaji = new String[10][3]; // ketika memasukkan kembali pilihan dengan angka 2 , maka secara
                                                      // otomatis akan memanggil ulang array sehingga data yang
                                                      // dimasukkan kembali ke nilai awalnya(0).

    // fungsi sudah digaji atau belum
    static String[][] sudahbelum = new String[10][2];
    private static int i;

    public static void main(String[] args) {

        // System.out.print("Pilih bahasa(indo/inggris) : ");
        // String bahasa = inputUser.next();

        // if (bahasa.equalsIgnoreCase("indo")) {
        //     bahasaIndo();
        // } else if (bahasa.equalsIgnoreCase("inggris")) {

        //     bahasaInggris();
        // }

        // login masuk
        while (true) {
            System.out.print("Pilihan login(Guru/Admin) : ");
            masuk = inputUser.next();
            // jika masuk sebagai guru maka lakukan pengisian data
            if (masuk.equalsIgnoreCase("Guru")) {
                // pemberian jumlah data guru yang ingin dilakukan eksekusi
                daftarDataGuru(barisGuru);
            } // jika login sebagai admin, maka admin berhak melakukan penggajian
            else if (masuk.equalsIgnoreCase("Admin")) {
                fungsiMenu();

            }
        }

    }

    static void bahasaIndo() {
        // ketika user memilih bahasa indonesia, maka akan tampil menu tengan tampilan
        // bahasa indonesia

    }

    static void bahasaInggris() {
        // ketika user memilih bahasa indonesia, maka akan tampil menu tengan tampilan
        // bahasa inggris

    }

    static void fungsiMenu() {
        System.out.println("------------------------------------------");
        System.out.println("| Selamat Datang Program Penggajian Guru |");
        System.out.println("------------------------------------------");

        // array nama guru
        boolean isExit = false;
        
        while (!isExit) {
            System.out.println("----------------------------------------");
            System.out.println("Daftar menu : ");
            System.out.println("----------------------------------------");
            System.out.println("| 1. | Menu tampil data guru\t\t|");
            System.out.println("| 2. | Menu Update data guru\t\t|");
            System.out.println("| 3. | Menu jadwal penggajian guru\t|");
            System.out.println("| 4. | Menu perhitungan gaji\t\t|");
            System.out.println("| 5. | Menu tampil struk gaji guru\t|");
            System.out.println("| 6. | Menu guru sudah dan belum digaji\t|");
            System.out.println("| 7. | Menu laporan penggajian(mm/yy)\t|");
            System.out.println("| 8. | Menu Kembali halaman login\t|");
            System.out.println("| 9. | Menu exit\t\t\t|"); // menu exit akan berjalan jika user nantinya memilih n untuk
            // opsi(y/n), yang akan diberikan pertanyaan, jika user kembali
            // ke daftar menu, akan tampil daftar menu
            System.out.println("----------------------------------------");
            System.out.print("Masukkan menu yang ingin dipilih(1,2,3,..) : ");
            int pilihan = inputUser.nextInt();
            System.out.println();

            switch (pilihan) {
                // MENU UNTUK MENAMPILKAN DAFTAR GURU YANG TELAH DIISIKAN SEBELUMNYA
                case 1:
                    tampilGuru(pilihan);
                    break;

                // MENNU UNTUK PENJADWALAN GAJI GURU
                case 2:
                    updateDataGuru(pilihan);
                    break;

                // MENU INPUT DAN OUTPUT PENGGAJIAN
                case 3:
                    jadwalPenggajian(pilihan);
                    break;
                // menu untuk menandai guru mana yang sudah di gaji dan belum di gaji
                case 4:
                    perhitunganGaji(pilihan);
                    break;
                // menu untuk menampilkan struk penggajian guru?
                case 5:
                    tampilStruk();
                    break;
                /// menu untuk melihat daftar guru yang sudah dan belum digaji
                case 6:
                    sudahGajiBelum(pilihan);
                    break;
                // menu untuk menampilkan laporan gajiguru bulanan
                case 7:
                    laporanGaji(pilihan);
                    break;
                // meenu kembali ke awal login guru/admin
                case 8:
                    isExit = true;
                    break;
                // menu exit
                case 9:
                    caseLima(pilihan);
                    break;
                default:
                    System.out.println("Anda memasukkan nomor menu yang salah");
                    break;
            }
            if (isExit) {
                pilihanExit();

            }
        }
    }

    static void daftarDataGuru(int barsiGuru) {
        // memasukkan jumlah baris array
        System.out.print("Jumlah Guru\t: ");
        barsiGuru = inputUser.nextInt();
        System.out.println("------------------------------------------------------------");

        dataGuru = new String[barsiGuru][6];
        // array untuk menyimpan data guru dengan baris sebanyak 6

        for (int i = 0; i < dataGuru.length; i++) {
            for (int j = 0; j < dataGuru[i].length; j++) {
                if (j == 0) { // kondisi untuk menginput nama guru
                    System.out.print("Nama guru(nama-tengah-akhir)\t\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 1) { // kondisi untuk meenginput riwayat pendidikan guru
                    System.out.print("Riwayat pendidikan(s1/s2-jurusan)\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 2) { // kondisi yang dugunakan untuk megninput NIP guru yang ditentukan oleh admin
                    System.out.print("NIP Guru(9 digit) \t\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 3) { // kondisi untuk menginput status guru apakah pns atau honorer
                    System.out.print("Status (PNS/Honorer)\t\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 4) { // kondisi jika status guru == honore maka skip mengisi golongan guru
                    if (dataGuru[i][3].equalsIgnoreCase("Honorer")) {
                        continue;
                    } else { // kondisi lain jika guru == pns maka diharuskan mengisi golongan
                        System.out.print("Masukkan Golongan (1,2,3,4)\t: ");
                        dataGuru[i][j] = inputUser.next();
                    }
                }
                if (j == 5) { // kondisi untuk menginput jumlah jam mengajar guru
                    System.out.print("Jumlah jam mengajar(perminggu)\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
            }
            System.out.println("------------------------------------------------------------");
            System.out.println();
        }
    }

    static void tampilGuru(int pilihan) { // fungsi untuk
        for (int i = 0; i < dataGuru.length; i++) {
            System.out.println("========================================================================");
            System.out.println("Daftar Data Guru POLINEMA");
            System.out.println("========================================================================");

            System.out.print("Nama Guru\t\t: " + dataGuru[i][0] + "\n" + "Riwayat Pendidikan\t:" + dataGuru[i][1] + "\n"
                    + "NIP Guru\t\t:" + dataGuru[i][2] + "\n" + "Status\t\t:" + dataGuru[i][3] + "\n"
                    + "Golongan PNS\t\t:" + dataGuru[i][4] + "\n" + "Jumlah Jam/hari\t\t:" + dataGuru[i][5] + "\n");
        }
        System.out.println();
    }

    static String jadwalPenggajian(int pilihan) {

        // String[][] jadwalGaji = new String[dataGuru.length][2]; // Array untuk
        // menyimpan jadwal penggajian
        // // guru
        System.out.println("Jadwal Penggajian Guru : ");
        for (int i = 0; i < dataGuru.length; i++) {
            System.out.println((i + 1) + ". " + dataGuru[i][0] + "\t" + " - " + "\t" + jadwalGaji[i][1]);
        }

        // kembali ke daftar menu
        System.out.println();
        System.out.print("Ingin kembali ke daftar menu?(y/n)");
        String kembali = inputUser.next();
        if (kembali.equalsIgnoreCase("y")) {
            fungsiMenu();
            System.out.println();
        }

        System.out.print("Pilih guru untuk dijadwalkan penggajiannya (nomor): ");
        int nomorGuru = inputUser.nextInt() - 1;
        inputUser.nextLine();

        System.out.print("Masukkan tanggal penggajian (format: DD-MM-YYYY): ");
        jadwalGaji[nomorGuru][1] = inputUser.next();

        jadwalGaji[nomorGuru][0] = dataGuru[nomorGuru][2];
        // jadwalGaji[nomorGuru][1] = tanggalPenggajian;

        System.out.println("Jadwal penggajian untuk guru " + dataGuru[nomorGuru][0]
                + "telah dijadwalkan pada tanggal " + jadwalGaji[nomorGuru][1]);
        return jadwalGaji[nomorGuru][1];
    }

    static void perhitunganGaji(int pilihan) {
        // perulangan jika nama guru tidak sesuai

        while (true) {

            System.out.print("Masukkan Nama Guru : ");
            namaGuru = inputUser.next();
            // kondisi jika nama guru tidak sesuai dengan yang ada pada dataGuru
            boolean isNamaGuruValid = false;

            // kondisi jika nama guru tidak sesuai dengan yang ada pada dataGuru
            for (int i = 0; i < dataGuru.length; i++) {
                if (dataGuru[i][0].equalsIgnoreCase(namaGuru)) {
                    isNamaGuruValid = true;
                    break;
                }
            }
            if (!isNamaGuruValid) {
                System.out.println(
                        "Peringatan!!! \n data guru yang anda inputkan tidak  dengan data yang ada!!");
                System.out.println();
            } else {
                break;
            }

        }

        while (true) {
            System.out.print("Masukkan NIP : ");
            NIP = inputUser.next();

            boolean nipGuru = false;

            for (int i = 0; i < dataGuru.length; i++) {
                if (dataGuru[i][2].equals(NIP)) {
                    nipGuru = true;
                    break;
                }
            }
            if (!nipGuru) {
                System.out.println("Peringatan, NIP yang anda masukkan tidak terdaftar");
            } else {
                break;
            }
        }

        // mengisikan pendidikan terakhir guru

        while (true) {
            
            // cek pendidikan terakhir dari guru tersebut
            System.out.print("Pendidikan terakhir guru (S1/S2) \n jawaban anda : ");
            pendidikan = inputUser.next();
            int tambah = 0;
            boolean riwayat = false;
            for (int i = 0; i < dataGuru.length; i++) {
                String jurusan = dataGuru[i][1].substring(0, 2);
                //String jurusanGuru = dataGuru[i][1];
               // System.out.println(jurusan);
                // s1
                if (pendidikan.equalsIgnoreCase(jurusan)) {
                    System.out.println(dataGuru[tambah][0] + " sebelumnya menempuh pendidikan " + dataGuru[tambah][1]);
                    riwayat = true;
                    break;
                    // s2
                // } else if (pendidikan.equalsIgnoreCase(jurusan)) {
                //     System.out.println(dataGuru[i][0] + " sebelumnya menempuh pendidikan " + jurusan);
                //     riwayat = true;2
                //     break;
                } 
                tambah++;
                // else {
                //     System.out.println(dataGuru[i][0] + " Tidak menenmpuh pendidikan sarjana");
                // }
                //System.out.println(dataGuru[i][1]);
            }
            // if (!riwayat) {
            //     System.out.println("Invalid riwayat pendidikan!!");
            // } else {
            //     break;
            // }
             if (!riwayat) {
                System.out.println("Riwayat yang anda masukkan tidak valid " + "(" + dataGuru[tambah][1] + ")");
                System.out.println("Status guru tidak sesuai!!");
            } else {
                break;
            }
        } 


        do {
            // cek apakah guru tersebut masih aktif mengajar atau tidak
            System.out.print("Apakah Guru tersebut masih aktif mengajar? (aktif/non-aktif) : ");
            jawaban = inputUser.next();

            do {
                if (jawaban.equalsIgnoreCase("aktif")) { // kondisi jika guru yang diinput masuk daftar dan
                                                         // masih aktif mengajar
                    System.out.println(namaGuru + " masih aktif mengajar");
                    System.out.print(
                            "Masukkan kehadiran guru hari ini : \n1. hadir\n2. izin \n3. sakit \n4. alpha \n jawaban anda : ");
                    kehadiran = inputUser.nextInt();
                    do { // perulangan untuk memasukkan kembali kehadiran guru selama proses mengajar
                        if (kehadiran == 1) {
                            System.out.println(namaGuru + " saat ini hadir");
                        } else if (kehadiran == 2) {
                            System.out.println(namaGuru + " sedang berhalangan hadir karena izin");
                        } else if (kehadiran == 3) {
                            System.out.println(namaGuru + " sedang berhalangan hadir karena sakit");
                        } else if (kehadiran == 4) {
                            System.out.println(namaGuru + " Tidak masuk tanpa keterangan(alpha)");
                        } else {
                            System.out.println("Kehadiran guru tidak dapat diketahui");
                        }
                    } while (false);

                } else if (jawaban.equalsIgnoreCase("non-aktif")) { // kondisi untuk mengemnbalikan ke daftar menu jika
                                                                    // guru sudah tidak aktif
                    System.out.println(namaGuru + " Sudah tidak aktif mengajar");
                    fungsiMenu();
                } else {
                    System.out.println("Status guru tidak diketahui!!");
                }
                System.out.println();

                // jika kehadiran != 1, maka tanyakan berapa hari?,kemudian tambah hari
                // ketidkahadiran untuk guru tersebut kedalam jmlHariAbsen

            } while (kehadiran < 1 || kehadiran > 4);
            System.out.println();
        } while (!jawaban.equalsIgnoreCase("aktif") && !jawaban.equalsIgnoreCase("non-aktif"));

        inputUser.nextLine();

        // int check = 0;
        while (true) {
            System.out.print("Masukkan Status PNS/HONORER? : ");
            status = inputUser.next();
            int check = 0;
            // perulangan untuk mkembali isi jika isian tidak sama dengan dataGuru
            boolean statusGuru = false;
            // System.out.println(dataGuru[i][3]);
            // System.out.println(dataGuru[i][4]);
            for (int i = 0; i < dataGuru.length; i++) {
                System.out.println("/n=============");
                for (int j = 0; j < dataGuru[i].length; j++) {
                    System.out.println(dataGuru[i][j]);
                }
                
            }
                // Proses status guru
                // if (status.equalsIgnoreCase(dataGuru[check][3])) {
                //     System.out.print("Masukkan status PNS, contoh : 1, 2, 3, 4\n jawaban anda = ");
                //     golongan = inputUser.nextInt();
                //     statusGuru = true;
                //     //check++;
                //     // break;
                // } else if (status.equalsIgnoreCase(dataGuru[check][3])) { // Periksa nilai lain di sini
                //     System.out.print("Masukkan tarif mengajar perjamnn ya = ");
                //     tarif = inputUser.nextInt();
                //     statusGuru = true;
                //     //check++;
                //     // break;
                // } else {
                //     System.out.println("Status guru yang anda masukkan salah!!");
                // }
                if (status.equalsIgnoreCase("PNS")) {
                    System.out.print("Masukkan status PNS, contoh : 1, 2, 3, 4\n jawaban anda = ");
                    golongan = inputUser.nextInt();
                    statusGuru = true;
                    //check++;
                    // break;
                } else if (status.equalsIgnoreCase("HONORER")) { // Periksa nilai lain di sini
                    System.out.print("Masukkan tarif mengajar perjamnn ya = ");
                    tarif = inputUser.nextInt();
                    statusGuru = true;
                    //check++;
                    // break;
                } else {
                    System.out.println("Status guru yang anda masukkan salah!!");
                }
                // check++;?
            check++;
            if (!statusGuru) {
                System.out.println("Status yang anda masukkan tidak valid " + "(" + dataGuru[check][3] + " /" + dataGuru[check][4] + ")");
                System.out.println("Status guru tidak sesuai!!");
            } else {
                break;
            }
        }



        // while (true) {
        //     System.out.print("Masukkan Status PNS/HONORER? : ");
        //     status = inputUser.nextLine();
        //     int check = 0;
        //     int statusCount = 0; // Tambahkan counter ini
        //     boolean statusGuru = false;
        //     for (int i = 0; i < dataGuru.length; i++) {
        //         String status = dataGuru[i][3];
        //         String jam = dataGuru[i][4];
        //         if (status.equalsIgnoreCase(status)) {
        //             System.out.print("Masukkan status PNS, contoh : 1, 2, 3, 4\n jawaban anda = ");
        //             golongan = inputUser.nextInt();
        //             statusGuru = true;
        //             statusCount++; // Tambahkan counter ini
        //             break;
        //         } else if (status.equalsIgnoreCase(jam)) {
        //             System.out.print("Masukkan tarif mengajar perjamnnya = ");
        //             tarif = inputUser.nextInt();
        //             statusGuru = true;
        //             statusCount++; // Tambahkan counter ini
        //             break;
        //         } else {
        //             System.out.println("Status guru yang anda masukkan salah!!");
        //         }
        //         check++;
        //     }
        //     if (!statusGuru) {
        //         System.out.println("Status yang anda masukkan tidak valid " + "(" + dataGuru[check][3] + " /" + dataGuru[check][4] + ")");
        //         System.out.println("Status guru tidak sesuai!!");
        //     } else {
        //         break;
        //     }
        // }
        


        // jumlah jam mengajar
        System.out.print("Masukkan jumlah jam mengajar(per jam kali 5 hari) = ");
        jumlahJam = inputUser.nextInt();

        // menghitung Gaji Guru
        switch (golongan) {
            case 1:
                tarifPerJam = 100000;
                break;
            case 2:
                tarifPerJam = 120000;
                break;
            case 3:
                tarifPerJam = 140000;
                break;
            case 4:
                tarifPerJam = 160000;
                break;
            default:
                tarifPerJam = tarif;
                System.out.println("Tarif perjam honorer\t : " + tarifPerJam);
                break;
        }

        // Mempertimbangkan gaji guru dengan kehadiran guru, dengan mengurangi biaya
        // gaji yang dikalikan banyak hari tidakmasuk
        if (status.equalsIgnoreCase("pns")) {
            System.out.print("Berapa hari guru " + namaGuru + " tidak hadir bulan ini,"
                    + "(Selain absesni hadir maka dapat ditambahkan) :  ");
            jmlHariAbsen = inputUser.nextInt();
            System.out.println("guru tidak hadir selama " + jmlHariAbsen + " kali");

            hitungAbsen = jmlHariAbsen * tarifPerJam;
        }

        gaji = jumlahJam * 4 * tarifPerJam - hitungAbsen;
        System.out.println("Perhitungan Gaji Guru \t: " + gaji + " Rupiah");

        // mengatur tunjangan sesuai dengan golongan
        switch (golongan) {
            case 1:
                tunjangan = 200000;
                break;
            case 2:
                tunjangan = 220000;
                break;
            case 3:
                tunjangan = 240000;
                break;
            case 4:
                tunjangan = 260000;
                break;

            default:
                tunjangan = 0;
                break;
        }

        totalGaji = gaji + tunjangan;
        System.out.println("Perhitungan Total Gaji Guru : " + totalGaji + " Rupiah");

        if (golongan == 1) {
            potonganPajak = totalGaji * 0.01;
            System.out.println(potonganPajak);
        } else if (golongan == 2) {
            potonganPajak = totalGaji * 0.02;
            System.out.println(potonganPajak);
        } else if (golongan == 3) {
            potonganPajak = totalGaji * 0.03;
            System.out.println(potonganPajak);
        } else if (golongan == 4) {
            potonganPajak = totalGaji * 0.04;
            System.out.println(potonganPajak);
        } else {
            potonganPajak = 0;
            System.out.println(potonganPajak);
        }
        slipGaji = totalGaji - potonganPajak;

        // store slip gaji

        for (int i = 0; i < dataGuru.length; i++) {
            if (dataGuru[i][2].equals(NIP)) {

                jadwalGaji[i][2] = String.valueOf(slipGaji);
                System.out.println("guru index " + i + "\t: " + jadwalGaji[i][2]);
            }
        }

    }

    static void tampilStruk() {

        // perulangan mencetak struk gaji
        for (int i = 0; i < dataGuru.length; i++) {
            // Data yang di print
            System.out.println("=========================================================");
            System.out.println("| \t\tData   \t\t|  \tDetail Guru \t|");
            System.out.println("=========================================================");
            System.out.println("| \tNama Guru   \t\t|\t" + dataGuru[i][0] + "\t\t|");
            System.out.println("| \tNIP GUru   \t\t|\t" + dataGuru[i][2] + "\t|");
            System.out.println("| \tStatus    \t\t|\t" + dataGuru[i][3] + "\t\t|");
            System.out.println("| \tStatus guru   \t\t|\t" + jawaban + "\t\t|");

            if (status.equalsIgnoreCase("pns")) {
                System.out.println("| \tGolongan   \t\t|\t" + dataGuru[i][4] + "\t\t|");
            }
            System.out.println("| \tGaji Guru   \t\t|\t" + gaji + "\t|");
            System.out.println("| \tTotal Gaji   \t\t|\t" + totalGaji + "\t|");
            System.out.println("| \tPotongan pajak   \t|\t" + potonganPajak + "\t|");
            System.out.println("| \tTotal slip gaji   \t|\t" + jadwalGaji[i][2] + "\t|");
            System.out.println("=========================================================");
            // }
        }

    }

    static void sudahGajiBelum(int pilihan) {
        // String[][] sudahbelum = new String[dataGuru.length][2]; // Array untuk
        // menyimpan data guru yang sudah digaji danbelum digaji
        // System.out.println("Daftar Penggajian Guru : ");
        // for (int i = 0; i < dataGuru.length; i++) {
        // System.out.println((i + 1) + ". " + dataGuru[i][0] + " - " +
        // sudahbelum[i][1]);
        // }
        // System.out.print("Pilih guru untuk penanda sudah atau belum digaji (nomor):
        // ");
        // int noguru = inputUser.nextInt() - 1;
        // inputUser.nextLine();
        // System.out.print("Masukkan format (sudah digaji)");
        // String penanda = inputUser.nextLine();
        // sudahbelum[noguru][0] = dataGuru[noguru][2];
        // sudahbelum[noguru][1] = penanda;
        // System.out.println("Guru " + dataGuru[noguru][0] + penanda);

        System.out.println("Daftar Penggajian Guru : ");
        for (int i = 0; i < dataGuru.length; i++) {
            sudahbelum[i][1] = jadwalGaji[i][1] != null ? "Sudah" : "Belum";
            System.out.println((i + 1) + ". " + dataGuru[i][0] + " - " + sudahbelum[i][1]);
        }
        System.out.println();
    }

    static void updateDataGuru(int pilihan) {
        tampilGuru(pilihan); // untuk menampilkan daftar data guru
        System.out.println();
        System.out.print("Pilih nomor urut guru yang ingin diupdate datanya(1,2,3...s) : ");
        int pilihGuru = inputUser.nextInt() - 1; // user memilih guru dari daftar guru
        // kondisi untuk melakukan update pada jabatan guru(golongan)
        System.out.print("Update golongan(PNS/Honorer) : ");
        dataGuru[pilihGuru][3] = inputUser.next(); // update golongan
        if (dataGuru[pilihGuru][3].equalsIgnoreCase("pns")) {
            System.out.print("Update Golongan PNS(1,2,3,4) : ");
            dataGuru[pilihGuru][4] = inputUser.next(); // update golongan pns
        } else {
            dataGuru[pilihGuru][4] = "-";
        }
        System.out.print("Update Jam mengajar per-Minggu : ");
        dataGuru[pilihGuru][5] = inputUser.next(); // update jam mengajar
    }

    static void caseLima(int pilihan) {
        System.out.println("Termikasih kami ucapkan!!!");
        System.exit(0);
        System.out.println();
    }

    // fungsi lapor gaji
    static void laporanGaji(int pilihan) {
        // String tanggalGaji = jadwalPenggajian(pilihan);
        System.out.print("Masukkan tanggal dan tahun penggajian(mm-yyyy) : ");
        bulan = inputUser.next();

        System.out.println("===============================================================================");
        System.out.println("|\tTanggal\t\t|\tSudah/Belum Gaji\t|\tPendapatan\t|");
        System.out.println("===============================================================================");
        for (int i = 0; i < dataGuru.length; i++) {
            // System.out.println("ini " + jadwalGaji[i][2]);
            if (jadwalGaji[i][2] != null) {
                String tanggal = jadwalGaji[i][1].substring(3, 10);
                // System.out.println(tanggal);
                // System.out.println("luar");
                if (bulan.equals(tanggal)) {
                    // System.out.println("dalam");
                    // check = jadwalGaji[i][1] != null ? "Sudah" : "Belum";

                    // System.out.println(bulan);
                    System.out.println("|\t" + jadwalGaji[i][1] + "\t|\t\t" + dataGuru[i][0] + "\t\t|\t"
                            + jadwalGaji[i][2] + "\t|");
                    System.out
                            .println("===============================================================================");
                }
            }
        }
    }

    
    // menu untuk memilih exit
    static void pilihanExit() {

        System.out.println();
        System.out.print("kembali lagi ke daftar menu? (y/n) : ");
        String next = inputUser.next();
        System.out.println();

        if (next.equalsIgnoreCase("n")) {
            System.out.println("Termikasih kami ucapkan!!!");
            System.out.println();
        }
    }

}