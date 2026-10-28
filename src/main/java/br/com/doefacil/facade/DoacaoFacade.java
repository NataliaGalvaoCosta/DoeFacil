package br.com.doefacil.facade;

import br.com.doefacil.model.Doacao;
import br.com.doefacil.repository.DoacaoRepository;
import br.com.doefacil.strategy.DistribuicaoStrategy;
import java.util.List;

public class DoacaoFacade{

    private final DoacaoRepository repository;

    public DoacaoFacade(){
        this.repository = DoacaoRepository.getInstance();
    }
    public void cadastrar(Doacao doacao){
        repository.adicionar(doacao);
    }
    public List<Doacao> listar(){
        return repository.listar();
    }
    public List<Doacao> distribuir(
            DistribuicaoStrategy estrategia) {
        if(estrategia == null){
            throw new IllegalArgumentException(
                    "A estratégia é obrigatória.");
        }
        return estrategia.organizar(repository.listar());
    }
    public String gerarResumo(){
        List<Doacao> doacoes = repository.listar();

        int total = 0;

        for (Doacao doacao : doacoes){
            total += doacao.getQuantidade();
        }
        return "Total de doações cadastradas: "
                + doacoes.size()
                + "\nQuantidade total de itens: " + total;
    }

}
