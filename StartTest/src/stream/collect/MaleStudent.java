package stream.collect;

import java.util.ArrayList;
import java.util.List;

public class MaleStudent {
	private List<Student> list; // 요소를 저장할 컬렉션
	
	public MaleStudent() {
		list = new ArrayList<Student>();
		System.out.println("[ " + Thread.currentThread().getName() + " ] MaleStudent()");
		                        // 생성자를 호출하는 스레드 이름
	}
	
	public void accumulate(Student student) { // 요소를 수집하는 메소드
		list.add(student);
		System.out.println("[ " + Thread.currentThread().getName() + " ] accumulate()");
                                // accumulate()를 호출하는 스레드 이름
	}
	
	public void combine(MaleStudent other) { /* 두 MaleStudent를 결합하는 메소드
	                                          * (병렬 처리 시에만 호출)
	                                          * */
		list.addAll(other.getList());
		System.out.println("[ " + Thread.currentThread().getName() + " ] combine()");
                               // combine()을 호출하는 스레드 이름
	}
	
	public List<Student> getList(){ // 요소가 저장된 컬렉션을 리턴
		return list;
	}
}
