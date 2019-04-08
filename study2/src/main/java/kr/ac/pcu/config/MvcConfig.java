package kr.ac.pcu.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable  /* 자바설정파일이야~~~  */
@EnableWebMvc  /* 기본적인  설정을 자동으로 등록   */
//	빈(스프링에서 관리하는 객체)을 자동으로 검색하여 등록
@ComponentScan(basePackages="kr.ac.pcu")
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 요청에 대한 컨트롤러가 없을때 기본 서블릿 헨들러(WAS)에게 위임 
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
}
