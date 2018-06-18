package service;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MinusAccountBean;

public interface AccountService {
	public void createAccount(AccountBean aa);
			public void addList(AccountBean account);
			public AccountBean[] list();
			public String createAccountNum(String random);
			public String createRandom(int start,int end);
			public String createDate();
			public AccountBean findById(AccountBean aa);
			public AccountBean[] findByName(String name);
			public int countSameWord(String word);
			public AccountBean[] minusList();
			public void createMinusAccount(AccountBean ma);
			
}
