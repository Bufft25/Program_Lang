package Club_Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will take diners and assign them a seating order based on their
 * food preference.
 * 
 * @author Travis Buff
 * @version Due:9/24/2015
 */
public class Table {
	private int numberOfDiners;
	private ArrayList<Diner> diners;

	public Table(int numDiners) {
		numberOfDiners = numDiners;
		diners = new ArrayList<Diner>(numberOfDiners);
		dinerInfo(numberOfDiners);
	}
	

	/**
	 * Allows user to enter all info of guests to be seated at a table.
	 * @param numberGuests is the number of guests to be seated at a table
	 */
	private void dinerInfo(int numberGuests){
		int i = 0;
		System.out.println("Please enter the information for each diner");
		while(i < numberGuests){
			diners.add(new Diner());
			i++;
		}
	}
	
	/**
	 * uses a likeness of the bubblesort design to go through the array and compare using the diner compare method
	 * the diner with the highest menu item likeness to this diner is then seated next to this diner.
	 * @return the Array of seated diners.
	 */
	public ArrayList<Diner> seat(){
		int likeness = -1;
		Diner temp;
		ArrayList<Diner> seatArr = diners;
		for(int i = 0; i < diners.size(); i++){
			for(int j = i+1; j < diners.size(); j++){
				if(seatArr.get(i).compare(seatArr.get(j)) > likeness){
					likeness = seatArr.get(i).compare(seatArr.get(j));
					temp = seatArr.get(i+1);
					seatArr.set(i+1,seatArr.get(j));
					seatArr.set(j, temp);
				}
						
			}
		}
		return seatArr;
	}

}
