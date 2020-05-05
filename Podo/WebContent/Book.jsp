<%@page import="java.util.ArrayList"%>
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

	<%-- <% int num = Integer.parseInt(request.getParameter("num"));
	   int bookpage = 0;   
	   int cnt = 9;
	   
	   if(num<0){
		   num = 0;
	   }else if(num > cnt){
		   num = cnt;
	   }
	   
	   String imgsrc = "./aaa/" + num + ".jpg";
	%> --%>
		
	
<!-- 	<img id="img0" src="./aaa/0.jpg"> -->
	<%-- <%= num %>
	<%= imgsrc %>
	<img id="img0" src= "<%= imgsrc %>">  --%>
	
	<audio class='audio' controls >
		<source src = "./aaa/0.wav" >
	</audio> 
 	
 	<audio class='audio' controls autoplay >
		<source src = "./aaa/1.wav" >
	</audio> 
	

	
	<!-- <audio id='audio' controls autoplay>
		<source src = "./aaa/1.wav"  >
	</audio>  -->
	
	<%-- <% 
		int cnt = 9;
	    String src22;
		
	    for(int i = 1; i <= cnt; i++){
	    	src22 =  "./aaa/" + i + ".wav";%>
	    
	    	<audio id='audio' controls autoplay>
				<source src = "<%= src22 %>" >
	 		</audio> 
	     	
	  	<%}%>  --%>
	

<!-- 	 <audio id='audio' controls >
		<source src="./aaa/0.wav" >
	 </audio>  -->


	

	
	
	
	
	
	
	
	<!-- <iframe src="./music/goethe.wav" allow="autoplay" id="audio" style="display:none"></iframe> -->

	<!-- <iframe src="test.html" allow="autoplay"></iframe> -->
	


	<script type="text/javascript" src='js/jquery-3.4.1.min.js'></script>  
<!-- 	<script src="https://cdn.plyr.io/3.6.1/plyr.polyfilled.js"></script>
	<script src="https://cdn.plyr.io/3.6.1/plyr.js"></script> -->
	<script type="text/javascript">
		/* document.getElementById('jj').play(); */
/* 	
	$('#img0').on('click', function(){
		var audio = new Audio();
		audio.src = 'music/goethe.wav';
		audio.play();
		
		console.log('dd')
	}); */
	
/* 	function onPageFinished() {
	       var audio = document.getElementById("audio");
	       audio.play();
	} */
	/* window.onload = function(){
		var audio = document.getElementById("audio");
		alert(audio)
	    audio.play();

	} */
	/* $(document).ready(function(){
		var audio = document.getElementById("audio");
		alert(audio)
	    audio.play();
	}); */
	/* const beeSound = document.getElementById("bee-sound"); 
	const [body] = document.getElementsByTagName("body"); 
	function play() { 
		if (!beeSound instanceof HTMLAudioElement) return; 
		if (beeSound.paused) { beeSound.play(); } 
		else { body.removeEventListener("click", play); } 
		console.log(beeSound.paused); } 
	body.addEventListener("click", play); */
	/* const audio = document.getElementById("audio"); 
	window.onload = function(){
		if (audio.paused) { audio.play(); }
		
	} */
	/* const beeSound = document.getElementById("video"); 
	const [body] = document.getElementsByTagName("body"); 
	function play() { 
		if (!beeSound instanceof HTMLAudioElement) return; 
		if (beeSound.paused) { beeSound.play(); } 
		else { body.removeEventListener("click", play); } 
		console.log(beeSound.paused); } 
	body.addEventListener("click", play);
	window.onload = function(){
		body.click();
	} */
	// const player = new Plyr('#audio');
	
	
	
	
	window.onload = function(){
		var audio = document.getElementById('audio');
		audio.play();
	}
	
<%
	response.setHeader("Feature-Policy", "autoplay *");
%>
	</script>
</body>



</html>