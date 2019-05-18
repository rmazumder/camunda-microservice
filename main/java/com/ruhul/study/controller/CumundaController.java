package com.ruhul.study.controller;


import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.model.dmn.instance.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
//@RequestMapping("/order")
public class CumundaController {

    @Autowired
    ProcessEngine camunda;

    @RequestMapping(path="/order", method = RequestMethod.POST)
    public void placeOrder(String orderId, int amount){
        System.out.println("Starting the process");
        camunda.getRuntimeService().startProcessInstanceByKey("order", Variables.putValue("OrderId", orderId).putValue("amount", amount));
    }

    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public void confirmShipment(String orderId){
        camunda.getRuntimeService().createMessageCorrelation("Message_GoodsShipped") //
                .processInstanceVariableEquals("OrderId", orderId) //
                .setVariable("shipmentId", UUID.randomUUID().toString()) //
                .correlateWithResult();
    }
}
