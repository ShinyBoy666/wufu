package cn.xinmeng.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
	public static void debug(Class<?> className, String message,Object ... obj) {
		Logger logger = LoggerFactory.getLogger(className);
		logger.debug(message,obj);
	}

	public static void info(Class<?> className, String message,Object ... obj) {
		Logger logger = LoggerFactory.getLogger(className);
		logger.info(message,obj);
	}

	public static void error(Class<?> className, String message,Object ... objects) {
		Logger logger = LoggerFactory.getLogger(className);
		logger.error(message,objects);
	}

	public static void warn(Class<?> className, String message,Object ... objects) {
		Logger logger = LoggerFactory.getLogger(className);
		logger.info(message,objects);
	}

	public static void info(Class<?> className, String message, Throwable t,Object ...objects) {
		Logger logger = LoggerFactory.getLogger(className);
		if(objects != null && objects.length > 0){
			logger.info(message,objects);
		}
		logger.info(message, t);
	}

	public static void warn(Class<?> className, String message, Throwable t,Object ...objects) {
		Logger logger = LoggerFactory.getLogger(className);
		if(objects != null && objects.length > 0){
			logger.warn(message,objects);
		}
		logger.warn(message, t);
	}

	public static void error(Class<?> className, String message, Throwable t,Object ...objects) {
		Logger logger = LoggerFactory.getLogger(className);
		if(objects != null && objects.length > 0){
			logger.error(message,objects);
		}
		logger.error(message, t);
	}

	public static void debug(Class<?> className, String message, Throwable t,Object ...objects) {
		Logger logger = LoggerFactory.getLogger(className);
		if(objects != null && objects.length > 0){
			logger.debug(message,objects);
		}
		logger.debug(message, t);
	}
	
	public static Logger getLogger(Class<?> className){
		return LoggerFactory.getLogger(className);
	}

	public static void infoProfit(String message,Object ...objects){
		Logger logger = LoggerFactory.getLogger("profitLog");
		logger.info(message,objects);
	}
	public static void errorProfit(String message,Throwable t,Object ...objects){
		Logger logger = LoggerFactory.getLogger("profitLog");
		logger.error(message,t);
		if(objects != null && objects.length > 0){
			logger.error(message,objects);
		}
	}
	public static void infoProfit(String message,Throwable t,Object ...objects){
		Logger logger = LoggerFactory.getLogger("profitLog");
		logger.info(message,t);
		if(objects != null && objects.length > 0){
			logger.info(message,objects);
		}
	}

	public static void infoStatLog(String message,Object ...objects){
		Logger logger = LoggerFactory.getLogger("statLog");
		logger.info(message,objects);
	}
	
}
