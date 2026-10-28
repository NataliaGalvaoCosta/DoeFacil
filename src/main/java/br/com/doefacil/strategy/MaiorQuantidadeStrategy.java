package br.com.doefacil.strategy;

import br.com.doefacil.model.Doacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaiorQuantidadeStrategy implements DistribuicaoStrategy {
    @Override
    public List<Doacao> organizar(List<Doacao> doacoes){
        List<Doacao> resultado = new ArrayList<>(doacoes);

        Collections.sort(resultado,
                Comparator.comparingInt(Doacao::getQuantidade).reversed());

        return resultado;
    }
}