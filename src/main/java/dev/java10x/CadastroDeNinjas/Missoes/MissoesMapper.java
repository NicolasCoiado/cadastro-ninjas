package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missaoDTO){

        MissoesModel missaoModel = new MissoesModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinja(missaoDTO.getNinja());

        return missaoModel;
    }

    public MissoesDTO map(MissoesModel missaoModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missaoModel.getId());
        missoesDTO.setNome(missaoModel.getNome());
        missoesDTO.setDificuldade(missaoModel.getDificuldade());
        missoesDTO.setNinja(missaoModel.getNinja());

        return missoesDTO;
    }
}
