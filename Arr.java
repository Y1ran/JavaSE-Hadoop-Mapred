package com.imooc;
import java.util.ArrayList;

public class Arr {
	//static int [] mylst = new int [3];
	//mylst = new int[3];
	static ArrayList mylist = new ArrayList();
	static int x = 88;
	//mylist.add(88);
	
	static void cc() {
	for(int i = 0; i < 10; i++)
	{
		mylist.add(33 * i);
		//System.out.println(mylst[i]);
	}
	System.out.println(mylist);

	
	}
}
