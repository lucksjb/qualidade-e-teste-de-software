package com.stefanini.tdd.enums;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import com.stefanini.tdd.components.Adicao;
import com.stefanini.tdd.components.Divisao;
import com.stefanini.tdd.components.IOperacao;
import com.stefanini.tdd.components.Media;
import com.stefanini.tdd.components.Multiplicacao;
import com.stefanini.tdd.components.Subtracao;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OperacaoEnumTest {
    @Test
    void quando_operacaoEnum_ADICAO_deve_retornar_Adicao() {
        IOperacao operacao = OperacaoEnum.ADICAO.getOperacao();
        assertInstanceOf(Adicao.class, operacao);
    }

    @Test
    void quando_operacaoEnum_SUBTRACAO_deve_retornar_Subtracao() {
        IOperacao operacao = OperacaoEnum.SUBTRACAO.getOperacao();
        assertInstanceOf(Subtracao.class, operacao);
    }

    @Test
    void quando_operacaoEnum_MULTIPLICACAO_deve_retornar_Multiplicacao() {
        IOperacao operacao = OperacaoEnum.MULTIPLICACAO.getOperacao();
        assertInstanceOf(Multiplicacao.class, operacao);
    }

    @Test
    void quando_operacaoEnum_DIVISAO_deve_retornar_Divisao() {
        IOperacao operacao = OperacaoEnum.DIVISAO.getOperacao();
        assertInstanceOf(Divisao.class, operacao);
    }

    @Test
    void quando_operacaoEnum_MEDIA_deve_retornar_Media() {
        IOperacao operacao = OperacaoEnum.MEDIA.getOperacao();
        assertInstanceOf(Media.class, operacao);
    }
}
