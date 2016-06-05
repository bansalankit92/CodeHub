package com.ankitbansal.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;




public class WebInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getServletConfigClasses() {
return new Class[] { SpringConfig.class };
}

@Override
protected String[] getServletMappings() {
return new String[] { "/" };
}

@Override
protected Class<?>[] getRootConfigClasses() {
return null;
}

}
