package com.mulesoft.training;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Callable;
import org.mule.api.lifecycle.Startable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MuleLifecycleComponent implements Callable, Startable {


    private static final Logger logger = LogManager.getLogger("com.mulesoft.training.Logger");
    
	@Override
	public void start() throws MuleException {
        logger.info("********************** Component initiated startup **********************");

	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {


        logger.info("********************** Component executed **********************");
		
		return eventContext.getMessage();
	}

}
