package cn.xinmeng.common.util.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES加密解密工具包
 */
public class AES128Utils {

    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;
    private static final int CACHE_SIZE = 1024;
    
    /**
     * 生成随机密钥
     * @return
     * @throws Exception
     */
    public static String getSecretKey() throws Exception {
        return getSecretKey(null);
    }
    
    /**
     * 生成密钥
     * @param seed 密钥种子
     * @return
     * @throws Exception
     */
    public static String getSecretKey(String seed) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(seed.getBytes());
        keyGenerator.init(KEY_SIZE, random); 
        SecretKey secretKey = keyGenerator.generateKey(); 
        return Base64Utils.encode(secretKey.getEncoded());
    }
    
    /**
     * 加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Key k = toKey(Base64Utils.decode(key));
        byte[] raw = k.getEncoded(); 
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM); 
        Cipher cipher = Cipher.getInstance(ALGORITHM); 
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }
    
    /**
     * 文件加密
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static void encryptFile(String key, String sourceFilePath, String destFilePath) throws Exception {
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath); 
        if (sourceFile.exists() && sourceFile.isFile()) {
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            destFile.createNewFile();
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(destFile);
            Key k = toKey(Base64Utils.decode(key));
            byte[] raw = k.getEncoded(); 
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM); 
            Cipher cipher = Cipher.getInstance(ALGORITHM); 
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            CipherInputStream cin = new CipherInputStream(in, cipher);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = cin.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
            out.close();
            cin.close();
            in.close();
        }
    }
    
    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Key k = toKey(Base64Utils.decode(key));
        byte[] raw = k.getEncoded(); 
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM); 
        Cipher cipher = Cipher.getInstance(ALGORITHM); 
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }
    
    /**
     * 文件解密
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static void decryptFile(String key, String sourceFilePath, String destFilePath) throws Exception {
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath); 
        if (sourceFile.exists() && sourceFile.isFile()) {
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            destFile.createNewFile();
            FileInputStream in = new FileInputStream(sourceFile);
            FileOutputStream out = new FileOutputStream(destFile);
            Key k = toKey(Base64Utils.decode(key));
            byte[] raw = k.getEncoded(); 
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM); 
            Cipher cipher = Cipher.getInstance(ALGORITHM); 
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            CipherOutputStream cout = new CipherOutputStream(out, cipher);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = in.read(cache)) != -1) {
                cout.write(cache, 0, nRead);
                cout.flush();
            }
            cout.close();
            out.close();
            in.close();
        }
    }
    
    /**
     * 转换密钥
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
        return secretKey;
    }
    
    public static void main(String[] args) throws Exception {
    	 String str="加密AES";  
         System.out.println("原文："+str);
         String key = getSecretKey("123456");
         System.out.println("密钥："+key);
         byte[] ss = encrypt(str.getBytes(), key);
//         System.out.println("加密后："+Ba);
         System.out.println("解密后："+new String(decrypt(ss, key)));
         
	}
}
