package com.gf.controller;

import com.gf.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public void debit(@RequestParam String userId , @RequestParam BigDecimal orderMoney) {
        System.out.println("account XID " + RootContext.getXID());
        accountService.debit(userId , orderMoney);
    }

}
