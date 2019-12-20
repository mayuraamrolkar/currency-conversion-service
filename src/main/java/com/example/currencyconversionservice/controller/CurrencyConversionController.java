package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.beans.ConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeServiceProxy proxy;

    //using hardcoded url
    @GetMapping(path="/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionBean convertedCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {

        Map<String,String> pathVariable= new HashMap<String,String>();
        pathVariable.put("from", from);
        pathVariable.put("to",to);

        ResponseEntity<ConversionBean> resEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",ConversionBean.class, pathVariable);
        ConversionBean bean=resEntity.getBody();
        if (bean!=null) {
            bean.setQuantity(quantity);
            bean.setCalculatedAmount(bean.getMultiple().multiply(bean.getQuantity()));
        }

        return bean;
    }

    //using feign client
    @GetMapping(path="/currency-conversion/feign/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionBean convertedCurrencyFaign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {
        ConversionBean bean=proxy.retrieveExchangeValue(from,to);
        if (bean!=null) {
            bean.setQuantity(quantity);
            bean.setCalculatedAmount(bean.getMultiple().multiply(bean.getQuantity()));
        }

        return bean;
    }

}
