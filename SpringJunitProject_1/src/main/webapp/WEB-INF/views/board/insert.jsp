<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
   margin-top: 50px;
}
.row {
  margin: 0px auto;
  width: 800px;
}
</style>
</head>
<!-- 
   1. JSP : MyBatis => JDBC
   2. Ajax / Jquery 
   3. Spring-Boot : MyBatis
   4. Vue / Pinia 
   5. Spring-Boot : JPA
   6. React / TanStack-query : TypeScript,MSA(NodeJS)
   ------------------------------- 목록 (페이지) / 상세보기 
                                   CRUD   
   데이터베이스 : 오라클 / MySQL,MariaDB 
   
   Spring - Framework : JSP / ThymeLeaf 
                         |
                       전송 / db연동 
                       -----------
                       | Cookie / Session
                                  | Security => JWT
                                  | Socket 
   => Spring AI 
   ========================> SI/SM/SE => DevOps 
   Git Action
      |
    Docker
      |
   Docker-compose 
      | ----------------- Kube 
    Jenkins  
 -->
<body>
  <div class="container">
    <div class="row">
      <h3 class="text-center">글쓰기</h3>
      <form method=post action="/board/insert_ok">
      <table class="table">
        <tbody>
          <tr>
            <th class="danger" width="20%" class="text-center">이름</th>
            <td width="80%">
              <input type=text name=name size=20 class="input-sm" required>
            </td>
          </tr>
          <tr>
            <th class="danger" width="20%" class="text-center">제목</th>
            <td width="80%">
              <input type=text name=subject size=60 class="input-sm" required>
            </td>
          </tr>
          <tr>
            <th class="danger" width="20%" class="text-center">내용</th>
            <td width="80%">
              <textarea rows="10" cols="60" name="content" required></textarea>
            </td>
          </tr>
          <tr>
            <th class="danger" width="20%" class="text-center">비밀번호</th>
            <td width="80%">
              <input type=password name=pwd size=10 class="input-sm" required>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="text-center">
              <button type=submit class="btn-sm btn-warning">글쓰기</button>
              <button type=button class="btn-sm btn-warning"
               onclick="javascript:history.back()"
              >취소</button>
            </td>
          </tr>
        </tbody>
      </table>
      </form>
    </div>
  </div>
</body>
</html>




