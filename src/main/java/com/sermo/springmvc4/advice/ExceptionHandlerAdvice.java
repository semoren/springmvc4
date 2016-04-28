package com.sermo.springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rq
 * @ControllerAdvice 声明一个控制器建言, 包含了 @Component 注解
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	/*
	 * @ExceptionHandler 定义全局处理, 拦截所有的 Exception
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error"); // error 页面
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}
	
	/*
	 * 使用 @ModelAttribute 注解将键值对添加到全局, 所有注解的 @RequestMapping 的方法可获取此键值对
	 */
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "额外信息");
	}
	
	/*
	 * 通过 @InitBinder 注解定制 WebDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		// 忽略 request 参数的 id
		webDataBinder.setDisallowedFields("id");
	}
}
