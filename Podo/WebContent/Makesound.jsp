<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BookPrivacyDAO"%>
<%@page import="model.BookPrivacyDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<% String id = request.getParameter("id");
	String title = request.getParameter("title");
	String folder = request.getParameter("folder");
	System.out.println(folder);
	BookPrivacyDTO dto = new BookPrivacyDTO(id, title);
	BookPrivacyDAO dao = new BookPrivacyDAO();
	ArrayList<String> book = new ArrayList();
	
	System.out.print(id);
	System.out.print(title);
	
%> 

<script type="text/javascript" src='js/jquery-3.4.1.min.js'></script>


	<%
	
	BookPrivacyDTO testdto = new BookPrivacyDTO(id, title);
	book = dao.findbook(testdto);
	
  	
  	
  	String msg = "";
  	for(int i=1;i<book.size();i++){
  		msg += book.get(i);
  		
  		if(i<book.size()-1)
  			msg += "a";
  	}
  	
  	URL url = new URL("http://localhost:9000/re/"+URLEncoder.encode(msg,"utf-8")+"/"+folder);
    HttpURLConnection con = (HttpURLConnection)url.openConnection();
	con.setRequestProperty("User-Agent", "Mozilla/5.0");
	con.setRequestMethod("POST");
    int code = con.getResponseCode();
  
    %>
  
   <%-- <%
   		for(int i = 0; i < book.size(); i++){
   			System.out.println("값을 보여줘  : " +book.get(i));
   			%>
   		
   		<input class = "myValue" type="text" value="<%= book.get(i) %>">			
   	<%
   	}
   
   %> --%>
   
   
   
   
  	<%-- <script type="text/javascript">
  	
  	var bookkey = document.querySelectorAll('.myValue');

  	<% System.out.print("dkdkdkdkdkdk");%>
  	for(var i = 0; i < bookkey.length; i++){
  		var texts = bookkey[i].value;
  		<% System.out.print("aaaaaaaaaaaaa");%>

  		console.log(texts);
  		$.ajax({
  	        url: "http://localhost:9000/re/" + texts,
  	        method : "POST",
  	     	async: false,
  	        success: function(rs) {
  	           if(rs.result == null){ 
  	              console.log(rs)
  	              $('#result').text('null 입니다')
  	           }else{
  	              console.log(rs)
  	              $('#result').text(rs.result)
  	           }
  	        }, error:function(data){
  	            console.log(data); 
  	        }
  	   })
  	}

  	</script> --%>

</body>
</html>