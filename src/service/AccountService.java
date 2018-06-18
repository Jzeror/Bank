package service;

import javax.swing.JOptionPane;

import domain.AccountBean;

public interface AccountService {
	public void createAccount(AccountBean aa);
			public void addList(AccountBean account);
			public AccountBean[] list();
			public String createAccountNum(String random);
			public String createRandom(int start,int end);
			public String createDate();
			public String showResult();
			public AccountBean findById(AccountBean aa);
}
