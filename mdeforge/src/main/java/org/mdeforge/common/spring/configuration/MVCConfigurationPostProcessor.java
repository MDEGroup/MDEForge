package org.mdeforge.common.spring.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class MVCConfigurationPostProcessor implements BeanPostProcessor{
	private WebBindingInitializer webBindingInitializer;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter requestMappingHandlerAdapter = ((RequestMappingHandlerAdapter) bean);
            requestMappingHandlerAdapter.setWebBindingInitializer(webBindingInitializer);
        }
       
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }   

    public void setWebBindingInitializer(WebBindingInitializer webBindingInitializer) {
        this.webBindingInitializer = webBindingInitializer;
    }
}
