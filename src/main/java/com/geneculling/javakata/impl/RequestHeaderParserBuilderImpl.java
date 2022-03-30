package com.geneculling.javakata.impl;

import com.geneculling.javakata.api.RequestHeaderParserBuilder;
import com.google.gson.Gson;

import java.util.Locale;

public class RequestHeaderParserBuilderImpl implements RequestHeaderParserBuilder {
    private static final Gson GSON = new Gson();
    private Locale locale;
    private String ipAddress;
    private String software;

    public RequestHeaderParserBuilderImpl(){

    }

    public RequestHeaderParserBuilderImpl(Locale locale, String ipAddress, String software){
        this.locale = locale;
        this.ipAddress = ipAddress;
        this.software = software;
    }

    @Override
    public RequestHeaderParserBuilder addLocale(Locale locale) {
        return new RequestHeaderParserBuilderImpl(locale, this.ipAddress, this.software);
    }

    @Override
    public RequestHeaderParserBuilder addIpAddress(String ipAddress) {
        return new RequestHeaderParserBuilderImpl(this.locale, ipAddress, this.software);
    }

    @Override
    public RequestHeaderParserBuilder addSoftware(String software) {
        return new RequestHeaderParserBuilderImpl(this.locale, this.ipAddress, software);
    }

    @Override
    public String build() {
        String json = GSON.toJson(this, RequestHeaderParserBuilderImpl.class);
        return json;
    }
}
