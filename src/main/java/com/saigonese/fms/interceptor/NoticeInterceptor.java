package com.saigonese.fms.interceptor;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NoticeInterceptor extends HandlerInterceptorAdapter {
	
	private MessageSourceAccessor messageAccessor;

	public MessageSourceAccessor getMessageAccessor() {
		return messageAccessor;
	}

	public void setMessageAccessor(MessageSourceAccessor messageAccessor) {
		this.messageAccessor = messageAccessor;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Calling preHandle");
		return super.preHandle(request, response, handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String userMessage = messageAccessor.getMessage("msg.app.default.blurb");

		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			if (request.isUserInRole("ROLE_ADMIN")) {
				userMessage = messageAccessor.getMessage("msg.app.admin.blurb");
			} else {
				userMessage = messageAccessor.getMessage("msg.app.user.blurb");
			}
//			modelAndView.getModelMap().addAttribute("SpecialBlurb", userMessage);
		}

		System.out.println("Calling postHandle");
		System.out.println("Special blurb message: " + userMessage);
		if(modelAndView != null) {
			modelAndView.getModelMap().addAttribute("SpecialBlurb", userMessage);
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Calling afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

}
