package com.alex.baseJava.junitDemo;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {
	
	private static Logger log = Logger.getLogger(TestLog4j.class.getClass());

	@Test
	public void testLog(){
		log.debug("debug");
		log.error("error");
	}
	}
