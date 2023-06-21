package com.stefanini.tdd.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CalculadoraResourceTest {

     @Nested
     @DisplayName("Executa os testes utilizando o strategy para criação da operação")
     class Calculate {
          @Test
          void quando_operacaoEnum_ADICAO_valorA_20_valorB_10_deveRetornar_30_com_statusCode_200() {
               given()
                         .when()
                         .headers("Content-Type", "application/json")
                         .basePath(RestPath.CALCULADORA)
                         .queryParam("valorA", 20)
                         .queryParam("valorB", 10)
                         .queryParam("operacaoEnum", "ADICAO")
                         .get(RestPath.CALCULATE)
                         .then()
                         .statusCode(HttpStatus.SC_OK)
                         .and()
                         .body(is("30.0"));
          }

          @Test
          void quando_operacaoEnum_SUBTRACAO_valorA_20_valorB_10_deveRetornar_10_com_statusCode_200() {
               given()
                         .when()
                         .headers("Content-Type", "application/json")
                         .basePath(RestPath.CALCULADORA)
                         .queryParam("valorA", 20)
                         .queryParam("valorB", 10)
                         .queryParam("operacaoEnum", "SUBTRACAO")
                         .get(RestPath.CALCULATE)
                         .then()
                         .statusCode(HttpStatus.SC_OK)
                         .and()
                         .body(is("10.0"));
          }

          @Test
          void quando_operacaoEnum_DIVISAO_valorA_20_valorB_10_deveRetornar_2_com_statusCode_200() {
               given()
                         .when()
                         .headers("Content-Type", "application/json")
                         .basePath(RestPath.CALCULADORA)
                         .queryParam("valorA", 20)
                         .queryParam("valorB", 10)
                         .queryParam("operacaoEnum", "DIVISAO")
                         .get(RestPath.CALCULATE)
                         .then()
                         .statusCode(HttpStatus.SC_OK)
                         .and()
                         .body(is("2.0"));
          }

          @Test
          void quando_operacaoEnum_MULTIPLICACAO_valorA_20_valorB_10_deveRetornar_200_com_statusCode_200() {
               given()
                         .when()
                         .headers("Content-Type", "application/json")
                         .basePath(RestPath.CALCULADORA)
                         .queryParam("valorA", 20)
                         .queryParam("valorB", 10)
                         .queryParam("operacaoEnum", "MULTIPLICACAO")
                         .get(RestPath.CALCULATE)
                         .then()
                         .statusCode(HttpStatus.SC_OK)
                         .and()
                         .body(is("200.0"));
          }

          @Test
          void quando_operacaoEnum_MEDIA_valorA_20_valorB_10_deveRetornar_15_com_statusCode_200() {
               given()
                         .when()
                         .headers("Content-Type", "application/json")
                         .basePath(RestPath.CALCULADORA)
                         .queryParam("valorA", 20)
                         .queryParam("valorB", 10)
                         .queryParam("operacaoEnum", "MEDIA")
                         .get(RestPath.CALCULATE)
                         .then()
                         .statusCode(HttpStatus.SC_OK)
                         .and()
                         .body(is("15.0"));
          }
     }

     @Test
     void quando_chamar_adicao_e_valorA_20_valorB_10_deveRetornar_30_com_statusCode_200() {
          given()
                    .when()
                    .headers("Content-Type", "application/json")
                    .basePath(RestPath.CALCULADORA)
                    .queryParam("valorA", 20)
                    .queryParam("valorB", 10)
                    .get(RestPath.ADICAO)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .and()
                    .body(is("30.0"));
     }

     @Test
     void quando_chamar_subtracao_e_valorA_20_valorB_10_deveRetornar_10_com_statusCode_200() {
          given()
                    .when()
                    .headers("Content-Type", "application/json")
                    .basePath(RestPath.CALCULADORA)
                    .queryParam("valorA", 20)
                    .queryParam("valorB", 10)
                    .get(RestPath.SUBTRACAO)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .and()
                    .body(is("10.0"));
     }

     @Test
     void quando_chamar_multiplicacao_e_valorA_20_valorB_10_deveRetornar_200_com_statusCode_200() {
          given()
                    .when()
                    .headers("Content-Type", "application/json")
                    .basePath(RestPath.CALCULADORA)
                    .queryParam("valorA", 20)
                    .queryParam("valorB", 10)
                    .get(RestPath.MULTIPLICACAO)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .and()
                    .body(is("200.0"));
     }

     @Test
     void quando_chamar_divisao_e_valorA_20_valorB_10_deveRetornar_2_com_statusCode_200() {
          given()
                    .when()
                    .headers("Content-Type", "application/json")
                    .basePath(RestPath.CALCULADORA)
                    .queryParam("valorA", 20)
                    .queryParam("valorB", 10)
                    .get(RestPath.DIVISAO)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .and()
                    .body(is("2.0"));
     }

     @Test
     void quando_chamar_media_e_valorA_20_valorB_10_deveRetornar_15_com_statusCode_200() {
          given()
                    .when()
                    .headers("Content-Type", "application/json")
                    .basePath(RestPath.CALCULADORA)
                    .queryParam("valorA", 20)
                    .queryParam("valorB", 10)
                    .get(RestPath.MEDIA)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .and()
                    .body(is("15.0"));
     }
}
