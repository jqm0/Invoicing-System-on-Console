package ApplicationMainMenu;

import java.util.ArrayList;

public class Shop {
	String name;
	ArrayList<Item> itemList = new ArrayList<Item>();

	public void setShopName(String shopName) {
		this.name = shopName;
	}

	public void addItem(Item newItem) {
		itemList.add(newItem);
		
	}

	public void deleteItem(Item itemToBeDeleted ) {
		for(Item i : itemList) {
			if(itemToBeDeleted.name.equalsIgnoreCase(i.name)) {
				itemList.remove(itemToBeDeleted);
				System.out.println("Item  has been Deleted ");
			}
			
		}
	}
}
