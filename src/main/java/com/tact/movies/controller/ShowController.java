package com.tact.movies.controller;

import com.tact.movies.entity.Film;
import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.ModifyService;
import com.tact.movies.service.impl.ModifyServiceImpl;
import com.tact.movies.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/film")
public class ShowController extends HttpServlet {
    ModifyService service = new ModifyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//        String id = "f39c979857a4c8c50157a9020fb8001d";

        Film film = service.ShowFilm(id);
        ResponseEntity<Film> responseEntity = null;
        try{
            responseEntity = ResponseEntity.success(film);
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        ResponseUtils.responseToJson(resp,responseEntity);
    }
}
