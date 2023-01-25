package ApplicationMainMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shop shopX = new Shop();
		boolean repeat = true;
		Integer countCase1 = 0;
		Integer countCase2 = 0;
		Integer countCase3 = 0;
		Integer countCase4 = 0;
		Integer countCase5 = 0;
		Integer countCase6 = 0;
		Integer countCase7 = 0;
		Integer countCase8 = 0;

		System.out.println("----------------------------------------");
		System.out.println("----- Welcom to Invoicing System  ------");
		while (repeat) {
			System.out.println("----------------------------------------");
			System.out.println("Please Select on of the Following Option");
			System.out.println("1- Shop Settings\r\n" + "2- Manage Shop Items\r\n"
					+ "3- Create New Invoice \r\n"
					+ "4- Report: Statistics \r\n"
					+ "5- Report: All Invoices \r\n"
					+ "6- Search (1) Invoice (Search by Invoice No and Report All Invoice details with items)\r\n"
					+ "7- Program Statistics .\r\n"
					+ "8- Exit ");

			if (sc.hasNextInt()) {
				boolean repeat2 = true;

				int option = sc.nextInt();
				switch (option) {
				case 1:
					countCase1++;
					while (repeat2) {
						System.out.println(
								"1. Load Data (Items and invoices)\r\n" + "2. Set Shop Name (data should be saved)\r\n"
										+ "3. Set Invoice Header (Tel / Fax / Email / Website) \r\n" + "4. Go Back");

						if (sc.hasNextInt()) {
							int option2 = sc.nextInt();
							switch (option2) {
							case 1:
								shopX.load();
								System.out.println("Items and invoices has been loaded");
								break;
							case 2:

								System.out.println("Enter Shop Name :");
								shopX.setShopName(sc.next());
								break;
							case 3:
								System.out.print("Enter Tel : ");
								String tel = sc.next();
								System.out.print("Enter Fax : ");
								String fax = sc.next();
								System.out.print("Enter Email : ");
								String email = sc.next();
								System.out.print("Enter Website : ");
								String website = sc.next();
								shopX.setInvoiceHeader(tel, fax, email, website);
								break;
							case 4:
								repeat2 = false;
								break;
							}
						}
					}
					break;
				case 2:
					countCase2++;
					boolean repeat3 = true;
					while (repeat3) {

						System.out.println("1. Add Items \r\n" + "2. Delete Items\r\n" + "3. Change Item Price\r\n"
								+ "4. Report All Items\r\n" + "5. Go Back");
						if (sc.hasNextInt()) {
							int option3 = sc.nextInt();
							switch (option3) {
							case 1:
								Item itemX = new Item();
								System.out.print("Item name : ");
								itemX.name = sc.next();
								System.out.print("Item  unitPrice : ");
								itemX.unitPrice = sc.nextInt();
								System.out.print("Item ID : ");
								itemX.id = sc.nextInt();
								System.out.print("Item   quantity : ");
								itemX.quantity = sc.nextInt();
								itemX.qtyAmountPrice = itemX.quantity * itemX.unitPrice;
								shopX.addItem(itemX);
								break;
							case 2:
								System.out.print("Enter name of the item : ");
								String itemDel = sc.next();
								shopX.deleteItem(itemDel);
								break;
							case 3:
								System.out.print("Write the item name :  ");
								String itemName = sc.next();
								System.out.print("Write the new price : ");
								int newPrice = sc.nextInt();
								shopX.changeItemPrice(itemName, newPrice);
								break;
							case 4:
								shopX.reportAllItems();
								break;
							case 5:
								repeat3 = false;
								break;
							}
						}

					}
					break;
				case 3:
					countCase3++;
					// - Create New Invoice (Invoices should be save/serialized)

					Invoice invoiceA = new Invoice();
					invoiceA.createNewInvoice();
					// In this case i have an issue that the menu will repeated infinte times..

					repeat = false;// i solved this by exiting the program but details of invoice will be saved in
									// txt files..
					break;
				case 4:
					countCase4++;
					// Report: Statistics (No Of Items, No of Invoices, Total Sales)
					Report rep = new Report();
					rep.getReport1();
					break;
				case 5:
					countCase5++;
					Report rep2 = new Report();
					rep2.getAllReport();
					break;
				case 6:
					countCase6++;
					Report rep3 = new Report();
					System.out.println("Enter invoice number : ");
					rep3.search(sc.nextInt());
					break;
				case 7:
					countCase7++;
					System.out.println("===== Program Statistics for current Run =====");
					System.out.println("The option 1 has been entered " + countCase1 + " Times " + "\r\n"
							+ "The option 2 has been entered " + countCase2 + " Times " + "\r\n"
							+ "The option 3 has been entered " + countCase3 + " Times " + "\r\n"
							+ "The option 4 has been entered " + countCase4 + " Times " + "\r\n"
							+ "The option 5 has been entered " + countCase5 + " Times " + "\r\n"
							+ "The option 6 has been entered " + countCase6 + " Times " + "\r\n"
							+ "The option 7 has been entered " + countCase7 + " Times " + "\r\n");

					System.out.println("===== Program Statistics for current Run with Previous Run =====");
					ArrayList<Integer> numbers = new ArrayList<Integer>();
					try {
						Scanner scanner = new Scanner(new File(
								"C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\countEnteredTimes\\count.txt"));
						while (scanner.hasNextLine()) {
							int number = Integer.parseInt(scanner.nextLine());
							numbers.add(number);
						}
						scanner.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					for (int i = 0; i < numbers.size(); i++) {
						if (i == 0) {
							System.out.println("The option 1 has been entered " + (numbers.get(i) + countCase1) + " Times ");
						}
						if (i == 1) {
							System.out.println("The option 2 has been entered " + (numbers.get(i) + countCase2) + " Times ");
						}
						if (i == 2) {
							System.out.println("The option 3 has been entered " + (numbers.get(i) + countCase3) + " Times ");
						}
						if (i == 3) {
							System.out.println("The option 4 has been entered " + (numbers.get(i) + countCase4) + " Times ");
						}
						if (i == 4) {
							System.out.println("The option 5 has been entered " + (numbers.get(i) + countCase5) + " Times ");
						}
						if (i == 5) {
							System.out.println("The option 6 has been entered " + (numbers.get(i) + countCase6) + " Times ");
						}
						if (i == 6) {
							System.out.println("The option 7 has been entered " + (numbers.get(i) + countCase7) + " Times ");
						}
						

					}
					break;
				case 8:
					countCase8++;
					System.out.println(" >> Are you sure you want to exit?");
					if (sc.next().equalsIgnoreCase("yes")) {
						repeat = false;
					}
					break;

				}
			}

		}
		// Write entered times in text file
		File counts = new File("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\countEnteredTimes\\count.txt");
		try {
			FileWriter fw = new FileWriter(counts);
			fw.write(countCase1.toString() + "\r\n");
			fw.write(countCase2.toString() + "\r\n");
			fw.write(countCase3.toString() + "\r\n");
			fw.write(countCase4.toString() + "\r\n");
			fw.write(countCase5.toString() + "\r\n");
			fw.write(countCase6.toString() + "\r\n");
			fw.write(countCase7.toString() + "\r\n");
			fw.write(countCase8.toString() + "\r\n");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();

	}
}
