package com.valid.admin;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "docker") // endpoint的名字
public class MyEndpoint {

    @ReadOperation
    public Map<String, String> getDockerInfo() {
        return Collections.singletonMap("start", "up");
    }

    @WriteOperation
    public void stopDocker() {
        System.out.println("docker stopped");
    }
}
