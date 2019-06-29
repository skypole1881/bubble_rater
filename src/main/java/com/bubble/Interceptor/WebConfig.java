package com.bubble.Interceptor;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin")
				.excludePathPatterns("/admin/login");
	}
//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//		Properties props = new Properties();
//		props.setProperty("hibernate.current_session_context_class", "thread");
//	    return new HibernateJpaSessionFactoryBean();
//	}
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
}
