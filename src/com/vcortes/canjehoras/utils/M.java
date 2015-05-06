package com.vcortes.canjehoras.utils;


import java.util.Locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;


public class M  {
	private static ReloadableResourceBundleMessageSource source = (ReloadableResourceBundleMessageSource) BeanGetter
			.getBean("messageSource");
	
	public static String sg(String codigo) {
		String mensaje;
		try {
			mensaje = source.getMessage(codigo, null, Locale.getDefault());
		} catch (Exception e) {
			try{
				mensaje = source.getMessage(codigo, null, Locale.getDefault());
			}catch(Exception ex){
				mensaje = codigo;
			}
		}
		return mensaje.trim();
	}
	
}