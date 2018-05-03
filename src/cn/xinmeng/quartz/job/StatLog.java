package cn.xinmeng.quartz.job;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import cn.xinmeng.common.mail.MailEnum;
import cn.xinmeng.common.mail.impl.MailEngineServiceImpl;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.quartz.base.BaseJob;

public class StatLog extends BaseJob{

	protected Scheduler quartzScheduler;

	@Resource
	private MailEngineServiceImpl mailEngine;

	public void work() throws SchedulerException{
		///data/logs/jetty/wufu/stat/statLog.log.2016-04-05.log
//		String path = "/Users/tanjiangyong/statLog.log.";
		
		//正式环境
		if(!Utils.isEmpty(propertiesPath) && "prd".equalsIgnoreCase(propertiesPath)){
			String path = "/data/logs/jetty/wufu/stat/statLog.log.";
			Date yesterday = DateUtil.addDay(new Date(), -1);
			String day = DateUtil.formatDate(yesterday, "yyyy-MM-dd");
			path = path + day +".log";
			try {
				Integer todayPv = 0;//今天总pv
				
				Map<String,Integer> pv = new HashMap<String,Integer>();//键：ios，安卓，wap，值：数量
				Map<String,Integer> uv = new HashMap<String,Integer>();//键：ip，值：数量
				
				
				HashMap<String,Integer> visitCount = new HashMap<String, Integer>();//键：code，值：总访问次数
				HashMap<String,Long> maxTime = new HashMap<String, Long>();//查询大于1秒，键：code，值：最大访问时间
				HashMap<String,Integer> maxCount = new HashMap<String, Integer>();//查询大于1秒，键：code，值：次数
				HashMap<String,String> codeMap = new HashMap<String, String>();//查询大于1秒，键：code，值：最长访问时间：s 大于一秒访问次数：c 总访问次数：m
				

				FileInputStream is = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line;
				try {
					while ((line = br.readLine()) != null) {
						if (line.equals(""))
							continue;
						todayPv++;
						String[] args = line.split(",");
						if(args == null || args.length < 5){
							continue;
						}
						String date = args[0];
						String source = args[1];
						String codeStr = args[2];
						String ip = args[3];
						String time = args[4];
						
						//PV
						if(pv.containsKey(source)){
							Integer count = pv.get(source);
							count = count + 1;
							pv.put(source, count);
						}else{
							pv.put(source, 1);
						}
						
						//UV
						if(uv.containsKey(ip)){
							Integer count = uv.get(ip);
							count = count + 1;
							uv.put(ip, count);
						}else{
							uv.put(ip, 1);
						}
						
						//code:总访问次数
						if(visitCount.containsKey(codeStr)){
							Integer count = visitCount.get(codeStr);
							count = count + 1;
							visitCount.put(codeStr, count);
						}else{
							visitCount.put(codeStr, 1);
						}
						
						
						//查询大于1秒，键：code，值：最大访问时间
						Long timeLong = Long.valueOf(time.trim());
						if(timeLong > 10){
							if(maxTime.containsKey(codeStr)){
								long s = maxTime.get(codeStr);
								if(timeLong > s){
									maxTime.put(codeStr, timeLong);
								}
								//code访问次数
								Integer count = maxCount.get(codeStr);
								count = count + 1;
								maxCount.put(codeStr, count);
							}else{
								maxTime.put(codeStr, timeLong);
								maxCount.put(codeStr, 1);
							}
						}

					}
					//访问超长
					for (String s : maxTime.keySet()) {
						//查询大于1秒，键：code，值：最长访问时间：s 大于一秒访问次数：c 总访问次数：m
						String value = "最长访问时间："+maxTime.get(s)+"毫秒  大于10毫秒访问次数："+maxCount.get(s)+"  总访问次数："+visitCount.get(s);
						codeMap.put(s, value);
					}
					LogManager.info(this.getClass(),"pv:"+todayPv);
					LogManager.info(this.getClass(),"pv:"+pv);
					LogManager.info(this.getClass(),"uv:"+uv);
					LogManager.info(this.getClass(),"code:"+codeMap);
					
					Map<String,Object> model = new HashMap<String, Object>();
					model.put("statDate", day);
					model.put("pvTotal", todayPv);
					model.put("pvDistribution", pv);
					model.put("uvTotal", uv.size());
					model.put("uvDistribution", uv);
					model.put("ReqLong", codeMap);
					mailEngine.sendEmail(MailEnum.LOG_STAT, model,"jishu@51shunkai.com");
				} catch (IOException e) {
					LogManager.error(this.getClass(),e.getMessage(),e);
				}
			} catch (FileNotFoundException e) {
				LogManager.error(this.getClass(),e.getMessage(),e);
			}
		}
	}

}
