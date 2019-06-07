package com.Sean.LoginController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor
{
    //在执行handler之前来执行的
    //用于用户认证校验、用户权限校验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURI();

        //判断是否是公開網址
        //實際開發中需要將公開網址配置在配置文件中

        if (url.indexOf("login")>=0 ||  url.indexOf("home")>=0  || url.indexOf("user/add/do")>=0 
        		|| url.indexOf("Topic")>=0 || url.indexOf("User")>=0 || url.indexOf("Article/detail")>=0) 
        {
            //如果是公開網址就可進入
            return true;
        }

        //判断登入人員身份在session中是否存在
        HttpSession session=request.getSession();
        Integer userToken= (Integer) session.getAttribute("userToken");

        //如果登入人員身份在session中存在可進入
        if (userToken!=null)
        {
            return true;
        }

        //執行到这里就攔截，跳轉到登入頁面
        request.setAttribute("notLogin", "請登入後才能進入該頁面！！");
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);
        return false;
    }


    //在执行handerl但是返回modelandview之前来执行
    //如果需要向页面提供一些公用的数据或配置一些视图信息，使用此方法实现从modelAndView入手
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptor1....postHandle");
    }


    //执行handler之后执行此方法
    //做系统统一异常处理，进行方法执行性能监控，在prehandler中设置一个时间点，在afterCompletion设置一个时间点，两个时间点的差就是执行时长
    //实现系统统一日志记录
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

        System.out.println("HandlerInterceptor1....afterCompletion");

    }
}