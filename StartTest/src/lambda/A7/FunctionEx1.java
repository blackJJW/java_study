package lambda.A7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionEx1 {
	private static List<Student> list = Arrays.asList(
			new Student("ABC", 90, 96),
			new Student("DEF", 95, 93)
			);
	
	public static void printString( Function<Student, String> function) {
		for(Student student : list) { // list에 저장된 항목 수만큼 루핑
			System.out.println(function.apply(student) + " ");
			                  // 람다식 실행
		}
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<Student> function ) {
		for(Student student : list) { // list에 저장된 항목 수만큼 루핑
			System.out.println(function.applyAsInt(student) + " ");
			                 // 람다식 실행
		}
		System.out.println();
	}
			
	public static void main(String[] args) {
		System.out.println("[ 학생 이름 ]");
		printString( t -> t.getName() );
		
		System.out.println("[ 영어 점수 ]");
		printInt( t -> t.getEnglishScore() );
		
		System.out.println("[ 수학 점수 ]");
		printInt( t -> t.getMathScore() );
	}
}
