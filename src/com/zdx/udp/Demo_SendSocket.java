package com.zdx.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Demo_SendSocket {

	public static void main(String[] args) {
		//发送方
		DatagramSocket send = null;
		try {
			send = new DatagramSocket();
			String str = "Hello World";
			byte[] b = str.getBytes();
			//打包
			DatagramPacket packet = new DatagramPacket(b, b.length, InetAddress.getByName("192.168.31.14"), 9999);
			//发送
			send.send(packet);
			//关闭
			send.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
