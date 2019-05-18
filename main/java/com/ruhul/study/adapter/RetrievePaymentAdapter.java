package com.ruhul.study.adapter;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class RetrievePaymentAdapter implements JavaDelegate {
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("*******************Retrievepayment adapter called");
        delegateExecution.setVariable("paymentTransactionId","TC2121");
    }
}
