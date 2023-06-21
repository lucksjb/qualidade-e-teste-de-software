package com.stefanini.tdd.services;

import com.stefanini.tdd.enums.OperacaoEnum;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculadoraServiceComStrategy {
    
    public double calcula(OperacaoEnum operacaoEnum, double valorA, double valorB) {
        return operacaoEnum.getOperacao().calculate(valorA, valorB);
    }
}
