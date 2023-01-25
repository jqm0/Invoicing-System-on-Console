package ApplicationMainMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	String name;
	ArrayList<Item> itemList = new ArrayList<Item>();
	String[] header = new String[4];
	Integer noOfInvoices;

	public void load() {
		File file = new File("C:\\\\Users\\\\Lenovo\\\\eclipse-workspace\\\\InvoicingSystem\\\\items\\\\item.txt");
		try {
			Scanner ss = new Scanner(file);
			int lineCount = 0;
			Item itemX = new Item();
			while (ss.hasNextLine()) {
				
				if (lineCount % 5 == 0) {
					itemX.name = ss.nextLine();
				} else if (lineCount % 5 == 1) {
					itemX.id = Integer.parseInt(ss.nextLine());
				} else if (lineCount % 5 == 2) {
					itemX.quantity = Integer.parseInt(ss.nextLine());
				} else if (lineCount % 5 == 3) {
					itemX.unitPrice = Integer.parseInt(ss.nextLine());
				} else if (lineCount % 5 == 4) {
					itemX.qtyAmountPrice = Integer.parseInt(ss.nextLine());
					itemList.add(itemX);
				}
				
				lineCount++;
			}
			
			ss.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setShopName(String shopName) {
		this.name = shopName;
	}

	public String getName() {
		return name;
	}

	public void addItem(Item newItem) {
		itemList.add(newItem);
		File items = new File("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\items\\item.txt");
		try {
			FileWriter fw = new FileWriter(items);
			for (Item i : itemList) {
				fw.write(i.name + "\r\n");
				fw.write(i.id.toString() + "\r\n");
				fw.write(i.quantity.toString() + "\r\n");
				fw.write(i.unitPrice.toString() + "\r\n");
				fw.write(i.qtyAmountPrice.toString() + "\r\n");
			}

			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteItem(String itemToBeDeleted) {
		for (int i = 0; i < itemList.size(); i++) {
			Item item = itemList.get(i);
			if (item.name.equalsIgnoreCase(itemToBeDeleted)) {
				itemList.remove(i);
				System.out.println("Item  has been Deleted ");
				System.out.println("--------------------------");
				break;
			}

		}

	}

	public void changeItemPrice(String itemName, int newPrice) {
		for (Item i : itemList) {
			if (itemName.equalsIgnoreCase(i.name)) {
				i.unitPrice = newPrice;
				i.qtyAmountPrice = i.unitPrice * i.quantity;
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
		if (!itemList.isEmpty()) {

			for (Item i : itemList) {
				System.out.println("----------------------------------");
				System.out.println("Item Name : " + i.name);
				System.out.println("Item ID : " + i.id);
				System.out.println("Item Quantity : " + i.quantity);
				System.out.println("Item Price : " + i.unitPrice);
				System.out.println("Item Quantity Amount Price : " + i.qtyAmountPrice);

			}
			System.out.println("----------------------------------");
		} else {
			System.out.println("------------There is no Items -------------");
		}
	}
}
