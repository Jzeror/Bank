package controller;

import javax.swing.JOptionPane;
import domain.AccountBean;
import service.AccountService;
import serviceImpl.AccountServiceImpl;

enum AccountButt1 {
	EXIT, ACCOUNT, MINUS_ACCOUNT, DEPOSIT, WITHDRAW, LIST, FIND_BY_ID
}

public class AccountController {

	public static void main(String[] args) {
		AccountButt1[] buttons = { AccountButt1.EXIT, AccountButt1.ACCOUNT, AccountButt1.MINUS_ACCOUNT,
				AccountButt1.DEPOSIT, AccountButt1.WITHDRAW, AccountButt1.LIST, AccountButt1.FIND_BY_ID

		};
		// Account account = null;
		AccountService service = new AccountServiceImpl();
		 AccountBean aa;
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

				aa = new AccountBean();
				aa.setName(JOptionPane.showInputDialog("이름"));
				aa.setUid(JOptionPane.showInputDialog("id"));
				aa.setPass(JOptionPane.showInputDialog("pass"));
				/* AccountBean account = */ service.createAccount(aa); // 굳이 account로 안 받아도 된다.
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.showResult());
				break;
			case FIND_BY_ID:
				/*
				 * ID 와 PASS 받아서 일치하면 계좌내역을 보여줘. 단, 혹시 모르니까 비번은 **** 처리해
				 */
;
				aa = new AccountBean();
				aa.setUid(JOptionPane.showInputDialog("id"));
				aa.setPass(JOptionPane.showInputDialog("pass"));
				service.findById(aa);
				JOptionPane.showMessageDialog(null, service.findById(aa));
				break;
			}
		}
	}

}
