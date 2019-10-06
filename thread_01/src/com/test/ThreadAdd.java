package com.test;
//git测试
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * 线程创建的三种方式：继承Thread,实现runable,实现Callable
 * 
 * call方法跟run方法的比较: 1.call有返回值 run没有返回值 2.call声明了异常(Exception),run没声明异常
 * 
 * 需求: 创建一个线程，产生一个数(10以内的整数)，获取这个数
 */
public class ThreadAdd implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return new Random().nextInt(10);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 创建Callable对象
		Callable<Integer> callAble = new ThreadAdd();
		// 将callAble转换为Runable
		FutureTask<Integer> ft = new FutureTask<>(callAble);
		// 创建线程
		Thread t = new Thread(ft);
		System.out.println("线程是否结束:" + ft.isDone());
		// 启动线程
		t.start();
		// 获取线程的返回结果
		Integer i = ft.get();
		System.out.println(i);
		System.out.println("线程是否结束:" + ft.isDone());
	}

}
