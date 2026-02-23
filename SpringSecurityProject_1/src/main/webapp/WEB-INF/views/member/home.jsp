<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.container{margin-top:50px}
.row{width:350px;margin:0 auto;}
</style>

</head>

<body>

<div class="container">
 <div class="row">

<h3 class="text-center">HOME (JWT)</h3>

<table class="table">
<tbody id="menuArea">
</tbody>
</table>

 </div>
</div>

<script>

function parseJwt(token){
    try{
        return JSON.parse(
          atob(token.split('.')[1]));
    }catch(e){
        return null;
    }
}

function renderMenu(){

    const token=localStorage.getItem("token");

    const menu=document.getElementById("menuArea");

    // 로그인 안됨
    if(!token){
        menu.innerHTML='<tr>'
          +'<td class="text-center">'
          +'<a href="/member/login_form" class="btn btn-success">로그인</a>'
          +'</td>'
        +'</tr>';
        return;
    }

    const payload=parseJwt(token);

    let html=`
    <tr>
      <td class="text-center">
        로그인 사용자 : ${payload.sub}
      </td>
    </tr>
    `;

    // USER
    html+=`
    <tr>
      <td class="text-center">
        <a href="/member/user"
         class="btn btn-info">
         사용자 페이지
        </a>
      </td>
    </tr>
    `;

    // ADMIN
    if(payload.role.includes("ADMIN")){
        html+=`
        <tr>
          <td class="text-center">
            <a href="/member/admin"
             class="btn btn-primary">
             관리자 페이지
            </a>
          </td>
        </tr>
        `;
    }

    html+=`
    <tr>
      <td class="text-center">
        <button onclick="logout()">
         로그아웃
        </button>
      </td>
    </tr>
    `;

    menu.innerHTML=html;
}

function logout(){
    localStorage.removeItem("token");
    location.reload();
}

renderMenu();

</script>

</body>
</html>