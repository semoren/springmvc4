package com.sermo.springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.sermo.springmvc4.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.sermo.springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/**
		 * addResourceHandler 指的是文件放置的目录
		 * addResourceLocations 指的是对外暴露的访问路径
		 */
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assest/");
	}
	
	/**
	 * 重写 addInterceptors 方法来注册自定义的拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
}
