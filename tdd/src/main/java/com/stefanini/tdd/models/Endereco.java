package com.stefanini.tdd.models;

public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private Cidade cidade;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco [rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + "]";
    }

    public static class Builder {
        private Endereco instance = new Endereco();

        public Endereco build() {
            return this.instance;
        }

        public Builder rua(String rua) {
            this.instance.setRua(rua);
            return this;
        }

        public Builder numero(String numero) {
            this.instance.setNumero(numero);
            return this;
        }

        public Builder bairro(String bairro) {
            this.instance.setBairro(bairro);
            return this;
        }

        public Builder cidade(Cidade cidade) {
            this.instance.setCidade(cidade);
            return this;
        }
    }

}
