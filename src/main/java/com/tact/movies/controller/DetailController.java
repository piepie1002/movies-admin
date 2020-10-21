package com.tact.movies.controller;

import com.tact.movies.entity.Film;
import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.DetailService;
import com.tact.movies.service.impl.DetailServiceImpl;
import com.tact.movies.utils.ResponseUtils;
import com.tact.movies.utils.SortData;
import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("detail")
public class DetailController extends HttpServlet {
    DetailService detailService =new DetailServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filmId = req.getParameter("filmId");
        Film film = detailService.getDetail(filmId);
        ResponseEntity<Film> entity =null;
       try {
           entity =ResponseEntity.success(film);
       }catch (Exception e){
           entity =ResponseEntity.error();
       }
       ResponseUtils.responseToJson(resp,entity);

    }
}
