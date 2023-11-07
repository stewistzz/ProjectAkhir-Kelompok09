import java.util.Scanner;

public class SistemPenggajianBaru {
    public static void main(String[] args) {
        
        Scanner inputUser = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("| Program Penggajian Guru |");
        System.out.println("---------------------------");

        String namaGuru, status, jawaban;
        double tunjangan = 0, tarifPerJam = 0, gaji, totalGaji, pajak, potonganPajak = 0, slipGaji;
        int jumlahJam, tarif = 0, NIP, pendidikan, kehadiran=0, golongan=0, jumlahGuru;

        System.out.print("Masukkan jumlah guru mengajar : ");
        jumlahGuru = inputUser.nextInt();

        //perulangan 
        for (int i = 0; i < jumlahGuru; i++) {
            
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
            } while (pendidikan != 1 && pendidikan != 2);
            

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

            } while (!jawaban.equalsIgnoreCase("ya") && !jawaban.equalsIgnoreCase("tidak"));


            
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
                
            } while (!status.equalsIgnoreCase("pns") && !status.equalsIgnoreCase("honorer"));

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
            gaji = jumlahJam * 7 * tarifPerJam;
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
            System.out.println("------------------------");
            System.out.println("| Data Hasil Gaji Guru |");
            System.out.println("------------------------");
            System.out.println("| Nama Guru      | " + namaGuru );
            System.out.println("| NIP GUru       | " + NIP );
            System.out.println("| Status Guru    | " + status );
            System.out.println("| Status guru    | " + jawaban );
            System.out.println("| Golongan       | " + golongan );
            System.out.println("| Gaji Guru      | " + gaji );
            System.out.println("| Total Gaji     | " + totalGaji );
            System.out.println("| Potongan pajak | " + potonganPajak );
            System.out.println("| Total slip gaji| " + slipGaji);
            System.out.println("------------------------");
        }
    }
}
