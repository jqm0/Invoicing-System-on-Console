package ApplicationMainMenu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Report {
	ArrayList<Invoice> invoicesList = new ArrayList<Invoice>();
	Integer noOfInvoices;
	Integer noOfItems;
	Integer totalSales;

	public void getNoOfInvoices() {
		System.out.println("Number of Invoices : " + invoicesList.size());
	}

	public void getReport1() {

		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\Invoice.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			Invoice object1 = (Invoice) in.readObject();
			in.close();
			file.close();
			System.out.println("Object has been deserialized ");
			System.out.println("Number Of Items :  " + object1.numberOfItems);
			System.out.println("Total Sales:  " + object1.totalAmount);
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}
}
