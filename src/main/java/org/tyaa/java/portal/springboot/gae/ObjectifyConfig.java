/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.portal.springboot.gae;

import com.googlecode.objectify.ObjectifyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author yurii
 */
@Configuration
public class ObjectifyConfig {

    @Bean
    public FilterRegistrationBean<ObjectifyFilter>
        objectifyFilterRegistration() {
        
        final FilterRegistrationBean<ObjectifyFilter> registration =
                new FilterRegistrationBean<>();
        registration.setFilter(new ObjectifyFilter());
        registration.addUrlPatterns("/api/*");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ObjectifyListener>
        listenerRegistrationBean() {
        
        ServletListenerRegistrationBean<ObjectifyListener> bean
                = new ServletListenerRegistrationBean<>();
        bean.setListener(new ObjectifyListener());
        return bean;
    }
    
    /*@Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet servlet=new DispatcherServlet();
        servlet.getServletContext().addListener(new ObjectifyListener());
        return  servlet;
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet(), "/api/*");
        registrationBean
                .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);


        return registrationBean;
    }*/
}
