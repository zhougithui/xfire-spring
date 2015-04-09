package com.bjzh.ws.helloclient;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.client.Client;

public class HelloClient {
	
	public static void testClient2() throws MalformedURLException, Exception {
		Client client = new Client(new URL(
				"http://localhost:8080/ws/HelloWorldService.ws?wsdl"));
		Object[] results = client.invoke("sayHello", new Object[] { "周辉" });
		System.out.println(results[0]);
	}

	public static void main(String[] args) throws MalformedURLException,
			Exception {
		testClient2();
	}
}
