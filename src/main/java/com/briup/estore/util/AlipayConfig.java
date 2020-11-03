package com.briup.estore.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
    /**
     * 服务网关   沙箱环境都是这个
     */
    public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";
    
    /**
     * 应用id  后期可以替换成自己的id
     */
    public static String appId = "2016102700768970";
    
    /**
     *  用户私钥   后期替换成自己的私钥
     */
    public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCoRN4NKq2dBwEiqqwA4sf39p/07xdsQyAQVDl224w4kpnfktWuhqJDIhXtErEGM/Ui5WIk7Qm68/+XlCBvpZ9IYnZg4ykwJCX/nvCxr6KbqY2tbKDmO5xpVx1HDIeDkJOqQZ+Ai28e/efZtf41Rb7a7QdmBVEPpQyzJSbfKB0EapzS28DjDOm/7a9AqAZ7kj4eGX48s/VfNSGohk6PiCH537CP1NNGHgvqtOnRfqCrpgDaODsMkxDqug+lszJU4e/eIzaENnb48U65ZiCD7ZgDV/O04cD2rK4V/bgGaQyYNLt4UgVIU+QjZDO7lA6OAL0yIk92hYeVTMBobqW0FBYpAgMBAAECggEAJLfqcJsYiYSGxebSY9sY4c4qd4tY5CH9tDJ826frAElVVIk5Ib11WQruF+6VPJJH8tZ1RTOIhQhLhOso7NQKXwRFar0HNt8cf5xST6PQ6wDjzq0+qx7k8cO1utRMGfSJlIR/ZtCGbg/f8Q0arMtMa39/ts6AMtbEX69CvT2Gn3i9rCPereSBoqlW4xLAhohEk0Or5iqc21sqGaExH6KbNuv2Yd1z77Km1C8hXXCBFPPvnE6K4jI6Dts2/UQd6wQX+R/gnnyluX/Q7f/i9AyxL6tsVq6gUR/2/TVHcPz8Tjpu/fwifpZ0a5zIILD3D7f3GV9rlRTKQTalYu1oAtVggQKBgQDRemuWIdvq8uUHGMqmrcTe6C3yHr1BmQ7PqE9mt6QAGJbR844msrtj1mVc3yx7PjT1/DPGVg0tC36uhyWgw5UHWBzJrq+k3LcFCHxnJwW0pqNYv2uu6qMcDQ5rAY1Rlh31YPEn5j5dhfqZS9am+w5AP3pyzs4zj+w0tB7DUuIisQKBgQDNo47shIWoKGZyjZ6e/SLBzIiNf5FdeX91Vz4/2NOqj7moSNNFW1PKGAjsAfyI90cbzA9j0br2KkkKXP0/qzh7zstySY4e2TuoljVNYtrxDL/Yzes7RvGruDJ4mk4KQFpPSzeKgddR/DY272OeTXSl/Qv7b4TJwTr6oCjOz0vY+QKBgQCGv3XnbD5X4wj6SLNLBqqGLNopTia1xKwnXgA9ddG0Eh0qTr5ZHE24ShiH5jNpz7knpqTzZzUwjZ1ezSaiRE1gHQjfn1Py+9trDGthu1NLQon+s5ukN+DWUXu9z5DFM4hv6H0YCl6BsIZkB8m7PfGL2Il+wpMXzfPGbzr+sBkw8QKBgQCXhabwfA2IBIzIZ7WzbM5Jgo4zxQW1nKrgKXLC1N/SU6j3aQHTnyG0TdV1IVmVCq+oucm1QXrDnBDJxA8O9PjfsVaTVcOU03h0FoocBXVSHJTYCZME0JeOcmEuIHTUdOqWdtPsCRRBYtgHzojWwjfrfvNvR5LOnsT4mz62dGRs8QKBgCgIDSfPe7BL9wYyE2yR592geMCHBlS+poD1dGyrYxzy+J85vQ4Puqd57MAXVgmMX7+WmNcQRhuqsFn5dK4yVqiQ2OD63SQMjXSZk8USs/3kHzqDnSFeCqA1rDW+BkgfZHaBoTQKv+GgUs5xjAxokdxwCZlRztT+3hayZPqqUG72";
    
    /**
     *  发送数据的格式 目前只能为json
     */
    public static String format = "json";
    
    /**
     *  设置字符集编码 目前只能为utf-8
     */
    public static String charset = "utf-8";

    /**
     *  支付宝公钥 后期替换成自己的支付宝公钥
     */
    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    
    /**
     *  支付宝签名 目前是 RSA2
     */
    public static String signType = "RSA2";

    /**
     *  页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://192.168.110.128:8080/estore/return";
    
    public static AlipayClient getAlipayClient() {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, 
        		privateKey, format, charset, publicKey, signType);
        return alipayClient;
    }
    
    public static AlipayClient getAlipayClientGBK() {
    	// 获得初始化的AlipayClient
    	AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, 
    			privateKey, format, "GBK", publicKey, "RSA");
    	return alipayClient;
    }
}
