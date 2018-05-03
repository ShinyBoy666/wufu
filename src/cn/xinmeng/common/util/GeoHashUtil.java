package cn.xinmeng.common.util;

import java.util.BitSet;
import java.util.HashMap;

import com.spatial4j.core.io.GeohashUtils;

public class GeoHashUtil {
	
	/** 地球半径  */
	static double EARTH_RADIUS = 6370996.81;
	
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}
	
	/**
	 * 得到已知两个坐标的距离
	 * @param lat1 纬度1 
	 * @param lng1 经度1
	 * @param lat2 纬度2
	 * @param lng2 经度2
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}
	
	/**
     * 获取给定经纬度和半径距离的经纬度范围
     * @param lat 纬度
     * @param lon 经度
     * @param raidus 单位:m
     * @return 数组 minLng, minLat, maxLng, maxLat
     */
    public static double[] getAround(double lon, double lat, int radius) {
        Double latitude = lat;
        Double longitude = lon;
 
        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = radius;
 
        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;
 
        Double mpdLng = Math.abs(degree * Math.cos(latitude * (Math.PI / 180)));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        // (lng BETWEEN #{c.minLng} AND #{c.maxLng}) AND (lat BETWEEN #{c.minLat} AND #{c.maxLat})
//        SELECT longitude,latitude,
//        ROUND(6378.138*2*ASIN(SQRT(POW(SIN((22.299439*PI()/180-latitude*PI()/180)/2),2)+COS(22.299439*PI()/180)*COS(latitude*PI()/180)*POW(SIN((114.173881*PI()/180-longitude*PI()/180)/2),2)))*1000)
//        AS
//         juli
//        FROM s_shop_info
//        ORDER BY juli DESC
        return new double[] { minLng, minLat, maxLng, maxLat };
    }
    
    private static int numbits = 6 * 5;
    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            					   '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p',
                                   'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
 
    final static HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
    static {
        int i = 0;
        for (char c : digits) {
            lookup.put(c, i++);
        }
    }
 
    public static void main(String[] args) {
//        double[] latlon = decode("uzururcpyzvp");
//        System.out.println(latlon[0] + " " + latlon[1]);
// 
//        String s = encode(116.404, 39.915);
//        System.out.println(s);
//        latlon = decode(s);
//        System.out.println(latlon[0] + " " + latlon[1]);
//        //DecimalFormat df = new DecimalFormat("0.00000");
//        //System.out.println(df.format(latlon[0]) + ", " + df.format(latlon[1]));
//        System.out.println(GeohashUtils.encodeLatLon(116.404, 39.915,5));
    	
    	  double lng1 = 117.10156050396506;
    	  double lat1 = 39.12835580850143;
    	  double lng2 = 117.09607822580763;
    	  double lat2 = 39.014446251230325;
    	  System.out.println(getDistance(lng1, lat1, lng2, lat2));
    }
 
    /**
     * 将Geohash字串解码成经纬值
     * 
     * @param geohash 待解码的Geohash字串
     * @return 经纬值数组
     */
    public static double[] decode(String geohash) {
        StringBuilder buffer = new StringBuilder();
        for (char c : geohash.toCharArray()) {
            int i = lookup.get(c) + 32;
            buffer.append(Integer.toString(i, 2).substring(1));
        }
 
        BitSet lonset = new BitSet();
        BitSet latset = new BitSet();
 
        // even bits
        int j = 0;
        for (int i = 0; i < numbits * 2; i += 2) {
            boolean isSet = false;
            if (i < buffer.length())
                isSet = buffer.charAt(i) == '1';
            lonset.set(j++, isSet);
        }
 
        // odd bits
        j = 0;
        for (int i = 1; i < numbits * 2; i += 2) {
            boolean isSet = false;
            if (i < buffer.length())
                isSet = buffer.charAt(i) == '1';
            latset.set(j++, isSet);
        }
 
        double lat = decode(latset, -90, 90);
        double lon = decode(lonset, -180, 180);
//        DecimalFormat df = new DecimalFormat("0.00000");
//        return new double[] { Double.parseDouble(df.format(lat)), Double.parseDouble(df.format(lon)) };
        
        
//        中国地理坐标：东经73°至东经135°，北纬4°至北纬53°
//        double lon = decode(lonset, 70, 140);
//        double lat = decode(latset, 0, 60);
        return new double[] {lat, lon};  
    }
 
    /**
     * 根据二进制编码串和指定的数值变化范围，计算得到经/纬值
     * 
     * @param bs 经/纬二进制编码串
     * @param floor 下限
     * @param ceiling 上限
     * @return 经/纬值
     */
    private static double decode(BitSet bs, double floor, double ceiling) {
        double mid = 0;
        for (int i = 0; i < bs.length(); i++) {
            mid = (floor + ceiling) / 2;
            if (bs.get(i))
                floor = mid;
            else
                ceiling = mid;
        }
        return mid;
    }
    
    /**
     * 根据经纬值得到Geohash字串
     * 
     * @param lat 纬度值
     * @param lon 经度值
     * @return Geohash字串
     */
    public static String encode(double lat, double lon) {
        BitSet latbits = getBits(lat, -90, 90);
        BitSet lonbits = getBits(lon, -180, 180);
//        BitSet latbits = getBits(lat, 0, 60);
//        BitSet lonbits = getBits(lon, 70, 140);
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < numbits; i++) {
            buffer.append((lonbits.get(i)) ? '1' : '0');
            buffer.append((latbits.get(i)) ? '1' : '0');
        }
        return base32(Long.parseLong(buffer.toString(), 2));
    }
    
    /**
     * 将二进制编码串转换成Geohash字串
     * 
     * @param i 二进制编码串
     * @return Geohash字串
     */
    public static String base32(long i) {
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (i < 0);
        if (!negative)
            i = -i;
        while (i <= -32) {
            buf[charPos--] = digits[(int) (-(i % 32))];
            i /= 32;
        }
        buf[charPos] = digits[(int) (-i)];
 
        if (negative)
            buf[--charPos] = '-';
        return new String(buf, charPos, (65 - charPos));
    }
    
    /**
     * 得到经/纬度对应的二进制编码
     * 
     * @param lat 经/纬度
     * @param floor 下限
     * @param ceiling 上限
     * @return 二进制编码串
     */
    private static BitSet getBits(double lat, double floor, double ceiling) {
        BitSet buffer = new BitSet(numbits);
        for (int i = 0; i < numbits; i++) {
            double mid = (floor + ceiling) / 2;
            if (lat >= mid) {
                buffer.set(i);
                floor = mid;
            } else {
                ceiling = mid;
            }
        }
        return buffer;
    }
}
