package br.com.doefacil.strategy;

import br.com.doefacil.model.Doacao;
import java.util.ArrayList;
import java.util.List;

public class OrdemCadastroStrategy implements DistribuicaoStrategy{

    @Override
    public List<Doacao> organizar(List<Doacao> doacoes) {
        return new ArrayList<>(doacoes);
    }
}