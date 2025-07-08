package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    //POST
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    //PUT
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoDTO){
        return missoesService.atualizarMissao(id, missaoDTO);
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "Missao deletada com sucesso!";
    }
}
