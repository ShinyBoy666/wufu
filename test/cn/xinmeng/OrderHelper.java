package cn.xinmeng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class OrderHelper {
    private static Logger logger = Logger.getLogger(OrderHelper.class);
	
	public static boolean isTestData(String source){
		if(StringUtils.isBlank(source)) return false;
		boolean rtn = false;
		if(source.toLowerCase().contains("test") || source.contains("测试")) return true;
		return rtn;
	}
	
	public static void main(String[] args) {
		System.out.println(new Date(1459993800000l));
//		String context = readTxtFile("/Users/tanjiangyong/xiongzhao.txt");
//		System.out.println(getProductInfoImage(context));//商品信息图片
//		System.out.println(getProductName(context));//商品名称
//		System.out.println(getProductPrice(context));//商品价格
//		System.out.println(getProductImage(context));//商品图片
		
		
	}
	
	public static String readTxtFile(String path){
		try {
			String encoding="UTF-8";
//			File file=new File("/Users/tanjiangyong/product.txt");
//			File file=new File("/Users/tanjiangyong/mianmo.txt");
			File file=new File(path);
			
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				StringBuffer bf=new StringBuffer();
				while((lineTxt = bufferedReader.readLine()) != null){
					bf.append(lineTxt);
					//	                        System.out.println(lineTxt);
				}
				read.close();//data-lazy-img="
		    	String html=bf.toString().replaceAll(" +","").replaceAll("	", "").replaceAll("data-lazy-img=", "src=");
				return html;
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			return "";
		}
		return "";

	}
    
    public static List<String> getProductInfoImage(String html) {
        List<String> resultList = new ArrayList<String>();
        Pattern p = Pattern.compile("<divclass=\"p-img\"><a.*?.jpg.*?</a></div>",Pattern.CANON_EQ);//匹配<title>开头，</title>结尾的文档
        Matcher m = p.matcher(html );//开始编译
        while (m.find()) {
        	String context = m.group();
        	context = context.substring(context.indexOf("src=\""), context.indexOf(".jpg")+4);
        	context=context.replaceAll("src=\"", "http:").replaceAll("\"></a></div>", "");
            resultList.add(context);//获取被匹配的部分
        }
        return resultList;
    }

    public static List<String> getProductName(String html) {
        List<String> resultList = new ArrayList<String>();
        Pattern p = Pattern.compile("<em>.*?</em>",Pattern.CANON_EQ);//匹配<title>开头，</title>结尾的文档
        Matcher m = p.matcher(html );//开始编译
        while (m.find()) {
        	String context = m.group();
        	context=context.replaceAll("<em>", "").replaceAll("</em>", "");
        	if(!context.equals("¥")){
                resultList.add(context);//获取被匹配的部分
        	}
        }
        return resultList;
    }
    

    public static List<String> getProductPrice(String html) {
        List<String> resultList = new ArrayList<String>();
        Pattern p = Pattern.compile("<em>¥</em><i>.*?</i></strong>",Pattern.CANON_EQ);//匹配<title>开头，</title>结尾的文档
        Matcher m = p.matcher(html );//开始编译
        while (m.find()) {
        	String context = m.group();
        	context=context.replaceAll("<em>¥</em><i>", "").replaceAll("</i></strong>", "");
            resultList.add(context);//获取被匹配的部分
        }
        return resultList;
    }

    public static List<List<String>> getProductImage(String html) {
    	List<List<String>> result = new ArrayList<List<String>>();
        Pattern p = Pattern.compile("<ulclass=\"ps-main\"><li.*?</li></ul></div>",Pattern.CANON_EQ);//匹配<title>开头，</title>结尾的文档
        Matcher m = p.matcher(html );//开始编译
        while (m.find()) {
            List<String> resultList = new ArrayList<String>();
        	String context = m.group();
        	 Pattern pp = Pattern.compile("src=\".*?.jpg\"></a></li>",Pattern.CANON_EQ);
        	 Matcher mm = pp.matcher(context);//开始编译
//        	context=context.replaceAll("src=\"", "http:");
        	while (mm.find()) {
            	String temp = mm.group();
            	if(temp.indexOf("src") != -1){
            		temp=temp.substring(temp.lastIndexOf("src="));
                	temp=temp.replaceAll("src=\"", "http:").replaceAll("\"></a></li>", "");
//                	System.out.println(temp);
                    resultList.add(temp);//获取被匹配的部分
            	}
        	}
        	result.add(resultList);//获取被匹配的部分
        }
        return result;
    }
}
