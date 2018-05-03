package cn.xinmeng.common.util.encrypt;

import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.JNCryptor;

import cn.xinmeng.common.util.UtilMD5;

public class AES256Utils {
	
	/**
	 *  解密
	 * @author jiangyong.tan
	 * @date 2016年2月22日 下午3:26:09
	 * @param base64
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String base64,String password) throws Exception{
		JNCryptor cryptor = new AES256JNCryptor();
		byte[] ciphertext = cryptor.decryptData(Base64Utils.decode(base64), password.toCharArray());
		return new String(ciphertext);
	}
	
	/**
	 *  加密
	 * @author jiangyong.tan
	 * @date 2016年2月22日 下午3:29:51
	 * @param data
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data,String password) throws Exception{
		JNCryptor cryptor = new AES256JNCryptor();
		byte[] ciphertext = cryptor.encryptData(data.getBytes(), password.toCharArray());
		return Base64Utils.encode(ciphertext);
	}
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			String str = "context\":\"浙江省杭州市萧山区东部公司 已打包\",\"time\":\"2015-08-21 20:21:36\"},{\"ftime\":\"2015-08-21 18:42:01\",\"context\":\"浙江省杭州市萧山区东部公司(点击查询电话) 已揽收\",\"time\":\"2015-08-21 18:42:01\"}]";
			StringBuilder sb = new StringBuilder();
			sb.append(str); //　请求数据
			System.out.println(UtilMD5.MD5(sb));
		}
//		for (int i = 0; i < 100; i++) {
//			String str = "context\":\"浙江省杭州市萧山区东部公司 已打包\",\"time\":\"2015-08-21 20:21:36\"},{\"ftime\":\"2015-08-21 18:42:01\",\"context\":\"浙江省杭州市萧山区东部公司(点击查询电话) 已揽收\",\"time\":\"2015-08-21 18:42:01\"}]";
////			String str = "{\"limit\":100}";
//			String key = "aes$#@!123456";
//			String base64 = encrypt(str, key);
//			decrypt(base64, key);
////			System.out.println(base64);
////			System.out.println(decrypt("AwGUmj481eIiU5FyaF4g7IEJ1Ikx3fRtUjAKEVuzyREyakuaAYVJGrFOWgi7T82bdMAmqEAT2mpf9XU5xzkGR53jGtT5nP6lk+v17GesisbjjQ==", "123"));
//		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
