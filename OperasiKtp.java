package ktpGen;

import java.util.*;

public class OperasiKtp {
    NodeKtp head;
    int size;

    public Random rn = new Random();

    public OperasiKtp() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void addFirst(String nik, String nama, String kotaLahir, int tglLahir, int blnLahir, int thnLahir, char jk, String alamat, int rt, int rw,String kel, String kec, String kota, String prov, String agama, String statusNikah, String pekerjaan, String kwn, char golDarah) {
        if (isEmpty()) {
            head = new NodeKtp(null, nik, nama, kotaLahir, tglLahir, blnLahir, thnLahir, jk, alamat, rt, rw, kel, kec, kota, prov, agama, statusNikah, pekerjaan, kwn, golDarah, null);
        } else {
            NodeKtp newNode = new NodeKtp(null, nik, nama, kotaLahir, tglLahir, blnLahir, thnLahir, jk, alamat, rt, rw, kel, kec, kota, prov, agama, statusNikah, pekerjaan, kwn, golDarah, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void add(String nama, String kotaLahir, int tglLahir, int blnLahir, int thnLahir, char jk, String alamat, int rt, int rw,String kel, String kec, String kota, String prov, String agama, String statusNikah, String pekerjaan, char golDarah) {
        
        // Random kode provinsi, kota, kecamatan
        // total: 6 digit
        int num6digit = rn.nextInt(900000) + 100000;

        // Mengubah tgl, bln, thn lahir kedalam kode NIK
        // total: 6 digit
        String thnLahirStr = "" + thnLahir;
        String thnSubstring = thnLahirStr.length() > 2 ? thnLahirStr.substring(thnLahirStr.length() - 2) : thnLahirStr;
        String tglLahirFix = (tglLahir < 10) ? "0" + tglLahir : "" + tglLahir;
        String blnLahirFix = (blnLahir < 10) ? "0" + blnLahir : "" + blnLahir;

        // Random kode unik E-KTP
        // total: 4 digit
        int noElektronik = rn.nextInt(9000) + 1000;

        // Hasil kombinasi NIK
        // total: 16 digit
        String nik = "" + num6digit + tglLahirFix + blnLahirFix + thnSubstring + noElektronik;
        
        String kwn = "WNI";
        if (isEmpty()) {
            addFirst(nik, nama, kotaLahir, tglLahir, blnLahir, thnLahir, jk, alamat, rt, rw, kel, kec, kota, prov, agama, statusNikah, pekerjaan, kwn, golDarah);
        } else {
            NodeKtp current = head;
            while (current.next != null) {
                current = current.next;
            }
            NodeKtp newNode = new NodeKtp(current, nik, nama, kotaLahir, tglLahir, blnLahir, thnLahir, jk, alamat, rt, rw, kel, kec, kota, prov, agama, statusNikah, pekerjaan, kwn, golDarah, null);
            current.next = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            int i = 1;
            NodeKtp tmp = head;
            System.out.println(" No.\tNIK\t\t\tNama");
            System.out.println("----------------------------------------");
            while (tmp != null) {
                System.out.println("[" + i + "]\t" + tmp.nik + "\t" + tmp.nama);
                tmp = tmp.next;
                i++;
            }
            System.out.println("----------------------------------------");
            System.out.println("Total: " + size + " data KTP ditemukan");
        } else
            System.out.println("Data KTP masih kosong");
    }

    /* public void printByKelas(String kelas) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar siswa masih kosong");
        boolean ditemukan = false;
        NodeKtp tmp = head;
        int jumlah = 0;
        System.out.println("Kelas\t NIS\tNama");
        System.out.println("----------------------");
        for (int i = 0; i < size; i++) {
            if (tmp.kelas.equalsIgnoreCase(kelas)) {
                ditemukan = true;
                System.out.println(tmp.kelas + "\t[" + tmp.nis + "]\t" + tmp.nama);
                jumlah++;
            }
            tmp = tmp.next;
        }
        if (!ditemukan) {
            System.out.println("----------------------");
            throw new Exception("Nilai tidak ditemukan");
        } else {
            System.out.println("----------------------");
            System.out.println("-> " + jumlah + " Data ditemukan");
        }
    } */

    public void removeFirst() {
        if (isEmpty())
            System.out.println("Data KTP masih kosong, tidak dapat dihapus");
        else if (size == 1)
            removeLast();
        else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty())
            System.out.println("Data KTP masih kosong, tidak dapat dihapus");
        else {
            if (head.next == null) {
                head = null;
                size--;
            } else {
                NodeKtp current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
                size--;
            }
        }
    }

    public String getBulan(int blnLahir) {
        String bulan = "Bulan kosong";
        switch (blnLahir) {
            case 1:
                bulan = "Januari";
                break;
            case 2:
                bulan = "Februari";
                break;
            case 3:
                bulan = "Maret";
                break;
            case 4:
                bulan = "April";
                break;
            case 5:
                bulan = "Mei";
                break;
            case 6:
                bulan = "Juni";
                break;
            case 7:
                bulan = "Juli";
                break;
            case 8:
                bulan = "Agustus";
                break;
            case 9:
                bulan = "September";
                break;
            case 10:
                bulan = "Oktober";
                break;
            case 11:
                bulan = "November";
                break;
            case 12:
                bulan = "Desember";
                break;
        }
        return bulan;
    }

    public void search(String nik) {
        if (isEmpty())
            System.out.println("Data KTP masih kosong");
        else {
            boolean ditemukan = false;
            NodeKtp tmp = head;
            for (int i = 0; i < size; i++) {
                if (!tmp.nik.equals(nik)) {
                    tmp = tmp.next;
                } else {
                    ditemukan = true;
                    break;
                }
            }
            if (!ditemukan)
                System.out.println("KTP tidak ditemukan");
            else {
                System.out.println("Data KTP ditemukan");
                System.out.println("-------------------------------");
                System.out.println("\tPROVINSI " + tmp.prov.toUpperCase());
                System.out.println("\tKOTA " + tmp.kota.toUpperCase());
                System.out.println();
                System.out.println("NIK \t\t\t: " + tmp.nik);
                System.out.println("Nama \t\t\t: " + tmp.nama);
                System.out.println("Tempat/Tgl Lahir \t: " + tmp.kotaLahir + ", " + tmp.tglLahir + " " + getBulan(tmp.blnLahir) + " " + tmp.thnLahir);
                System.out.println("Jenis Kelamin \t\t: " + getJk(tmp.jk));
                System.out.println("Gol. Darah \t\t: " + tmp.golDarah);
                System.out.println("Alamat \t\t\t: " + tmp.alamat);
                System.out.println("\tRT/RW \t\t: " + "RT." + tmp.rt + " / RW." + tmp.rw);
                System.out.println("\tKel/Desa \t: " + tmp.kel);
                System.out.println("\tKecamatan \t: " + tmp.kec);
                System.out.println("Agama \t\t\t: " + tmp.agama);
                System.out.println("Status Perkawinan \t: " + tmp.statusNikah);
                System.out.println("Pekerjaan \t\t: " + tmp.pekerjaan);
                System.out.println("Kewarganegaraan \t: " + tmp.kwn);
                System.out.println("-------------------------------");
            }
        }
    }

    public String getJk(char jk) {
        String hasil;
        if (jk == 'L')
            hasil = "Laki-laki";
        else
            hasil = "Perempuan";
        return hasil;
    }

    public boolean isJk(char jk) {
        return jk == 'l' || jk == 'L' || jk == 'p' || jk == 'P';
    }

    public boolean isGolDarah(char golDarah) {
        return golDarah == 'a' || golDarah == 'A' || golDarah == 'b' || golDarah == 'B' || golDarah == 'o' || golDarah == 'O';
    }

    /* public NodeKtp getSiswa(int nis) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar siswa masih kosong");
        boolean ditemukan = false;
        NodeKtp tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.nis != nis) {
                tmp = tmp.next;
            } else {
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan)
            throw new Exception("Nilai tidak ditemukan");
        else {
            return tmp;
        }
    } */

    public void remove(int nomor) {
        if (isEmpty())
            System.out.println("Data KTP masih kosong, tidak dapat dihapus");
        else {
            if (nomor < 1 || nomor > size) {
                System.out.println("Input diluar batas");
            }
            else if (nomor == 1)
                removeFirst();
            else {
                NodeKtp current = head;
                for (int i = 0; i < nomor; i++) {
                    current = current.next;
                }
                if (current.next == null)
                    current.prev.next = null;
                else if (current.prev == null) {
                    current = current.next;
                    current.prev = null;
                    head = current;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
            }
        }
    }

    public void printNomor(int nomor) {
        if (isEmpty())
            System.out.println("Data KTP masih kosong");
        else {
            if (nomor < 1 || nomor > size) {
                System.out.println("Input diluar batas");
            }
            if (nomor == 1) {
                search(head.nik);
            }
            else {
                NodeKtp current = head;
                for (int i = 1; i < nomor; i++) {
                    current = current.next;
                }
                search(current.nik);
            }
        }
    }



    /* public boolean isKelas(String kelas) {
        return kelas.equalsIgnoreCase("VII") || kelas.equalsIgnoreCase("VIII") || kelas.equalsIgnoreCase("IX");
    } */

    /* public boolean isNis(int nis) {
        boolean ditemukan = false;
        NodeKtp tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.nis != nis) {
                tmp = tmp.next;
            } else {
                ditemukan = true;
                break;
            }
        }
        return ditemukan;
    } */
}
