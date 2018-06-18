package domain;

public class MinusAccountBean extends AccountBean{
	public final static String ACCOUNT_TYPE = "마이너스통장";
	public int limit; // 대출한도

	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getLimit() {
		return limit;
	}
	public String toString() {
		return String.format("%s \n %s \n 이름: %s\n 계좌번호: %s\n 생성날짜: %s\n ID: %s \n Pass: ****** \n 마이너스한도: %d \n\n",BANK_NAME, ACCOUNT_TYPE, name, accountNum,
				createDate, uid, limit); 
	}
}
