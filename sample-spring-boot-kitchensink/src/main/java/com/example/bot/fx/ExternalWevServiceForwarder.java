package com.example.bot.fx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ExternalWevServiceForwarder {

    public double getQuote(String baseCcy, String counterCcy) {
        RestTemplate restTemplate = new RestTemplate();
        FxQuote quote = restTemplate.getForObject("http://api.fixer.io/latest?base=" + baseCcy, FxQuote.class);

        log.info(quote.toString());
        log.info(String.valueOf(quote.getRate(counterCcy)));
        return quote.getRate(counterCcy);
    }


}
