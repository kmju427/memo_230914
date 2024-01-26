package com.memo.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // spring bean
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		// 요청 URL Path를 꺼낸다.
		String uri = request.getRequestURI();
		log.info("[&&&&&&&& prehandle] uri : {}", uri);
		
		// 로그인 여부
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 비로그인 상태이면서 "/post" 주소 진입 시 -> 로그인 페이지로 이동, 컨트롤러 수행 방지
		if (userId == null && uri.startsWith("/post")) {
			response.sendRedirect("/user/sign-in-view");
			return false; // 원래 요청에 대해서 컨트롤러 수행 안 함
		}
		
		// 로그인 상태이면서 "/user" 주소 진입 시 -> 글 목록 페이지로 이동, 컨트롤러 수행 방지
		if (userId != null && uri.startsWith("/user")) {
			response.sendRedirect("/post/post-list-view");
			return false; // 원래 요청에 대해서 컨트롤러 수행 안 함
		}
		
		return true; // 컨트롤러 수행
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) {
		// view 객체가 있다는 건 아직 jsp가 html로 변환되기 전이라는 뜻이다.
		log.info("[######## postHandle]");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		// jsp가 html로 최종 변환된 후이다.
		log.info("[@@@@@@@@ afterCompletion]");
	}
	
} // public class PermissionInterceptor