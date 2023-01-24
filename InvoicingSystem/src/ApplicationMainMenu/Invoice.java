package ApplicationMainMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
	String customerFullName;
	Integer phoneNumber;
	Date date;
	Integer numberOfItems = 0;
	Integer totalAmount;
	Integer paidAmount;
	Integer balance;
	Integer idInvoice;
	Integer txtFileCount = 1;

	public void createNewInvoice() {
		Report rep = new Report();
		boolean choice = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Shop name : ");
		Shop shopX = new Shop();
		shopX.setShopName(sc.next());
		Invoice invoiceX = new Invoice();
		System.out.print("Enter customer Full Name : ");
		customerFullName = sc.next();
		System.out.print("Enter phone Number : ");
		invoiceX.phoneNumber = sc.nextInt();

		while (choice) {
			Item itemX = new Item();
			System.out.print("Enter Item Name : ");
			itemX.name = sc.next();
			System.out.print("Enter Item id : ");
			itemX.id = sc.nextInt();
			idInvoice = itemX.id;
			System.out.print("Enter unitPrice : ");
			itemX.unitPrice = sc.nextInt();
			System.out.print("Enter quantity : ");
			itemX.quantity = sc.nextInt();
			itemX.qtyAmountPrice = itemX.unitPrice * itemX.quantity;
			shopX.itemList.add(itemX);
			numberOfItems++;
			System.out.print("Do You Want Add Anouther Item write 1 if yes .. : ");
			if (sc.nextInt() != 1) {
				choice = false;

			}
		}
		System.out.println("---------------- Invoice Details ----------------");
		Integer total = 0;

		for (Item i : shopX.itemList) {
			System.out.println("=====================");
			System.out.println("Item name : " + i.name);
			System.out.println("Item ID : " + i.id);
			System.out.println("Item quantity : " + i.quantity);
			System.out.println("Item unitPrice : " + i.unitPrice);
			System.out.println("Total Price for this Item " + i.qtyAmountPrice);
			total = total + i.qtyAmountPrice;
		}
		totalAmount = total;

		System.out.println("======================");
		System.out.println("Total Price : " + total);
		System.out.println("---------------------");
		System.out.print(" >> Enter paid Amount :");
		paidAmount = sc.nextInt();
		balance = paidAmount - totalAmount;
		System.out.println("======================");
		System.out.println("Balance : " + balance);
		sc.close();
		rep.invoicesList.add(invoiceX);
		// _________________________________________
		//This to get invoice number in same folder
		File directory = new File("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\Invoices");
		File[] files = directory.listFiles();

		if (files.length > 0) {
			for (File f : files) {
				if (f.getName().endsWith(".txt")) {
					txtFileCount++;
				}
			}
		}

		// --------------------------------------------------
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Integer numberOfInvoice = rep.invoicesList.size();
		
		File fileStatistics = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\InvoicesStatistics\\ReportStatistics.txt");
		File fileAllReport = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\Invoices\\allReport" + idInvoice + ".txt");
		try {
			FileWriter fw = new FileWriter(fileAllReport);
			FileWriter fWrite = new FileWriter(fileStatistics);
			// File for fourth option

			fWrite.write("No Of Items : " + numberOfItems.toString() + "\r\n");
			fWrite.write("No of Invoices : " + numberOfInvoice.toString() + "\r\n");
			fWrite.write("Total Sales: " + totalAmount.toString());
			fWrite.close();

			// -------------------------------------------------------//
			// file for 5th option
			date = new Date();

			fw.write("Invoice No : " + txtFileCount + "\r\n");
			fw.write("Invoice Date : " + formatter.format(date).toString() + "\r\n");
			fw.write("Customer Name : " + customerFullName.toUpperCase() + "\r\n");
			fw.write("No Of Items : " + numberOfItems.toString() + "\r\n");
			fw.write("Total : " + totalAmount.toString() + "\r\n");
			fw.write("Balance : " + balance.toString());

			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
