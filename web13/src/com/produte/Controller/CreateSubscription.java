package com.produte.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.produte.Bean.Parent;
import com.produte.Domain.TableData;
import com.produte.Domain.ReturnData;
import com.produte.Service.CheckAccountIdService;
import com.produte.Service.CreateTableService;
import com.produte.Util.ExtractDomain;
import com.produte.Util.Signing;



/**
 * Servlet implementation class CreateSubscription
 */
@WebServlet("/CreateSubscription")
public class CreateSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSubscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iurl = request.getParameter("url");
		Parent p = new Signing().signUrl(iurl);
		
		/* Uncomment this code if you want to create table automatically in database TechChallenge
		 * new CreateTableService().createTables();
		 */
		
		TableData tb = new TableData();
		tb = new ExtractDomain().extractDomain(p);
		
		
		int i = new CheckAccountIdService().checkAccountIdService(tb);
		ReturnData rd = new ReturnData();
		if(i==0)
		{
			rd.setSuccess(true);
			rd.setAccountIdentifier(tb.getAccount().getAccountIdentifier());
			System.out.println("Data inserted in database. User Successfully Subscribed");
		}
		else
		{
			rd.setSuccess(false);
			rd.setErrorCode("USER_ALREADY_EXISTS");
			rd.setMessage("Account Identifier already exists in database");
			System.out.println("Account Identifier already exists in database");
			
		}
		
		response.setContentType("application/json");
		
		PrintWriter pw = null;
		
		ObjectMapper om = new ObjectMapper();
		pw = response.getWriter();
		String json = om.writeValueAsString(rd);
		
	    pw.println(json);
	}

}
