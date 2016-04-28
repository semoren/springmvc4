package com.sermo.springmvc4.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sermo.springmvc4.MyMvcConfig;
import com.sermo.springmvc4.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyMvcConfig.class})
@WebAppConfiguration("src/main/resources") // 用来声明加载的 ApplicationContext 是一个 @WebAppConfiguration,指定web资源位置
public class TestControllerIntegrationTests {
	//模拟 MVC 对象, 通过 MockMvcBuilders.webAppContextSetup(this.context).build() 初始化
	private MockMvc mockMvc;
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	MockHttpSession session; // 注入模拟的 http session
	
	@Autowired
	MockHttpServletRequest request; // 注入模拟的 http request
	
	@Before //初始化
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testNormalController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/normal")) //模拟向 /normal 进行get请求
			.andExpect(MockMvcResultMatchers.status().isOk())  //预期控制返回状态为 200
			.andExpect(MockMvcResultMatchers.view().name("page")) //预期 view 的名称为 page
			.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp")) // 预期页面转向的真正路径
			.andExpect(MockMvcResultMatchers.model().attribute("msg", demoService.saySomething())); // 预期 model 里的值是 hello
	}
	
	@Test
	public void testRestController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/testRest"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=utf-8"))
			.andExpect(MockMvcResultMatchers.content().string(demoService.saySomething()));
	}
}
