package com.kf.callBackTemplateTest;

import java.io.BufferedReader;
import java.io.IOException;

import com.kf.callBackTemplateTest.interfaceC.ICallback;

public class CalCStringPlus implements ICallback<String>{

	@Override
	public String multiCal(BufferedReader br , String value) throws NumberFormatException, IOException {
		String line = null;
		while ((line= br.readLine())!=null) {
			value = value + Integer.valueOf(line);
		}
		return value;
	}

}
