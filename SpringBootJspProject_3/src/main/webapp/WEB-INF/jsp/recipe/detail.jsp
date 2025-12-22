<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
  margin-top: 50px
}
.row {
  margin: 0px auto;
  width: 960px;
}
p{
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
.nav-link{
  cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3.3.4/dist/vue.global.js"></script>
<script src="https://unpkg.com/vue-demi"></script>
<script src="https://unpkg.com/pinia@2.1.7/dist/pinia.iife.prod.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
		<div class="row">
		 <table class="table">
		   <tr>
		    <td class="text-center" colspan="3">
		     <img :src="store.detail.poster" style="width: 960px;height: 450px">
		    </td>
		   </tr>
		   <tr>
		     <td colspan="3" class="text-center"><h3>{{store.detail.title}}</h3></td>
		   </tr>
		   <tr>
		     <td colspan="3">{{store.detail.content}}</td>
		   </tr>
		   <tr>
		     <td class="text-center"><img src="/images/a1.png"></td>
		     <td class="text-center"><img src="/images/a2.png"></td>
		     <td class="text-center"><img src="/images/a3.png"></td>
		   </tr>
		   <tr>
		     <td class="text-center">{{store.detail.info1}}</td>
		     <td class="text-center">{{store.detail.info2}}</td>
		     <td class="text-center">{{store.detail.info3}}</td>
		   </tr>
		 </table>
		 <table class="table">
		   <tr>
		    <td colspan="2"><b>[조리순서]</b></td>
		   </tr>
		   <%-- <tr v-for="(detail,index) in ">
		     <td class="text-left" width=80%>[[${data}]]</td>
		     <td class="text-right" width="20%">
		      <img th:src="${nList[status.index]}" style="width:150px;height: 100px"
		       class="img-rounded"
		      >
		     </td>-->
		     <!-- 
		         status 
		         status.index => ArrayList의 index
		         status.count => ArrayList의 총갯수
		         status.last  => ArrayList의 저장된 마지막값
		         status.first => 첫번째 값
		         status.even  => 짝수 
		         status.odd   => 홀수 
		         
		         => StringTokenizer 
		         => <c:forTokens> 
		         => ${#strings.split(문자열,'구분자')}
		      -->
		    </tr> --%>
		 </table>
		 <table class="table">
		   <tr>
		     <td width=20% class="text-left" rowspan="2">
		      <img :src="store.detail.chef_poster" style="width: 100px;height: 100px"
		       class="img-circle"
		      >
		     </td>
		     <td width=80%>{{store.detail.chef}}</td>
		   </tr>
		   <tr>
		     <td width=80%>{{store.detail.chef_profile}}</td>
		   </tr>
		 </table>
	</div>
  </div>
  <script src="/recipejs/recipeDetailStore.js"></script>
  <script>
    const detailApp=Vue.createApp({
    	setup(){
    		const store=useRecipeDetailStore()
    		const params=new URLSearchParams(location.search)
    		const no=params.get('no')
    		console.log("no="+no)
    		Vue.onMounted(()=>{
    			store.recipeDetailData(no)
    		})
    		
    		return {
    			store
    		}
    	}
    })
    detailApp.use(Pinia.createPinia())
    detailApp.mount(".container")
  </script>
</body>
</html>