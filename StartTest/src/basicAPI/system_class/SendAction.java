package basicAPI.system_class;

public class SendAction implements Action{
	@Override
	public void execute() {
		System.out.println("sending data");
	}

}
