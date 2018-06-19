package domain;

public class StaffBean extends MemberBean{
//직원 번호를 넣으면 직원으로 인정.
	private String accessNum;

	public String getAccessNum() {
		return accessNum;
	}
	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}
	public String toString() {
		return "회원정보 [아이디:" + uid 
				+ ", 비번:" + pass + ", 이름:" + name 
				+ ", 주민번호:" + ssn + ", 주소:" + addr
				+ ", 전화번호:" + phone 
				+", 접근번호: "+ accessNum+ "]\n";
	}
}
