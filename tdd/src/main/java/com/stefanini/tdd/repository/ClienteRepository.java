package com.stefanini.tdd.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stefanini.tdd.models.Cliente;

public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Long proxId = 1L;

    public Cliente adicionar(Cliente cliente) {
        cliente.setId(proxId++);
        cliente.ativar();
        clientes.add(cliente);
        return cliente;
    }

    public Cliente alterar(Long id, Cliente cliente) {
        cliente.setId(id);
        clientes.stream().filter(c -> c.getId().equals(id)).forEach(cli -> {
            cli = cliente;
        }

        );
        return cliente;
    }

    public void excluir(Long id) {
        clientes.removeIf(cli -> cli.getId().equals(id));
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public Optional<Cliente> buscar(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void excluirTudo() {
        clientes = new ArrayList<>();
    }
}
