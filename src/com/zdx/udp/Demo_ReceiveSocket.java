package com.zdx.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo_ReceiveSocket {

	public static void main(String[] args) {
		//接收方
		DatagramSocket receive=null;
		try {
			receive = new DatagramSocket(9999);
			//准备接收数据
			byte[] b = new byte[1024];
			DatagramPacket packet = new DatagramPacket(b, b.length);
			//接受数据
			receive.receive(packet);
			byte[] data = packet.getData();
			String from = "数据来自："+packet.getAddress()+";port:"+packet.getPort();
			System.out.println(from+"；数据："+new String(data));
			//关闭
			receive.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
