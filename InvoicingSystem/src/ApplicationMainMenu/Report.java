package ApplicationMainMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Report implements Serializable {
	ArrayList<Invoice> invoicesList = new ArrayList<Invoice>();
	Integer noOfInvoices;
	Integer noOfItems;
	Integer totalSales;

	public void getNoOfInvoices() {
		System.out.println("Number of Invoices : " + invoicesList.size());
	}

	public void getReport1() {

		File file = new File("C:\\\\Users\\\\Lenovo\\\\eclipse-workspace\\\\InvoicingSystem\\\\Invoices\\ReportStatistics.txt");
		try {
			Scanner ss = new Scanner(file);
			int i = 0;
			while (ss.hasNext() && i <3) {
				System.out.println(ss.nextLine().toString());
				i++;
			}
			ss.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void getAllReport() {
		File directoryPath = new File("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\Invoices");
		File filesList[] = directoryPath.listFiles();
		int i = 1;
		for (File file : filesList) {
			System.out.println("============ Invoice NO "+i + " ============ ");
			i++;
			
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
			
		}
	}

}
