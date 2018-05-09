package MutiThread;

public class excute implements Runnable {

	public void excute() {
		System.out.println("now begin");
	}
	
	@Override
	public void run() {
		doi();
		// TODO Auto-generated method stub
	}
	public void doi()
	{
		more();
		System.out.println("here is 1");
	}
	
	public void more()
	{
		System.out.println("here is 2");
	}
	

}
