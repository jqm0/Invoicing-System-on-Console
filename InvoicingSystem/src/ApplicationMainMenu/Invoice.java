package ApplicationMainMenu;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Invoice  implements Serializable {
	String customerFullName;
	Integer phoneNumber;
	String date;
	Integer numberOfItems;
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
			System.out.print("Enter Item Name :");
			itemX.name = sc.next();
			System.out.println("Enter Item id");
			itemX.id = sc.nextInt();
			System.out.println("Enter unitPrice");
			itemX.unitPrice = sc.nextInt();
			System.out.println("Enter quantity");
			itemX.quantity = sc.nextInt();
			itemX.qtyAmountPrice = itemX.unitPrice * itemX.quantity;
			System.out.println("Do You Want Add Anouther Item write 1 if yes ..");
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
		sc.close();
	}

}
