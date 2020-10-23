package com.tact.movies.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/UploadController")
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            upload(req,resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    private void upload(HttpServletRequest req, HttpServletResponse resp) throws FileUploadException, IOException, FileUploadException {
        //1.创建一个磁盘工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.通过工厂创建上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3.通过上传对象来解析请求
        List<FileItem> list = upload.parseRequest(req);
        //4.遍历集合
        for (FileItem fileItem:list) {
            //5.判断是否非表单文本文件
            if(!fileItem.isFormField()){
                //6.通过请求获取输入流
                InputStream is = fileItem.getInputStream();
                //E:\\out\\Upload_Download\\images
                //getServletContext().getRealPath()获取部署项目的绝对路径
                String path = getServletContext().getRealPath("public/static/upload/filmPic");
                File file = new File(path);
                if(!file.exists()){
                    file.mkdirs();
                }
                //指定文件拷贝路径
                FileOutputStream fos = new FileOutputStream(new File(path, fileItem.getName()));
                IOUtils.copy(is,fos);
                is.close();
                fos.close();
            }
        }
    }
}

