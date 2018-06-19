package service;

import domain.MemberBean;

public interface MemberService {

	public void createJoin(MemberBean member);

	public void createAdd(MemberBean member);

	public MemberBean[] addList(MemberBean member);

	public String showList();

	public MemberBean findById(MemberBean member);

	public int findSame(String name);

	public MemberBean[] findByName(String name);

	public int showCount();

	public String changePass(MemberBean member);

	public String withdrawalId(MemberBean member);

}
