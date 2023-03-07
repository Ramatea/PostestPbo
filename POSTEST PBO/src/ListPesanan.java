import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ListPesanan{
    private String Nama;
    private String NoPesanan;
    private Long NoTelp;
    private int NoAntrian;

    ListPesanan(String Nama, String NoPesanan, Long NoTelp, int nomor_antrian){
        this.Nama = Nama;
        this.NoPesanan = NoPesanan;
        this.NoTelp = NoTelp;
        this.NoAntrian = nomor_antrian;
    }
    
    public void setNoTelp(Long NoTelp){
        this.NoTelp = NoTelp;
    }

    public String getNoPesanan(){ return NoPesanan;}

    public void setNoPesanan(String NoPesanan){
        this.NoPesanan = NoPesanan;
    }

    public String getNama(){ return Nama;}

    public void setNama(String Nama){ this.Nama = Nama;}
    
    public int getNoAntrian(){ return NoAntrian;}

    public void setNoAntrian(int NoAntrian){
        this.NoAntrian = NoAntrian;
    }
    
    @Override public String toString(){

        return "ListPesanan("+"No Antrian = "+ NoAntrian + "nama = " + Nama + ", No Pesanan = " + NoPesanan + ", No Telpon = " + NoTelp + "}";
    }

    
}
