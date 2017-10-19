package com.example.bot.fx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ExternalWebServiceForwarder {

    public double getQuote(String baseCcy, String counterCcy) {
        RestTemplate restTemplate = new RestTemplate();
        log.info("DEBUG: url: " + "http://api.fixer.io/latest?base=" + baseCcy);
        //
        FxQuote quote = restTemplate.getForObject("http://api.fixer.io/latest?base=" + baseCcy, FxQuote.class);

        log.info("DEBUG: print quote:" + quote.toString());
        log.info(String.valueOf(quote.getRate(counterCcy)));
        return quote.getRate(counterCcy);
    }


}
