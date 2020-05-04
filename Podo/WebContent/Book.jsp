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
#img0{
	background-size: 100% 100%;
} 
</style>

</head>
<body>

	<%-- <img src="<d:url value="../../../../../../D/ttt/${1588033643597.jpg}"/>""/> --%>
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1.0"> -->

	<% int num = Integer.parseInt(request.getParameter("num"));
	   int bookpage = 0;   
	   int cnt = 9;
	   
	   if(num<0){
		   num = 0;
	   }else if(num > cnt){
		   num = cnt;
	   }
	   
	   String imgsrc = "./aa/" + num + ".jpg";
	%>
		
	
<!-- 	<img id="img0" src="./aaa/0.jpg"> -->
	<%= num %>
	<%= imgsrc %>
	<img id="img0" src= "<%= imgsrc %>">
	<audio controls autoplay>
		<source src="./music/goethe.wav" >
	</audio>
	
	
	
	
	
	
	<!-- <iframe src="../silence.mp3" allow="autoplay" id="audio" style="display:none"></iframe> -->
-  	<audio id="audio" controls autoplay>
		<source src="./music/goethe.wav" >
	</audio> 
	
<!-- 	<a id = 'ff'>ggh</a> -->
	
	


	<script type="text/javascript" src='js/jquery-3.4.1.min.js'></script>  
	<script type="text/javascript">
		//document.getElementById('jj').play();
/* 	
	$('#img0').on('click', function(){
		var audio = new Audio();
		audio.src = 'music/goethe.wav';
		audio.play();
		
		console.log('dd')
	}); */
	
	function onPageFinished() {
	       var audio = document.getElementById("audio");
	       audio.play();
	}
	
	
	</script>
</body>



</html>