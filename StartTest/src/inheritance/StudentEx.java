package inheritance;

public class StudentEx {

	public static void main(String[] args) {
		Student student = new Student("ABC", "123456-1234567", 1);
		System.out.println("name : " + student.name); // 부모에서 물려받은
		System.out.println("ssn : " + student.ssn);   // 필드 출력
		System.out.println("studentNo : " + student.studentNo);

	}

}
