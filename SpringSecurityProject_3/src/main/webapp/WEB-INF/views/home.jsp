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
.container { margin-top:50px }
.row { width:350px; margin:0 auto }
</style>
</head>
<body>

<div class="container">
  <div class="row">
    <h3 class="text-center">HOME</h3>

    <table class="table">
      <tbody>

        <!-- 로그인 사용자 -->
        <tr id="login-user" style="display:none">
          <td class="text-center">
            로그인 사용자 :
            <strong id="username"></strong>
          </td>
        </tr>

        <!-- ADMIN -->
        <tr id="admin-menu" style="display:none">
          <td class="text-center">
            <a href="/admin" class="btn btn-sm btn-primary">
              관리자 페이지
            </a>
          </td>
        </tr>

        <!-- USER -->
        <tr id="user-menu" style="display:none">
          <td class="text-center">
            <a href="/user" class="btn btn-sm btn-info">
              사용자 페이지
            </a>
          </td>
        </tr>

        <!-- 로그아웃 -->
        <tr id="logout-menu" style="display:none">
          <td class="text-center">
            <button onclick="logout()" class="btn btn-default">
              로그아웃
            </button>
          </td>
        </tr>

        <!-- 비로그인 -->
        <tr id="login-menu">
          <td class="text-center">
            <a href="/login" class="btn btn-sm btn-success">
              로그인
            </a>
          </td>
        </tr>

      </tbody>
    </table>
  </div>
</div>

<script>
function parseJwt(token) {
  const base64Url = token.split('.')[1];
  const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  return JSON.parse(atob(base64));
}

const token = localStorage.getItem("token");

if (token) {
  const payload = parseJwt(token);

  // 로그인 / 비로그인 처리
  document.getElementById("login-menu").style.display = "none";
  document.getElementById("login-user").style.display = "";
  document.getElementById("logout-menu").style.display = "";

  // 사용자명
  document.getElementById("username").innerText = payload.sub;

  // 권한 처리
  if (payload.role === "ROLE_ADMIN") {
    document.getElementById("admin-menu").style.display = "";
  }

  if (payload.role === "ROLE_USER" ||
      payload.role === "ROLE_ADMIN") {
    document.getElementById("user-menu").style.display = "";
  }
}

function logout() {
  localStorage.removeItem("token");
  location.href = "/";
}
</script>

</body>
</html>
