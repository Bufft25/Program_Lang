package Club_Model;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Table table = new Table(5);
		ArrayList<Diner> seated = table.seat();
		System.out.print(seated);
	}

}
