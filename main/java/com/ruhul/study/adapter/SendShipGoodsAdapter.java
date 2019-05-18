package com.ruhul.study.adapter;


import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@ConfigurationProperties
public class SendShipGoodsAdapter implements JavaDelegate {

    @Autowired
    ProcessEngine camunda;

    public void execute(DelegateExecution delegateExecution) throws Exception {
        String orderId = (String) delegateExecution.getVariable("orderId");

       delegateExecution.getVariableNames().forEach(System.out :: println);

        //amount
        //OrderId
        //paymentTransactionId

    }
}
