
package javaapplication;

/**
 *
 * @author Revaldi
 */
public class formulir {
    protected String nama;
    protected String NIM;
    protected String jurusan;
    protected String fakultas;
    
    public void setNama (String nama){
        this.nama = nama;
    }
    public void setNIM (String NIM){
        this.NIM = NIM;
    }
    public void setJurusan (String jurusan){
        this.jurusan = jurusan;
    }
    public void setFakultas (String fakultas){
        this.fakultas = fakultas;
    }    
    public String getNama(){
        return nama;
    }    
    public String getNIM(){
        return NIM;
    }   
    public String getJurusan(){
        return jurusan;
    }   
    public String getFakultas(){
        return fakultas;
    }
    
    public void printData(){
        System.out.println("Nama : "+getNama());
        System.out.println("NIM : "+getNIM());
        System.out.println("Jurusan : "+getJurusan());
        System.out.println("Fakultas : "+getFakultas());
    }
    
    public void setJudul(String e) {}

    public void setDosenwali(String f) {}

    public void setKotaPKL(String e) {}

    public void setTempatPKL(String f) {}

    public void setSKS(String g) {}
}

class pengajuan_skripsi extends formulir {
    private String judul;
    private String dosenwali;
    
    @Override
    public void setJudul (String judul){
        this.judul = judul;
    }
    @Override
    public void setDosenwali (String dosenwali){
        this.dosenwali = dosenwali;
    }
    
    public String getJudul(){
        return judul;
    }
    public String getDosenwali(){
        return dosenwali;
    }

    @Override
    public void printData(){
        System.out.println("Nama : "+getNama());
        System.out.println("NIM : "+getNIM());
        System.out.println("Jurusan : "+getJurusan());
        System.out.println("Fakultas : "+getFakultas());
        System.out.println("Judul : "+getJudul());
        System.out.println("Dosen Wali : "+getDosenwali());
    }
}

class pengajuan_pkl extends formulir {
    private String kotaPKL;
    private String tempatPKL;
    private String SKS;
    
    @Override
    public void setKotaPKL(String kotaPKL){
        this.kotaPKL = kotaPKL;
    }
    @Override
    public void setTempatPKL(String tempatPKL){
        this.tempatPKL = tempatPKL;
    }
    @Override
    public void setSKS(String SKS){
        this.SKS = SKS;
    }
    public String getKotaPKL(){
        return kotaPKL;
    }
    public String getTempatPKL(){
        return tempatPKL;
    }
    public String getSKS(){
        return SKS;
    }

    @Override
    public void printData(){
        System.out.println("Nama : "+getNama());
        System.out.println("NIM : "+getNIM());
        System.out.println("Jurusan : "+getJurusan());
        System.out.println("Fakultas : "+getFakultas());
        System.out.println("Kota Tujuan : "+getKotaPKL());
        System.out.println("Tempat PKL : "+getTempatPKL());
        System.out.println("Jumlah SKS yang sudah diselesaikan : "+getSKS());
    }
}

//class testdrive {
//    public static void main(String[] args) {
//        
//    }
//}
