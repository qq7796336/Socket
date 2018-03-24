package com.zdx.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo_Socket {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os =null;
		try {
			//1.建立客户端的socket，并指定所要链接的主机的IP与程序端口号
			socket = new Socket("192.168.31.14", 6868);
			System.out.println("客户端程序已经建立...同时申请接受服务端");
			//2.写入IO流
			os= socket.getOutputStream();
			os.write("HelloWorld".getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(socket!=null){
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
