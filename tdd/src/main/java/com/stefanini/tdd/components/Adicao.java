package com.stefanini.tdd.components;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("adicao")
public class Adicao implements IOperacao {
    
    @Override
    public double calculate(double valorA, double valorB) {
        return valorA + valorB ;
    }
}
