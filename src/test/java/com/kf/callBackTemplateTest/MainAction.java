package com.kf.callBackTemplateTest;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.kf.callBackTemplateTest.interfaceC.ICallback;

public class MainAction {
	public static void main(String[] args) throws IOException{
		Path path = Paths.get("C:\\workspace_sts\\netty\\src\\test\\java\\documents\\callBackText");
		Calculator calA = new Calculator();
		ICallback<String> calString = new CalCStringPlus();
		ICallback<Integer> calInt = new CalCPlus();
		
		
		int a      = calA.calcSum(path.toString(), calInt , 0 );
		String str = calA.calcSum(path.toString(), calString, "");
		System.out.println(a);
		System.out.println(str);
		
		//a = calA.calcSum("C:\\workspace_sts\\netty\\src\\test\\java\\documents\\callBackText" , cal);
		//System.out.println(a);
		
	}
}
