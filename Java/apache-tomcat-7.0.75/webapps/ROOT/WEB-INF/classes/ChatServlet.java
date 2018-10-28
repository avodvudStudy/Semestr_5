
import java.io.IOException;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.net.ssl.HttpsURLConnection;

import java.util.Collection;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
//import javax.GetCookie;


@ServerEndpoint(value = "/ws")
public class ChatServlet extends HttpServlet{
    //notice:not thread-safe
    private static ArrayList<Session> sessionList = 
                    new ArrayList<Session>();
    private boolean StatusLogining = false;
    ArrayList<ArrayList<String>> users = 
                     new ArrayList<ArrayList<String>>();

    private static ArrayList <String> lastLogged;

    public boolean getStatusLogining(){
        return StatusLogining;
    }

    public void setStatusLogining(){
        StatusLogining = true;
    }
    
    @OnOpen
    public void onOpen(Session session)
    {
        sessionList.add(session);

    }
    
    @OnClose
    public void onClose(Session session){
        sessionList.remove(session);
    }
    
    @OnMessage
    public void onMessage(String msg){
        try{
            for(Session session : sessionList){
                session.getBasicRemote().sendText(msg);
            }
        }catch(IOException e){}
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // Set response content type       

        String user = request.getParameter("login");
        String passwd = request.getParameter("password");

        //new GetCookie().doGet(request, response);

        //response.sendRedirect("//localhost:8080/wschat.htm");
            
   }
}