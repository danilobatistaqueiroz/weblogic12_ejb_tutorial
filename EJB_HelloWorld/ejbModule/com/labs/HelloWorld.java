package com.labs;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
    public String sayHello(String name);
}

