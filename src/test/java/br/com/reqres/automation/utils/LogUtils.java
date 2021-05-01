package br.com.reqres.automation.utils;

import org.apache.log4j.Logger;

public final class LogUtils {
	private LogUtils() { }
	
	public static Logger getLogger() {
		return Logger.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
}
