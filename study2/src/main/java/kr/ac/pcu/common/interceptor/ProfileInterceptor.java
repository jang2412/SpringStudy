package kr.ac.pcu.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

//	Spring4 버전은 HandlerInterceptorAdapter를 상속
//	Spring5 버전은 HandlerInterceptor 구현(JAVA 8버전에서 인터페이스 내부에 코드처리가 가능함.)

public class ProfileInterceptor implements HandlerInterceptor {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("--- Profile 실행 -----------------------------");		
		// 동시에 여러명이 접속해 들어오므로 멤버 변수에 값을 저장하면 안되고,
		// 현재 시간 속성에 저장 
		request.setAttribute("profileStartTime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 컨트롤러 수행 시간 체크, 로깅 처리(DB 로그기록 등..)		
		// 속성에 저장했던 시간 가져오기  
		long startTime = (Long)request.getAttribute("profileStartTime");
		long execTime = System.currentTimeMillis() - startTime;
		
		log.info("  요청 URI : {}ms", request.getRequestURI());
		log.info("  요청 수행시간 : " + execTime);
		log.info("--- Profile 종료 -----------------------------");

		if(ex != null) {
			log.error(" 예외 : " + ex.getMessage(), ex);
		}		
	}
}
