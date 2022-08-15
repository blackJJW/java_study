package annotation;

import java.lang.reflect.Method;

public class PrintAnnotationEx {

	public static void main(String[] args) {
		// Service Ŭ�����κ��� �޼ҵ� ������ ����
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		                           // Service Ŭ������ ����� �޼ҵ� ���(���÷���)
		// Method ��ü�� �ϳ��� ó��
		for(Method method : declaredMethods) {
			// PrintAnnotation�� ����Ǿ����� Ȯ��
			if(method.isAnnotationPresent(PrintAnnotation.class)) {
				// PrintAnnotation ��ü ���
				PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			
				// �޼ҵ� �̸� ���
				System.out.println("[ " + method.getName() + " ] ");
			
				// ���м� ���
				for(int i = 0; i <printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();
			
				try {
					// �޼ҵ� ���
					method.invoke(new Service());
				} catch(Exception e) {}
				System.out.println();
			}
		}
	}	
}