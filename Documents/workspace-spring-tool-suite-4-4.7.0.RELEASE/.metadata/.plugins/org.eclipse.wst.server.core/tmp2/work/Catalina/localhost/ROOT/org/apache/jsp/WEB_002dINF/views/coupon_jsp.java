/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-08-26 05:36:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class coupon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/gusql/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/woongs1/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1596332406682L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"EUC-KR\">\n");
      out.write("<title>관리자 쿠폰 발행 페이지</title>\n");
      out.write("</head>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.1.0.min.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(function() {\n");
      out.write("\t\tvar check = \"");
      out.print( request.getAttribute("isAvailable") );
      out.write("\";\n");
      out.write("\t\tif(check == null) {\n");
      out.write("\t\t\tconsole.log(\"");
      out.print( request.getAttribute("isAvailable") );
      out.write("\");\n");
      out.write("\t\t\tconsole.log(\"null 이다!\");\n");
      out.write("\t\t} else {\n");
      out.write("\t\t\tconsole.log(\"");
      out.print( request.getAttribute("isAvailable") );
      out.write("\");\n");
      out.write("\t\t\tif(check == \"success\") {\n");
      out.write("\t\t\t\talert(\"등록 성공\");\t\n");
      out.write("\t\t\t}else if(check == \"fail\"){\n");
      out.write("\t\t\t\talert(\"등록 오류\");\n");
      out.write("\t\t\t}else if(check == \"already\") {\n");
      out.write("\t\t\t\talert(\"이미 등록한 쿠폰입니다.\");\n");
      out.write("\t\t\t}else if(check == \"used\") {\n");
      out.write("\t\t\t\talert(\"이미 사용된 쿠폰입니다.\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype : \"post\",\n");
      out.write("\t\t\turl : \"couponView\",\n");
      out.write("\t\t\tdataType : \"json\"\n");
      out.write("\t\t}).done(\n");
      out.write("\t\t\t\tfunction(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수\n");
      out.write("\t\t\t\t\tif (args.length == 0) {\n");
      out.write("\t\t\t\t\t\t$(\"#coupon\").append(\"<div> 쿠폰이 없습니다.</div>\");\n");
      out.write("\n");
      out.write("\t\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t\tfor (var i = 0; i < args.length; i++) {\n");
      out.write("\t\t\t\t\t\t\t$(\"#coupon\").append(\n");
      out.write("\t\t\t\t\t\t\t\t\t\"<div>\" \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ args[i].coupon_name + \" \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ args[i].coupon_price + \" \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ args[i].coupon_validate_date + \" \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"</div>\");\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}).fail(function(e) {\n");
      out.write("\t\t\talert(e.responseText);\n");
      out.write("\t\t})\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("<body>\n");
      out.write("\t<form action=\"/couponEnroll\" method=\"Post\">\n");
      out.write("\t\t쿠폰 코드 : <input type=\"text\" name=\"coupon_code\"> \n");
      out.write("\t\t<input type=\"submit\" value=\"쿠폰등록\">\n");
      out.write("\t</form>\n");
      out.write("\n");
      out.write("\t에이젝스로 쿠폰 보여주는 페이지\n");
      out.write("\t<div>쿠폰이름 쿠폰가격 유효기간 </div>\n");
      out.write("\t<div id=\"coupon\"></div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
