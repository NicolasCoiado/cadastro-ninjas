package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tb_missoes")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // Uma missão pode possuir muitos ninjas.
    @OneToMany(mappedBy = "missoes")
    @JoinColumn(name = "missoes_id") // Foreing Key ou Chave Estrangeira.
    private List<NinjaModel> ninja;
}
