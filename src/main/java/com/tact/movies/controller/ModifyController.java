package com.tact.movies.controller;

import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Decade;
import com.tact.movies.entity.Film;
import com.tact.movies.entity.Loc;
import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.ModifyService;
import com.tact.movies.service.impl.ModifyServiceImpl;
import com.tact.movies.utils.ListData;
import com.tact.movies.utils.ResponseUtils;
import com.tact.movies.utils.SortData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        String cateLogName = req.getParameter("cateLogName");
        String subClassName = req.getParameter("subClassName");
        String typeName = req.getParameter("typeName");
        String actor = req.getParameter("actor");
        String locName = req.getParameter("locName");
        String plot = req.getParameter("plot");
        Film film = new Film(id,actor,img,locName,name,onDecade,plot,resolution,status,cateLogName,subClassName,typeName);
        int i = service.ModifyData(film);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortData sortData = new SortData();
        List<Decade> decades = service.ShowDecade();
        List<Loc> locs = service.ShowLoc();
        List<CateLog> cateLogs = service.ShowCateLog();
        sortData.setDecades(decades);
        sortData.setLocs(locs);
        sortData.setCateLogs(cateLogs);

        ResponseEntity<SortData> responseEntity = null;
        try{
            responseEntity = ResponseEntity.success(sortData);
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        ResponseUtils.responseToJson(resp,responseEntity);
    }
}
