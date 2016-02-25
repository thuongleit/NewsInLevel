package com.thuongleit.collectandupdate.config;

import java.util.Arrays;
import java.util.List;

public interface Constant {
    String PARSE_SERVICE_ENDPOINT = "http://www.kimonolabs.com/api/ondemand/";

    List<String> CATALOGS = Arrays.asList("news", "sport", "nature", "interesting", "funny", "information", "exercises");
    List<String> CATALOG_CODE = Arrays.asList("productscbm_153609", "productscbm_368418", "productscbm_444255", "productscbm_695892", "productscbm_466005", "productscbm_74952", "productscbm_629653", "productscbm_430421");
}
