package mao.common.utils;

import java.util.Locale;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

@Component("springUtils")
@Lazy(false)
public final class SpringUtils implements ApplicationContextAware, DisposableBean {

	/** applicationContext */
	private static ApplicationContext applicationContext;
	
	/** localeResolver */
	private static LocaleResolver localeResolver;

	/**
	 * 不可实例化
	 */
	private SpringUtils() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext = applicationContext;
	}

	public void destroy() throws Exception {
		applicationContext = null;
	}

	/**
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param name Bean名称
	 * @return 实例
	 */
	public static Object getBean(String name) {
		Assert.hasText(name);
		return applicationContext.getBean(name);
	}

	/**
	 * @param name Bean名称
	 * @param type Bean类型
	 * @return 实例
	 */
	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		return applicationContext.getBean(name, type);
	}

	/**
	 * @param code 代码
	 * @param args 参数
	 * @return 国际化消息
	 */
	public static String getMessage(String code, Object... args) {
		Locale locale = LocaleContextHolder.getLocale();//getLocaleResolver().resolveLocale(null);
		return applicationContext.getMessage(code, args, locale);
	}
	
	
	
	/**
	 * @return localeResolver
	 */
	private static LocaleResolver getLocaleResolver() {
		if (localeResolver == null) {
			localeResolver = getBean("localeResolver", LocaleResolver.class);
		}
		return localeResolver;
	}

}
