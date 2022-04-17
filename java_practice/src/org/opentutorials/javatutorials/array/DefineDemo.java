package org.opentutorials.javatutorials.array;

public class DefineDemo {

	public static void main(String[] args) {
		
		String[] classGroup = {"ÃÖÁøÇö", "ÃÖÀ¯ºó", "ÇÏ³¶¸²", "ÀÌ°íÀ×"};
		System.out.println(classGroup[0]);
		System.out.println(classGroup[1]);
		System.out.println(classGroup[2]);
		System.out.println(classGroup[3]);
		
		String[] classGroup1 = new String[4];
		classGroup1[0] = "ÃÖÄ£Çõ";
		System.out.println(classGroup1.length);
		classGroup1[1] = "ÃÖÀ¯ºó";
		System.out.println(classGroup1.length);
		classGroup1[2] = "ÇÑ¾Æ¶÷";
		System.out.println(classGroup1.length);
		classGroup1[3] = "ÀÌ°íÀ×";
		System.out.println(classGroup1.length);
	}

}
