package br.com.doefacil.model;

public class Doacao{

    private final String doador;
    private final TipoDoacao tipo;
    private final int quantidade;

    public Doacao(String doador, TipoDoacao tipo, int quantidade){
        if (doador == null || doador.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O nome do doador é obrigatório!");
        }
        if (tipo == null){
            throw new IllegalArgumentException(
                    "O tipo de doação é obrigatório!");
        }
        if (quantidade <= 0){
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero.");
        }
        this.doador = doador;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }
    public String getDoador(){
        return doador;
    }
    public TipoDoacao getTipo(){
        return tipo;
    }
    public int getQuantidade(){
        return quantidade;
    }
    @Override
    public String toString(){
        return "Doador: " + doador
                + " | Tipo: " + tipo
                + " | Quantidade: " + quantidade;
    }

}