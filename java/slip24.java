import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;


 interface Menu 
{
public Iterator<MenuItem> createIterator();
}


class CafeMenu implements Menu 
{
HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();
public CafeMenu() 
{
addItem("Veggie Burger and French Fries","Veggie burger on a whole wheat bun, lettuce, tomato, and fries",true, 40);
addItem("Soup of the day","A cup of the soup of the day, with a side salad",false, 70);
addItem("Burrito","A large burrito, with whole pinto beans, salsa, guacamole",true, 80);
}
public void addItem(String name, String description,boolean vegetarian, double price) 
{
MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
menuItems.put(name, menuItem);
}
public Map<String, MenuItem> getItems()
{
return menuItems;
}
public Iterator<MenuItem> createIterator() 
{
return menuItems.values().iterator();
}
}




 class DinerMenu implements Menu 
{
static final int MAX_ITEMS = 6;
int numberOfItems = 0;
MenuItem[] menuItems;

public DinerMenu() 
{
menuItems = new MenuItem[MAX_ITEMS];
addItem("Vegetarian BLT","(Fakin') Bacon with lettuce & tomato on whole wheat", true, 80);
addItem("BLT","Bacon with lettuce & tomato on whole wheat", false, 90);
addItem("Soup of the day","Soup of the day, with a side of potato salad", false, 70);
addItem("Hotdog","A hot dog, with sauerkraut, relish, onions, topped with cheese",false, 60);
addItem("Steamed Veggies and Brown Rice","A medly of steamed vegetables over brown rice", true, 99);
addItem("Pasta","Spaghetti with Marinara Sauce, and a slice of sourdough bread",true, 89);
}
public void addItem(String name, String description,boolean vegetarian, double price) 
{
MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
if (numberOfItems >= MAX_ITEMS) 
{
System.err.println("Sorry, menu is full!  Can't add item to menu");		
} 
else 
{
menuItems[numberOfItems] = menuItem;
numberOfItems = numberOfItems + 1;
}
}
public MenuItem[] getMenuItems() 
{
return menuItems;
}
public Iterator<MenuItem> createIterator() 
{
return new DinerMenuIterator(menuItems);
//return new AlternatingDinerMenuIterator(menuItems);
}
// other menu methods here
}



 class DinerMenuIterator implements Iterator<MenuItem> {
	MenuItem[] list;
	int position = 0;

	public DinerMenuIterator(MenuItem[] list) {
		this.list = list;
	}

	public MenuItem next() {
		MenuItem menuItem = list[position];
		position = position + 1;
		return menuItem;
	}

	public boolean hasNext() {
		if (position >= list.length || list[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		if (list[position-1] != null) {
			for (int i = position-1; i < (list.length-1); i++) {
				list[i] = list[i+1];
			}
			list[list.length-1] = null;
		}
	}
}


 class MenuItem {
	String name;
	String description;
	boolean vegetarian;
	double price;

	public MenuItem(String name, 
	                String description, 
	                boolean vegetarian, 
	                double price) 
	{
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}
}


public class slip24 {
	public static void main(String args[]) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		CafeMenu cafeMenu = new CafeMenu();

		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);

		waitress.printMenu();
		waitress.printVegetarianMenu();

		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.isItemVegetarian("Hotdog")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.isItemVegetarian("Waffles")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}



 class PancakeHouseMenu implements Menu {
	ArrayList<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();

		addItem("K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs and toast", 
			true,
			90);

		addItem("Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 
			false,
			80);

		addItem("Blueberry Pancakes",
			"Pancakes made with fresh blueberries and blueberry syrup",
			true,
			60);

		addItem("Waffles",
			"Waffles with your choice of blueberries or strawberries",
			true,
			70);
	}

	public void addItem(String name, String description,
	                    boolean vegetarian, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}

	// other menu methods here
}



 class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;

	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		System.out.println("\nDINNER");
		printMenu(cafeIterator);
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	public void printVegetarianMenu() {
		System.out.println("\nVEGETARIAN MENU\n---------------");
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		printVegetarianMenu(dinerMenu.createIterator());
		printVegetarianMenu(cafeMenu.createIterator());
	}

	public boolean isItemVegetarian(String name) {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		if (isVegetarian(name, pancakeIterator)) {
			return true;
		}
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		if (isVegetarian(name, dinerIterator)) {
			return true;
		}
		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();
		if (isVegetarian(name, cafeIterator)) {
			return true;
		}
		return false;
	}


	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName() + ", ");
				System.out.print(menuItem.getPrice() + " -- ");
				System.out.println(menuItem.getDescription());
			}
		}
	}

	private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
}

 class MenuTestDrive {
	public static void main(String args[]) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		CafeMenu cafeMenu = new CafeMenu();

		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);

		waitress.printMenu();
		waitress.printVegetarianMenu();

		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.isItemVegetarian("Hotdog")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.isItemVegetarian("Waffles")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}