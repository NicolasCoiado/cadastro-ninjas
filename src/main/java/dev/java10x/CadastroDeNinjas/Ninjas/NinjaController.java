package dev.java10x.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.OpenAPI31;
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

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Salve!";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel ListarNinjaPorId (@PathVariable Long id){
        return ninjaService.listarNinja(id);
    }

    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.criarNinja(ninjaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }
}