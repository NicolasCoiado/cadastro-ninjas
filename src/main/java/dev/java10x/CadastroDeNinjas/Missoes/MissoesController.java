package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        if(missoesService.listarMissaoPorId(id) != null){
            return ResponseEntity.ok(missoesService.listarMissaoPorId(id));
        }else{
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("A missão de ID "+id+" não foi encontrada!");
        }
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missaoDTO = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: "+missaoDTO.getNome());
    }

    //PUT
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoDTO){
        if(missoesService.listarMissaoPorId(id) != null){
            return ResponseEntity.ok(missoesService.atualizarMissao(id, missaoDTO));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID "+id+" não foi encontrada!");
        }
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID "+id+" não foi encontrada!");
        }
    }
}
