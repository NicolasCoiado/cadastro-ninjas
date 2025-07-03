package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_ninjas")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    // Um ninja tem uma única missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Criando uma chave estrangeira.
    private MissoesModel missoes;


}
