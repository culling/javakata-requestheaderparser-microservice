package com.geneculling.javakata.impl;

import com.geneculling.javakata.api.RequestHeaderParserBuilder;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class RequestHeaderParserBuilderImplTest {

    @Test
    public void addLocale_1() {
        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLocale(Locale.ENGLISH)
                .addIpAddress("10.1.1.1")
                .addSoftware("browser and os")
                .build();
        assertEquals("{\"locale\":\"en\",\"ipAddress\":\"10.1.1.1\",\"software\":\"browser and os\"}", json);
    }

    @Test
    public void addLocale_2() {
        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLocale(Locale.FRANCE)
                .addIpAddress("10.1.1.1")
                .addSoftware("browser and os")
                .build();
        assertEquals("{\"locale\":\"fr_FR\",\"ipAddress\":\"10.1.1.1\",\"software\":\"browser and os\"}", json);
    }

    @Test
    public void addIpAddress() {
        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLocale(Locale.ENGLISH)
                .addIpAddress("10.1.1.254")
                .addSoftware("browser and os")
                .build();
        assertEquals("{\"locale\":\"en\",\"ipAddress\":\"10.1.1.254\",\"software\":\"browser and os\"}", json);
    }

    @Test
    public void addSoftware() {
        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLocale(Locale.ENGLISH)
                .addIpAddress("10.1.1.1")
                .addSoftware("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0")
                .build();
        assertEquals("{\"locale\":\"en\",\"ipAddress\":\"10.1.1.1\",\"software\":\"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0\"}", json);
    }

    @Test
    public void build() {
        RequestHeaderParserBuilder requestHeaderParserBuilder = new RequestHeaderParserBuilderImpl();
        String json = requestHeaderParserBuilder
                .addLocale(Locale.ENGLISH)
                .addIpAddress("10.1.1.1")
                .addSoftware("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0")
                .build();
        assertEquals("{\"locale\":\"en\",\"ipAddress\":\"10.1.1.1\",\"software\":\"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0\"}", json);
    }
}