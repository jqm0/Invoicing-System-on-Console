package ApplicationMainMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	String name;
	ArrayList<Item> itemList = new ArrayList<Item>();
	String[] header = new String[4];
	Integer noOfInvoices;
	public void setShopName(String shopName) {
		this.name = shopName;
	}

	public String getName() {
		return name;
	}

	public void addItem(Item newItem) {
		itemList.add(newItem);
	
	}

	public void deleteItem(Item itemToBeDeleted) {
		for (Item itemI : itemList) {
			if (itemToBeDeleted.name.equalsIgnoreCase(itemI.name)) {
				itemList.remove(itemToBeDeleted);
				System.out.println("Item  has been Deleted ");
			}

		}
	}

	public void changeItemPrice(int newPrice, String itemName) {
		for (Item i : itemList) {
			if (itemName.equalsIgnoreCase(i.name)) {
				i.unitPrice = newPrice;
				System.out.println("Item has been changed it's price");
			}
		}
	}

	public void setInvoiceHeader() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Tel ");
		header[0] = sc.next();
		System.out.print("Enter Fax ");
		header[1] = sc.next();
		System.out.print("Enter Email ");
		header[2] = sc.next();
		System.out.print("Enter Website ");
		header[3] = sc.next();
		sc.close();

	}

	public void reportAllItems() {
		System.out.println("----------------------------------");
		System.out.println("---------- Items Report ----------");
		for (Item i : itemList) {
			System.out.println("----------------------------------");
			System.out.println("Item Name : " + i.name);
			System.out.println("Item ID : " + i.id);
			System.out.println("Item Quantity : " + i.quantity);
			System.out.println("Item Price : " + i.unitPrice);
			System.out.println("Item Quantity Amount Price : " + i.qtyAmountPrice);

		}
		System.out.println("----------------------------------");
	}
}
