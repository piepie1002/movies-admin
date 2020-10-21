package com.tact.movies.controller;

import com.tact.movies.entity.Film;
import com.tact.movies.service.ModifyService;
import com.tact.movies.service.impl.ModifyServiceImpl;
import com.tact.movies.utils.ListData;
import com.tact.movies.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyController")
public class ModifyController extends HttpServlet {
    ModifyService service = new ModifyServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        String onDecade = req.getParameter("onDecade");
        String status = req.getParameter("status");
        String resolution = req.getParameter("resolution");
        String typeName = req.getParameter("typeName");
        String actor = req.getParameter("actor");
        String locName = req.getParameter("locName");
        String plot = req.getParameter("plot");
        Film film = new Film(id,actor,img,locName,name,onDecade,plot,resolution,status,typeName);
        int i = service.ModifyData(film);
        String str1 = "修改成功！";
        String str2 = "修改失败！";
        if(i>0){
            ResponseUtils.responseToJson(resp,str1);
        }else{
            ResponseUtils.responseToJson(resp,str2);
        }
    }
}
