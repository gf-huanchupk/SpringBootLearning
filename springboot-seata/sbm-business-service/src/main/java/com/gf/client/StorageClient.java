package com.gf.client;

import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class StorageClient {

    private final RestTemplate restTemplate;

    public void deduct(String commodityCode, int orderCount) {
        System.out.println("business to storage " + RootContext.getXID());
        String url = "http://127.0.0.1:8083/api/storage/deduct?commodityCode=" + commodityCode + "&count=" + orderCount;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            log.error("deduct url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }
}
