package com.example.demo.interceptor;

import com.example.demo.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session =httpServletRequest.getSession();
        String contextPath=session.getServletContext().getContextPath();
        //requireAuthPages=>路径列表，在里面写下需要拦截的路径
        String[] requireAuthPages =new String[]{
                "index",
        };

        String uri=httpServletRequest.getRequestURI();

        uri = StringUtils.remove(uri,contextPath+"/");
        String page=uri;

        /**
         * 判断session中是否存在user属性，如果存在就放行，如果不存在就跳转到login界面。
         */
        if(begingWith(page,requireAuthPages)){
            User user =(User) session.getAttribute("user");
            if(user==null){
                httpServletResponse.sendRedirect("login");
                return false;
            }
        }
        return true;
    }
    private boolean begingWith(String page,String[] requireAuthPages){
        boolean result=false;
        for(String requireAuthPage :requireAuthPages){
            if(StringUtils.startsWith(page,requireAuthPage)){
                result=true;
                break;
            }
        }
        return result;
    }
}
