package Club_Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Menu items for Diners to pick from.
 * 
 * @author Travis Buff
 * @version due:9/24/2015
 *
 */
public class Menu {
	private ArrayList<String> items = new ArrayList<String>(5);

	public Menu() {
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
	}

	public String toString() {
		String menuContains = "The menu contains the following items:\n";
		Iterator<String> item = items.iterator();
		while (item.hasNext()) {
			menuContains = menuContains + item.next();
			if(item.hasNext() == true){
				menuContains = menuContains +", ";
			}else{
				menuContains = menuContains + "\n";
			}
		}
		return menuContains;
	}
}
