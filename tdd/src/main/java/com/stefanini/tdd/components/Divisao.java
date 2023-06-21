package com.stefanini.tdd.components;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("divisao")
public class Divisao implements IOperacao {

    @Override
    public double calculate(double valorA, double valorB) {
        if (valorB == 0) {
            throw new IllegalArgumentException("valorB não pode ser zero em uma divisão ");
        }
        return valorA / valorB;
    }
}
