package com.geneculling.javakata.api;

public interface RequestHeaderParserBuilder {
    RequestHeaderParserBuilder addLanguage(String language);
    RequestHeaderParserBuilder addIpAddress(String ipAddress);
    RequestHeaderParserBuilder addSoftware(String software);
    String build();
}
