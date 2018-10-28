import java.io.*;
import java.net.*;


public class ServerHTTP
{
   public static void main(String[] args) throws IOException                
   {                                                                       
      ServerSocket serv=new ServerSocket(80);                              
                                                                           
      while(true)                                                          
      {                                                                    
         //przyjecie polaczenia                                            
         System.out.println("Oczekiwanie na polaczenie...");               
         Socket sock=serv.accept();                                        
                                                                           
         //strumienie danych                                               
         InputStream is=sock.getInputStream();                             
         OutputStream os=sock.getOutputStream();                           
         BufferedReader inp=new BufferedReader(new InputStreamReader(is)); 
         DataOutputStream outp=new DataOutputStream(os);                   
                                                                           
         //przyjecie zadania (request)                                     
         String request=inp.readLine();   
        
        
                                                                           
         //wyslanie odpowiedzi (response)                                  
         if(request.startsWith("GET"))                                     
         {                                                                 
            //response header                                              
            outp.writeBytes("HTTP/1.0 200 OK\r\n");                        
            outp.writeBytes("Content-Type: text/html\r\n");                
            outp.writeBytes("Content-Length: \r\n");                       
            outp.writeBytes("\r\n");                                       
                                                                           
            //response body                                                
            outp.writeBytes("<html>\r\n");                                 
            outp.writeBytes("<H1>Strona testowa</H1>\r\n");   
            
            
            try(FileInputStream fis = new FileInputStream("C://Users//Sergey//Desktop//java.png");)
            {
            	byte[] bufor, buffer;
            	bufor=new byte[1024];
            	buffer=new byte[1024];
            	int n=0;

            	while ((n = fis.read(bufor)) != -1 )
            	{
            		outp.write(buffer, 0, n);
            	}
            	outp.writeBytes("<img src=\"java.png\">");
            	
            }
            catch(IOException ex)
            {
            	outp.writeBytes("HTTP/1.0 404 Not Found.");
            }
            outp.writeBytes("</html>\r\n");    
            
            
         }                                                                 
         else                                                              
         {                                                                 
            outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");            
         }       
         
         System.out.println("Request = " + request);
         
         
         while(inp.ready()){
                      
             System.out.println(inp.readLine());
         }
                                                                           
         //zamykanie strumieni                                             
         inp.close();                                                      
         outp.close();                                                     
         sock.close();                                                     
      }                                                                    
   }                                                                       
}