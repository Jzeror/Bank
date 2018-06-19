package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.AccountBean;
import domain.MinusAccountBean;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountBean[] list, minusList; //
	private int count, minusCount;

	public AccountServiceImpl() { // 생성자.
		list = new AccountBean[5];
		count = 0;
		minusList = new AccountBean[5];
		minusCount = 0;
	}

	@Override
	public void createAccount(AccountBean aa) {

		aa.setAccountNum(createAccountNum(createRandom(0, 999))); // 계좌번호
		aa.setAccountType(aa.ACCOUNT_TYPE);
		aa.setCreateDate(createDate());
		// account.setMoney();
		addList(aa);
	}

	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
		if (account instanceof MinusAccountBean) {
			minusList[minusCount++] = account;
		}
	}

	@Override
	public AccountBean[] list() {
		System.out.println("배열의 카운트 : " + count);
		String res = "";
		for (int i = 0; i < list.length; i++) {
			res += list[i] + "\n";
			System.out.println("배열 내부" + res);

		}
		return list;
	}

	@Override
	public AccountBean[] minusList() {

		return minusList;
	}

	@Override
	public String createAccountNum(String random) {
		String num = "";
		for (int i = 0; i < 3; i++) {
			if (i != 2) {
				num += String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "-";
			} else {
				num += String.format("%03d", Integer.parseInt(createRandom(0, 999))) + "";
			}
		}
		return num;
	}

	@Override
	public String createRandom(int start, int end) {
		String random = "";
		random = String.valueOf((int) (Math.random() * (end + 1)) + start);

		return random;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public AccountBean findById(AccountBean aa) {
		for (int i = 0; i < count; i++) {
			if (aa.getUid().equals(list[i].getUid()) && aa.getPass().equals(list[i].getPass())) {
				aa = list[i];
				break;
			}
		}
		// 배열 list 를 looping 하면서
		// Id가 일치하고 Pass가 일치하는 값을 찾아서
		// 그 객체를 리턴한다
		// 일단 일치하는 값이 없는 상황은 나중에 처리
		return aa;
	}

	@Override
	public AccountBean[] findByName(String name) {
		/* int temp =countSameWord(name); */
		AccountBean[] account = new AccountBean[countSameWord(name)];
		int d = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				account[d++] = list[i];
				if (d == countSameWord(name)) {
					break;
				}
			}
		}
		return account;
	}

	@Override
	public int countSameWord(String word) {
		int temp = 0;
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				temp++;
			}
		}
		return temp;
	}

	@Override
	public String changePass(AccountBean account) {
		String msg = "";
		// String id = account.getUid();
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		account.setPass(pass);
		account = findById(account);
		if (account.getUid() == null) {
			msg = "변경실패";
		} else {
			if (pass.equals(newPass)) {
				msg = "변경실패";
			} else {
				account.setPass(newPass);
				msg = "ㅇㅋ";
			}
		}

		// 성공 : 변경 완료
		// 실패 : 변경 실패. 현재 pass와 같다면.
		return msg;
	}

	@Override
	public String deleteAccount(AccountBean account) {
		String msg = "";
		String pass = account.getPass().split("/")[0];
		String confirmPass = account.getPass().split("/")[1];
		if (account.getUid() == null) {
			msg = "계정을 찾을 수 없습니다";}
		for (int i = 0; i < count; i++) {
			if (account.getUid().equals(list[i].getUid()) && pass.equals(list[i].getPass())&&pass.equals(confirmPass)) {
				list[i] = list[--count];
				list[count] = null;
				msg = "삭제 성공";				
				break;
			}else{
				msg = "비밀번호 다름";
			}
		}		
		return msg;
	}
}