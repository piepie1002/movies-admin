package com.tact.movies.controller;

import com.tact.movies.resp.ResponseEntity;
import com.tact.movies.service.SortService;
import com.tact.movies.service.impl.SortServiceImpl;
import com.tact.movies.utils.PageBean;
import com.tact.movies.utils.ResponseUtils;
import com.tact.movies.utils.SortData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LIN
 * @since JDK 1.8
 */
@WebServlet("/sort")
public class SortController extends HttpServlet {
    private final SortService sortService = new SortServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前页
        String curPage = req.getParameter("curPage");
        PageBean pageBean = sortService.getPageBean("1");
        SortData sortData = sortService.getSortDate(pageBean);
        ResponseEntity<SortData>entity;
        try {
            entity = ResponseEntity.success(sortData);
        }catch (Exception e){
            entity=ResponseEntity.error();
        }
        ResponseUtils.responseToJson(resp,entity);
    }
    
}
