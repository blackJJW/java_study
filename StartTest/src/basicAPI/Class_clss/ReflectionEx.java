package basicAPI.Class_clss;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {

	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("interfacePrac.Car");
		
		System.out.println(" [클래스 이름] ");
		System.out.println(clazz.getName());
		System.out.println();
		
		System.out.println(" [생성자 정보] ");
		// 생성자 이름과 매개 변수 정보를 출력
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		
		System.out.println();
		
		System.out.println( " [필드 정보] ");
		// 필드 타입과 필드 이름을 출력
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getType().getSimpleName() + 
					" " + field.getName());
		} 
		
		System.out.println();
		
		System.out.println(" [ 메소드 정보 ] ");
		// 메소드 이름과 매개 변수를 출력
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
	}
	
	private static void printParameters(Class[] parameters) {
		// 매개 변수 정보를 출력하는 공통 코드
		for(int i = 0; i < parameters.length; i++) {
			System.out.println(parameters[i].getName());
			if(i<(parameters.length-1)) {
				System.out.print(",");
			}
		}
	}
}
