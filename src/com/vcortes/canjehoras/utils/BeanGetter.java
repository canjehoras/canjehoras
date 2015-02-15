package com.vcortes.canjehoras.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanGetter implements ApplicationContextAware {
	private static ApplicationContext appContext;

	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		BeanGetter.appContext = appContext;
	}

	public static Object getBean(String beanName) {
		return BeanGetter.appContext.getBean(beanName);
	}
}
 