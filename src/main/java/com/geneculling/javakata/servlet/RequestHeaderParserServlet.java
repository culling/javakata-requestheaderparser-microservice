package com.geneculling.javakata.servlet;

import com.geneculling.javakata.api.RequestHeaderParserBuilder;
import com.geneculling.javakata.impl.RequestHeaderParserBuilderImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestHeaderParserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String language = request.getHeader("Accept-Language");
        String ipAddress = request.getRemoteAddr();
        String software = request.getHeader("User-Agent");

        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLanguage(language)
                .addIpAddress(ipAddress)
                .addSoftware(software)
                .build();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.flushBuffer();
    }
}
