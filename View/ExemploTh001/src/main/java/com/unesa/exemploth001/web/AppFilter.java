/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unesa.exemploth001.web;

import com.unesa.exemploth001.controller.ControllerMappings;
import com.unesa.exemploth001.controller.IController;
import java.io.IOException;
import java.io.Writer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;


/**
 *
 * @author denis
 */
@WebFilter(urlPatterns = "/app/*")
public class AppFilter implements Filter {

    private ITemplateEngine templateEngine;
    
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.templateEngine = EngineFactory.buildTemplateEngine(
                                    filterConfig.getServletContext());
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!process((HttpServletRequest)request, (HttpServletResponse)response)) {
            chain.doFilter(request, response);
        }
    }

    private boolean process(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException {
        try {
            String path = request.getServletPath();
            if (!path.startsWith("/app")) {
                return false;
            }
            IController controller = ControllerMappings.fromPath(path);
            if (controller == null) {
                return false;
            }
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            Writer writer = response.getWriter();
            WebContext context = new WebContext(request, response, request.getServletContext());
            controller.process(context, this.templateEngine, writer);
            return true;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {
    }
    
}
