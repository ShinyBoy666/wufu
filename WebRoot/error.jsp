<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" %>
<%   
String key = (String) request.getAttribute("javax.servlet.forward.servlet_path");   
String reg = "^/pages/(\\d+)/";   
String rewriteUrl = key.replaceAll(reg,"/pages/");
if(key != null && !key.equals(rewriteUrl)){
	request.getRequestDispatcher(rewriteUrl).forward(request,response);
	out.clear();
	out = pageContext.pushBody();
}else{
	out.println(key);
	
}
%> 