<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JWT Login</title>
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
    <h3 class="text-center">로그인</h3>

    <!-- 에러 메시지 -->
    <table class="table" id="errorBox" style="display:none">
      <tbody>
        <tr>
          <td class="text-center">
            <span style="color:red">
              아이디나 비밀번호가 틀립니다
            </span>
          </td>
        </tr>
      </tbody>
    </table>

    <table class="table">
      <tbody>
        <tr>
          <td width="20%" class="text-center">ID</td>
          <td width="80%">
            <input type="text" id="username"
                   class="input-sm form-control">
          </td>
        </tr>
        <tr>
          <td class="text-center">PW</td>
          <td>
            <input type="password" id="password"
                   class="input-sm form-control">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button onclick="login()"
                    class="btn-sm btn-warning">
              로그인
            </button>
            <button onclick="history.back()"
                    class="btn-sm btn-default">
              취소
            </button>
          </td>
        </tr>
      </tbody>
    </table>

  </div>
</div>

<script>
function login() {

  fetch("/jwt-login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      username: document.getElementById("username").value,
      password: document.getElementById("password").value
    })
  })
  .then(res => {
    if (!res.ok) throw new Error("fail");
    return res.json();
  })
  .then(data => {
    localStorage.setItem("token", data.token);
    location.href = "/";
  })
  .catch(() => {
    document.getElementById("errorBox").style.display = "";
  });
}
</script>

</body>
</html>
