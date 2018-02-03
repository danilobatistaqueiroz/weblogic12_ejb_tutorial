package com.labs;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.labs.HelloWorld;

public class HelloWorldClient {

	private static HelloWorld helloWorld;
	
	public  static void main(String[] args) {
		try {
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			env.put(Context.SECURITY_PRINCIPAL,"danilo");
			env.put(Context.SECURITY_CREDENTIALS,"WebLogicSA!01");
			env.put(Context.PROVIDER_URL,"t3://localhost:7001");
			Context ctx = new InitialContext(env);
			System.out.println("Initial Context created");
			helloWorld = (HelloWorld) ctx.lookup("HelloWorld#examples.stateless.HelloWorld");
			//helloWorld = (HelloWorld) ctx.lookup("HelloWorld#HelloWorldBean");
			System.out.println("lookup successful");
			System.out.println("Calling EJB method . . .");
			System.out.println(helloWorld.sayHello("Upog"));
			System.out.println("Output will be in Managed server console");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
