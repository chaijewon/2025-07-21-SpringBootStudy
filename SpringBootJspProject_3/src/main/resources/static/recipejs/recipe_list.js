const app=Vue.createApp({
    	setup(){
    		const store=useRecipeStore()
    		Vue.onMounted(()=>{
    			store.recipeListData()
    			
    		})
    		
    		const range=(start,end)=>{
    			let arr=[]
    			let len=end-start
    			for(let i=0;i<=len;i++)
    			{
    				arr[i]=start
    				start++
    			}
    			return arr
    		}
    		
    		return {
    			store,
    			range
    		}
    	}
    })
    const pinia=Pinia.createPinia()
    app.use(pinia)
    app.mount(".container")