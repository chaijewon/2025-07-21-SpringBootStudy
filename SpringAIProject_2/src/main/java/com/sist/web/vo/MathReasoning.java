package com.sist.web.vo;

import java.awt.ItemSelectable;

/*
 *    {"items":[{},{},{}],"aaa":"aaaa","bbb":{}}
 */

import com.fasterxml.jackson.annotation.JsonProperty;
// jackson => JSON과 객체의 변수가 동일한 경우에만 가능
// => 저장하는 공간 => getter 
/*
 *   {"steps":{"items":[{"explanation":"","output":""},{}...]},"finalAnswer":""}
 */
public record MathReasoning(
	@JsonProperty(required = true,value="steps") Steps steps,
	@JsonProperty(required = true,value="final_answer") String finalAnswer
	
) 
{
     record Steps(
        @JsonProperty(required = true,value="items") Items[] items
     )
     {
	    record Items(
	       @JsonProperty(required = true , value="explanation") String explanation,
	       @JsonProperty(required = true , value = "output") String output
	    )
	    {
	    	
	    }
     }
}
