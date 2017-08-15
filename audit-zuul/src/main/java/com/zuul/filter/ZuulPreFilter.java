package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulPreFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ZuulPreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        // 让所有请求带上 access_token
//        Object accessToken = request.getParameter("access_token");
//        if(null == accessToken) {
//            logger.warn("access_token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
////            return null;
//            throw new RuntimeException("access_token is empty");
//        }

        logger.info("access token ok");
        return null;
    }

}
