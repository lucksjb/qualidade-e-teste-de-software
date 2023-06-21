package com.stefanini.tdd.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MediaTest {
    @Inject
    @Named("media")
    IOperacao media;

    @Inject
    @Named("adicao")
    Adicao adicaoMock;

    @Inject
    @Named("divisao")
    Divisao divisaoMock;

    @Test
    void quando_valorA_igual_20_E_valorB_igual_30_deveRetornar_25() {
        adicaoMock = mock(Adicao.class);
        QuarkusMock.installMockForType(adicaoMock, Adicao.class);

        divisaoMock = mock(Divisao.class);
        QuarkusMock.installMockForType(divisaoMock, Divisao.class);

        doReturn(50D)
                .when(adicaoMock)
                .calculate(anyDouble(), anyDouble());

        doReturn(25D)
                .when(divisaoMock)
                .calculate(anyDouble(), anyDouble());
        var result = media.calculate(20D, 30D);
        assertEquals(25D, result);
    }
}
