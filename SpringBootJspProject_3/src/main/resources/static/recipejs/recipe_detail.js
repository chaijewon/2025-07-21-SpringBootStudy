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