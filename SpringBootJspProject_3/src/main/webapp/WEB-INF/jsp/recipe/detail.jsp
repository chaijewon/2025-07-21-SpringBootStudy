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