import java.util.Arrays;
import java.util.Scanner;

public class SistemPenggajianBaru {
    public static void main(String[] args) {
        
        Scanner inputUser = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("| Program Penggajian Guru |");
        System.out.println("---------------------------");

        String status, jawaban, namaGuru;
        double tunjangan = 0, tarifPerJam = 0, gaji, totalGaji, pajak, potonganPajak = 0, slipGaji;
        int jumlahJam, tarif = 0, NIP, pendidikan, kehadiran=0, golongan=0, jumlahGuru, tarifHonorer;

        String[][] dataGuru= {
            { "Dimas\t", "S1\t", "234234234\t", "PNS\t\t", "Golongan IV\t", "6 jam perminggu" },
            {"Daffa\t", "S1\t","123123123\t", "PNS\t\t", "Golongan II\t", "6 jam perminggu"},
            {"Agus\t", "S1\t","345345345\t", "PNS\t\t", "Golongan I\t", "5 jam perminggu"},
            {"prime\t", "S1\t", "456456456\t", "Honorer\t\t\t", "5 jam perminggu"}
        };

        String[][] jadwalGaji = new String[dataGuru.length][2]; // Array untuk menyimpan jadwal penggajian guru
        String[][] sudahbelum = new String[dataGuru.length][2]; // Array untuk menyimpan data guru yang sudah digaji dan belum digaji
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
                    for (String[] guru : dataGuru) {
                        for (String data : guru) {
                        System.out.print(data + " ");
                        }
                        System.out.println();
                    }
                break;

                // MENNU UNTUK PENJADWALAN GAJI GURU
                case 2:
                    System.out.println("Jadwal Penggajian Guru : ");
                    for (int i = 0; i < dataGuru.length; i++) {
                        System.out.println((i + 1) + ". " + dataGuru[i][0] + " - " + jadwalGaji[i][1]);
                    }

                    System.out.print("Pilih guru untuk dijadwalkan penggajiannya (nomor): ");
                    int nomorGuru = inputUser.nextInt() - 1;
                    inputUser.nextLine();

                    System.out.print("Masukkan tanggal penggajian (format: DD-MM-YYYY): ");
                    String tanggalPenggajian = inputUser.nextLine();

                    jadwalGaji[nomorGuru][0] = dataGuru[nomorGuru][2];
                    jadwalGaji[nomorGuru][1] = tanggalPenggajian;

                    System.out.println("Jadwal penggajian untuk guru " + dataGuru[nomorGuru][0] +"telah dijadwalkan pada tanggal " + tanggalPenggajian);

                break;

                // MENU INPUT DAN OUTPUT PENGGAJIAN
                case 3 : 
                    // System.out.print("Masukkan jumlah guru mengajar : ");
                    // jumlahGuru = inputUser.nextInt();
                    //perulangan 
                    //for (int i = 0; i < jumlahGuru; i++) {
                        // masukkan informasi dari guru
                        System.out.print("Masukkan Nama Guru : ");
                        namaGuru = inputUser.next();
                        System.out.print("Masukkan NIP : ");
                        NIP = inputUser.nextInt();
                        
                        do {  
                            // cek pendidikan terakhir dari guru tersebut
                            System.out.print("Pendidikan terakhir guru : \n1. S1\n2. S2 \n jawaban anda : ");
                            pendidikan = inputUser.nextInt();                
                                if (pendidikan==1) {
                                    System.out.println(namaGuru + " sebelumnya menempuh pendidikan S1");
                                }
                                else if(pendidikan==2) {
                                    System.out.println(namaGuru + " sebelumnya menempuh pendidikan S2");
                                } else {
                                    System.out.println(namaGuru + " Tidak menenmpuh pendidikan sarjana");
                                    
                                }
                        } while (pendidikan == 1 && pendidikan == 2);
                        

                        do {
                            // cek apakah guru tersebut masih aktif mengajar atau tidak
                            System.out.print("Apakah Guru tersebut masih aktif mengajar? (ya/tidak) : ");
                            jawaban = inputUser.next();

                            do {
                                if(jawaban.equalsIgnoreCase("ya")){
                                    System.out.println(namaGuru + " masih aktif mengajar");
                                    System.out.print("Masukkan kehadiran guru hari ini : \n1. hadir\n2. izin \n3. sakit \n4. alpha \n jawaban anda : ");
                                    kehadiran = inputUser.nextInt();
                                    if(kehadiran==1) {
                                        System.out.println(namaGuru + " saat ini hadir");
                                    } else if(kehadiran==2){
                                        System.out.println(namaGuru + " sedang berhalangan hadir karena izin");
                                    } else if(kehadiran==3) {
                                        System.out.println(namaGuru + " sedang berhalangan hadir karena sakit");
                                    } else if(kehadiran==4) {
                                        System.out.println(namaGuru + " Tidak masuk tanpa keterangan(alpha)");
                                    } else {
                                        System.out.println("Guru Sudah tidak aktif");
                                    }
                                } else {
                                    System.out.println(namaGuru + " Sudah tidak aktif mengajar");
                                }
                            } while (kehadiran < 1 || kehadiran >4);

                        } while (jawaban.equalsIgnoreCase("ya") && jawaban.equalsIgnoreCase("tidak"));


                        inputUser.nextLine();
                        do {
                            System.out.print("Masukkan Status PNS/HONORER? : ");
                            status = inputUser.nextLine();
                                
                                // Proses status guru
                                if (status.equalsIgnoreCase("PNS")) {
                                    System.out.print("Masukkan golongan guru, contoh : \n1. I \n2. II \n3. III \n4. IV \n jawaban anda = ");
                                    golongan = inputUser.nextInt();
                                } else if (status.equalsIgnoreCase("HONORER")){
                                    System.out.print("Masukkan tarif mengajar perjamnnya = ");
                                    tarifPerJam = inputUser.nextInt();
                                }else {
                                    System.out.println("Status yang anda masukkan tidak valid");
                                    return;
                                }
                        } while (status.equalsIgnoreCase("pns") && status.equalsIgnoreCase("honorer"));

                        // jumlah jam mengajar
                        System.out.print("Masukkan jumlah jam mengajar(per jam kali 7 hari) = ");
                        jumlahJam = inputUser.nextInt();

                        // menghitung Gaji Guru
                        switch(golongan) {
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
                        gaji = jumlahJam * 4 * tarifPerJam;
                        System.out.println("Perhitungan Gaji Guru = " + gaji + " Rupiah");

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
                        
                        if (golongan==1) {
                            potonganPajak = totalGaji * 0.01;
                            System.out.println(potonganPajak);
                        } else if (golongan==2) {
                            potonganPajak = totalGaji * 0.02;
                            System.out.println(potonganPajak);
                        } else if (golongan==3) {
                            potonganPajak = totalGaji * 0.03;
                            System.out.println(potonganPajak);
                        } else if (golongan==4) {
                            potonganPajak = totalGaji * 0.04;
                            System.out.println(potonganPajak);
                        }else {
                            potonganPajak = totalGaji;
                            System.out.println(potonganPajak);
                        }
                        slipGaji = totalGaji - potonganPajak;
                        // Data yang di print
                       System.out.println("=========================================================");
                       System.out.println("| \t\tData   \t\t|  \tDetail Guru \t|");
                       System.out.println("=========================================================");
                       System.out.println("| \tNama Guru   \t\t|\t" + namaGuru +"\t\t|");
                       System.out.println("| \tNIP GUru   \t\t|\t" + NIP +"\t|");
                       System.out.println("| \tStatus Guru   \t\t|\t" + status +"\t\t|");
                       System.out.println("| \tStatus guru   \t\t|\t" + jawaban +"\t\t|");

                       if (status.equalsIgnoreCase("pns")) {
                           System.out.println("| \tGolongan   \t\t|\t" + golongan +"\t\t|");
                       }
                       System.out.println("| \tGaji Guru   \t\t|\t" + gaji +"\t|");
                       System.out.println("| \tTotal Gaji   \t\t|\t" + totalGaji    +"\t|");
                       System.out.println("| \tPotongan pajak   \t|\t" + potonganPajak +"\t|");
                       System.out.println("| \tTotal slip gaji   \t|\t" + slipGaji     +"\t|");
                       System.out.println("=========================================================");
                   //}
                break;

                // menu untuk menandai guru mana yang sudah di gaji dan belum di gaji 
                case 4 :
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
                   //menu exit
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
