package ktpGen;

import java.util.*;

public class KtpMain {
    public static void main(String[] args) {
        OperasiKtp ok = new OperasiKtp();
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        Scanner scc = new Scanner(System.in);

        boolean ulang = true;

        int pilihan, tglLahir, blnLahir, thnLahir, rt, rw;
        char jk, golDarah;
        String nik, nama, kotaLahir, alamat, kel, kec, kota, prov, agama = "", statusNikah = "", pekerjaan; 

        while (ulang) {
            System.out.println();
            System.out.println("+------------------------+");
            System.out.println("| SISTEM MANAJEMEN E-KTP |");
            System.out.println("+------------------------+");
            System.out.println("| -> [1] Pembuatan KTP   |");
            System.out.println("| -> [2] Tampilkan KTP   |");
            System.out.println("| -> [3] Cari KTP        |");
            System.out.println("| -> [3] Hapus KTP       |");
            System.out.println("| -> [0] Keluar          |");
            System.out.println("+------------------------+");
            System.out.print("-> Masukan Pilihan: ");
            pilihan = sci.nextInt();
            switch (pilihan) {
            case 1:
                System.out.println();
                System.out.println("PEMBUATAN KTP BARU");
                System.out.println("------------------");

                System.out.print("Nama lengkap \t\t: ");
                nama = scs.nextLine();

                System.out.print("Kota kelahiran \t\t: ");
                kotaLahir = scs.nextLine();

                do {
                    System.out.print("Tanggal lahir \t\t: ");
                    tglLahir = sci.nextInt();
                } while (tglLahir > 31 || tglLahir < 1);

                do {
                    System.out.print("Bulan lahir (angka)\t: ");
                    blnLahir = sci.nextInt();
                } while (tglLahir > 12 && tglLahir < 1);

                System.out.print("Tahun lahir \t\t: ");
                thnLahir = sci.nextInt();
                
                do {
                    System.out.print("Jenis kelamin (L/P)\t: ");
                    jk = scc.next().charAt(0);
                } while (!ok.isJk(jk));
                
                do {
                    System.out.print("Gol. Darah \t\t: ");
                    golDarah = scc.next().charAt(0);
                } while (!ok.isGolDarah(golDarah));
                
                System.out.print("Alamat \t\t\t: ");
                alamat = scs.nextLine();

                System.out.print("RT \t\t\t: ");
                rt = sci.nextInt();

                System.out.print("RW \t\t\t: ");
                rw = sci.nextInt();
                
                System.out.print("Kel/Desa \t\t: ");
                kel = scs.nextLine();
                
                System.out.print("Kecamatan \t\t: ");
                kec = scs.nextLine();

                System.out.print("Kota \t\t\t: ");
                kota = scs.nextLine();

                System.out.print("Provinsi \t\t: ");
                prov = scs.nextLine();
                
                System.out.println();
                System.out.println("[1] Islam");
                System.out.println("[2] Protestan");
                System.out.println("[3] Katolik");
                System.out.println("[4] Hindu");
                System.out.println("[5] Buddha");
                System.out.println("[6] Kong Hu Cu");
                System.out.println("----------------");
                do {
                    System.out.print("Agama (nomor) \t: ");
                    pilihan = sci.nextInt();
                    switch (pilihan) {
                        case 1:
                            agama = "Islam";
                            break;
                        case 2:
                            agama = "Protestan";
                            break;
                        case 3:
                            agama = "Katolik";
                            break;
                        case 4:
                            agama = "Hindu";
                            break;
                        case 5:
                            agama = "Buddha";
                            break;
                        case 6:
                            agama = "Kong Hu Cu";
                            break;
                    
                        default:
                            System.out.println("Nomor salah");
                            break;
                    }
                } while (pilihan > 6 || pilihan < 1);
                
                System.out.println();
                System.out.println("[1] Kawin");
                System.out.println("[2] Belum Kawin");
                System.out.println("----------------");
                do {
                    System.out.print("Status Perkawinan (nomor)\t: ");
                    pilihan = sci.nextInt();
                    switch (pilihan) {
                        case 1:
                            statusNikah = "Kawin";
                            break;
                        case 2:
                            statusNikah = "Belum Kawin";
                            break;                    
                        default:
                            System.out.println("Nomor salah");
                            break;
                    }
                } while (pilihan > 2 || pilihan < 1);
                
                System.out.print("Pekerjaan \t\t: ");
                pekerjaan = scs.nextLine();

                System.out.println();
                ok.add(nama, kotaLahir, tglLahir, blnLahir, thnLahir, jk, alamat, rt, rw, kel, kec, kota, prov, agama, statusNikah, pekerjaan, golDarah);
                break;
            case 2:
                System.out.println();
                ok.print();
                System.out.println();
                System.out.println("---------------------------");
                System.out.print("-> pilih nomor: ");
                pilihan = sci.nextInt();
                System.out.println();
                ok.printNomor(pilihan);
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                System.out.print("Keluar ");
                ulang = false;
                break;
            default:
                System.out.print("Input salah, ulangi! ");
                break;
            }
            System.out.println();
            System.out.print("Tekan [ENTER]");
            scs.nextLine();
        }

    }
}
