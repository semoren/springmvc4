package com.sermo.springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sermo.springmvc4.model.DemoObj;

@Controller
public class ConverterController {
	
	// 指定返回的媒体类型为我们自定义的媒体类型 application/x-renqing
	@RequestMapping(value = "/convert", produces={"application/x-renqing"})
	public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj){
		return demoObj;
	}
	
}
