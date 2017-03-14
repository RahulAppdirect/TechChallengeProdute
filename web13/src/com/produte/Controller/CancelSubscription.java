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
import com.produte.Domain.ReturnData;
import com.produte.Domain.TableData;
import com.produte.Service.CancelSubsService;
import com.produte.Util.ExtractDomain;
import com.produte.Util.Signing;

/**
 * Servlet implementation class CancelSubscription
 */
@WebServlet("/CancelSubscription")
public class CancelSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelSubscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String iurl = request.getParameter("url");
		Parent p = new Signing().signUrl(iurl);
		
		TableData tb = new TableData();
		tb = new ExtractDomain().extractDomain(p);
		
		int i = new CancelSubsService().cancelSub(tb);
		ReturnData rd = new ReturnData();
		if(i==1)
		{
			rd.setSuccess(true);
			System.out.println("Subscription cancelled");
			//rd.setMessage(tb.getAccount().getAccountIdentifier());
		}
		else
		{
			rd.setSuccess(false);
			rd.setErrorCode("ACCOUNT_NOT_FOUND");
			rd.setMessage("Account Identifier doesn't exist in database");
			System.out.println("Subscription not cancelled");
		}
		
        response.setContentType("application/json");
		
		PrintWriter pw = null;
		
		ObjectMapper om = new ObjectMapper();
		pw = response.getWriter();
		String json = om.writeValueAsString(rd);
		
	    pw.println(json);
	}

}
