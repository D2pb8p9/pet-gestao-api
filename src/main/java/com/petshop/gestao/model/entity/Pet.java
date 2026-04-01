package com.petshop.gestao.model.entity;

import com.petshop.gestao.model.enums.TipoPelagem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Past
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotBlank
    @Column(nullable = false)
    private String raca;

    @NotNull
    @Positive
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPelagem tipoPelagem;

    @Column(name = "possui_alergia")
    private boolean hasAlergia;

    private String descricaoAlergia;

    @Column(name = "usa_medicamentos")
    private boolean usaMedicamentos;

    private String descricaoMedicamentos;

    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @Builder.Default
    @Column(name = "ativo")
    @SQLRestriction("is_ativo = true")
    private boolean isAtivo = true;

    @Version
    private Long version;
}
