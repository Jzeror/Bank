package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.AccountBean;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountBean[] list; // 
	private int count;
	 public AccountServiceImpl() { // 생성자.
		list =new AccountBean[3];
		count = 0;
	}
	@Override
	public void createAccount(AccountBean aa) {
		
		aa.setAccountNum(createAccountNum(createRandom(0,999))); //계좌번호
		aa.setAccountType(aa.ACCOUNT_TYPE);
		aa.setCreateDate(createDate());
		//account.setMoney();
		addList(aa);
	}

	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
	}

	@Override
	public AccountBean[] list() {
		AccountBean arr[] = new AccountBean[10];
		return list;
	}

	@Override
	public String createAccountNum(String random) {
		String num = "";
		for(int i = 0; i<3; i++) {
			if(i!=2) {
				num += String.format("%d", Integer.parseInt(createRandom(0,999)))+"-";
			}else {
				num+=String.format("%d", Integer.parseInt(createRandom(0, 999)))+"";
			}
		}
		return num;
	}

	@Override
	public String createRandom(int start, int end) {
		String random="";
		random = String.valueOf((int) (Math.random() * (end+1)) + start);
		
		return random;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String showResult() {
		String result = "";
		for(int i = 0; i <count; i++) {
			result += list[i].toString()+"\n";
		}
		return result;
	}
	@Override
	public AccountBean findById(AccountBean aa) {
	AccountBean acc=new AccountBean();
	for(int i=0; i<count;i++) {
		
		if(list[i].getUid().equals(aa.getUid()) && list[i].getPass().equals(aa.getPass())){
	return list[i];
		}
	}
	// 배열 list 를 looping 하면서 
	// Id가 일치하고 Pass가 일치하는 값을 찾아서
	//그 객체를 리턴한다
	//일단 일치하는 값이 없는 상황은 나중에 처리
		return acc;
	}

}
