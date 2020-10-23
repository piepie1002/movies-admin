package com.tact.movies.controller;

import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.TelService;
import com.tact.movies.service.impl.TelServiceImpl;
import com.tact.movies.utils.ResponseUtils;
import com.tact.movies.utils.SortData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/tel")
public class TelPlayController extends HttpServlet {
    TelService telService =new TelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortData data = telService.getTel();
        ResponseEntity<SortData> entity = null;
        try {
             entity = ResponseEntity.success(data);
        }
        catch (Exception e){
            entity = ResponseEntity.error();
        }
        ResponseUtils.responseToJson(resp,entity);
    }
}
