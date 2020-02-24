package com.bardalez.microzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiPostFiltro extends ZuulFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(MiPostFiltro.class);
    private static final String FILTERTYPE = "post";
    private static final Integer FILTERORDER = 2;

    public MiPostFiltro(){ }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        final HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        LOGGER.info("Estado de la Petición {}", response.getStatus());
        return null;
    }

    @Override
    public String filterType() {
        return FILTERTYPE;
    }

    @Override
    public int filterOrder() {
        return FILTERORDER;
    }
}
