package ApplicationMainMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Report {
	ArrayList<Invoice> invoicesList = new ArrayList<Invoice>();
	Integer noOfInvoices;
	Integer noOfItems;
	Integer totalSales;

	public void getNoOfInvoices() {
		System.out.println("Number of Invoices : " + invoicesList.size());
	}

	public void getReport1() {
		System.out.println("----------------------------------");
		File file = new File(
				"C:\\\\Users\\\\Lenovo\\\\eclipse-workspace\\\\InvoicingSystem\\\\InvoicesStatistics\\ReportStatistics.txt");
		try {
			Scanner ss = new Scanner(file);
			while (ss.hasNext()) {
				System.out.println(ss.nextLine().toString());
			}
			ss.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------------");

	}

	public void getAllReport() {
		File directoryPath = new File("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\Invoices");
		File filesList[] = directoryPath.listFiles();
		int i = 1;
		for (File file : filesList) {
			System.out.println("\t---------------------------------------- Invoice NO "+ i + " ----------------------------------------");
		//	System.out.println("\\t\\t\\t\\t============ Invoice NO " + i + " ============ ");
			System.out.println("\t----------------------------------------" + "Email :shop@icloud.com ----------------------------------------");
			System.out.println("\t----------------------------------------" + "Website:www.shop.com ----------------------------------------");
			
			i++;

			try {
				Scanner ss = new Scanner(file);

				while (ss.hasNext()) {
					System.out.println("\t" + ss.nextLine().toString());
				}
				ss.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void search(Integer invoiceNo) {
		File directoryPath = new File("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\Invoices");
		File filesList[] = directoryPath.listFiles();
		System.out.println("------------- Invoice No " + invoiceNo + " Details --------------------");
		for (File file : filesList) {
			try {
				Scanner ss = new Scanner(file);
				int i = 0;
				while (ss.hasNext() && i < 1) {
					String[] a = ss.nextLine().split(" ");
					if (invoiceNo == Integer.parseInt(a[3])) {
						while (ss.hasNext()) {
							System.out.println(ss.nextLine());
						}

					}
					i++;

				}
				ss.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("----------------------------------");

	}

}
