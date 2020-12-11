<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("loginok");
	session.removeAttribute("loginid");
	response.sendRedirect("../index.jsp");
	
%>