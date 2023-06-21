package com.stefanini.tdd.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DivisaoTest {
    @Inject
    @Named("divisao")
    IOperacao divisao;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Antes de iniciar a execução dos testes da classe da classe");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Após terminar executar todos os testes da classe");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Antes de cada teste da classe ");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Após cada teste da classe ");
    }

    @Test
    void quando_valorB_igual_zero_deveLancar_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    divisao.calculate(10, 0);
                });
    }

    @Test
    void quando_valorA_igual_30_E_valorB_igual_10_deveRetornar_3() {
        var result = divisao.calculate(30, 10);
        assertEquals(3D, result);

    }
}
