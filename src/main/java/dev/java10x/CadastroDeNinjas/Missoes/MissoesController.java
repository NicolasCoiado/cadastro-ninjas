package dev.java10x.CadastroDeNinjas.Missoes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Listar missões", description = "Lista todas as missões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missões listadas com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao listar missões.")
    })
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar uma missão", description = "Lista todas as informações de uma missão.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão listada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não cadastrada.")
    })
    public ResponseEntity<?> listarMissaoPorId(
            @Parameter(description = "Id enviado através da URL da requisição.")
            @PathVariable Long id
    ){
        if(missoesService.listarMissaoPorId(id) != null){
            return ResponseEntity.ok(missoesService.listarMissaoPorId(id));
        }else{
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("A missão de ID "+id+" não foi encontrada!");
        }
    }

    //POST
    @PostMapping("/criar")
    @Operation(summary = "Criar uma missão", description = "Cadastra uma nova missão.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão cadastrada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar missão.")
    })
    public ResponseEntity<String> criarMissao(
            @Parameter(description = "Dados da missão enviados no corpo da requisição.")
            @RequestBody MissoesDTO missao
    ){
        MissoesDTO missaoDTO = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: "+missaoDTO.getNome());
    }

    //PUT
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Editar uma missão", description = "Edita uma missão identificada por seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão listada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não cadastrada.")
    })
    public ResponseEntity<?> alterarMissao(
            @Parameter(description = "Id enviado através da URL da requisição.")
            @PathVariable Long id,
            @Parameter(description = "Dados da missão enviados no corpo da requisição.")
            @RequestBody MissoesDTO missaoDTO
    ){
        if(missoesService.listarMissaoPorId(id) != null){
            return ResponseEntity.ok(missoesService.atualizarMissao(id, missaoDTO));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID "+id+" não foi encontrada!");
        }
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Excluir uma missão", description = "Exclui uma missão identificada por seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão excluída com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não cadastrada.")
    })
    public ResponseEntity<String> deletarMissao(
            @Parameter(description = "Id enviado através da URL da requisição.")
            @PathVariable Long id
    ){
        if(missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de ID "+id+" não foi encontrada!");
        }
    }
}
