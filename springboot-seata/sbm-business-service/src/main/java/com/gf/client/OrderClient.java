package com.gf.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class OrderClient {

    private final RestTemplate restTemplate;

    public void create(String userId, String commodityCode, int orderCount) {
        String url = "http://127.0.0.1:8082/api/order/debit?userId=" + userId + "&commodityCode=" + commodityCode + "&count=" + orderCount;
        try {
            restTemplate.getForEntity(url, Void.class);
        } catch (Exception e) {
            log.error("create url {} ,error:", url);
            throw new RuntimeException();
        }
    }
}
