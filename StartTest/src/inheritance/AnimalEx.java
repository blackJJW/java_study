package inheritance;

public class AnimalEx {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		System.out.println("-----");
		
		// ������ �ڵ� Ÿ�� ��ȯ
		Animal animal = null;
		
		animal = new Dog();   // �ڵ� Ÿ�� ��ȯ
		animal.sound();       // �����ǵ� �޼ҵ� ȣ��
		
		animal = new Cat();   // �ڵ� Ÿ�� ��ȯ
		animal.sound();       // �����ǵ� �޼ҵ� ȣ��
		System.out.println("-----");
		
		// �޼ҵ��� ������
		animalSound(new Dog()); // �ڵ� Ÿ�� ��ȯ
		animalSound(new Cat()); // �ڵ� Ÿ�� ��ȯ
	}
	
	public static void animalSound(Animal animal) {
		animal.sound(); // �����ǵ� �޼ҵ� ȣ��
	}
}
