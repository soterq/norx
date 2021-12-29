package com.example.norx.bnm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/bnm")
public class BNMController {

    @GetMapping
    public List<Currency> getCurrency() throws IOException, InterruptedException {
        return MDCurrencyService.getCurrencyListFromToday();
    }

    @GetMapping
    public List<Currency> getCurrency(@PathVariable String date) throws IOException, InterruptedException {
        return MDCurrencyService.getHttpCurrencyList(date);
    }
}
