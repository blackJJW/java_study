package basicAPI.system_class;

public class NewInstanceEx {
	public static void main(String[] args) {
	
		try {
			//Class clazz = Class.forName("basicAPI.system_class.SendAction");
			Class clazz = Class.forName("basicAPI.system_class.ReceiveAction");
			Action action = (Action) clazz.newInstance();
			action.execute();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
