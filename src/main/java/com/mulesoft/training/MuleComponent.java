package com.mulesoft.training;

import java.util.*;
import org.mule.api.annotations.param.*;

public class MuleComponent {
	
	int count;
	
	public MuleComponent() {
		count = 1;
	}

	public Map<String, String> processMap(Map<String, String> input) {
		input.put("processedBy", "processMap");
		return input;
	}

	public Map<String, String> processArray(List<String> input) {
		Map<String, String> output = new HashMap<String,String>();
		
		output.put("message", input.get(0));
		output.put("processedBy", "processArray");
		
		return output;
	}

	public Map<String, String> processString(String input) {
		Map<String, String> output = new HashMap<String,String>();
		
		output.put("message", input);
		output.put("processedBy", "processString");
		
		return output;
	}
	
	/*
	 * This will be invoked in favour of the above (this is annotation)
	 */
	  public Map<String,String> processAll(
			  @Payload Object input
			  , @InboundHeaders("http.method") String method) 
	  {
	      Map<String,String> output = new HashMap<String,String>();
	      output.put("message", input.toString());
	      output.put("HTTP method", method);
	      output.put("processedBy", "processAll");
	      output.put("counter", Integer.toString(count));
	      
	      count++;
	      
	      return output;
	  }
	

}
