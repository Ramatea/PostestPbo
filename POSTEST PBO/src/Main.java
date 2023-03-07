import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    
	public static void main(String[] args)
	{

		MethodCRUD mb = new MethodCRUD();

		ListPesanan order = new ListPesanan();
		Random rand = new Random();
    	Date date = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		order.getNoPesanan();
		order.setNoAntrian(6862);
		order.setNoTelp(911);
		order.setNama("Ankit");


		
		Scanner input = new Scanner(System.in);

		
		int option = 0;

		
		do {
			menu();
			option = input.nextInt();

			
			switch (option) {

			
			case 1:
			
				System.out.println("Nomer Pesanan");
				String NoPesanan = dateFormat.format(date)+ rand.nextInt(1000);

				System.out.print(
					"Masukkan Nomer Antrian Pelanggan ");
				int NoAntrian = input.nextInt();

			
				System.out.print(
					"Masukkan Nomer HP Pelanggan ");
				int NoTelp = input.nextInt();
				input.nextLine();

			
				System.out.print(
					"Masukkan Nama Pelanggan ");
				String Nama = input.nextLine();

				
				order = new ListPesanan(Nama,NoPesanan,NoAntrian,NoTelp);
				
				mb.add(order);
				System.out.println(order.toString());

			
				break;

			
			case 2:

				
				System.out.print(
					"Masukkan Nomer Antrian Pelanggan ");
				int rId = input.nextInt();		
				mb.delete(rId);

				break;

			
			case 3:

			
				System.out.print(
					"Masukkan No Antrian ");

				int rIdNo = input.nextInt();
				mb.update(rIdNo, input);

				break;

			case 4:

				System.out.print(
					"Masukkan No Antrian ");
				int bookId = input.nextInt();

				if (!mb.find(bookId)) {
					System.out.println(
						"No Antrian Tidak Ditemukan\n");
				}

				break;

			case 5:
				mb.display();
				break;

			case 9:

				System.out.println("Terima Kasih Telah Memesan!!!");
				System.exit(0);

				break;

			default:

				System.out.println("Invalid input");
				break;
			}
		}

	
		while (option != 9);
	}

	
	public static void menu()
	{
		System.out.println("MENU");
		System.out.println("1: Add Pesanan");
		System.out.println("2: Delete Pesanan");
		System.out.println("3: Update Pesanan");
		System.out.println("4: Search Pesanan");
		System.out.println("5: Display Pesanan");
		System.out.println("9: Exit program");
		System.out.print("Enter your selection : ");
	}
}

