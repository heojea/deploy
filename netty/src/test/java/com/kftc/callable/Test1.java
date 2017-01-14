package com.kftc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class Test1 {
	@Test
	public void test() throws InterruptedException, ExecutionException{
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				for (int i = 0; i < 10; i++) {
					System.out.println("cccccc");
				}
				return 111;
			}
		});
		System.out.println("dddddd");
		System.out.println(future.get());
		System.out.println("eeeeee");
	}
}
