package com.geneculling.javakata.impl;

import com.geneculling.javakata.api.RequestHeaderParserBuilder;
import com.google.gson.Gson;


public class RequestHeaderParserBuilderImpl implements RequestHeaderParserBuilder {
    private static final Gson GSON = new Gson();
    private String language;
    private String ipAddress;
    private String software;

    public RequestHeaderParserBuilderImpl(){

    }

    public RequestHeaderParserBuilderImpl(String language, String ipAddress, String software){
        this.language = language;
        this.ipAddress = ipAddress;
        this.software = software;
    }

    @Override
    public RequestHeaderParserBuilder addLanguage(String language) {
        return new RequestHeaderParserBuilderImpl(language, this.ipAddress, this.software);
    }

    @Override
    public RequestHeaderParserBuilder addIpAddress(String ipAddress) {
        return new RequestHeaderParserBuilderImpl(this.language, ipAddress, this.software);
    }

    @Override
    public RequestHeaderParserBuilder addSoftware(String software) {
        return new RequestHeaderParserBuilderImpl(this.language, this.ipAddress, software);
    }

    @Override
    public String build() {
        String json = GSON.toJson(this, RequestHeaderParserBuilderImpl.class);
        return json;
    }
}
