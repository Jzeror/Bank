package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.AccountBean;
import domain.MinusAccountBean;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountBean[] list; //
	private int count;

	public AccountServiceImpl() { // 생성자.
		list = new AccountBean[100000];
		count = 0;
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
	}

	
	@Override
	public AccountBean[] list() {
	
		return list;
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
	public AccountBean[] minusList() {
		AccountBean[] minusAccount=new AccountBean[100];
		int d=0;
		for(int i=0; i<count ; i++) {
			if(list[i].getAccountType().equals(MinusAccountBean.ACCOUNT_TYPE )) {
				minusAccount[d++]=list[i];
			}
		}System.out.println(list[0].getAccountType() );
		return minusAccount;
	}

	@Override
	public void createMinusAccount(AccountBean ma) {
		createAccount(ma);
		ma.setLimit(ma.limit);
		
	}


	
}
