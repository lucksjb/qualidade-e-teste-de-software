package com.stefanini.tdd.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import com.stefanini.tdd.components.Adicao;
import com.stefanini.tdd.components.Divisao;
import com.stefanini.tdd.components.IOperacao;
import com.stefanini.tdd.components.Media;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CalculadoraServiceTest {

    @Test
    void quando_calcular_Media_10_8_deveRetornar_9() {
        Adicao adicao = new Adicao();
        Divisao divisao = new Divisao();

        IOperacao media = new Media(adicao, divisao);
        CalculadoraService calculadoraService = new CalculadoraService(media);
        var result = calculadoraService.calcula(10, 20);
        assertEquals(15D, result);
    }

    @Test
    void quando_calcular_Media_10_8_deveRetornar_9_mocando_adicao() {
        Adicao adicaoMock = mock(Adicao.class);
        doReturn(40D)
                .when(adicaoMock)
                .calculate(anyDouble(), anyDouble());
        Divisao divisao = new Divisao();

        IOperacao media = new Media(adicaoMock, divisao);
        CalculadoraService calculadoraService = new CalculadoraService(media);
        var result = calculadoraService.calcula(10, 20);
        assertEquals(20D, result);
    }
}
