package com.hbma.app.thread;

import java.util.logging.Level;


public class ThreadLifeCycle {
public static void main(String[] args) {
	Thread th3 = new Thread(new RunnableThread("T3"));
	Thread th1 = new Thread(new RunnableThread("T1"));
	Thread th2 = new Thread(new RunnableThread("T2"));
	Thread th4 = new Thread(new RunnableThread("T4"));
	Thread th5 = new Thread(new RunnableThread("T5"));
	Thread th6 = new Thread(new RunnableThread("T6"));
	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
//	try {
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
//		th1.join();
//		th2.join();
//		th3.join();
//		th4.join();
//		th5.join();
//		th6.join();
//		System.out.println(th.isAlive());
//		th.getStackTrace();
//		System.out.println(th1.isAlive());
//		th.interrupt();
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
	
	System.out.println("execution over");
	return;
}
}
