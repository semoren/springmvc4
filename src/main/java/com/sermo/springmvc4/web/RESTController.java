package com.sermo.springmvc4.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sermo.springmvc4.model.DemoObj;

@RestController
@RequestMapping("/rest")
public class RESTController {
	
	@RequestMapping(value="/getjson",produces={"application/json;charset=UTF-8"})
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
	}
	
	@RequestMapping(value="/getxml",produces={"application/xml;charset=UTF-8"})
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
	}
}
