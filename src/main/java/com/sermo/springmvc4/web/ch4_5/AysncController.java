package com.sermo.springmvc4.web.ch4_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.sermo.springmvc4.service.PushService;

@Controller
public class AysncController {
	
	@Autowired
	PushService pushService; // 定时任务, 定时更新 DeferredResult
	
	@RequestMapping("/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall(){ //返回给客户端 DeferredResult
		return pushService.getAsyncUpdate();
	}
}
