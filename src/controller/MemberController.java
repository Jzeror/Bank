package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

//JOIN은 일반유저 추가 , ADD는 직원 추가
enum MemberButt {
	EXIT, JOIN, ADD, LIST, FIND_BY_ID, FIND_BY_NAME, COUNT, UPDATE, WITHDRAWAL
}

public class MemberController {

	public static void main(String[] args) {
		MemberButt[] buttons = { MemberButt.EXIT, MemberButt.JOIN, MemberButt.ADD, MemberButt.LIST,
				MemberButt.FIND_BY_ID, MemberButt.FIND_BY_NAME, MemberButt.COUNT, MemberButt.UPDATE,
				MemberButt.WITHDRAWAL };
		// Account account = null;
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		while (true) {
			MemberButt select = (MemberButt) JOptionPane.showInputDialog(null, // frame
					"선택", // frame title
					"기능을 선택하시오", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1]); // default
			switch (select) {
			case EXIT:
				JOptionPane.showMessageDialog(null, "종료함다");
				return;
			case JOIN:
				member = new UserBean();
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?"));
				member.setName(JOptionPane.showInputDialog("이름?"));
				member.setSsn(JOptionPane.showInputDialog("주민등록번호?"));
				member.setAddr(JOptionPane.showInputDialog("주소?"));
				member.setPhone(JOptionPane.showInputDialog("폰번호?"));
				member.setEmail(JOptionPane.showInputDialog("이메일?"));
				service.createJoin(member);

				break;
			case ADD:
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?"));
				member.setName(JOptionPane.showInputDialog("이름?"));
				member.setSsn(JOptionPane.showInputDialog("주민등록번호?"));
				member.setAddr(JOptionPane.showInputDialog("주소?"));
				member.setPhone(JOptionPane.showInputDialog("폰번호?"));
				member.setEmail(JOptionPane.showInputDialog("이메일?"));
				service.createAdd(member);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.showList());
				break;

			case FIND_BY_ID:
				member = new MemberBean();
				member.setName(JOptionPane.showInputDialog("이름?"));
				member.setSsn(JOptionPane.showInputDialog("주민번호?"));
				JOptionPane.showMessageDialog(null, service.findById(member));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름?")));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, "총 등록된 수는 " + service.showCount() + " 명 입니다.");
				break;
			case UPDATE:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?") + "/" + JOptionPane.showInputDialog("새 비밀번호?"));
				JOptionPane.showMessageDialog(null, service.changePass(member));
				break;
			case WITHDRAWAL:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디?"));
				member.setPass(JOptionPane.showInputDialog("비밀번호?") + "/" + JOptionPane.showInputDialog("비밀번호 확인"));
				JOptionPane.showMessageDialog(null, service.withdrawalId(member));
				break;
			}
		}
	}
}
