1.Write a program in java to create a thread by extending the "Thread" class
 and by implementing the "Runnable" interface.

package thread;


	
	
	public class MyThread extends Thread
	{
	 	public void run()
	 	{
	  		System.out.println("concurrent thread started running..");
	}
	 	public static void main( String args[] )
	 	{
	  		MyThread mt = new  MyThread();
	  		mt.start();
	 	}
	} 