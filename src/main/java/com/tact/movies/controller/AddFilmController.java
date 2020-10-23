package com.tact.movies.controller;


import com.tact.movies.data.TypeSelectedData;
import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.AddFilmService;
import com.tact.movies.service.impl.AddFilmServiceImpl;
import com.tact.movies.utils.ResponseUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddFilmController")
public class AddFilmController extends HttpServlet {
    AddFilmService addFilmService = new AddFilmServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action){
            case "getSubClassData" :
                ToGetSubClassData(request,response);
                break;
            case "getTypeData":
                ToGetTypeData(request,response);
                break;
            case "addFilm":
                toAddFilm(request,response);
            default:
                break;
        }
    }

    private void toAddFilm(HttpServletRequest request, HttpServletResponse response) {
        String filmId = request.getParameter("filmId");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String onDecade = request.getParameter("onDecade");
        String status = request.getParameter("status");
        String resolution = request.getParameter("resolution");
        String typeName = request.getParameter("typeName");
        String typeId = request.getParameter("type_id");
        String actor = request.getParameter("actor");
        String locName = request.getParameter("locName");
        String loc_id = request.getParameter("loc_id");
        String plot = request.getParameter("plot");
        String isVip = request.getParameter("isVip");
    }


    private void ToGetSubClassData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cataLogId = request.getParameter("cataLogId");
        TypeSelectedData subClassData = addFilmService.getSubClassData(cataLogId);
        ResponseEntity responseEntity = null;
        try {
            responseEntity = ResponseEntity.success(200,"success",subClassData);
        }catch (Exception e){
            responseEntity = ResponseEntity.error(400, "error");
        }
        ResponseUtils.responseToJson(response,responseEntity);
    }

    private void ToGetTypeData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subClassId = request.getParameter("subClassId");
        TypeSelectedData typeData = addFilmService.getTypeData(subClassId);
        ResponseEntity responseEntity = null;
        try {
            responseEntity = ResponseEntity.success(200,"success",typeData);
        }catch (Exception e){
            responseEntity = ResponseEntity.error(400, "error");
        }
        ResponseUtils.responseToJson(response,responseEntity);
    }
}
