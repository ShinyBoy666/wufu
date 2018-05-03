package cn.xinmeng.common.util.encrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.http.HttpClient;

/**
 * BASE64编码解码工具包
 */
public class Base64Utils {

    /**
     * 文件读取缓冲区大小
     */
    private static final int CACHE_SIZE = 1024;
    
    /**
     * BASE64字符串解码为二进制数据
     * @param base64
     * @return
     * @throws Exception
     */
    public static byte[] decode(String base64) throws Exception {
        return Base64.decodeBase64(base64.getBytes());
    }
    
    /**
     * 二进制数据编码为BASE64字符串
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(byte[] bytes) throws Exception {
        return new String(Base64.encodeBase64(bytes));
    }
    
    /**
     * 将文件编码为BASE64字符串
     * 大文件慎用，可能会导致内存溢出
     * @param filePath 文件绝对路径
     * @return
     * @throws Exception
     */
    public static String encodeFile(String filePath) throws Exception {
        byte[] bytes = fileToByte(filePath);
        return encode(bytes);
    }
    
    /**
     * BASE64字符串转回文件
     * @param filePath 文件绝对路径
     * @param base64 编码字符串
     * @throws Exception
     */
    public static void decodeToFile(String filePath, String base64) throws Exception {
        byte[] bytes = decode(base64);
        byteArrayToFile(bytes, filePath);
    }
    
    /**
     * 文件转换为二进制数组
     * @param filePath 文件路径
     * @return
     * @throws Exception
     */
    public static byte[] fileToByte(String filePath) throws Exception {
        byte[] data = new byte[0];
        File file = new File(filePath);
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = in.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
            out.close();
            in.close();
            data = out.toByteArray();
         }
        return data;
    }
    
    /**
     * 二进制数据写文件
     * @param bytes 二进制数据
     * @param filePath 文件生成目录
     */
    public static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
        InputStream in = new ByteArrayInputStream(bytes);   
        File destFile = new File(filePath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }
        destFile.createNewFile();
        OutputStream out = new FileOutputStream(destFile);
        byte[] cache = new byte[CACHE_SIZE];
        int nRead = 0;
        while ((nRead = in.read(cache)) != -1) {   
            out.write(cache, 0, nRead);
            out.flush();
        }
        out.close();
        in.close();
    }
    
    public static void main(String[] args) throws Exception {

//    	Customer customer = new Customer();
//    	customer.setCashAmount(10.55);
//    	customer.setNickname("测试");
//    	RequestDataReport report = new RequestDataReport();
//    	report.setCode("1000");
//    	report.setData(Utils.parseToJson(customer));
//    	report.setImei("21312");
//    	report.setMak("21312");
//    	report.setSource("IOS");
//    	report.setTimestamp(1442289394);
//    	report.setToken("1442289394");
//    	
//    	byte[] byteStr = SerializeUtil.serialize(customer);
//		System.out.println(byteStr);
//		String base64 = Base64Utils.encode(byteStr);
//		System.out.println(base64);
//		byte[] s= decode(base64);
//		System.out.println(s);
//		Customer c = (Customer) SerializeUtil.unserialize(s);
//		System.out.println(Utils.parseToJson(c));
		
    	String base64 = Base64Utils.encodeFile("/Users/tanjiangyong/Downloads/1.png");
//
		Map<String,String> params = new HashMap<String, String>();
		params.put("base64String", base64);
		params.put("imgType","0");
//		String url = "http://120.26.206.215:9291/UploadFile/Base64UploadImage";
		String url = "http://139.196.195.34:8084/UploadFile/Base64UploadImage";
		HttpClient httpClient= HttpClient.getInstance();
		String res = httpClient.doPost(url, FastJsonUtils.bean2Json(params));
		Map<String,String> mapResult = FastJsonUtils.json2Bean(res, Map.class);
		System.out.println(mapResult);
		String result = mapResult == null ?"":mapResult.get("Base64UploadImageResult");
		System.out.println(result);
	}
}