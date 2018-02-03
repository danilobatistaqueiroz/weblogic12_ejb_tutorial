package com.labs;

import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Stateless(mappedName="HelloWorld")
public class HelloWorldBean implements HelloWorld {
    public String sayHello(String name) {
    	System.out.println("say hello " + name + " works!");
        return "Hello, "  + name;
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("iniciando o ejb");
    }
    
    @PrePassivate
    public void passivate() { System.out.println("@PrePassivate  ejb"); }
    @PostActivate
    public void activate() { System.out.println("@PostActivate  ejb"); }
    @PreDestroy
    public void shutdown() { System.out.println("@PreDestroy  ejb"); }
}

