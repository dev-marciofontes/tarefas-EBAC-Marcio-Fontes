/**
 *
 */
package br.com.marciofontes.vendas.online.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    public enum Status {
        ATIVO, INATIVO;
    }

    @Id
    private String id;

    @NotBlank(message = "O código do produto é obrigatório")
    @Size(min = 2, max = 10, message = "O código do produto deve ter entre 2 e 10 caracteres")
    @Indexed(unique = true, background = true)
    private String codigo;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(min = 1, max = 50, message = "O nome do produto deve ter entre 1 e 50 caracteres")
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatória")
    @Size(min = 1, max = 50, message = "A descrição do produto deve ter entre 1 e 50 caracteres")
    private String descricao;

    @NotNull(message = "O valor do produto é obrigatório")
    private BigDecimal valor;

    private Status status;

}
