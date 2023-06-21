package com.stefanini.tdd.services;

import com.stefanini.tdd.components.IOperacao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CalculadoraService {
   final IOperacao operacao;

   @Inject 
   public CalculadoraService(@Named("adicao") IOperacao operacao) {
        this.operacao = operacao;
    }
    
    public double calcula(double a, double b) {
        return operacao.calculate(a, b);
    }
}
