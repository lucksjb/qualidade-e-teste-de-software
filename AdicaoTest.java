package dependencies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EsqueletoTest {
    static Adicao adicao = new Adicao();

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
    void quando_chamar_calculate_com_valorA_10_e_valorB_20_deveRetornar_30() {
        // Triple A:
        // Arrange
        double valorA = 10;
        double valorB = 20;
        
        // Act
        var result = adicao.calculate(valorA, valorB);

        // Assert
        assertEquals(30.0, result);
    }

    @Test
    void quando_chamar_calculate_com_valorA_0_e_valorB_20_deveRetornar_30() {
        // Triple A:
        // Arrange
        double valorA = 0;
        double valorB = 20;

        // Act
        var result = adicao.calculate(valorA, valorB);

        // Assert
        assertEquals(20.0, result);
    }
}
