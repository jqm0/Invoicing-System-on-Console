package ApplicationMainMenu;

import java.util.ArrayList;

public class Report {
	ArrayList<Invoice> invoicesList = new ArrayList<Invoice>();
	Integer noOfInvoices;
	Integer noOfItems;
	Integer totalSales;
	public void getNoOfInvoices() {
		System.out.println("Number of Invoices : "+ invoicesList.size());
	}
}
