/**
 *
 */
package br.com.marciofontes.vendas.online.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;


@Document(collection = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Cliente", description = "Cliente")
public class Cliente {

    @Id
    @Schema(description = "Identificador único")
    private String id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    @Size(min = 1, max = 50, message = "O nome do cliente deve ter entre 1 e 50 caracteres")
    @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
    private String nome;

    @NotNull(message = "O CPF do cliente é obrigatório")
    @Positive(message = "O CPF do cliente deve ser um número positivo")
    @Schema(description = "CPF", nullable = false)
    private Long cpf;

    @NotNull(message = "O telefone do cliente é obrigatório")
    @Positive(message = "O telefone do cliente deve ser um número positivo")
    @Schema(description = "Telefone", nullable = false)
    private Long tel;

    @NotBlank(message = "O email do cliente é obrigatório")
    @Size(min = 1, max = 50, message = "O email do cliente deve ter entre 1 e 50 caracteres")
    @Indexed(unique = true, background = true)
    @Email(message = "O email do cliente deve ser válido")
    @Schema(description = "Email", minLength = 1, maxLength = 50, nullable = false)
    private String email;

    @NotBlank(message = "O endereço do cliente é obrigatório")
    @Size(min = 1, max = 50, message = "O endereço do cliente deve ter entre 1 e 50 caracteres")
    @Schema(description = "Endereço", minLength = 1, maxLength = 50, nullable = false)
    private String end;

    @NotNull(message = "O número residencial do cliente é obrigatório")
    @Positive(message = "O número residencial do cliente deve ser um número positivo")
    @Schema(description = "Número residencial", nullable = false)
    private Integer numero;

    @NotBlank(message = "A cidade do cliente é obrigatória")
    @Size(min = 1, max = 50, message = "A cidade do cliente deve ter entre 1 e 50 caracteres")
    @Schema(description = "Cidade", minLength = 1, maxLength = 50, nullable = false)
    private String cidade;

    @NotBlank(message = "O estado do cliente é obrigatório")
    @Size(min = 1, max = 50, message = "O estado do cliente deve ter entre 1 e 50 caracteres")
    @Schema(description = "Estado", minLength = 1, maxLength = 50, nullable = false)
    private String estado;


}
