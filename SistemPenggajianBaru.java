import java.util.Scanner;

public class SistemPenggajianBaru {
    public static void main(String[] args) {
        
        Scanner inputUser = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("Program Penggajian Guru");
        System.out.println("------------------------");

        String namaGuru, status, golongan = "";
        double tunjangan = 0, tarifPerJam = 0, gaji, totalGaji;
        int jumlahJam, tarif = 0, NIP;

        // masukkan informasi dari guru
        System.out.print("Masukkan Nama Guru : ");
        namaGuru = inputUser.nextLine();
        System.out.print("Masukkan NIP : ");
        NIP = inputUser.nextInt();
        inputUser.nextLine();

        System.out.print("Masukkan Status PNS/HONORER? : ");
        status = inputUser.nextLine();
       
        // Proses status guru
        if (status.equals("PNS")) {
            System.out.print("Masukkan golongan guru, contoh : I, II, III, IV = ");
            golongan = inputUser.nextLine();
        } else if (status.equals("HONORER")){
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
        gaji = jumlahJam * tarifPerJam;
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
        System.out.println("------------------------");
        
        
    }
}
