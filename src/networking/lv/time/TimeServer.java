package networking.lv.time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

	public static void main(String[] args) {
		int counter = 0;
		
		while(true) {
			try(ServerSocket ss = new ServerSocket(1111)) {
				Socket s = ss.accept();
				counter++;
				if(counter <= 10) {
					try(OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
					BufferedWriter bw = new BufferedWriter(osw)) {
						bw.write("Counter: " + counter + " Uhrzeit: " + LocalDateTime.now().toString());
						bw.flush();
					}
				}
				else {
					break;
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
