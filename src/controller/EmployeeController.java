package controller;

import javax.swing.JOptionPane;

enum SalButt {
	EXIT, INTERNSHIP;
}

public class EmployeeController {
	public static void main(String[] args) {
		SalButt[] buttons = { SalButt.EXIT, SalButt.INTERNSHIP };
		while (true) {
			SalButt select = (SalButt) JOptionPane.showInputDialog(null, // frame
					"MENU", // frame title
					"SELECT CALL MENU", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1] // default
			);

			switch (select) {
			case EXIT:
				return;
			case INTERNSHIP:
				
				break;

			}

		}
	}
}
