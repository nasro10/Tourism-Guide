package tn.esprit.b3.esprit1718b3tourism.mBeans;

import java.util.Collections;
import java.util.HashSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
@ManagedBean
@SessionScoped
@ServerEndpoint("/chatroomServerEndPoint")
public class ChatroomServerEndpoint {
	@ManagedProperty(value="#{identity}")
	 private Identity identity;
	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void handleOpen(Session userSession)
	{
		chatroomUsers.add(userSession);
	}
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException
	{

		String username= (String) userSession.getUserProperties().get("username");
		
		if(username==null)
		{
			userSession.getUserProperties().put("username",message);
			userSession.getBasicRemote().sendText(buildJsonData("System","You are now Connected as "+message));
		}
		else
		{
			Iterator<Session> iterator = chatroomUsers.iterator();
			while(iterator.hasNext()) iterator.next().getBasicRemote().sendText(buildJsonData(username,message));
		}
	}
	
		@OnClose
	public void handleClose(Session userSession)
	{
		chatroomUsers.remove(userSession);
	}
		private String buildJsonData(String username , String message)
		{
			JsonObject jsonObject=Json.createObjectBuilder().add("message",username+": "+message).build();
			StringWriter stringWriter=new StringWriter();
			try(JsonWriter jsonWriter = Json.createWriter(stringWriter))
			{
				jsonWriter.write(jsonObject);
			}
			return stringWriter.toString();
			
		}
		public void affiche()
		{
			System.out.println("********** "+identity.getUser().getLastName());
		}
		public Identity getIdentity() {
			return identity;
		}
		public void setIdentity(Identity identity) {
			this.identity = identity;
		}
		
}
