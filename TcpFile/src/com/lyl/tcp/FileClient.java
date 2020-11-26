package com.lyl.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("---Client---");
		Socket client = new Socket("localhost", 8888);
		
		InputStream is = new BufferedInputStream(new FileInputStream("test.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = is.read(buffer)) != -1) {
			System.out.println(buffer.length+"---"+len);
			os.write(buffer, 0, len);
		}
		os.flush();
		
		os.close();
		is.close();
		client.close();
		
	}
}
