package com.hw.servicezuuldemo1.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 过滤
 * 安全验证
 */
@Component
public class MyFilter  {
//public class MyFilter extends ZuulFilter {

/*    private static Logger log =LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }*/
}
