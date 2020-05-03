package com.dev.reactive.app;

public class CallBackDemo {

	public static void main(String...strings) throws InterruptedException {
		System.out.println("Main Thread is running");
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				new CallBackDemo().runningAsync(new Callback() {

					@Override
					public void pushData(String data) {
						System.out.println("Callback data: " + data);
					}

					@Override
					public void pushComplete() {
						System.out.println("Callback Complete !");
					}

					@Override
					public void pushError(Exception e) {
						System.out.println("Callback Error called, Got an Excpetion : " + e.getMessage());
					}
					
				});
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		Thread.sleep(2000);
		
		System.out.println("Main Thread Completed");
	}
	
	public void runningAsync(Callback callback) {
		System.out.println("I am running in separate thread");
		sleep(1000);
		callback.pushData("Data1");
		callback.pushData("Data2");
		callback.pushData("Data3");
		
		callback.pushError(new RuntimeException("An Exception Occurred"));
		callback.pushComplete();
	}
	
	private static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}