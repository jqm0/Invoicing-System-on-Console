package ApplicationMainMenu;

import java.util.Scanner;

public class Menu {
	static Integer noOfItems;
	static Integer noOfInvoices;
	static Integer totalSales;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----------------------------------------");
		System.out.println("----- Welcom to Invoicing System  ------");
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
				System.out.println("Shop Settings");
				break;
			case 2:
				System.out.println("Shop Settings");
				break;
			case 3:
				//- Create New Invoice (Invoices should be save/serialized)
				Invoice inv = new Invoice();
				inv.createNewInvoice();
				break;
			case 4:
				//Report: Statistics (No Of Items, No of Invoices, Total Sales)
				System.out.println();
				
				break;
			case 5:
				System.out.println("Shop Settings");
				break;
			case 6:
				System.out.println("Shop Settings");
				break;
			case 7:
				System.out.println("Shop Settings");
				break;

			}
		}
	sc.close();
	}
}
