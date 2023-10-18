public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();

        // Inserção de dados
        for (int i = 0; i < 1000; i++) {
            Estudante estudante = new Estudante(i, "MAT" + i);
            tabelaHash.inserirEncadeamento(i, estudante);
            tabelaHash.inserirSondagemLinear(i, estudante);
        }

        // Teste de eficiência - Busca
        long inicio, fim;

        inicio = System.nanoTime();
        tabelaHash.buscarEncadeamento(500); // Supomos que a chave 500 existe.
        fim = System.nanoTime();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Tempo de busca com Encadeamento: " + (fim - inicio) + " ns");

        inicio = System.nanoTime();
        tabelaHash.buscarSondagemLinear(500); // Supomos que a chave 500 existe.
        fim = System.nanoTime();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Tempo de busca com Sondagem Linear: " + (fim - inicio) + " ns");
    }
}
