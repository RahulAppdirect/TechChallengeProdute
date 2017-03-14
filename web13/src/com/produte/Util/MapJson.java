package com.produte.Util;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.produte.Bean.Parent;

public class MapJson {
	public Parent mapJson(String str)
	{
		ObjectMapper om = new ObjectMapper();
		Parent p = new Parent();
		try {
			p = om.readValue(str, Parent.class);
			//return p;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

}
