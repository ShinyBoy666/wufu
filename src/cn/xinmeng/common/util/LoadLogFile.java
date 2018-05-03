package cn.xinmeng.common.util;

import java.io.File;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LoadLogFile {

	public LoadLogFile(String path){
		try {
			String projectPath = ClassLoaderUtil.getClassPath()+"//"+path+"//";
			File logbackFile = new File(projectPath+"//logback.xml");
			if (logbackFile.exists()) {
				LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
				JoranConfigurator configurator = new JoranConfigurator();
				configurator.setContext(lc);
				lc.reset();
				configurator.doConfigure(logbackFile);
			}
		}catch (JoranException e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
}
