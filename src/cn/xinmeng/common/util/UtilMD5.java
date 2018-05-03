package cn.xinmeng.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import cn.xinmeng.common.exceptions.NullException;

public class UtilMD5 {
	
	/**
	 * 供应商加密串 
	 */
	public static final String SUPPLIER_MD5="t@oj!n{0}zi";
	
	// 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private UtilMD5() { }

    /**
     * 返回形式为数字跟字符串
     * @param bByte
     * @return
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     * 转换字节数组为16进制字串
     * @param bByte
     * @return
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    /**
     * 对字符串进行 MD5加密
     * @param CharSequence target
     * @return
     */
    public static String MD5(CharSequence target) {
    	
    	if(Utils.isEmpty(target)){
    		throw new NullException("加密字符串不能为空...");
    	}
        
        try {
        	String value = new String(target.toString());
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            return byteToString(md.digest(value.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    
    
    
    
}
