import java.io.*;
import java.net.*;

public class time
{
    public static void main(String[] args) throws Exception
    {
      ServerSocket sersock = new ServerSocket(4583);
      System.out.println("Ready...");
      Socket sock = sersock.accept();
      String IPadd = sock.getInetAddress().getHostAddress();
      //String port = ""+sock.getLocalPort();
      String hostname = sock.getInetAddress().getCanonicalHostName();
      
      System.out.println("Connected" + hostname +" " + IPadd);
      BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));
      String receiveMessage, sendMessage;               
      System.out.println("If you want to exit, press ctrl C");
      
      while(true)
      {
	sendMessage = keyRead.readLine();
        pwrite.println(sendMessage);
	pwrite.flush();
	
        receiveMessage = receiveRead.readLine();
	float hours = Float.parseFloat(receiveMessage);
        System.out.println(" " + receiveMessage + " hours");
        
	if (hours >= 0.00 && hours < 12.00)
        {
          pwrite.println("GOOD MORNING");
          pwrite.flush();
        }
        else if (hours >= 12.00 && hours < 13.00)
        {
          pwrite.println("GOOD AFTERNOON");
          pwrite.flush();
        }
        else if (hours >= 13.00 && hours < 19.00)
        {
          pwrite.println("GOOD EVENING");
          pwrite.flush();
        }
        else if (hours >= 19.00 && hours < 23.00)
        {
          pwrite.println("GOOD NIGHT");
          pwrite.flush();
        }
        else
        {
          pwrite.println("MIDNIGHT");
          pwrite.flush();
        }

        //receiveMessage = receiveRead.readLine();
	//System.out.println(receiveMessage); 
      }
    }
}
