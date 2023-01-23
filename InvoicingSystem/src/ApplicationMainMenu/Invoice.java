package ApplicationMainMenu;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Invoice implements Serializable {
	String customerFullName;
	Integer phoneNumber;
	String date;
	Integer numberOfItems= 0 ;
	Integer totalAmount;
	Integer paidAmount;
	Integer balance;

	public void createNewInvoice() {
		
		boolean choice = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Shop name : ");
		Shop shopX = new Shop();
		shopX.setShopName(sc.next());
		Invoice invoiceX = new Invoice();
		System.out.print("Enter customer Full Name : ");
		invoiceX.customerFullName = sc.next();
		System.out.print("Enter phone Number : ");
		invoiceX.phoneNumber = sc.nextInt();

		while (choice) {
			Item itemX = new Item();
			System.out.print("Enter Item Name : ");
			itemX.name = sc.next();
			System.out.print("Enter Item id : ");
			itemX.id = sc.nextInt();
			System.out.print("Enter unitPrice : ");
			itemX.unitPrice = sc.nextInt();
			System.out.print("Enter quantity : ");
			itemX.quantity = sc.nextInt();
			itemX.qtyAmountPrice = itemX.unitPrice * itemX.quantity;
			shopX.itemList.add(itemX);
			numberOfItems ++;
			System.out.print("Do You Want Add Anouther Item write 1 if yes .. : ");
			if (sc.nextInt() != 1) {
				choice = false;

			}
		}
		try {
			FileOutputStream file = new FileOutputStream("Invoice.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(shopX);
			out.flush();
			out.close();
			file.close();
			System.out.println("Serialized Done and saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------------- Invoice Details ----------------");
		Integer total = 0;
		for (Item i : shopX.itemList) {
			System.out.println("=====================");
			System.out.println("Item name : " + i.name);
			System.out.println("Item ID : " + i.id);
			System.out.println("Item name : " + i.quantity);
			System.out.println("Item name : " + i.unitPrice);
			System.out.println("Total Price for this Item " + i.qtyAmountPrice);
			total = total + i.qtyAmountPrice;
		}
		totalAmount = total;
		
		System.out.println("======================");
		System.out.println("Total Price : " + total);
		System.out.println("---------------------");
		System.out.print(" >> Enter paid Amount :");
		paidAmount = sc.nextInt();
		balance =  paidAmount - totalAmount ;
		System.out.println("======================");
		System.out.println("Balance : " + balance);
		sc.close();

	}

}
