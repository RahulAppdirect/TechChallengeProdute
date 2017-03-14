package com.produte.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.produte.Bean.Parent;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class Signing {
	
public Parent signUrl(String iurl){
	OAuthConsumer consumer = new DefaultOAuthConsumer("produtedemotest2-154434", "hFTuPH86Tjfc843Q");
	//URL url = new URL("https://www.appdirect.com/api/events/dummyChange");
	
	URL url=null;
	
	try {
		url = new URL(iurl);
	} catch (MalformedURLException e1) {
		e1.printStackTrace();
	}
	
	HttpURLConnection requestRes = null;
	
	try {
		requestRes = (HttpURLConnection) url.openConnection();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
	requestRes.setRequestProperty("Accept", "application/json");
	
	try {
		consumer.sign(requestRes);
	} catch (OAuthMessageSignerException e) {
		e.printStackTrace();
	} catch (OAuthExpectationFailedException e) {
		e.printStackTrace();
	} catch (OAuthCommunicationException e) {
		e.printStackTrace();
	}
	
	try {
		requestRes.connect();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	String str = "";
	try{
	BufferedReader br = new BufferedReader(new InputStreamReader(requestRes.getInputStream()));
	
	//System.out.println(requestRes.getResponseMessage());
	String line = "";
	//String str = "";
	while((line = br.readLine())!=null)
	{
		System.out.println(line);
		str = str+line;
	}
	
	//return new MapJson().mapJson(str);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return new MapJson().mapJson(str);
}

}
