package basicAPI.objects;

public class StudentComparator implements Comparator<Student>{
	@Override
	public int compare(Student a, Student b) {
		if(a.sno < b.sno) return -1;
		else if(a.studentNo == b.sno) return 0;
		else return 1;
		// 간단하게 다음과 같이 코드 대체 가능
		// return Integer.compare(a.sno, b.sno);
	}

}
