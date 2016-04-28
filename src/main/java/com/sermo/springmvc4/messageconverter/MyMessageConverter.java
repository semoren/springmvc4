package com.sermo.springmvc4.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import com.sermo.springmvc4.model.DemoObj;

/**
 * 
 * @author rq
 * 继承 AbstractHttpMessageConverter 接口来实现自定义的 HttpMessageConverter
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj>{

	
	public MyMessageConverter() {
		// 新建一个我们自定义的媒体类型 application/x-renqing
		super(new MediaType("application", "x-renqing", Charset.forName("UTF-8")));
	}

	/*
	 * 表明本  HttpMessageConverter 只处理 DemoObj 这个类
	 */
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	/*
	 * 重写 readInternal 方法, 处理请求的数据
	 */
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}

	/*
	 * 重写 writeInternal 方法, 处理如何输出数据到 response
	 */
	@Override
	protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello:" + obj.getId() + "-" + obj.getName();
		outputMessage.getBody().write(out.getBytes());
	}

}
