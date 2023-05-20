package com.templates.springapiserver.constant;

import java.time.ZoneOffset;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonConstants {

    public static final String RESPONSE_DATE_TIME_FORMAT = "yyyy-MM-dd EEE HH:mm:ss";
    public static final ZoneOffset DEFAULT_SERVER_ZONE_OFFSET = ZoneOffset.UTC;
}
