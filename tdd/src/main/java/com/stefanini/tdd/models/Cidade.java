package com.stefanini.tdd.models;

public class Cidade {
    private Long id;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        Cidade other = (Cidade) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cidade [id=" + id + ", descricao=" + descricao + "]";
    }

    public static class Builder {
        private Cidade instance = new Cidade();

        public Cidade build() {
            return this.instance;
        }

        public Builder id(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder descricao(String descricao) {
            this.instance.setDescricao(descricao);
            return this;
        }
    }
}
