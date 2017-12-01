package com.kftc.blockServerAndClinetTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingServer {
	public static void main(String[] args) throws IOException{
		BlockingServer server = new BlockingServer();
		server.run();
	}
	
	public void run() throws IOException{
		ServerSocket server = new ServerSocket(8888);
		System.out.println("connected wait!!");
		
		
		while(true){
			Socket sock = server.accept();
			System.out.println("clinet accept!!!");
			
			OutputStream out = sock.getOutputStream();
			InputStream in   = sock.getInputStream();
			
			while(true){
				try{
					//System.out.println(in.available());
					
						System.out.println(in.read());
						System.out.println("11111");
					
					//out.write(request);	
				}catch(IOException e){
					break;
				}
				
			}
		}
	}
	
}
