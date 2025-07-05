package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("missoes")
public class MissoesController {
    //GET
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso.";
    }

    //POST
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso.";
    }

    //PUT
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso.";
    }

    //DELETE
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso.";
    }
}
