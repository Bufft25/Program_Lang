package Club_Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Name of person attending restaurant and a list of their top 5 foods.
 * 
 * @author Travis Buff
 * @version Due:9/24/2015
 */
public class Diner {
	private Menu menu = new Menu(); // foods to choose from.
	private String name;
	private ArrayList<String> foods = new ArrayList<String>(); // diners most
																// liked to
																// least liked
																// menu items.
	private Scanner scan;

	public Diner() {
		scan = new Scanner(System.in);
		System.out.print("Please enter diner's name: ");
		name = scan.nextLine();
		this.foodChoices();
	}

	/**
	 * allows the customer to list his most liked to least liked items on the
	 * menu.
	 */
	private void foodChoices() {
		String food;
		this.menuItems();
		System.out
				.print("The above are the foods we are currently serving today. please list them in order from most liked to least liked.\n");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + ":");
			food = scan.next();
			if ((food.equalsIgnoreCase("A") || food.equalsIgnoreCase("B")
					|| food.equalsIgnoreCase("C") || food.equalsIgnoreCase("D")
					|| food.equalsIgnoreCase("E")) && (!foods.contains(food))) {
				foods.add(food);
			} else {
				foods.clear(); // have to restart because one input was not an
								// option or was a repeat.
				System.out.println("Error in input");
				this.foodChoices(); // re-do method for correct input.
			}

		}
		System.out.println();
	}

	/**
	 * @return items of the food menu.
	 */
	public void menuItems() {
		System.out.print(menu);
	}
	
	/**
	 * Compares the top 3 foods with the other diner.
	 * likeness goes up more if the higher liked food is a match.
	 * @param diner to be compared with this Diner
	 * @return likeness value between this Diner and the param diner, higher is better.
	 */
	public int compare(Diner diner){
		int likeness = 0;
		for(int i = 0; i < foods.size(); i++){
			if(i == 1){
				if(compareFoods(diner, i)){
					likeness = likeness + 5;
				}
				if(diner.foods.get(i++).equalsIgnoreCase(this.foods.get(i))){
					likeness = likeness + 3;
				}
				if(diner.foods.get(i+2).equalsIgnoreCase(this.foods.get(i))){
					likeness = likeness + 1;
				}			
			}
			if(i == 2){
				if(compareFoods(diner, i)){
					likeness = likeness + 3;
				}
				if(diner.foods.get(i++).equalsIgnoreCase(this.foods.get(i))){
					likeness = likeness + 1;
				}
			}
			if(i == 3){
				if(compareFoods(diner, i)){
					likeness = likeness + 1;
				}
			}
		}
		return likeness;
	}
	
	/**
	 * Method is used to shorten amount of if statement made in compare method for this class.
	 */
	private boolean compareFoods(Diner diner, int i){
		if(this.foods.get(i).equalsIgnoreCase(diner.foods.get(i))){
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String diner = name + "\n";
		int num = 0;
		Iterator<String> it = foods.iterator();
		while (it.hasNext()) {
			num++;
			diner = diner + num + ". " + it.next() + "\n";
		}
		return diner;
	}
}
