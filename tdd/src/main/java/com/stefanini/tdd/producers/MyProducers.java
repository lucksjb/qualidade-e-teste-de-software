package com.stefanini.tdd.producers;

import com.stefanini.tdd.components.Adicao;
import com.stefanini.tdd.components.Divisao;
import com.stefanini.tdd.components.Media;
import com.stefanini.tdd.components.Multiplicacao;
import com.stefanini.tdd.components.Subtracao;
import com.stefanini.tdd.services.CalculadoraService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

public class MyProducers {
    @ApplicationScoped

    @Produces
    @Named("multiplicacaoService")
    public CalculadoraService createMultiplicacaoService() {
        return new CalculadoraService(new Multiplicacao());
    }

    @Produces
    @Named("divisaoService")
    public CalculadoraService createDivisaoService() {
        return new CalculadoraService(new Divisao());
    }

    @Produces
    @Named("adicaoService")
    public CalculadoraService createAdicaoService() {
        return new CalculadoraService(new Adicao());
    }

    @Produces
    @Named("subtracaoService")
    public CalculadoraService createSubtracaoService() {
        return new CalculadoraService(new Subtracao());
    }

    @Produces
    @Named("mediaService")
    public CalculadoraService createMediaService() {
        return new CalculadoraService(new Media(new Adicao(), new Divisao()));
    }

    
}
