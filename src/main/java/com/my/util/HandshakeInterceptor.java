package com.my.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.my.security.SecurityUserDetail;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		// ���� �Ķ���� ��, attributes �� ���� �����ϸ� ������ �ڵ鷯 Ŭ������ WebSocketSession�� ���޵ȴ�
		System.out.println("Before Handshake");

		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
		System.out.println("URI:" + request.getURI());

		HttpServletRequest req = ssreq.getServletRequest();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SecurityUserDetail userDetails = (SecurityUserDetail) principal;

		/*
		 * String userId = req.getParameter("userid");
		 * System.out.println("param, id:"+userId); attributes.put("userId", userId);
		 */

		// HttpSession �� ����� �̿����� ���̵� �����ϴ� ���
//		String id = (String) req.getSession().getAttribute("id");
//		attributes.put("userId", id);
		System.out.println("HttpSession�� ����� " + userDetails);
		attributes.put("userNickName", userDetails.getNickname());

		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		System.out.println("After Handshake");

		super.afterHandshake(request, response, wsHandler, ex);
	}

}
