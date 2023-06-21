package com.stefanini.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.stefanini.tdd.models.Cidade;
import com.stefanini.tdd.models.Cliente;
import com.stefanini.tdd.models.Endereco;
import com.stefanini.tdd.motherObjects.ClienteData;
import com.stefanini.tdd.singletons.ClienteRepositorySingleton;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteRepositoryTest {
    ClienteRepository clienteRepository = ClienteRepositorySingleton.getRepositoryInstance();

    @Test
    @Order(10)
    void quando_adicionar_cliente_deveRetornar_cliente_com_Id_Maior_que_zero_sem_Design_Pattern_Object_Mother() {
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
        var result = clienteRepository.adicionar(cli);
        assertNotEquals(0, result.getId());
    }

    @Order(15)
    void quando_adicionar_cliente_deveRetornar_cliente_com_Id_Maior_que_zero_com_Design_Pattern_Object_Mother() {
        var cli = ClienteData.clienteNovo_semBuilder();
        var result = clienteRepository.adicionar(cli);
        assertNotEquals(0, result.getId());
    }

    @Test
    @Order(20)
    void quando_listar_cliente_deveRetornar_List_Clientes_com_1_registro() {
        var result = clienteRepository.listar();
        assertEquals(1, result.size());
    }

    @Test
    @Order(30)
    void quando_buscar_cliente_deveRetornar_Optional_cliente() {
        var result = clienteRepository.buscar(1L);
        assertTrue(result.isPresent());
    }

    @Test
    @Order(40)
    void quando_excluir_cliente_e_depois_listar_deveRetornar_List_Clientes_com_0_registro() {
        clienteRepository.excluir(1L);
        var result = clienteRepository.listar();
        assertEquals(0, result.size());
    }
}
