package ravi.web;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


import com.produte.Bean.Marketplace;
import com.produte.Bean.Parent;


import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import ravi.model.ReturnData;

/**
 * Servlet implementation class ServTest
 */
@WebServlet("/ServTest")
public class ServTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String iurl = request.getParameter("url");
		ReturnData rd = new ReturnData();
		
		rd.setAcctID(123L);
		rd.setSuccess(true);
		
		response.setContentType("application/json");
		
		PrintWriter pw = null;
		
		ObjectMapper om = new ObjectMapper();
		pw = response.getWriter();
		String json = om.writeValueAsString(rd);
		
	pw.println(json);
		//System.out.println(iurl);
		
		OAuthConsumer consumer = new DefaultOAuthConsumer("produtedemotest-152795", "SaCLpT7NqVi8eRhB");
		//URL url = new URL("https://www.appdirect.com/api/events/dummyChange");
		
		URL url = new URL(iurl);
		HttpURLConnection requestRes = (HttpURLConnection) url.openConnection();
		requestRes.setRequestProperty("Accept", "application/json");
		
		try {
			consumer.sign(requestRes);
		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestRes.connect();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(requestRes.getInputStream()));
		
		System.out.println(requestRes.getResponseMessage());
		String line = "";
		String str = "";
		while((line = br.readLine())!=null)
		{
			System.out.println(line);
			str = str+line;
		}
		
		
		Parent p = om.readValue(str, Parent.class);
		Marketplace mp = p.getMarketplace();
		System.out.println(mp.getPartner());
		//System.out.println(p.getCreator().getAddress().getZip());
		
		/*FileWriter writer = new FileWriter("/Users/produte.roy/Desktop/MyFile.txt", true);
		writer.write(str);
		
		writer.close();
		System.out.println("Start1");
		FileInputStream fis = new FileInputStream("/Users/produte.roy/Desktop/MyFile.txt");
		JsonReader jsonReader = Json.createReader(fis);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		fis.close();
		System.out.println("Start");
		System.out.println(jsonObject.getString("type"));
		System.out.println("End");
		
		
		
		JsonNode js = om.readTree(str);
		Iterator<String> t = js.getFieldNames();
		
		ArrayList<JsonNode> aj = new ArrayList();
		
		while(t.hasNext())
		{
			//System.out.println(js.findValue(t.next()));
			aj.add(js.findValue(t.next()));
		}
		
		String type = js.findValue("type").getTextValue();
		
		switch(type)
		{
		case "SUBSCRIPTION_ORDER":
			new CreateSubscription().display();
			break;
			
		case "SUBSCRIPTION_CHANGE":
			new ChangeSubscription().display();
			break;
			
		case "SUBSCRIPTION_CANCEL":
			new CancelSubscription().display();
			break;
			
		case "SUBSCRIPTION_STATUS":
			new StatusSubscription().display();
			break;
			
			default:
				System.out.println("no match");
		}

		System.out.println("************"+js.findValue("type").getTextValue());
		
		for(int i = 0;i<aj.size();i++)
		{
			System.out.println(aj.get(i));
		}
		
		System.out.println("hi");
		
		Parent parent = om.readValue(str, Parent.class);
		
	    System.out.println(om.writeValueAsString(parent));
		
		/*Parent p = new Parent();
		System.out.println(p.getType());
		
		System.out.println("hello");*/
	    
	    /*JsonParser parser = (JsonParser) Json.createParser(new StringReader(str));
	    while (((javax.json.stream.JsonParser) parser).hasNext()) {
	       parser.Event event = ((javax.json.stream.JsonParser) parser).next();
	       switch(event) {
	          case START_ARRAY:
	          case END_ARRAY:
	          case START_OBJECT:
	          case END_OBJECT:
	          case VALUE_FALSE:
	          case VALUE_NULL:
	          case VALUE_TRUE:
	             System.out.println(event.toString());
	             break;
	          case KEY_NAME:
	             System.out.print(event.toString() + " " +
	                              parser.getString() + " - ");
	             break;
	          case VALUE_STRING:
	          case VALUE_NUMBER:
	             System.out.println(event.toString() + " " +
	                                parser.getString());
	             break;
	       }
		
	}*/

}}
