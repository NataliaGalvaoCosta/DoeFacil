package br.com.doefacil.strategy;

import br.com.doefacil.model.Doacao;
import java.util.List;

public interface DistribuicaoStrategy {
    List<Doacao> organizar(List<Doacao> doacoes);
}