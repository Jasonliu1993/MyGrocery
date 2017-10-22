package com.grocery.interceptor;

import com.grocery.domain.NavigatationMenu;
import com.grocery.domain.SystemUser;
import com.grocery.services.IndexService;
import com.grocery.utilities.PackingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jason on 14/10/2017.
 */

@Component
public class GroceryInterceptor implements HandlerInterceptor {

    @Autowired
    private IndexService indexService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().contains("/admin")) {
            HttpSession session = request.getSession();
            SystemUser systemUser = null;
            if ((systemUser = (SystemUser) session.getAttribute("User")) != null) {
                if ("admin".equals(systemUser.getType())) {
                    return true;
                } else {
                    response.sendRedirect(request.getContextPath() + "/error/authFailed");
                    return false;
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/error/authFailed");
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /**
         * 导航条
         */

        List<NavigatationMenu> navigatationMenus = indexService.getNavMenu(request.getRequestURI());

        HttpSession session = request.getSession();
        SystemUser systemUser = null;
        if ((systemUser = (SystemUser) session.getAttribute("User")) != null) {
            if ("admin".equals(systemUser.getType())) {
                request.setAttribute("Nav", PackingInfo.changeData2Message(navigatationMenus));
            } else {
                navigatationMenus.remove(navigatationMenus.remove(navigatationMenus.size() - 1));
                request.setAttribute("Nav", PackingInfo.changeData2Message(navigatationMenus));
            }
        } else {
            navigatationMenus.remove(navigatationMenus.remove(navigatationMenus.size() - 1));
            request.setAttribute("Nav", PackingInfo.changeData2Message(navigatationMenus));
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
