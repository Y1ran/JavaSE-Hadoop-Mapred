package MutiThread;

public class Mutitest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable threadjob = new excute();
		Thread t = new Thread(threadjob);
		
		t.start();
		
		Mutitest.check2();
		
		System.out.println("go back again");
		
		Mutitest.check();
	}
	
	public static void check()
	{
		System.out.println("end");
	}
	
	public static void check2()
	{
		System.out.println("before ending");
	}

}
