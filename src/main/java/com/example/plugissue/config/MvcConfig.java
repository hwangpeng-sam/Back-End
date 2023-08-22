package com.example.plugissue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.plugissue.user.controller"})
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override // Spring MVC 에서 jsp view가 위치하는 경로를 설정함
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/view/",".jsp");
    }
    @Override// '/'로 요청이 오면 /main으로 리다이렉트 하도록 함.
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/main");
    }
    //
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resourceas/");
    }

}
