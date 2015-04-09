package com.bjzh.ws.hello.impl;

import com.bjzh.ws.hello.IHello;

public class HelloImpl implements IHello {

	@Override
	public String sayHello(String name) {
		return "Hello :" + name;
	}

}
