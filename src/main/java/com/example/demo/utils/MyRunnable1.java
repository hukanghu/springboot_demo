package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("first DynamicTask，"
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
