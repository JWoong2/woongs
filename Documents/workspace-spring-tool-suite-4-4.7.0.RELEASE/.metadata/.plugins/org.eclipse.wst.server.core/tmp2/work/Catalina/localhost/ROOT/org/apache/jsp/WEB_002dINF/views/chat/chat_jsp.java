/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-08-26 07:17:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/Users/gusql/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/woongs1/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1596332406682L));
    _jspx_dependants.put("jar:file:/C:/Users/gusql/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/woongs1/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/gusql/Documents/workspace-spring-tool-suite-4-4.7.0.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/woongs1/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"resources/css/bootstrap-grid.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"resources/css/bootstrap-reboot.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"resources/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"resources/css/bootstrap.min.css\">\n");
      out.write("<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/page.css\"> -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/style.css\"> -->\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/sockjs.min.js\"></script>\n");
      out.write("<style>\n");
      out.write("\t.my{width: auto; float: right; clear: both;}\n");
      out.write("\t.my_chat{background-color:#a5cfcf; padding : 10px 5px; float:left; border-radius:10px;}\n");
      out.write("\t.your{background-color: #ACF3FF; padding: 10px 50px 10px 20px; border-radius: 10px; width: auto; display: inline-block; min-width: 130px;}\n");
      out.write("\t.time{font-size:9px; text-align:right; float:right; position:absolute; bottom: -18px; right: -10px;}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      boolean _jspx_th_c_005fset_005f0_reused = false;
      try {
        _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fset_005f0.setParent(null);
        // /WEB-INF/views/chat/chat.jsp(28,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fset_005f0.setVar("profile");
        // /WEB-INF/views/chat/chat.jsp(28,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
        _jspx_th_c_005fset_005f0.setValue(session.getAttribute("login"));
        int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
        if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        _jspx_th_c_005fset_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
      }
      out.write("\n");
      out.write(" \t<div class=\"col-12 row justify-content-center align-items-center my-5 \">\n");
      out.write("\t\t<a href=\"\"><img src=\"resources/Temp_ung_Logo.PNG\"\n");
      out.write("\t\t\talt=\"Ung Logo\" width=\"180px\" class=\"img-fluid\" /></a>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"col-12\">\n");
      out.write("\t\t<div class=\"col-2\" style=\"float: left\">\n");
      out.write("\t\t\t<span> 목록 </span>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-8\" style=\"float: left; text-align: center;\">\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${partnerInfo.nick_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 님과 대화</div>\n");
      out.write("\t\t<div class=\"col-2\" style=\"float: right\">\n");
      out.write("\t\t\t<span> 닫기 </span>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"col-12\" style=\"margin-top: 40px; clear: both;\">\n");
      out.write("\t\t<div class=\"col-10\" style=\"margin: 20px auto; text-align: center; color: white; background-color: #01D1FE; border: 1px solid #01D1FE; padding: 10px 10px; border-radius: 8px;\">\n");
      out.write("\t\t\t일정과 작업내용에 대해 문의해보세요. <br>(연락처 문의 또는 직접 계좌를 알려주는 것은 불가)\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- 채팅 내용 -->\n");
      out.write("\t<div class=\"col-12\">\n");
      out.write("\t\t<div class=\"col-11\"\n");
      out.write("\t\t\tstyle=\"margin: 0 auto; border: 1px solid #01D1FE; height: 400px; border-radius: 10px; overflow:scroll\" id = \"chatArea\">\n");
      out.write("\t\t\t<div id=\"chatMessageArea\" style = \"margin-top : 10px; margin-left:10px;\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- 채팅 입력창 -->\n");
      out.write("\t<div class=\"col-12\" style=\"margin-top: 20px; margin-bottom: 15px;\">\n");
      out.write("\t\t<div class=\"col-12\" style=\"float: left\">\n");
      out.write("\t\t\t<textarea class=\"form-control\" style=\"border: 1px solid #01D1FE; height: 65px; float: left; width: 80%\" placeholder=\"Enter ...\" id = \"message\"> </textarea>\n");
      out.write("\t\t\t<span style=\"float: right; width: 18%; height: 65px; text-align: center; background-color: #01D1FE; border-radius: 5px;\">\n");
      out.write("\t\t\t\t<a style=\"margin-top: 30px; text-align: center; color: white; font-weight: bold;\" id = \"sendBtn\"><br>전송</a>\n");
      out.write("\t\t\t</span>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("<img id=\"profileImg\" class=\"img-fluid\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${partnerInfo.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" \" style = \"display:none\">\n");
      out.write("<input type=\"text\" id=\"nickname\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${partnerInfo.nick_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" style = \"display:none\">\n");
      out.write(" <input type=\"button\" id=\"enterBtn\" value=\"입장\" style = \"display:none\">\n");
      out.write(" <input type=\"button\" id=\"exitBtn\" value=\"나가기\" style = \"display:none\">\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write(" connect();\n");
      out.write(" function connect() {\n");
      out.write("\t    sock = new SockJS('/chat');\n");
      out.write("\n");
      out.write("\t    sock.onopen = function() {\n");
      out.write("\t        console.log('Info : connection opened.');\n");
      out.write("\t        var params = {\n");
      out.write("\t    \t        chatroom_id : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roomInfo.chatroom_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(",\n");
      out.write("\t    \t        user_id : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile.user_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("',\n");
      out.write("\t    \t        \n");
      out.write("\t        }\n");
      out.write("\t        \n");
      out.write("\t        $.ajax({\n");
      out.write("\t    \t\ttype:\"post\"\n");
      out.write("\t    \t\t,url:\"chatPreviousContent\"\t\n");
      out.write("\t    \t\t,data:params\n");
      out.write("\t    \t\t,dataType:\"json\" })\n");
      out.write("\t    \t\t.done(function(args){\t//응답이 성공 상태 코드를 반환하면 호출되는 함수\n");
      out.write("\t\t    \t\tfor(var i=0; i<args.length; i++) {\n");
      out.write("\t\t    \t\t\tappendMessage(args[i]);\t\n");
      out.write("\t\t\t    \t\t}\n");
      out.write("\t    \t\t\t\t})\n");
      out.write("\t        \t.fail(function(e) {\n");
      out.write("\t    \t    \talert(e.responseText);\n");
      out.write("\t        })\n");
      out.write("\t    };\n");
      out.write("\t    \n");
      out.write("\t    sock.onmessage = function(evt) {\n");
      out.write("\t\t    console.log(\"메세지 받음!\");\n");
      out.write("    \t \tvar data = evt.data;\n");
      out.write("    \t   console.log(data)\n");
      out.write("  \t\t   var obj = JSON.parse(data)  \t   \n");
      out.write("    \t   console.log(obj)\n");
      out.write("    \t   appendMessage(obj);\n");
      out.write("\t    };\n");
      out.write("\t    \n");
      out.write("\t    sock.onclose = function() {\n");
      out.write("\t        console.log('Info : connection closed.');\n");
      out.write("\t    };\n");
      out.write("\t}\n");
      out.write("\n");
      out.write(" function send() {\n");
      out.write("  var msg = $(\"#message\").val();\n");
      out.write("  if(msg != \"\"){\n");
      out.write("\t  message = {};\n");
      out.write("\t  message.message_content = $(\"#message\").val()\n");
      out.write("  \t  message.worker_id = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile.worker_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("  \t  message.client_id = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile.client_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("  \t  message.post_no = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile.post_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("  \t  message.message_sender = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile.user_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  sock.send(JSON.stringify(message));\n");
      out.write("  $(\"#message\").val(\"\");\n");
      out.write(" }\n");
      out.write("\n");
      out.write(" function getTimeStamp() {\n");
      out.write("   var d = new Date();\n");
      out.write("   var s =\n");
      out.write("     leadingZeros(d.getFullYear(), 4) + '-' +\n");
      out.write("     leadingZeros(d.getMonth() + 1, 2) + '-' +\n");
      out.write("     leadingZeros(d.getDate(), 2) + ' ' +\n");
      out.write("\n");
      out.write("     leadingZeros(d.getHours(), 2) + ':' +\n");
      out.write("     leadingZeros(d.getMinutes(), 2) + ':' +\n");
      out.write("     leadingZeros(d.getSeconds(), 2);\n");
      out.write("\n");
      out.write("   return s;\n");
      out.write(" }\n");
      out.write("\n");
      out.write(" function leadingZeros(n, digits) {\n");
      out.write("   var zero = '';\n");
      out.write("   n = n.toString();\n");
      out.write("\n");
      out.write("   if (n.length < digits) {\n");
      out.write("     for (i = 0; i < digits - n.length; i++)\n");
      out.write("       zero += '0';\n");
      out.write("   }\n");
      out.write("   return zero + n;\n");
      out.write(" }\n");
      out.write("\n");
      out.write(" function appendMessage(obj) {\n");
      out.write("\t if(obj.message_content== \"\"){\n");
      out.write("\t\t return false;\n");
      out.write("\t }else{\n");
      out.write("// 만약에 자기가 보낸거면 오른쪽\n");
      out.write("// 다른 사람이 보낸거면 왼쪽으로 붙이고 색상 다르게\n");
      out.write("\t\t if(obj.message_sender == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${profile.user_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\") {\n");
      out.write("\t\t\t var t = getTimeStamp();\n");
      out.write("\t\t\t $(\"#chatMessageArea\").append(\"<div class='col-12 row my' style = 'height : auto; margin-top : 5px;'><div class='col-2' style = 'float:left; padding-right:0px; padding-left : 0px;'></div><div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:right;'><div class = 'col-12 my_chat'><span style = 'font-size : 12px;'>\"+obj.message_content+\"</span></div><div col-12 style = 'font-size:9px; text-align:right; float:right;'><span style ='float:right; font-size:9px; text-align:right;' >\"+t+\"</span></div></div></div>\")\t\t \n");
      out.write("\n");
      out.write("\t\t\t  var chatAreaHeight = $(\"#chatArea\").height();\n");
      out.write("\t\t\t  var maxScroll = $(\"#chatMessageArea\").height() - chatAreaHeight;\n");
      out.write("\t\t\t  $(\"#chatArea\").scrollTop(maxScroll);\n");
      out.write("\t\t\t  \n");
      out.write("\t\t}else if(obj.message_sender == \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${partnerInfo.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\t){\n");
      out.write("\t\t\t var t = getTimeStamp();\n");
      out.write("\t\t\t $(\"#chatMessageArea\").append(\"<div class='col-12 row' style = 'height : auto; margin-top : 5px;'><div class='col-2' style = 'float:left; padding-right:0px; padding-left : 0px;'><img id='profileImg' class='img-fluid' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${partnerInfo.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("' style = 'width:50px; height:50px; '><div style='font-size:9px; clear:both;'>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${partnerInfo.nick_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div></div><div class = 'col-10' style = 'overflow : y ; margin-top : 7px; float:right;'><div class = 'col-12 your'><div class='col-12 time'><span style ='float:right; font-size:9px; text-align:right;' >\"+t+\"</span></div><span style = 'font-size : 12px;'>\"+obj.message_content+\"</span></div></div></div>\")\t\t \n");
      out.write("\n");
      out.write("\t\t\t  var chatAreaHeight = $(\"#chatArea\").height();\n");
      out.write("\t\t\t  var maxScroll = $(\"#chatMessageArea\").height() - chatAreaHeight;\n");
      out.write("\t\t\t  $(\"#chatArea\").scrollTop(maxScroll);\n");
      out.write("\t\t}\n");
      out.write("\t }\n");
      out.write(" }\n");
      out.write(" \n");
      out.write(" $(document).ready(function() {\n");
      out.write("  $('#message').keypress(function(event){\n");
      out.write("   var keycode = (event.keyCode ? event.keyCode : event.which);\n");
      out.write("   if(keycode == '13'){\n");
      out.write("    send();\n");
      out.write("   }\n");
      out.write("   event.stopPropagation();\n");
      out.write("  });\n");
      out.write("\n");
      out.write("  $('#sendBtn').click(function() { send(); });/* $('#enterBtn').click(function() { connect(); }); $('#exitBtn').click(function() { disconnect(); }); */\n");
      out.write(" });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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