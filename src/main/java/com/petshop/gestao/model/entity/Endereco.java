package com.petshop.gestao.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco_tutor")
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String logradouro;

    @NotBlank
    @Column(nullable = false)
    private String numero;

    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String bairro;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String estado;

    @Version
    private Long version;
}
