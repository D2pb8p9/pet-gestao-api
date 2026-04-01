package com.petshop.gestao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String raca;

    private Double peso;

    private String tipoPelagem;

    @Column(name = "possui_alergia")
    private Boolean hasAlergia;

    private String descricaoAlergia;

    @Column(name = "usa_medicamentos")
    private Boolean usaMedicamentos;

    private String descricaoMedicamentos;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @CreationTimestamp
    private LocalDate dataCadastro;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;

    private Boolean isAtivo = true;
}
