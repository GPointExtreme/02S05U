package networking.lv.time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(1111)) {
			Socket s = ss.accept();
			
			try(OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			BufferedWriter bw = new BufferedWriter(osw)) {
				bw.write(LocalDateTime.now().toString());
				bw.flush();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
