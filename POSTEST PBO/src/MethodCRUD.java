import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class MethodCRUD {
    
    static ArrayList<ListPesanan> Datapesanan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static Date date = new Date();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    
    public static void main(String[] args) throws ParseException {
        add();
    }
    private static Long error_long(){
        Long masukkan_long;
        while(true){
            try{
                masukkan_long = input.nextLong();
                break;
            }
            catch(Exception e){
                System.err.print("format salah >> ");
            }
        }
        return masukkan_long;

    }
    // public void ManajemenBaju(){
    //     list = new ArrayList<>();
    // }

    public static void add() throws ParseException{
        System.out.print("masukkan nama baju >>");
        String baju = input.nextLine();
        System.out.print("Masukkan tanggal pesanan >> ");
        String tanggal_pesan = input.nextLine();
        Date date = dateFormat.parse(tanggal_pesan);
        System.out.print("masukkan nomor telepon >> ");
        Long phone_number = error_long();
        int nomor_antrian = rand.nextInt();
        ListPesanan pesanan_baru = new ListPesanan(baju, tanggal_pesan, phone_number, nomor_antrian);
        Datapesanan.add(pesanan_baru);
    }

    public boolean find(int NoAntrian){
        for(ListPesanan l : Datapesanan){

            if (l.getNoAntrian() == NoAntrian){
                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    public void delete(int recNoAntrian){
        ListPesanan ListPesananDel = null;

        for (ListPesanan ll : Datapesanan){

            if (ll.getNoAntrian() == recNoAntrian){
                ListPesananDel = ll;
            }
        }

        if (ListPesananDel == null){
            
            System.out.println("No Baju Invalid");
        
        }
        else{
            Datapesanan.remove(ListPesananDel);

            System.out.println("Berhasil Menghapus Orderan!");
        }
    }

    public ListPesanan findListPesanan(int NoAntrian){
        for(ListPesanan l : Datapesanan ){

            if (l.getNoAntrian() == NoAntrian){
                System.out.println(l);
                return l;
            }
        }
        return null;
    }        
    
    public void update(int No, Scanner input){
        if (find(No)){
            ListPesanan rec = findListPesanan(No);

            System.out.println("Masukkan No Antrian ");
            input.nextInt();

            System.out.println("Masukkan No Telpon");
            int NoTelp = input.nextInt();

            System.out.println("Masukkan Nama Pemesan");
            String Nama = input.nextLine();
            
            rec.setNoAntrian(No);
            rec.setNama(Nama);
            rec.setNoTelp(NoTelp);
            System.out.println("Pesanan Telah Di Update");
        }
        else{
            System.out.println("Pesanan Tidak Ditemukan!");
        }
    }

    public void display(){
        if(Datapesanan.isEmpty()){
            System.out.println("Pesanan Kosong!!");
        }

        for (ListPesanan ListPesanan : Datapesanan){
            System.out.println(ListPesanan.toString());
        }
    }
}