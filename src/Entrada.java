class Entrada {
    Object chave;
    Estudante valor;
    Entrada proximo;  // campo para o encadeamento

    public Entrada(Object chave, Estudante valor) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;  // inicialmente, não há próximo elemento
    }
}
