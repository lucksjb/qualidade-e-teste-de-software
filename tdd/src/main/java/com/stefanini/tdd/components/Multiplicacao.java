package com.stefanini.tdd.components;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("multiplicacao")
public class Multiplicacao implements IOperacao {

    @Override
    public double calculate(double valorA, double valorB) {
        return valorA * valorB;
    }
}
