package service;

import domain.AccountBean;

public interface AccountService {
	public void createAccount(AccountBean aa);
			public void addList(AccountBean account);
			public AccountBean[] list();
			public AccountBean[] minusList();
			public String createAccountNum(String random);
			public String createRandom(int start,int end);
			public String createDate();
			public AccountBean findById(AccountBean aa);
			public AccountBean[] findByName(String name);
			public int countSameWord(String word);
			public String changePass(AccountBean account);
			public String deleteAccount(AccountBean account);
}