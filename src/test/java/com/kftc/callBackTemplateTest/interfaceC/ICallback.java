package com.kftc.callBackTemplateTest.interfaceC;

import java.io.BufferedReader;
import java.io.IOException;

public interface ICallback<T> {
	T multiCal(BufferedReader br, T value) throws NumberFormatException, IOException;
}
