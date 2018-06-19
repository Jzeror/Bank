package serviceImpl;

import domain.*;

import service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] list;
	private int count;

	public MemberServiceImpl() {
		list = new MemberBean[20];
		count = 0;
	}

	@Override
	public void createJoin(MemberBean member) {
		((UserBean) member).setCreditRating("7등급");
		addList(member);
	}

	@Override
	public void createAdd(MemberBean member) {
		((StaffBean) member).setAccessNum("111-1111");
		addList(member);
	}

	@Override
	public MemberBean[] addList(MemberBean member) {
		list[count++] = member;
		return null;
	}

	@Override
	public String showList() {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += list[i] + "\n";
		}
		return result;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		for (int s = 0; s < count; s++) {
			if (member.getName().equals(list[s].getName()) && member.getSsn().equals(list[s].getSsn())) {
				member = list[s];
				break;
			}
		}
		return member;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int temp = findSame(name);
		MemberBean[] member = new MemberBean[temp];
		int count = 0;
		for (int s = 0; s < count; s++) {
			if (name.equals(list[s].getName())) {
				member[count++] = list[s];
				if (count == temp) {
					break;
				}
			}
		}
		return member;
	}

	@Override
	public int findSame(String name) {
		int temp = 0;
		for (int s = 0; s < count; s++) {
			if (name.equals(list[s].getName())) {
				temp++;
			}
		}
		return temp;
	}

	@Override
	public int showCount() {
		return count;
	}

	@Override
	public String changePass(MemberBean member) {
		String result = "";
		String uid = member.getName();
		String pass = member.getPass().split("/")[0];
		String newPass = member.getPass().split("/")[1];
		member.setPass(pass);
		member = findById(member);
		if (pass.equals(newPass)) {
			result = "동일비번 ㄴㄴ";
		} else {
			if (member.getName() == null) {
				result = "아이디비번 확인해주셈";
			} else {
				member.setPass(newPass);
				result = "ㅇㅋ 성공";
			}
		}
		return result;
	}

	@Override
	public String withdrawalId(MemberBean member) {
		String result = "";
		String pass = member.getPass().split("/")[0];
		String confirmPass = member.getPass().split("/")[1];
		for (int s = 0; s < count; s++) {
			if (member.getUid().equals(list[s].getUid()) && pass.equals(list[s].getPass())
					&& pass.equals(confirmPass)) {
				list[s] = list[--count];
				list[count] = null;
				result = "이용해주셔서 감사";
				break;
			} else {
				result = "잘못 입력하셨습니다";
			}
		}
		return result;
	}
}
