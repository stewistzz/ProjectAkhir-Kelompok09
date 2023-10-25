import java.util.Scanner;

public class SistemPenggajianBaru {
    public static void main(String[] args) {
        
        Scanner inputUser = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("| Program Penggajian Guru |");
        System.out.println("---------------------------");

        String namaGuru, status, golongan = "",pendidikan,S2, S1, jawaban, kehadiran, sakit, izin, alpha;
        double tunjangan = 0, tarifPerJam = 0, gaji, totalGaji, pajak, potonganPajak = 0;
        int jumlahJam, tarif = 0, NIP;

        // masukkan informasi dari guru
        System.out.print("Masukkan Nama Guru : ");
        namaGuru = inputUser.nextLine();
        System.out.print("Masukkan NIP : ");
        NIP = inputUser.nextInt();

        // cek pendidikan terakhir dari guru tersebut
        System.out.print("Pendidikan terakhir guru(S1/S2) : ");
        pendidikan = inputUser.next();
        if (pendidikan.equalsIgnoreCase("S2")) {
            System.out.println(namaGuru + " sebelumnya menempuh pendidikan S2");
        } else {
            System.out.println(namaGuru + " sebelumnya menempuh pendidikan S1");
            
        }



        // cek apakah guru tersebut masih aktif mengajar atau tidak
        System.out.print("Apakah Guru tersebut masih aktif mengajar? (ya/tidak) : ");
        jawaban = inputUser.next();

        if(jawaban.equalsIgnoreCase("ya")){
            System.out.println(namaGuru + " masih aktif mengajar");
            System.out.print("Masukkan kehadiran guru hari ini : ");
            kehadiran = inputUser.next();
            if(kehadiran.equalsIgnoreCase("hadir")) {
                System.out.println(namaGuru + " saat ini hadir");
            } else if(kehadiran.equalsIgnoreCase("izin")){
                System.out.println(namaGuru + " sedang berhalangan hadir karena izin");
            } else if(kehadiran.equalsIgnoreCase("Sakit")) {
                System.out.println(namaGuru + " sedang berhalangan hadir karena sakit");
            } else if(kehadiran.equalsIgnoreCase("Alpha")) {
                System.out.println(namaGuru + " Tidak masuk tanpa keterangan(alpha)");
            } else {
                System.out.println("Guru Sudah tidak aktif");
            }
        } else {
            System.out.println(namaGuru + " Sudah tidak aktif mengajar");
        }


        
        inputUser.nextLine();

        System.out.print("Masukkan Status PNS/HONORER? : ");
        status = inputUser.nextLine();
       
        // Proses status guru
        if (status.equalsIgnoreCase("PNS")) {
            System.out.print("Masukkan golongan guru, contoh : I, II, III, IV = ");
            golongan = inputUser.nextLine();
        } else if (status.equalsIgnoreCase("HONORER")){
            System.out.print("Masukkan tarif mengajar perjamnnya = ");
            tarifPerJam = inputUser.nextInt();
        }else {
            System.out.println("Status yang anda masukkan tidak valid");
            return;
        }

        // jumlah jam mengajar
        System.out.print("Masukkan jumlah jam mengajar(per jam kali 7 hari) = ");
        jumlahJam = inputUser.nextInt();

        // menghitung Gaji Guru
        switch(golongan) {
                case "I":
                    tarifPerJam = 100000;
                    break;
                case "II":
                    tarifPerJam = 120000;
                    break;
                case "III":
                    tarifPerJam = 140000;
                    break;
                case "IV":
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
            case "I":
                tunjangan = 200000;
                break;
            case "II":
                tunjangan = 220000;
                break;
            case "III":
                tunjangan = 240000;
                break;
            case "IV":
                tunjangan = 260000;
                break;
        
            default:
                tunjangan = 0;
                break;
        }
        totalGaji = gaji + tunjangan;
        System.out.println("Perhitungan Total Gaji Guru = " + totalGaji + " Rupiah");
        
        if (golongan.equalsIgnoreCase("I")) {
            potonganPajak = totalGaji * 0.01;
            System.out.println(potonganPajak);
        } else if (golongan.equalsIgnoreCase("II")) {
            potonganPajak = totalGaji * 0.02;
            System.out.println(potonganPajak);
        } else if (golongan.equalsIgnoreCase("III")) {
            potonganPajak = totalGaji * 0.03;
            System.out.println(potonganPajak);
        } else if (golongan.equalsIgnoreCase("IV")) {
            potonganPajak = totalGaji * 0.04;
            System.out.println(potonganPajak);
        }else {
            potonganPajak = totalGaji * 0.005;
            System.out.println(potonganPajak);
        }

        double slipGaji = totalGaji - potonganPajak;
        


        // Data yang di print
        System.out.println("------------------------");
        System.out.println("| Data Hasil Gaji Guru |");
        System.out.println("------------------------");
        System.out.println("| Nama Guru   | " + namaGuru + " |");
        System.out.println("| NIP GUru    | " + NIP + " |");
        System.out.println("| Status Guru | " + status + " |");
        System.out.println("| Golongan    | " + golongan + " |");
        System.out.println("| Gaji Guru   | " + gaji + " |");
        System.out.println("| Total Gaji  | " + totalGaji + " |");
        System.out.println("Potongan pajak | " + potonganPajak + " |");
        System.out.println("Total slip gaji  | " + slipGaji + " |");
        System.out.println("------------------------");
        
        
    }
}
