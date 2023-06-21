package com.stefanini.tdd.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.stefanini.tdd.enums.OperacaoEnum;
import com.stefanini.tdd.services.CalculadoraService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path(RestPath.CALCULADORA)
@Tag(name = "calculadora resource", description = "permite fazer varias operações")
public class CalculadoraResource {

        @Inject
        @Named("adicaoService")
        private CalculadoraService adicaoService;

        @Inject
        @Named("subtracaoService")
        private CalculadoraService subtracaoService;

        @Inject
        @Named("multiplicacaoService")
        private CalculadoraService multiplicacaoService;

        @Inject
        @Named("divisaoService")
        private CalculadoraService divisaoService;

        @Inject
        @Named("mediaService")
        private CalculadoraService mediaService;

        @GET
        @Path(RestPath.CALCULATE)
        @Operation( //
                        summary = "permite fazer calculos", //
                        description = "Utilizando Strategy pattern "//
        )
        @APIResponse( //
                        responseCode = "200", //
                        description = "retorna o valor calculado", //
                        content = @Content(mediaType = MediaType.APPLICATION_JSON) //
        )
        public Response calculate(@QueryParam("operacaoEnum") OperacaoEnum operacaoEnum,
                        @QueryParam("valorA") double valorA,
                        @QueryParam("valorB") double valorB) {

                var operacao = operacaoEnum.getOperacao();

                return Response.ok(operacao.calculate(valorA, valorB)).build(); // Response.ok(operacao.calculate(valorA,
                                                                                // valorB)).build();
        }

        @GET
        @Path(RestPath.ADICAO)
        @Operation( //
                        summary = "Adição", //
                        description = "soma valorA + valorB"//
        )
        @APIResponse( //
                        responseCode = "200", //
                        description = "retorna o valorA + valorB ", //
                        content = @Content(mediaType = MediaType.APPLICATION_JSON) //
        )
        public Response adicao(@QueryParam("valorA") double valorA,
                        @QueryParam("valorB") double valorB) {

                return Response.ok(adicaoService.calcula(valorA, valorB)).build();
        }

        @GET
        @Path(RestPath.SUBTRACAO)
        @Operation( //
                        summary = "Subtração", //
                        description = "subtrai valorB do valorA"//
        )
        @APIResponse( //
                        responseCode = "200", //
                        description = "retorna o valorA - valorB ", //
                        content = @Content(mediaType = MediaType.APPLICATION_JSON) //
        )
        public Response subtracao(@QueryParam("valorA") double valorA,
                        @QueryParam("valorB") double valorB) {

                return Response.ok(subtracaoService.calcula(valorA, valorB)).build();
        }

        @GET
        @Path(RestPath.MULTIPLICACAO)
        @Operation( //
                        summary = "multiplicação", //
                        description = "multiplica valorA pelo valorB"//
        )
        @APIResponse( //
                        responseCode = "200", //
                        description = "retorna o valorA x valorB ", //
                        content = @Content(mediaType = MediaType.APPLICATION_JSON) //
        )
        public Response multiplicacao(@QueryParam("valorA") double valorA,
                        @QueryParam("valorB") double valorB) {

                return Response.ok(multiplicacaoService.calcula(valorA, valorB)).build();
        }

        @GET
        @Path(RestPath.DIVISAO)
        @Operation( //
                        summary = "divisão", //
                        description = "divide valorA pelo valorB"//
        )
        @APIResponse( //
                        responseCode = "200", //
                        description = "retorna o valorA / valorB ", //
                        content = @Content(mediaType = MediaType.APPLICATION_JSON) //
        )
        public Response divisao(@QueryParam("valorA") double valorA,
                        @QueryParam("valorB") double valorB) {

                return Response.ok(divisaoService.calcula(valorA, valorB)).build();
        }

        @GET
        @Path(RestPath.MEDIA)
        @Operation( //
                        summary = "média", //
                        description = "(soma valorA +  valorB) e divide o resultado por 2 "//
        )
        @APIResponse( //
                        responseCode = "200", //
                        description = "retorna a média do valorA + valorB ", //
                        content = @Content(mediaType = MediaType.APPLICATION_JSON) //
        )
        public Response media(@QueryParam("valorA") double valorA,
                        @QueryParam("valorB") double valorB) {

                return Response.ok(mediaService.calcula(valorA, valorB)).build();
        }
}
