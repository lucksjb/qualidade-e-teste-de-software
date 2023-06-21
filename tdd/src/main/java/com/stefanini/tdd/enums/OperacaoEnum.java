package com.stefanini.tdd.enums;


import com.stefanini.tdd.components.Adicao;
import com.stefanini.tdd.components.Divisao;
import com.stefanini.tdd.components.IOperacao;
import com.stefanini.tdd.components.Media;
import com.stefanini.tdd.components.Multiplicacao;
import com.stefanini.tdd.components.Subtracao;
import com.stefanini.tdd.utils.BeanUtil;

public enum OperacaoEnum {
    ADICAO(BeanUtil.getBean(Adicao.class)),
    SUBTRACAO(BeanUtil.getBean(Subtracao.class)),
    MULTIPLICACAO(BeanUtil.getBean(Multiplicacao.class)),
    DIVISAO(BeanUtil.getBean(Divisao.class)),
    MEDIA(BeanUtil.getBean(Media.class));

    private final IOperacao operacao;

    private OperacaoEnum(IOperacao operacao) {
        this.operacao = operacao;
    }

    public IOperacao getOperacao() {
        return this.operacao;
    }
}
