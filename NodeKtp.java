package ktpGen;

public class NodeKtp {
    String nik;
    String nama;
    String kotaLahir;
    int tglLahir, blnLahir, thnLahir;
    char jk, golDarah;
    String alamat;
    int rt, rw;
    String kel, kec, kota, prov;
    String agama;
    String statusNikah;
    String pekerjaan;
    String kwn;
    
    NodeKtp next;
    NodeKtp prev;

    NodeKtp(
        NodeKtp prev, 
        String nik, 
        String nama, 
        String kotaLahir, 
        int tglLahir, 
        int blnLahir, 
        int thnLahir, 
        char jk,
        String alamat,
        int rt, 
        int rw,
        String kel, 
        String kec, 
        String kota, 
        String prov,
        String agama,
        String statusNikah,
        String pekerjaan,
        String kwn,
        char golDarah,
        NodeKtp next
    ) {
        this.prev = prev;
        this.nik = nik;
        this.nama = nama;
        this.kotaLahir = kotaLahir;
        this.tglLahir = tglLahir;
        this.blnLahir = blnLahir;
        this.thnLahir = thnLahir;
        this.jk = jk;
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.kel = kel;
        this.kec = kec;
        this.kota = kota;
        this.prov = prov;
        this.agama = agama;
        this.statusNikah = statusNikah;
        this.pekerjaan = pekerjaan;
        this.kwn = kwn;
        this.golDarah = golDarah;
        this.next = next;
    }
}
