import java.util.Arrays;
import java.util.Scanner;

public class ISistemGajiGuruDinamis {

    static void jumlahBarisArray() {
        
    }

    public static void main(String[] args) {

        Scanner inputUser = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("| Program Penggajian Guru |");
        System.out.println("---------------------------");

        String status, jawaban, namaGuru, NIP;
        double tunjangan = 0, tarifPerJam = 0, gaji, totalGaji, potonganPajak = 0, slipGaji, hitungAbsen = 0;
        int jumlahJam, tarif = 0, pendidikan, kehadiran = 0, golongan = 0, tarifHonorer,
                jmlHariAbsen = 0, barsiGuru = 0, kolomGuru = 0;

        System.out.print("Jumlah Baris Data\t: ");
        barsiGuru = inputUser.nextInt();
        // System.out.print("Masukkan jumlah kolom data = ");
        // kolomGuru = inputUser.nextInt();

        String[][] dataGuru = new String[barsiGuru][6];

        for (int i = 0; i < dataGuru.length; i++) {
            for (int j = 0; j < dataGuru[i].length; j++) {
                if (j == 0) {
                    System.out.print("Nama guru\t\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 1) {
                    System.out.print("Riwayat pendidikan\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 2) {
                    System.out.print("NIP Guru \t\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 3) {
                    System.out.print("Status (PNS/Honorer)\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
                if (j == 4) {
                    if (dataGuru[i][3].equalsIgnoreCase("Honorer")) {
                        continue;
                    } else {
                        System.out.print("Masukkan Golongan\t: ");
                        dataGuru[i][j] = inputUser.next();
                    }
                }
                if (j == 5) {
                    System.out.print("Jumlah jam mengajar\t: ");
                    dataGuru[i][j] = inputUser.next();
                }
            }
            System.out.println();
        }

        String[][] jadwalGaji = new String[dataGuru.length][2]; // Array untuk menyimpan jadwal penggajian guru
        String[][] sudahbelum = new String[dataGuru.length][2]; // Array untuk menyimpan data guru yang sudah digaji dan
                                                                // belum digaji
        // array nama guru
        while (true) {
            System.out.println("Daftar menu : ");
            System.out.println("1. Menu Daftar Data Guru");
            System.out.println("2. Menu jadwal penggajian guru");
            System.out.println("3. Menu input dan output penggajian");
            System.out.println("4. Menu daftar guru yang sudah dan belum digaji");
            System.out.println("5. Menu exit");
            System.out.print("Masukkan menu yang ingin dipilih(1,2,3,..) : ");
            int pilihan = inputUser.nextInt();
            System.out.println();

            switch (pilihan) {
                // MENU MENAMPILKAN DATA GURU
                case 1:
                    // Menampilkan array dataGuru
                    System.out.println(" Nama \t Pendidikan \t NIP Guru \t StatusGuru \t Golongan \t Jumlah jam");
                    System.out.println("=========================================================================================");
                    for (String[] guru : dataGuru) {
                        for (String data : guru) {
                            System.out.print(data + " \t ");
                        }
                        System.out.println();
                    }
                    break;

                // MENNU UNTUK PENJADWALAN GAJI GURU
                case 2:
                    System.out.println("Jadwal Penggajian Guru : ");
                    for (int i = 0; i < dataGuru.length; i++) {
                        System.out.println((i + 1) + ". " + dataGuru[i][0] + "\t" + " - " + "\t" + jadwalGaji[i][1]);
                    }

                    System.out.print("Pilih guru untuk dijadwalkan penggajiannya (nomor): ");
                    int nomorGuru = inputUser.nextInt() - 1;
                    inputUser.nextLine();

                    System.out.print("Masukkan tanggal penggajian (format: DD-MM-YYYY): ");
                    String tanggalPenggajian = inputUser.nextLine();

                    jadwalGaji[nomorGuru][0] = dataGuru[nomorGuru][2];
                    jadwalGaji[nomorGuru][1] = tanggalPenggajian;

                    System.out.println("Jadwal penggajian untuk guru " + dataGuru[nomorGuru][0]
                            + "telah dijadwalkan pada tanggal " + tanggalPenggajian);

                    break;

                // MENU INPUT DAN OUTPUT PENGGAJIAN
                case 3:
                    // perulangan jika nama guru tidak sesuai
                    while (true) {

                        System.out.print("Masukkan Nama Guru : ");
                        namaGuru = inputUser.next();
                        

                        // // kondisi jika nama guru tidak sesuai dengan yang ada pada dataGuru

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
                                    "Peringatan!!! \n data guru yang anda inputkan tidak sesuai dengan data yang ada!!");
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
                            if  (dataGuru[i][2].equals(NIP)) {
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
                    

                    do {
                        // cek pendidikan terakhir dari guru tersebut
                        System.out.print("Pendidikan terakhir guru : \n1. S1\n2. S2 \n jawaban anda : ");
                        pendidikan = inputUser.nextInt();
                        if (pendidikan == 1) {
                            System.out.println(namaGuru + " sebelumnya menempuh pendidikan S1");
                        } else if (pendidikan == 2) {
                            System.out.println(namaGuru + " sebelumnya menempuh pendidikan S2");
                        } else {
                            System.out.println(namaGuru + " Tidak menenmpuh pendidikan sarjana");

                        }
                    } while (pendidikan == 1 && pendidikan == 2);

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
                            } else if (jawaban.equalsIgnoreCase("non-aktif")) { // kondisi untuk cut system jika guru
                                                                                // tidak aktif
                                System.out.println(namaGuru + " Sudah tidak aktif mengajar");
                                System.exit(0);
                            } else {
                                System.out.println("Status guru tidak diketahui!!");
                            }

                            // jika kehadiran != 1, maka tanyakan berapa hari?,kemudian tambah hari
                            // ketidkahadiran untuk guru tersebut kedalam jmlHariAbsen

                        } while (kehadiran < 1 || kehadiran > 4);
                        System.out.println();

                    } while (!jawaban.equalsIgnoreCase("aktif") && !jawaban.equalsIgnoreCase("non-aktif"));

                    inputUser.nextLine();
                    do {
                        System.out.print("Masukkan Status PNS/HONORER? : ");
                        status = inputUser.nextLine();

                        // Proses status guru
                        if (status.equalsIgnoreCase("PNS")) {
                            System.out.print(
                                    "Masukkan golongan guru, contoh : \n1. I \n2. II \n3. III \n4. IV \n jawaban anda = ");
                            golongan = inputUser.nextInt();
                        } else if (status.equalsIgnoreCase("HONORER")) {
                            System.out.print("Masukkan tarif mengajar perjamnnya = ");
                            tarifPerJam = inputUser.nextInt();
                        } else {
                            System.out.println("Status yang anda masukkan tidak valid");
                            return;
                        }
                    } while (status.equalsIgnoreCase("pns") && status.equalsIgnoreCase("honorer"));

                    // jumlah jam mengajar
                    System.out.print("Masukkan jumlah jam mengajar(per jam kali 7 hari) = ");
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
                            // tarifPerJam = 50000;
                            System.out.println("Tarif perjam honorer " + tarif);
                            break;
                    }

                    // Mempertimbangkan gaji guru dengan kehadiran guru, dengan mengurangi biaya
                    // gaji yang dikalikan banyak hari tidakmasuk
                    if (status.equalsIgnoreCase("pns")) {
                        System.out.print("Berapa lama guru " + namaGuru
                                + " tidak masuk mengajar (Selain absesni hadir maka dapat ditambahkan)? ");
                        jmlHariAbsen = inputUser.nextInt();
                        System.out.println("guru tidak hadir selama " + jmlHariAbsen + " kali");

                        hitungAbsen = jmlHariAbsen * tarifPerJam;
                    }

                    gaji = jumlahJam * 4 * tarifPerJam - hitungAbsen;
                    System.out.println("Perhitungan Gaji Guru \t\t\t = " + gaji + " Rupiah");

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
                    System.out.println("Perhitungan Total Gaji Guru = " + totalGaji + " Rupiah");

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
                        potonganPajak = totalGaji;
                        System.out.println(potonganPajak);
                    }
                    slipGaji = totalGaji - potonganPajak;
                    // Data yang di print
                    System.out.println("=========================================================");
                    System.out.println("| \t\tData   \t\t|  \tDetail Guru \t|");
                    System.out.println("=========================================================");
                    System.out.println("| \tNama Guru   \t\t|\t" + namaGuru + "\t\t|");
                    System.out.println("| \tNIP GUru   \t\t|\t" + NIP + "\t|");
                    System.out.println("| \tStatus Guru   \t\t|\t" + status + "\t\t|");
                    System.out.println("| \tStatus guru   \t\t|\t" + jawaban + "\t\t|");

                    if (status.equalsIgnoreCase("pns")) {
                        System.out.println("| \tGolongan   \t\t|\t" + golongan + "\t\t|");
                    }
                    System.out.println("| \tGaji Guru   \t\t|\t" + gaji + "\t|");
                    System.out.println("| \tTotal Gaji   \t\t|\t" + totalGaji + "\t|");
                    System.out.println("| \tPotongan pajak   \t|\t" + potonganPajak + "\t|");
                    System.out.println("| \tTotal slip gaji   \t|\t" + slipGaji + "\t|");
                    System.out.println("=========================================================");
                    // }
                    break;

                // menu untuk menandai guru mana yang sudah di gaji dan belum di gaji
                case 4:
                    System.out.println("Daftar Penggajian Guru : ");
                    for (int i = 0; i < dataGuru.length; i++) {
                        System.out.println((i + 1) + ". " + dataGuru[i][0] + " - " + sudahbelum[i][1]);
                    }

                    System.out.print("Pilih guru untuk penanda sudah atau belum digaji (nomor): ");
                    int noguru = inputUser.nextInt() - 1;
                    inputUser.nextLine();

                    System.out.print("Masukkan format (sudah digaji)");
                    String penanda = inputUser.nextLine();

                    sudahbelum[noguru][0] = dataGuru[noguru][2];
                    sudahbelum[noguru][1] = penanda;

                    System.out.println("Guru " + dataGuru[noguru][0] + penanda);

                    break;

                case 5:
                    // menu exit
                    System.out.println("Termikasih kami ucapkan!!!");
                    System.exit(0);
                    System.out.println();

                    break;

                default:
                    System.out.println("Anda memasukkan nomor menu yang salah");
                    break;
            }

            // jika baris dan kolom kursi tidak tersedia maka kembali ke daftar menu
            System.out.println();
            System.out.print("kembali lagi ke daftar menu? (y/n) : ");
            String next = inputUser.next();
            System.out.println();

            if (next.equalsIgnoreCase("n")) {
                System.out.println("Termikasih kami ucapkan!!!");
                System.out.println();
                break;
            }
        }
    }
}
