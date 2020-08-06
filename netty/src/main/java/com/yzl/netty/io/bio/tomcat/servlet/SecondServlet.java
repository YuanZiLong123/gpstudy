package com.yzl.netty.io.bio.tomcat.servlet;

import com.yzl.netty.io.bio.tomcat.http.GPRequest;
import com.yzl.netty.io.bio.tomcat.http.GPResponse;
import com.yzl.netty.io.bio.tomcat.http.GPServlet;

public class SecondServlet extends GPServlet {

	@Override
	public void doGet(GPRequest request, GPResponse response) throws Exception {
		this.doPost(request, response);
	}

	@Override
	public void doPost(GPRequest request, GPResponse response) throws Exception {
		response.write("This is Second Serlvet");
	}

}
