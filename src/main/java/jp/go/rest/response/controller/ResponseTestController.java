package jp.go.rest.response.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.go.rest.response.dto.ResposeDto;

@RestController
@RequestMapping("/test")
public class ResponseTestController {

	@PostMapping(value = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> responseRest(@RequestBody ResposeDto responseDto) throws NoSuchFieldException, SecurityException {
		
		
		System.out.println("REST REQUEST SUCESS");
		
		 Map<String, String> map = new HashMap<String, String>();
		 
		 Field field = new ResposeDto().getClass().getField("val");
		 
		 map.put("test", responseDto.getVal());
		 map.put("val2", "345");
		
		System.out.println(responseDto);
		
		return map;
	}
}
