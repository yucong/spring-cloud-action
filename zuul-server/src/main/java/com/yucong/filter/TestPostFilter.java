package com.yucong.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TestPostFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(TestPostFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * return 可以返回任意的对象，当前实现忽略。（spring-cloud-zuul官方解释）
	 * 直接返回null即可。
	 */
	@Override
	public Object run() throws ZuulException {
		// 通过zuul，获取请求上下文
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();

		logger.info("TestPostFilter.....method={},url={}",
				request.getMethod(),request.getRequestURL().toString());
		
		// 收集统计系统性能。
		
		// throw new RuntimeException("in post filter");
		return null;
	}

	
	/**
	 * post:
	 * 在route或error执行后被调用，
	 * 一般用于收集服务信息，
	 * 统计服务性能指标等，
	 * 也可以对response结果做特殊处理
	 */
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
