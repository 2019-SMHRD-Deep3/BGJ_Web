<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.FilenameFilter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#img0 { /* 반응형 웹 -> 이미지 조절 법 */
	width: 100%;
	height: auto !important;
}

#img0 {
	background-size: 100% 100%;
}
</style>

<script type="text/javascript">
	var audio = new Audio();
	audio.src = "./aaa/0.wav";
</script>
<style>
#img0 { /* 반응형 웹 -> 이미지 조절 법 */
	width: 100%;
	height: auto !important;
}

#img0 {
	background-size: 100% 100%;
}
</style>

</head>
<body>

	<%
		String id = request.getParameter("id");
		int num = Integer.parseInt(request.getParameter("num"));
		String where = request.getParameter("where");
		int page1 = Integer.parseInt(request.getParameter("page"));
		//String id = "aaa";
		String path = null;
		String src = null;
		
		if(where.equals("book")){
			path = "C://Users//SM025//git//BGJ_Web//Podo//WebContent//" + id +"//" + id + "_" + num;
			src = "./" + id + "/" + id + "_" + num + "/";
		
		}else if(where.equals("library")){
			path = "C://Users//SM025//git//BGJ_Web//Podo//WebContent//" + where + "//l" + num;
			src = "./" + where + "/l" + num + "/";
		}



		System.out.println("id : " + id);
		System.out.println("num : " + num);
		System.out.println("where : " + where);
		System.out.println("page1 : " + page1);
		
		System.out.println("path : " + path);
		System.out.println("audioSrc : " + src);
		
		
		File dir = new File(path);
		File[] files = dir.listFiles();
		String fileList[] = dir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir1, String name) {
				return name.endsWith("jpg");
			}

		});

		int cnt = fileList.length;
		System.out.println("파일의 개수 : " + cnt);
	%>

	<audio id='audio' controls>
		<source src= <%= src+"1.m4a" %>> 
		
	</audio>

	<img id="img0" src= <%= src+"1.jpg" %>>

	<!-- <audio class='audio2' controls autoplay >
		<source src = "./aaa/1.wav" >
	</audio>  -->


	<!-- 	<input type = "button" onclick="audio.ended();" value="play"> -->






	<script type="text/javascript" src='js/jquery-3.4.1.min.js'></script>

	<script type="text/javascript">
		var audio = document.getElementById('audio');
		var img = document.getElementById('img0');
		var i = 0;
		
		//var width = img.naturalWidth;
		//var height = img.naturalHeight;
		
		
		//myFunction();
		<% System.out.println("cnt 값 : " + cnt);%>
		
	
		
		audio.addEventListener("ended", function() {
			i = i + 1 + <%= num%>;
			if (i < <%= cnt %>) {
				myFunction();
			} 
		});
		
		img.onload = function(){
		
			audio.play();
			
		};

		
		
		function myFunction() {
			

			var imgSrc1 = '<%= src %>' + i + '.jpg' ;
			var audioSrc1 = '<%= src %>' + i + '.m4a' ;
			img.setAttribute('src', imgSrc1);
			if(img.naturalWidth > img.naturalHeight){
				//img.setAttributeotate(90deg)ransform:rotate(90deg);");
				img.style.transform = "rotate(90deg)"
			}
			audio.setAttribute('src', audioSrc1);
			
			console.log("img: " + imgSrc1);
			console.log("width: " + img.naturalWidth);
			console.log("height :  " + img.naturalHeight);

		}
	</script>


	<%-- <%
	response.setHeader("Feature-Policy", "autoplay *");
%>  --%>



</body>



</html>