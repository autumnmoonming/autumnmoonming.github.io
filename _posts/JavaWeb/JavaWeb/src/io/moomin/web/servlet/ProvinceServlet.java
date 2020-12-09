package io.moomin.web.servlet;

import io.moomin.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        /*ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> all = provinceService.findAll();
        //序列化list为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(all);*/
        //调用service查询
        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        String allJson = provinceService.findAllJson();
        System.out.println(allJson);
        //响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(allJson);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}