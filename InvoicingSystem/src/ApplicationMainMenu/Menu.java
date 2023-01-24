package ApplicationMainMenu;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		System.out.println("----------------------------------------");
		System.out.println("----- Welcom to Invoicing System  ------");
		while (repeat) {
			System.out.println("----------------------------------------");
			System.out.println("Please Select on of the Following Option");
			System.out.println("1- Shop Settings\r\n" + "2- Manage Shop Items\r\n"
					+ "3- Create New Invoice (Invoices should be save/serialized)\r\n"
					+ "4- Report: Statistics (No Of Items, No of Invoices, Total Sales)\r\n"
					+ "5- Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance)\r\n"
					+ "6- Search (1) Invoice (Search by Invoice No and Report All Invoice details with items)\r\n"
					+ "7- Program Statistics (Print each Main Menu Item with how many number selected).\r\n"
					+ "8- Exit (Are you sure you want to exit? If yes, program ends, if No , then main menu reprinted again) ");

			if (sc.hasNextInt()) {
				int option = sc.nextInt();
				switch (option) {
				case 1:
					boolean repeat2 = true;
					while (repeat2) {
						System.out.println("1. Load Data (Items and invoices)\r\n"
								+ "2. Set Shop Name (data should be saved)\r\n"
								+ "3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)\r\n"
								+ "4. Go Back");

						if (sc.hasNextInt()) {
							int option2 = sc.nextInt();
							switch (option2) {
							case 1:
								System.out.println("Load Data");
								break;
							case 2:
								System.out.println("set shop name");
								break;

							case 3:
								System.out.println("Set Invoice Header");
								break;
							case 4:
								repeat2 = false;
							}
						}
					}
					break;
				case 2:
					System.out.println("Shop Settings");
					break;
				case 3:
					// - Create New Invoice (Invoices should be save/serialized)
					Invoice invoiceA = new Invoice();
					invoiceA.createNewInvoice();
					repeat = false;
					break;
				case 4:
					// Report: Statistics (No Of Items, No of Invoices, Total Sales)
					Report rep = new Report();
					rep.getReport1();
					break;
				case 5:
					Report rep2 = new Report();
					rep2.getAllReport();
					break;
				case 6:
					Report rep3 = new Report();
					System.out.println("Enter invoice number : ");
					rep3.search(sc.nextInt());
					break;
				case 7:
					System.out.println("Shop Settings");
					break;
				case 8:
					System.out.println(" >> Are you sure you want to exit?");
					if (sc.next().equalsIgnoreCase("yes")) {
						repeat = false;
					}
					break;

				}
			}

		}
		sc.close();
	}
}
