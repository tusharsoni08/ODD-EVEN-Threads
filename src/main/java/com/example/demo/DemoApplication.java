package com.example.demo;


public class DemoApplication {
	public static void main(String[] args) {
		State state = new State(PrinterType.ODD);
		EvenTask eventTask = new EvenTask(2, state);
		OddTask oddTask = new OddTask(1, state);

		Thread evenThread = new Thread(eventTask);
		Thread oddThread = new Thread(oddTask);
		evenThread.start();
		oddThread.start();

	}
}
