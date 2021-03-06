package com.example.concurrency.st;

/**
 * 线程优先级,有效范围1-10之间（数字越大优先级越高）
 * @author OKali
 *
 */
public class PriorityDemo {
	
	public static void main(String[] args) {
		Thread hight = new HightPriority();
		LowPriority low = new LowPriority();
		hight.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		
		low.start();
		hight.start();
	}

	public static class HightPriority extends Thread {
		static int count = 0;
		
		@Override
		public void run() {
			while (true) {
				synchronized (PriorityDemo.class) {
					count ++;
					if (count > 10000000) {
						System.out.println("HightPriority is complete");
						break;
					}
				}
			}
		}
	}
	
	public static class LowPriority extends Thread {
		static int count = 0;
		
		@Override
		public void run() {
			while (true) {
				synchronized (PriorityDemo.class) {
					count ++;
					if (count > 10000000) {
						System.out.println("lowPriority is complete");
						break;
					}
				}
			}
		}
	}
}
