package com.kftc.callBackTemplateTest;

import java.io.BufferedReader;
import java.io.IOException;

import com.kftc.callBackTemplateTest.interfaceC.ICallback;

public class CalCPlus implements ICallback<Integer>{

	@Override
	public Integer multiCal(BufferedReader br , Integer sum) throws NumberFormatException, IOException {
		String line = null;
		while ((line= br.readLine())!=null) {
			sum += Integer.valueOf(line);
		}
		return sum;
	}

}
