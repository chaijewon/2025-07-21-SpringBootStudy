<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JWT 로그인</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.container{margin-top:50px}
.row{width:350px;margin:0 auto;}
</style>

</head>
<body>
  <h2>JWT LOGIN</h2>

ID <input id="id"><br>
PW <input id="pw" type="password"><br>

<button onclick="login()">LOGIN</button>

<script>
async function login(){

 const p=new URLSearchParams();
 p.append("username",id.value);
 p.append("password",pw.value);

 const res=await fetch("/member/login",{
   method:"POST",
   body:p
 });

 const token=await res.text();

 localStorage.setItem("token",token);

 location.href="/member";
}
</script>
  

</body>
</html>