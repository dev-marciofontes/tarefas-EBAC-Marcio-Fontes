package br.com.marciofontes.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Márcio Fontes
 */
@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "TEL", nullable = false)
    private Long tel;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "ENDERECO", nullable = false, length = 100)
    private String end;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;


}

