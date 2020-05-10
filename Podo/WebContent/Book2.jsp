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

<!-- <script type="text/javascript">
	var audio = new Audio();
	audio.src = "./aaa/0.wav";
</script> -->
<style>
#img0 { /* 반응형 웹 -> 이미지 조절 법 */
	width: 100%;
	height: auto !important;
}

#img0 {
	background-size: 100% 100%;
}

#img1 {
	width: 150px;
	height: 150px;
	z-index: 1;
}
</style>

</head>
<body>

	<%
		String id = request.getParameter("id");
		int num = Integer.parseInt(request.getParameter("num"));
		String where = request.getParameter("where");
		int a=1;
		File file ;
		
		String path = null;
		String src = null; 
		
		if(where.equals("book")){
			path = "C://Users//SM015//git//BGJ_Web//Podo//WebContent//" + id +"//" + id + "_" + num;
			src = "./" + id + "/" + id + "_" + num + "/";
		
		}else if(where.equals("library")){
			path = "C://Users//SM015//git//BGJ_Web//Podo//WebContent//" + where + "//l" + num;
			src = "./" + where + "/l" + num + "/";
		} 		

		/* String id = "aaa";
		int num = 0;
		String where = "book";
		int a=1;
		File file ;
		
		

		String path = "C:\\Users\\SM015\\git\\BGJ_Web\\Podo\\WebContent\\" + id + "\\" + id + "_" + num;
		String src = "./" + id + "/" + id + "_" + num + "/"; 
  */
		System.out.println("id : " + id);
		System.out.println("num : " + num);
		System.out.println("where : " + where);

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
		
		String[] audioList = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir1, String name) {
				return name.endsWith("wav");
			}

		});

		for(int i = 0; i < audioList.length; i++){
			file = new File( path + "//" + audioList[i]);
			System.out.println("dkdkdkdkdkkdk : " + path + "//" +  audioList[i]);
			file.renameTo(new File(path + "//" + (i+1) + ".wav"));
			
		}
		
		int cnt = fileList.length;
		System.out.println("파일의 개수 : " + cnt);
		
	%>

	<audio id='audio'>
	
		<source src=<%=src + "1.wav"%>>

	</audio>
<%-- 
	<img id="img0" src=<%=src + "1.jpg"%>>
	<img id="img1" src="img2/play.png">
 --%>



		<div style="position: absolute;">
			<img id="img0" src=<%=src + "1.jpg"%>>
		</div>

		<div style="position: absolute;">
			<img id="img1" src="img2/play.png" style="position: relative; top: 200px; left: 100px;">
		</div>






	<script type="text/javascript" src='js/jquery-3.4.1.min.js'></script>

	<script type="text/javascript">
		var audio = document.getElementById('audio');
		var img = document.getElementById('img0');
		var img1 = document.getElementById('img1');
		var i = 1;
		
		//var width = img.naturalWidth;
		//var height = img.naturalHeight;
		
		
		//myFunction();
		<%System.out.println("cnt 값 : " + cnt);%>
		
		$('#img1').click(function(){
			audio.play();
			$('#img1').css("display", "none");
		});
		
	
		
		audio.addEventListener("ended", function() {
			<%-- i = i + 1 + <%= page1 %>;  --%>
			i += 1;
			
			if (i < <%=cnt%>) {
				<%-- var aaaa = '<%= audioList[a]%>';
				console.log("aaaa : " + aaaa );
				console.log("aa1 : " + <%=a %>);
				var b = <%=a %>;
				<%= a%> = b + i;
				console.log("aa2 : " + <%=a %>); --%>
				myFunction();
			} 
		});
		
		img.onload = function(){
			/*  if(img.naturalWidth == 4032){
					img.style.transform = "rotate(90deg)"
				}else {
					img.style.transform = "rotate(0deg)"
				} */
			audio.play();
			
		};

		
		
		function myFunction() {
			

			var imgSrc1 = '<%= src %>' + i + '.jpg' ;
			var audioSrc1 = '<%=src%>' + i + '.wav' ;
			<%-- var audioSrc1 = '<%= src %>' +  aaaa ;  --%>
			
			console.log("audioSrc: " + audioSrc1);
			img.setAttribute('src', imgSrc1);
			audio.setAttribute('src', audioSrc1);
			
			console.log("img: " + imgSrc1);
			console.log("width: " + img.naturalWidth);
			console.log("height :  " + img.naturalHeight);

		};
	</script>


	<%-- <%
	response.setHeader("Feature-Policy", "autoplay *");
%>  --%>



</body>



</html>