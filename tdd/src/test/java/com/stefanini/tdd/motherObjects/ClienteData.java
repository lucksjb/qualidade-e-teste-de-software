package com.stefanini.tdd.motherObjects;

import com.stefanini.tdd.enums.SimNaoEnum;
import com.stefanini.tdd.models.Cidade;
import com.stefanini.tdd.models.Cliente;
import com.stefanini.tdd.models.Endereco;

public final class ClienteData {
    private ClienteData() {
    }

    public static Cliente clienteNovo_semBuilder() {
        Cidade cid = new Cidade();
        cid.setId(0L);
        cid.setDescricao("Rio de Janeiro");

        Endereco end = new Endereco();
        end.setRua("Rua das flores");
        end.setNumero("123A");
        end.setBairro("Jardins");
        end.setCidade(cid);

        Cliente cli = new Cliente();

        cli.setId(0L);
        cli.setName("Luciano");
        cli.setEndereco(end);
        cli.ativar();
        return cli;
    }

    public static Cliente clienteNovo_comBuilder() {
        return new Cliente.Builder() //
                .id(0L) //
                .name("Luciano") //
                .ativo(SimNaoEnum.SIM) //
                .endereco( //
                        new Endereco.Builder() //
                                .bairro("Jardins") //
                                .rua("Rua das flores") //
                                .numero("123A") //
                                .cidade(new Cidade.Builder() //
                                        .id(10L) //
                                        .descricao("Rio de Janeiro") //
                                        .build())
                                .build() //
                ).build();
    }
}
