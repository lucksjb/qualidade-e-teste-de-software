package com.stefanini.tdd.models;

import com.stefanini.tdd.enums.SimNaoEnum;

public class Cliente {
    private Long id;
    private String name;
    private Endereco endereco = new Endereco();
    private SimNaoEnum ativo;

    public void ativar() {
        this.ativo = SimNaoEnum.SIM;
    }

    public void desativar() {
        this.ativo = SimNaoEnum.NAO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public SimNaoEnum getAtivo() {
        return ativo;
    }

    public void setAtivo(SimNaoEnum ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", name=" + name + ", endereco=" + endereco + ", ativo=" + ativo + "]";
    }

    public static class Builder {
        private Cliente instance = new Cliente();

        public Cliente build() {
            return this.instance;
        }

        public Builder id(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder name(String name) {
            this.instance.setName(name);
            return this;
        }

        public Builder endereco(Endereco endereco) {
            this.instance.setEndereco(endereco);
            return this;
        }

        public Builder ativo(SimNaoEnum ativo) {
            this.instance.setAtivo(ativo);
            return this;
        }
    }
}
