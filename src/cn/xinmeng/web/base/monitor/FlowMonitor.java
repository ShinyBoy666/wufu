package cn.xinmeng.web.base.monitor;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("singleton")
@Service("flowMonitor")
public class FlowMonitor {
	
	//默认最大的并发数默认为100，可以配置  
    private int maxFlowSize = 400;  
    //最大并发数  
    private int maxRunningSize = 1;  
      
    //当前并发数  
    private AtomicInteger runningSize = new AtomicInteger();  
      
    //通过的数量  
    private AtomicInteger passSize = new AtomicInteger();  
      
    //失败的数量  
    private AtomicInteger loseSize = new AtomicInteger();  
      
    public FlowMonitor(){  
        super();  
    }  
      
    public FlowMonitor(int maxFlowSize){  
        this();  
        this.maxFlowSize = maxFlowSize;  
    }  
  
    /** 
     * 线程进入开关，即使这里用了一些Atomic类，这里仍然会有并发问题。 
     * @return 
     */  
    public boolean entry(){  
        //每个类中一个配置maxFlowSize  
        if(maxFlowSize > 0){  
            if(maxFlowSize<=runningSize.get()){  
                //已经超过最大限制  
                loseSize.incrementAndGet();  
                return false;  
            }  
            //并发数+1  
            runningSize.incrementAndGet();  
            if(runningSize.get() > maxRunningSize){  
                //记录最大的并发数，有并发问题  
                maxRunningSize = runningSize.get();  
            }  
            //记录通过的线程数  
            passSize.incrementAndGet();  
        }  
        return true;  
    }  
    
    /** 
     * 执行完后，并发数-1 
     * @param key 
     */  
    public void release(){  
        runningSize.decrementAndGet();  
    }  
      
    public AtomicInteger getRunningSize() {  
        return runningSize;  
    }  
  
    public AtomicInteger getPassSize() {  
        return passSize;  
    }  
  
    public AtomicInteger getLoseSize() {  
        return loseSize;  
    }  
  
    public int getMaxRunningSize() {  
        return maxRunningSize;  
    }  
      
    /** 
     * 重置,可以分时段进行监控 
     */  
    public void reset(){  
        passSize.set(0);  
        loseSize.set(0);  
        maxRunningSize = 0;  
    }  
}
