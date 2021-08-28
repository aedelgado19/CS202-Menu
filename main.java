import java.util.Scanner;
import java.io.*;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Sushi Central!");
		System.out.println("You can order sushi, ramen, and drinks.");
		System.out.println("What is the name for the order?");
		System.out.print("> ");
		
		String name = scanner.nextLine();
		System.out.println("Thank you, " + name + ". Beginning ordering process now.");
		System.out.println();
		Menu[] m = new Menu[3];
		m[0] = new Ramen("ramen.txt", name);
		m[1] = new Drinks("drinks.txt", name);
		m[2] = new Sushi("sushi.txt", name);
		
		System.out.println();
		
		//choices(name, m);		
	}
	
	
	public static void choices(String name, Menu m) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select an option: ");
		System.out.println("1 - order sushi");
		System.out.println("2 - order ramen");
		System.out.println("3 - order drinks");
		System.out.print("> ");
		String choice = scanner.nextLine();
		
		if(choice.equals("1")) {
			Sushi s = new Sushi("sushi.txt", name);
			//order here
			
			
			System.out.println("Would you like to order more? (y/n)");
			String yn = scanner.nextLine();
			if(yn.equals("y")) {
				choices(name, m);
			} else {
				System.out.println("Thank you for ordering!");
			}
		} else if(choice.equals("2")) {
			Ramen r = new Ramen("ramen.txt", name);
			//order here
			System.out.println("Would you like to order more? (y/n)");
			String yn = scanner.nextLine();
			if(yn.equals("y")) {
				choices(name, m);
			} else {
				System.out.println("Thank you for ordering!");
			}
		} else if(choice.equals("3")) {
			Drinks d = new Drinks("drinks.txt", name);
			//order here
			System.out.println("Would you like to order more? (y/n)");
			String yn = scanner.nextLine();
			if(yn.equals("y")) {
				choices(name, m);
			} else {
				System.out.println("Thank you for ordering!");
			}
		} else {
			System.out.println("That was not one of the options!");
		}
	}
}

// ------------------------- MENU CLASS ------------------------
abstract class Menu {
	int total_cost;
	String customer; //customer's name
	int amount_of_items;
	
	//constructor
	public Menu(String file_name, String name) {
		this.customer = name;
		File f = new File(file_name);
		Scanner s;
		try {
			s = new Scanner(f);
			while(s.hasNextLine()) {
				//insert to DLL here
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	//called by derived classes to add to the total cost
	//when a customer adds an item
	public void add_to_cost(int to_add) {
		total_cost += to_add;
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		total_cost -= to_remove;
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		amount_of_items += to_add;
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		amount_of_items -= to_remove;
	}
	
	public void display() {
		System.out.println("Thank you for ordering.");
	}
}

// ------------------ SUSHI CLASS ---------------------------
class Sushi extends Menu {
	public Sushi(String file_name, String customer) {
		super(file_name, customer);
	}
	
	
	public void add_to_cost(int to_add) {
		super.add_to_cost(to_add);
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		super.remove_from_cost(to_remove);
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		super.add_item(to_add);
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		super.remove_item(to_remove);
	}
	
}

// -------------------- DRINKS CLASS --------------------------
class Drinks extends Menu {
	public Drinks(String file_name, String customer) {
		super(file_name, customer);
	}
	
	public void add_to_cost(int to_add) {
		super.add_to_cost(to_add);
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		super.remove_from_cost(to_remove);
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		super.add_item(to_add);
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		super.remove_item(to_remove);
	}
	
}

// -------------------- RAMEN CLASS ----------------------------
class Ramen extends Menu {
	public Ramen(String file_name, String customer) {
		super(file_name, customer);
	}
	
	public void add_to_cost(int to_add) {
		super.add_to_cost(to_add);
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		super.remove_from_cost(to_remove);
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		super.add_item(to_add);
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		super.remove_item(to_remove);
	}
	
}

