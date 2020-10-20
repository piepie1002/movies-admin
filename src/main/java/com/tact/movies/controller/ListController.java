package com.tact.movies.controller;


import com.tact.movies.entity.Film;
import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.ListService;
import com.tact.movies.service.impl.ListServiceImpl;
import com.tact.movies.utils.ListData;
import com.tact.movies.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")

public class ListController extends HttpServlet {
    private ListService service = new ListServiceImpl();
    ListService listService = new ListServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ListData listData = service.getListData();
        ResponseEntity<ListData> responseEntity = null;
        try{
            responseEntity = ResponseEntity.success(listData);
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        ResponseUtils.responseToJson(resp,responseEntity);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "find":
                String name = req.getParameter("name");
//                String name = "自杀小队";
                Film filmData = listService.getFilmData(name);
                ResponseEntity<Film> responseEntity = null;
                try{
                    responseEntity = ResponseEntity.success(filmData);
                }catch (Exception e){
                    responseEntity = ResponseEntity.error();
                }
                ResponseUtils.responseToJson(resp,responseEntity);
        }
    }
}
