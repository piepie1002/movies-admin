package com.tact.movies.utils;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class PageBean<T> {
    private List<T>dataList; //当前页列表数据
    private int firstPage=1;   //首页
    private int prePage;     //上一页
    private int curPage;     //当前页
    private int nextPage;    //下一页
    private int totalPage;   // 总页数,末页
    private int count;       // 总条数
    private int pageSize;    //每页大小

    public PageBean() {
    }

    public PageBean(List<T> dataList, int firstPage, int prePage, int curPage, int nextPage, int totalPage, int count, int pageSize) {
        this.dataList = dataList;
        this.firstPage = firstPage;
        this.prePage = prePage;
        this.curPage = curPage;
        this.nextPage = nextPage;
        this.totalPage = count%pageSize ==0?count/pageSize:count/pageSize+1;
        this.count = count;
        this.pageSize = pageSize;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getFirstPage() {
        return firstPage;
    }
    

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }
    //设置总条数
    public void setCount(int count) {
        this.count = count;
        //设置总页数
        if (this.pageSize>0 && count>0){
            this.totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }
    //设置每页展示的数据 --先设置总条数,再设置每页展示的数据
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (this.pageSize>0 && count>0){
            this.totalPage= count%pageSize==0?count/pageSize:count/pageSize+1;
        }
    }
}
