package dev.java10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {
    private Long id;
    private String nome;
    private String dificuldade;
    @JsonIgnore // Para evitar loop de serialização.
    private List<NinjaModel> ninja;
}
