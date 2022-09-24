package basicAPI.system_class;

public class ReceiveAction implements Action{

	@Override
	public void execute() {
		System.out.println("receiving data");
	}
}
