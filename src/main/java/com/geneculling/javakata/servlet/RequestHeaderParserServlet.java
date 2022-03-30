package com.geneculling.javakata.servlet;

import com.geneculling.javakata.api.RequestHeaderParserBuilder;
import com.geneculling.javakata.impl.RequestHeaderParserBuilderImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class RequestHeaderParserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Locale locale = request.getLocale();
        String ipAddress = request.getRemoteAddr();
        String software = request.getHeader("User-Agent");

        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLocale(locale)
                .addIpAddress(ipAddress)
                .addSoftware(software)
                .build();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("[\"Hello\"]");
        response.flushBuffer();
    }
}
