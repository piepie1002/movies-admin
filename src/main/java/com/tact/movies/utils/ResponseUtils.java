package com.tact.movies.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class ResponseUtils {
    public static final String CHARACTERE_NCODING_NAME = "UTF-8";
    public static final String CONTENT_TYPE_NAME ="application/json;charset=utf-8";
    public static void responseToJson(HttpServletResponse resp, Object object) throws IOException {
        //设置响应
        resp.setCharacterEncoding(CHARACTERE_NCODING_NAME);
        //如果服务器返回是json数据必须设置 application/json
        resp.setContentType(CONTENT_TYPE_NAME);
        resp.getWriter().println(JSONObject.toJSONString(object));
    }
}
