package basicAPI.system_class;

public class GcEx {

	public static void main(String[] args) {
		Employee emp;
		
		emp = new Employee(1); // 쓰레기가 됨
		emp = null;
		emp = new Employee(2); // 쓰레기가 됨
		emp = new Employee(3);
		
		System.out.print("emp가 최종적으로 참조하는 사원번호 : ");
		System.out.println(emp.eno);
		System.gc(); // 가비지 컬렉터 실행 요청

	}

}
class Employee{
	public int eno;
	
	public Employee(int eno) { 
		this.eno = eno;
		System.out.println("Employee(" + eno + ") 이 메모리에서 생성됨");
	}
	
	public void finalize() { // 소멸자
		System.out.println("Employee(" + eno + ") 이 메모리에서 제거됨");
	}
}

