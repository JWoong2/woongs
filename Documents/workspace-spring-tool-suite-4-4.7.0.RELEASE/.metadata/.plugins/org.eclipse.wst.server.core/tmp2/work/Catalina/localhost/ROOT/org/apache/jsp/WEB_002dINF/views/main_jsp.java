/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-08-27 07:05:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/gusql/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/woongs/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005fvar_005ftest_005fscope;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005fvar_005ftest_005fscope = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005fvar_005ftest_005fscope.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"EUC-KR\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"resources/js/common.js\"></script>\n");
      out.write("<style>\n");
      out.write(".post {\n");
      out.write("\twidth: 300px;\n");
      out.write("\theight: auto;\n");
      out.write("\tposition: relative;\n");
      out.write("\tdisplay: inline-block;\n");
      out.write("\tmargin-right: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".post img {\n");
      out.write("\twidth: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".wish {\n");
      out.write("\tposition: absolute;\n");
      out.write("\ttop: 25px;\n");
      out.write("\tright: 5px;\n");
      out.write("\twidth: 20px;\n");
      out.write("}\n");
      out.write(" table {\n");
      out.write("    width: 100%;\n");
      out.write("    border-top: 1px solid #444444;\n");
      out.write("    border-collapse: collapse;\n");
      out.write("  }\n");
      out.write("  th, td {\n");
      out.write("    border-bottom: 1px solid #444444;\n");
      out.write("    padding: 10px;\n");
      out.write("  }\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write('\n');
      out.write('	');
      out.write('	');
  System.out.println("main.jsp : " + session.getAttribute("admin"));  
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\n");
      out.write(" \t ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write('\n');
      out.write('	');

		String user_id = (String) session.getAttribute("user_id");
	
	if (user_id != null) {
	
      out.write('\n');
      out.write('	');
      out.write('"');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" 님 환영합니다\n");
      out.write("\t<a href=\"logout\" class=\"logout\">로그아웃</a>\n");
      out.write("\t<a href=\"signout\"> 회원탈퇴</a>\n");
      out.write("\t<a href=\"chatTest\">채팅 테스트</a>\n");
      out.write("\t<a href=\"chatRoom\">채팅목록</a>\n");
      out.write("\t");
} else {
      out.write("\n");
      out.write("\t<a href=\"register\">회원가입</a>\n");
      out.write("\t<a href=\"login\"> 로그인 </a>\n");
      out.write("\n");
      out.write("\t");

		}
	
      out.write("\n");
      out.write("\n");
      out.write("\t<a href=\"find\">비밀번호 찾기</a>\n");
      out.write("\t<a href=\"upload\"> 업로드 페이지</a>\n");
      out.write("\t<a href=\"callback\">콜백페이지</a>\n");
      out.write("\t<a href=\"myPage\"> 마이 페이지</a>\n");
      out.write("\t<a href=\"wishList\"> 찜한목록</a>\n");
      out.write("\t<a href=\"buylist\"> 구매페이지</a>\n");
      out.write("\t<br>\n");
      out.write("\t<a href=\"coupon\"> 쿠폰 발행 페이지 (관리자)</a> 사용자 아이디로 로그인했다면 쿠폰확인 페이지로 링크\n");
      out.write("\t<br>\n");
      out.write("\t<a href=\"coupon\"> 쿠폰 확인/등록 페이지 (사용자)</a>\n");
      out.write("\n");
      out.write("\t<img src=\"resources/Images/test.jpg\">\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.1.0.min.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<script>\n");
      out.write("\t\t$(function() {\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype : \"post\",\n");
      out.write("\t\t\t\turl : \"tag\",\n");
      out.write("\t\t\t\tdataType : \"json\"\n");
      out.write("\t\t\t}).done(\n");
      out.write("\t\t\t\t\tfunction(args) { //응답이 성공 상태 코드를 반환하면 호출되는 함수\n");
      out.write("\t\t\t\t\t\tfor (var i = 0; i < args.length; i++) {\n");
      out.write("\t\t\t\t\t\t\t$(\"#tag\").append(\n");
      out.write("\t\t\t\t\t\t\t\t\t\"<a href='category?no=\" + args[i].no + \"'>\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ args[i].name + \"</option>\");\n");
      out.write("\t\t\t\t\t\t\t$(\"#cate\").after(\n");
      out.write("\t\t\t\t\t\t\t\t\t\"<div id='\"+args[i].no+\"'>\" + args[i].name\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</div>\");\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t}).fail(function(e) {\n");
      out.write("\t\t\t\talert(e.responseText);\n");
      out.write("\t\t\t})\n");
      out.write("\t\t\tconsole.log(\"ajax 끝\");\n");
      out.write("\t\t\tafterAjax();\n");
      out.write("\t\t\t$(\".wish\").click(function() {\n");
      out.write("\t\t\t\tconsole.log(\"Dd\");\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t});//ready 끝\n");
      out.write("\n");
      out.write("\t\tfunction afterAjax() {\n");
      out.write("\t\t\tconsole.log(\"함수 호출\");\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\ttype : \"post\",\n");
      out.write("\t\t\t\t\t\turl : \"post\",\n");
      out.write("\t\t\t\t\t\tdataType : \"json\"\n");
      out.write("\t\t\t\t\t})\n");
      out.write("\t\t\t\t\t.done(\n");
      out.write("\t\t\t\t\t\t\tfunction(args) {\n");
      out.write("\t\t\t\t\t\t\t\tfor (var i = 0; i < args.length; i++) {\n");
      out.write("\t\t\t\t\t\t\t\t\tconsole.log(args[i].category_first);\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#\" + args[i].category_first)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.after(\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\"<div class='post' id='\"+args[i].no+\"'><a href='cart?post_no=\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ args[i].no\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"'>찜하기</a><img src=\"+args[i].thumbnail+\">\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ args[i].title + \" \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ args[i].user_id + \" \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ args[i].price+ \" \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t/* + args[i].eval+ \" \" */\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<a href='#none' id='heart\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ args[i].no\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"' class='wish off' onclick='changeHeart($(this).attr(\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ '\"'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ 'id'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ '\"'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"),$(this).attr(\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ '\"'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ 'class'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ '\"'\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"));'><img src='/resources/Images/emptyheart.png'></a><a href='/chatAsk?user_id=\"+args[i].user_id+\"&&no=\"+args[i].no+\"'>문의하기</a></div>\");\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\tfunction changeCheck(url, id) {\n");
      out.write("\t\t\tvar test = ");
      out.print(session.getAttribute("user_id") == null);
      out.write(";\n");
      out.write("\t\t\tif (test) {\n");
      out.write("\t\t\t\twindow.location.href = 'login';\n");
      out.write("\t\t\t} else {\n");
      out.write("\t\t\t\tvar params = \"post_no=\" + id * 1;\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\ttype : \"post\",\n");
      out.write("\t\t\t\t\turl : url,\n");
      out.write("\t\t\t\t\tdataType : \"text\",\n");
      out.write("\t\t\t\t\tdata : params\n");
      out.write("\t\t\t\t}).done(function(args) {\n");
      out.write("\t\t\t\t\tconsole.log(args);\n");
      out.write("\t\t\t\t}).fail(function(e) {\n");
      out.write("\t\t\t\t\talert(e.responseText);\n");
      out.write("\t\t\t\t})\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\tfunction changeHeart(id, className) {\n");
      out.write("\t\t\tif (className == \"wish off\") {\n");
      out.write("\t\t\t\tconsole.log(\"\")\n");
      out.write("\t\t\t\t$(\"#\" + id).attr(\"class\", \"wish on\");\n");
      out.write("\t\t\t\t$(\"#\" + id).children('img').attr('src',\n");
      out.write("\t\t\t\t\t\t'/resources/Images/heart.png');\n");
      out.write("\t\t\t\tchangeCheck(\"check\", id.replace(\"heart\", \"\") * 1);\n");
      out.write("\t\t\t} else {\n");
      out.write("\t\t\t\t$(\"#\" + id).attr(\"class\", \"wish off\");\n");
      out.write("\t\t\t\t$(\"#\" + id).children('img').attr('src',\n");
      out.write("\t\t\t\t\t\t'/resources/Images/emptyheart.png');\n");
      out.write("\t\t\t\tchangeCheck(\"check_cancel\", id.replace(\"heart\", \"\") * 1);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t<h2>카테고리 모음</h2>\n");
      out.write("\t<div id=\"tag\"></div>\n");
      out.write("\t<div id=\"cate\"></div>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005fvar_005ftest_005fscope.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/main.jsp(50,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      // /WEB-INF/views/main.jsp(50,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setVar("admin");
      // /WEB-INF/views/main.jsp(50,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setScope("session");
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t어드민이당\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005fvar_005ftest_005fscope.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/main.jsp(54,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id == admin }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("\t\t<a href=\"../index\">관리자</a>\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
