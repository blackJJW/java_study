package nestedClassAndNestedInterface;

public class CallListener implements Button.OnClickListener{

	@Override
	public void onClick() {
		System.out.println("전화를 건다.");
	}
}
