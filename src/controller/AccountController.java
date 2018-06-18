package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.AccountService;
import serviceImpl.AccountServiceImpl;

enum AccountButt1 {
	EXIT, ACCOUNT, MINUS_ACCOUNT, DEPOSIT, WITHDRAW, LIST, MINUS_LIST, FIND_BY_ID, FIND_BY_NAME
}

public class AccountController {

	public static void main(String[] args) {
		AccountButt1[] buttons = { AccountButt1.EXIT, AccountButt1.ACCOUNT, AccountButt1.MINUS_ACCOUNT,
				AccountButt1.DEPOSIT, AccountButt1.WITHDRAW, AccountButt1.LIST, AccountButt1.MINUS_LIST ,AccountButt1.FIND_BY_ID, AccountButt1.FIND_BY_NAME

		};
		// Account account = null;
		AccountService service = new AccountServiceImpl();
		AccountBean account;
		while (true) {
			AccountButt1 select = (AccountButt1) JOptionPane.showInputDialog(null, // frame
					"선택", // frame title
					"기능을 선택하시오", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1]); // default
			switch (select) {
			case EXIT:
				JOptionPane.showInputDialog("종료되었습니다.");
				return;
			case ACCOUNT:
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("id"));
				account.setPass(JOptionPane.showInputDialog("pass"));
				/* AccountBean account = */ service.createAccount(account); // 굳이 account로 안 받아도 된다.
				break;
			case MINUS_ACCOUNT:
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아디"));
				account.setPass(JOptionPane.showInputDialog("패스"));
				((MinusAccountBean) account).setLimit(Integer.parseInt(JOptionPane.showInputDialog("한도?")));
				service.createMinusAccount(account);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
				
			case MINUS_LIST: 
				JOptionPane.showMessageDialog(null, service.minusList());
				break;
			case FIND_BY_ID: 
				/*
				 * ID 와 PASS 받아서 일치하면 계좌내역을 보여줘. 단, 혹시 모르니까 비번은 **** 처리해
				 */
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("id"));
				account.setPass(JOptionPane.showInputDialog("pass"));
				JOptionPane.showMessageDialog(null, service.findById(account));
				break;
			case FIND_BY_NAME: 
				
				 JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("NAME")));
				break;
			}
		}
	}

}
