package com.test;
//git����
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * �̴߳��������ַ�ʽ���̳�Thread,ʵ��runable,ʵ��Callable
 * 
 * call������run�����ıȽ�: 1.call�з���ֵ runû�з���ֵ 2.call�������쳣(Exception),runû�����쳣
 * 
 * ����: ����һ���̣߳�����һ����(10���ڵ�����)����ȡ�����
 */
public class ThreadAdd implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return new Random().nextInt(10);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// ����Callable����
		Callable<Integer> callAble = new ThreadAdd();
		// ��callAbleת��ΪRunable
		FutureTask<Integer> ft = new FutureTask<>(callAble);
		// �����߳�
		Thread t = new Thread(ft);
		System.out.println("�߳��Ƿ����:" + ft.isDone());
		// �����߳�
		t.start();
		// ��ȡ�̵߳ķ��ؽ��
		Integer i = ft.get();
		System.out.println(i);
		System.out.println("�߳��Ƿ����:" + ft.isDone());
	}

}
