package twoup.top4t.com;

public class Payment {
    private String jenis1;
    private int harga;
    private String jenis2;
    private String jenis3;
    private String status;

    public Payment(String jenis1, int harga, String jenis2, String jenis3, String status){
        this.jenis1 = jenis1;
        this.harga = harga;
        this.jenis2 = jenis2;
        this.jenis3 = jenis3;
        this.status = status;
    }

    public String getJenis1(){
        return jenis1;
    }
    public void setJenis1(String jenis1){
        this.jenis1 = jenis1;
    }
    public int getHarga(){
        return harga;
    }

    public void setHarga(int harga){
        this.harga = harga;
    }

    public String getJenis2(){
        return jenis2;
    }
    public void setJenis2(String jenis2){
        this.jenis2 = jenis2;
    }

    public String getJenis3(){
        return jenis3;
    }
    public void setJenis3(String jenis3){
        this.jenis3 = jenis3;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
