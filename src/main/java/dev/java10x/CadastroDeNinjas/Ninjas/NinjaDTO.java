package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private String imgUrl;
    private MissoesModel missoes;
}
