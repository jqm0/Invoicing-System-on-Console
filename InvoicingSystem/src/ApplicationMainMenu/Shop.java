package ApplicationMainMenu;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

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

	public void deleteItem(String itemToBeDeleted) {
		if (itemList.size() > 0) {
			for (Item itemI : itemList) {
				if (itemToBeDeleted.equalsIgnoreCase(itemI.name)) {
					itemList.remove(itemI);
					System.out.println("Item  has been Deleted ");
				}

			}
		}
		else {
			System.out.println(" >>>> There is no items ;(");
			System.out.println("--------------------------");
		}
	}

	public void changeItemPrice(String itemName, int newPrice) {
		for (Item i : itemList) {
			if (itemName.equalsIgnoreCase(i.name)) {
				i.unitPrice = newPrice;
				System.out.println("Item has been changed it's price");
			}
		}
	}

	public void setInvoiceHeader(String tel, String fax, String mail, String website) {
		header[0] = tel;
		header[1] = fax;
		header[2] = mail;
		header[3] = website;
	}

	public void reportAllItems() {
		System.out.println("----------------------------------");
		System.out.println("---------- Items Report ----------");
		if(!itemList.isEmpty()) {
			
		
		for (Item i : itemList) {
			System.out.println("----------------------------------");
			System.out.println("Item Name : " + i.name);
			System.out.println("Item ID : " + i.id);
			System.out.println("Item Quantity : " + i.quantity);
			System.out.println("Item Price : " + i.unitPrice);
			System.out.println("Item Quantity Amount Price : " + i.qtyAmountPrice);

		}
		System.out.println("----------------------------------");}
		else {
			System.out.println("------------There is no Items -------------");
		}
	}
}
