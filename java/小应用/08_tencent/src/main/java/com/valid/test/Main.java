package com.valid.test;

import com.qcloud.services.scf.runtime.events.APIGatewayProxyRequestEvent;

public class Main {
    public String mainHandler(APIGatewayProxyRequestEvent event) {
        return "Hello World!";
    }
}
