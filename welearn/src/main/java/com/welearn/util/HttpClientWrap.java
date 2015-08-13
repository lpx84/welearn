package com.welearn.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Created by yanggch on 2015/6/11.
 */
public class HttpClientWrap {
   public String httpGetRequest(String url){

        try {
            HttpClient httpclient = new HttpClient();
            GetMethod method = new GetMethod(url);
            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));

            int statusCode = httpclient.executeMethod(method);
            if (statusCode == 200) {
                return  parseInputStream(method.getResponseBodyAsStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String httpPostRequest(String url,Map<String,String> parameters){

        try {
            HttpClient httpclient = new HttpClient();
            PostMethod method = new PostMethod(url);
            method.setRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded; charset=UTF-8");
            method.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36");

            for(String key:parameters.keySet()) {
                method.addParameter(key,parameters.get(key));
            }

            int statusCode = httpclient.executeMethod(method);
            if (statusCode == 200) {
                return  parseInputStream(method.getResponseBodyAsStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String postResponseNative(String url,String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }


    public void writeJsonResponse(HttpServletResponse response, String json) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(json);
    }

    public void writeXMLResponse(HttpServletResponse response, String xml) throws Exception {
        response.setContentType("application/xml");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(xml);
    }

    public void writeResponse(HttpServletResponse response, String value) throws Exception {
        System.out.println("response text : " + value);
        response.getWriter().print(value);
    }

    public String parseInputStream(InputStream is) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder respongseContext = new StringBuilder();

        while ((line = rd.readLine()) != null) {
            respongseContext.append(line).append("\n");
        }
        rd.close();
        if (respongseContext.length() > 0) {
            respongseContext.deleteCharAt(respongseContext.length() - 1);
        }
        return respongseContext.toString();
    }
}
