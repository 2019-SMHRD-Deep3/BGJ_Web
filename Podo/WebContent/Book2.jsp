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
#img0{
	background-size: 100% 100%;
} 

</style>

</head>
<body>
	

	<audio id='audio'  controls>
		<source src="./aaa/0.wav">
	</audio>

    <img id="img0" src="./aaa/0.jpg">

	<!-- <audio class='audio2' controls autoplay >
		<source src = "./aaa/1.wav" >
	</audio>  -->


<!-- 	<input type = "button" onclick="audio.ended();" value="play"> -->






	<script type="text/javascript" src='js/jquery-3.4.1.min.js'></script>
	<!-- 	<script src="https://cdn.plyr.io/3.6.1/plyr.polyfilled.js"></script>
	<script src="https://cdn.plyr.io/3.6.1/plyr.js"></script> -->
	<script>
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

 	
/* 	window.onload = function(){
		var audio = document.getElementById('audio');
		audio.play();
	} */
	
	
	
	
/* 	var audio = new Audio();
	audio.src = "./aaa/0.wav";
	audio.play();
	alert(audio.ended());
	*/
/* 	$('#img0').on('click', function(){
		var audio = new Audio();
		audio.src = './aaa/0.wav';
		audio.play();
	}); */

	
	
		var audio = document.getElementById('audio');
		var img = document.getElementById('img0');
		var cnt = 5;
		var i = 0;
		
		
		
			
			//myFunction();
			audio.addEventListener("ended", function(){			
				
				i +=1;
				myFunction();
		    });
		
			
		
		
		function myFunction(){
			
		
		    audio.setAttribute('src', './aaa/' + i + '.wav');
			img.setAttribute('src', './aaa/' + i + '.jpg'); 
			audio.play();
			console.log(i);
			
		}
			
		
		
	

	
<%-- <%
	response.setHeader("Feature-Policy", "autoplay *");
%>  --%>
	</script>

</body>



</html>