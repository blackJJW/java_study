package basicAPI.objectClass;

public class Member1 implements Cloneable{ 
                             // 복제 가능 표시
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;
	
	public Member1(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}
	
	public Member1 getMember1() {
		Member1 cloned = null;
		
		try {
			cloned = (Member1) clone(); // clone() 메소드릐 리턴 타입은 
			                            // Object이므로 Member1 타입으로 캐스팅
		} catch (CloneNotSupportedException e) {}
		
		return cloned;
		
	}
}
