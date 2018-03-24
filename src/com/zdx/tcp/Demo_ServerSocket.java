package com.zdx.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_ServerSocket {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		InputStream is = null;
		Socket s = null;
		try {
			//1.建立服务端的socket并指定端口号
			serverSocket = new ServerSocket(6868);
			System.out.println("服务器已启动...等待客户端发送请求..");
			//2.建立链接
			s = serverSocket.accept();
			System.out.println("已经有客户端链接.."+s.getInetAddress()+"#port："+s.getPort());
			//3.获取IO流
			is = s.getInputStream();
			byte[] b = new byte[1024];
			int len = 0;
			len = is.read(b);
			System.out.println("客户端："+new String(b,0,len));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s!=null){
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
