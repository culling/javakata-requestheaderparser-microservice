package com.geneculling.javakata.api;

import java.util.Locale;

public interface RequestHeaderParserBuilder {
    RequestHeaderParserBuilder addLocale(Locale locale);
    RequestHeaderParserBuilder addIpAddress(String ipAddress);
    RequestHeaderParserBuilder addSoftware(String software);
    String build();
}
