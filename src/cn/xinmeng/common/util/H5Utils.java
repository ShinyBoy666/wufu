package cn.xinmeng.common.util;

import java.util.HashMap;
import java.util.Map;

public class H5Utils {

	public static Map<Integer,String> headSculpture = new HashMap<Integer,String>();
	
	static {
		if(Utils.isEmpty(headSculpture)){
			headSculpture.put(1, H5Utils.getLoaclUrl("statics/head/1.jpg"));
			headSculpture.put(2, H5Utils.getLoaclUrl("statics/head/2.jpg"));
			headSculpture.put(3, H5Utils.getLoaclUrl("statics/head/3.jpg"));
			headSculpture.put(4, H5Utils.getLoaclUrl("statics/head/4.jpg"));
			headSculpture.put(5, H5Utils.getLoaclUrl("statics/head/5.jpg"));
			headSculpture.put(6, H5Utils.getLoaclUrl("statics/head/6.jpg"));
			headSculpture.put(7, H5Utils.getLoaclUrl("statics/head/7.jpg"));
			headSculpture.put(8, H5Utils.getLoaclUrl("statics/head/8.jpg"));
			headSculpture.put(9, H5Utils.getLoaclUrl("statics/head/9.jpg"));
		}
	}
	
	private static String getLocalUrl(){
		return HelperPropertie.getValue("local.url");
	}
	
	public static String getLoaclUrl(String url){
		return getLocalUrl()+url;
	}
	
	private static String getHoutaiUrl(){
		return HelperPropertie.getValue("houtai.url");
	}
	
	public static String getHoutaiUrl(String url){
		return getHoutaiUrl()+url;
	}
	
	public static String findActivityUrl(Integer id){
		return getLocalUrl()+"/App/findActivity?id="+id;
	}
}
