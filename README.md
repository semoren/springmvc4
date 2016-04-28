# springmvc4
 
##第二部分：点睛 Spring MVC 4.x
###第四章 Spring MVC 基础
####4.3 Spring MVC 的常用注解
####4.4 Spring MVC 基本配置
#####4.4.1 静态资源拦截
#####4.4.2 拦截器配置
   * 继承 HandlerInterceptorAdapter 类来实现自定义拦截器 
   * 实现 HandlerInterceptor 接口来实现自定义拦截器
   * 重写 addInterceptors 方法来注册自定义的拦截器
   
#####4.4.3 @ControllerAdvice
通过 @ControllerAdvice, 我们可以将对于控制器的全局配置放置在同一个位置,注解了 @Controller 的类的方法可以使用 @ExceptionHandler、@ModelAttribute、@InitBinder 注解到方法上, 这对所有注解了 @RequestMapping 的控制器内部的方法有效
   * @ExceptionHandler : 用于全局处理控制器里的异常
   * @ModelAttribute : @ModelAttribute 本来的作用是绑定键值对到 Model 中, 此处的是让全局的 @RequestMapping 都能获得在此处设置的键值对
   * @InitBinder : 用来设置 WebDataBinder, WebDataBinder 用来知道绑定前台请求参数的 Model 中 
   
####4.5 Spring MVC 的高级配置
#####4.5.1 文件上传配置
#####4.5.2 自定义 HttpMessageConverter
HttpMessageConverter 是用来处理 request 和 response 里的数据的<br>
* readInternal 方法处理请求前的数据
* writeInternal 方法处理返回数据
	
#####4.5.3 服务器端推送技术
####4.6 Spring MVC 的测试
