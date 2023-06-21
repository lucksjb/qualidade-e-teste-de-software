package com.stefanini.tdd.components;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named("media")
public class Media implements IOperacao {
    final Adicao adicao;
    final Divisao divisao;

    @Inject
    public Media(Adicao adicao, Divisao divisao) {
        this.adicao = adicao;
        this.divisao = divisao;
    }

    @Override
    public double calculate(double valorA, double valorB) {
        var resultadoAdicao = adicao.calculate(valorA, valorB);
        return divisao.calculate(resultadoAdicao, 2);
    }
}
