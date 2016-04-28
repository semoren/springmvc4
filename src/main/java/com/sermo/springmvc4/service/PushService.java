package com.sermo.springmvc4.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {
	// 在 PushService 里产生 DeferredResult 给控制器使用, 通过 @Scheduled 注解的方法定时更新 DeferredResult
	private DeferredResult<String> deferredResult;
	
	public DeferredResult<String> getAsyncUpdate(){
		deferredResult = new DeferredResult<String>();
		return deferredResult;
	}
	
	@Scheduled(fixedDelay=5000)
	public void refresh(){
		if (deferredResult != null) {
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
		}
	}
}
