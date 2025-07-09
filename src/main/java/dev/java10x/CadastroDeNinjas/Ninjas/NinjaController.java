package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boas-vindas")
    @Operation(summary = "Mensagem de boas-vindas", description = "Essa rota te deseja boas vindas.")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Criar ninjas", description = "Cria um novo ninja.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja.")
    })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Informações do ninja, enviadas no corpo da requisição.")
            @RequestBody NinjaDTO ninja
    ){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: "+novoNinja.getNome() + " (ID): "+ novoNinja.getId());
    }

    // Procurar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não cadastrado.")
    })
    @Operation(summary = "Listar um ninja", description = "Acessa as informações de um ninja através de seu ID.")
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "Id enviado através da URL da requisição.")
            @PathVariable Long id
    ){

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum ninja foi encontrado com o ID "+id+"!");
        }
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao listar ninjas.")
    })
    @Operation(summary = "Listar todos os ninjas", description = "Lista todos os ninjas cadastrados.")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Alterar dados dos ninjas  (UPDATE)
    @PutMapping("/alterar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja editado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não cadastrado.")
    })
    @Operation(summary = "Editar ninja", description = "Edita um ninja identificado pelo seu ID.")
    public ResponseEntity<?> atualizarNinja(
            @Parameter(description = "Id enviado através da URL da requisição.")
            @PathVariable Long id,
            
            @Parameter(description = "Dados do ninja enviados através do corpo da requisição.")
            @RequestBody NinjaDTO ninjaAtualizado){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaAtualizado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum ninja foi encontrado com o ID "+id+"!");
        }
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "410", description = "Ninja excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não cadastrado.")
    })
    @Operation(summary = "Excluir ninja", description = "Exclui um ninja identificado pelo seu ID.")
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Id enviado através da URL da requisição.")
            @PathVariable Long id
    ){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.GONE).body("Ninja com ID "+id+" deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum ninja foi encontrado com o ID "+id+"!");
        }
    }
}
