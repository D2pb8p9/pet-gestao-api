package com.petshop.gestao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPelagem {
    LONGO_LISO("Longo Liso"),
    LONGO_ENCARACOLADO("Longo Encaracolado"),
    DUPLO("Duplo"),
    CURTO("Curto");

    private final String descricao;
}
