package com.stefanini.tdd.components;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("subtracao")
public class Subtracao implements IOperacao {

    @Override
    public double calculate(double valorA, double valorB) {
        return valorA - valorB;
    }
}
