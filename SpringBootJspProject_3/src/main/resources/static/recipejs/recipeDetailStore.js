const {defineStore,createPinia} = Pinia
const useRecipeDetailStore=defineStore('recipeDetail',{
	state:()=>({
		detail:{}
	}),
	actions:{
		async recipeDetailData(fno){
			const res=await axios.get(
				'http://localhost:9090/recipe/detail_vue/',{
					params:{
						fno:fno
					}
				}
			)
			console.log(res.data)
			this.detail=res.data
		}
	}
})