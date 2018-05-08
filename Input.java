package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Input {

	public void outer{
	try {
		Socket chatsock = new Socket("127.0.0.1", 5000);
		
		InputStreamReader stream = new InputStreamReader
				(chatsock.getInputStream());
		
		BufferedReader reader = new BufferedReader(stream);
		
		String message = reader.readLine();
		System.out.println(message);
		
		reader.close();
	} catch(IOException ex)
	 {
		ex.printStackTrace();
	 }

	}
}
