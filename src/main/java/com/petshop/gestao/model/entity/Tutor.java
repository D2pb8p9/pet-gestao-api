package com.petshop.gestao.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutores")
@EqualsAndHashCode(of = "id")
@ToString(exclude = "pets")
public class Tutor {

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
    @Column(unique = true,  nullable = false)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    private String cpf;

    @NotBlank
    @Pattern(regexp = "\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}")
    @Column(nullable = false)
    private String telefone;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    @Valid
    private Endereco endereco;

    @OneToMany(mappedBy = "tutor",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @Builder.Default
    private List<Pet> pets = new ArrayList<>();

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
