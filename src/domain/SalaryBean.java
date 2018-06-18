package domain;

public class SalaryBean {
public static final String DEPT = "인턴쉽";
String dept, name;
int sal;

public void setName() {
	
}
public void setSal() {
	
}
public void setDept() {
	
}
public String getName() {
	return name;
}
public String getDept() {
	return dept;
}
public int getSal() {
	return sal;
}

public String toString() {
	return String.format("%s%s에게 %d원을 지급한다", name,dept,sal);
}
}
