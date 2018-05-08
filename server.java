package socket;

import java.net.Socket;

import java.io.*;
import java.net.*;

public class server {

	public void write() {
	Socket chatsock = new Socket("127.0.0.1", 5000);
	
	PrintWriter writer = new PrintWriter(chatsock.getOutputStream());
	
	writer.println("message to send");
	}
	
}
