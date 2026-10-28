package br.com.doefacil.repository;

import br.com.doefacil.model.Doacao;
import java.util.ArrayList;
import java.util.List;

public class DoacaoRepository{

    private static final DoacaoRepository INSTANCE =
            new DoacaoRepository();

    private final List<Doacao> doacoes = new ArrayList<>();

    private DoacaoRepository(){
    }
    public static DoacaoRepository getInstance() {
        return INSTANCE;
    }
    public void adicionar(Doacao doacao){
        doacoes.add(doacao);
    }
    public List<Doacao> listar(){
        return new ArrayList<>(doacoes);
    }
}