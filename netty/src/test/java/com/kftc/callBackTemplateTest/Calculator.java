package com.kftc.callBackTemplateTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.kftc.callBackTemplateTest.interfaceC.ICallback;

class Calculator {
	/**
	 * multiple param  and multiple return
	 * @param filePath : file FULLPATH
	 * @param icalc : callback
	 * @param value : cal default value
	 * @return
	 * @throws IOException
	 */
	public <T> T calcSum(String filePath , ICallback<T> icalc , T value) throws IOException{
		BufferedReader br = null;
		try{
			br =new BufferedReader(new FileReader(filePath));
			return icalc.multiCal(br , value);
		}catch (IOException e){
			e.printStackTrace();
			throw e;
		}finally{
			if(br != null) br.close();
		}
		
	}
}
