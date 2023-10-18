import java.util.LinkedList;

public class TabelaHash {
    private int tamanho;
    private Entrada[] tabelaEncadeamento;
    private Entrada[] tabelaSondagemLinear;
    private static final int TAMANHO_INICIAL = 10;

    public TabelaHash() {
        tabelaEncadeamento = new Entrada[TAMANHO_INICIAL];
        tabelaSondagemLinear = new Entrada[TAMANHO_INICIAL];
        tamanho = 0;
    }

    // Hash function
    private int hash(Object chave) {
        return chave.hashCode() % tabelaEncadeamento.length;
    }

    // Inserir usando encadeamento
    public void inserirEncadeamento(Object chave, Estudante estudante) {
        System.out.println("[Encadeamento] Inserindo: " + estudante.toString());
        int index = hash(chave);
        if (tabelaEncadeamento[index] == null) {
            tabelaEncadeamento[index] = new Entrada(chave, estudante);
        } else {
            Entrada atual = tabelaEncadeamento[index];
            while (atual != null) {
                if (atual.chave.equals(chave)) {
                    atual.valor = estudante; // Atualizar se a chave já existe
                    return;
                }
                atual = atual.proximo;
            }
            Entrada novaEntrada = new Entrada(chave, estudante);
            novaEntrada.proximo = tabelaEncadeamento[index];
            tabelaEncadeamento[index] = novaEntrada;
        }
        if (++tamanho == tabelaEncadeamento.length) {
            expandirTabela();
        }
    }

    // Inserir usando sondagem linear
    public void inserirSondagemLinear(Object chave, Estudante estudante) {
        System.out.println("[Sondagem Linear] Inserindo: " + estudante.toString());
        int index = hash(chave);
        while (tabelaSondagemLinear[index] != null && !tabelaSondagemLinear[index].chave.equals(chave)) {
            index = (index + 1) % tabelaSondagemLinear.length; // Circular
        }
        tabelaSondagemLinear[index] = new Entrada(chave, estudante);
        if (++tamanho == tabelaSondagemLinear.length) {
            expandirTabela();
        }
    }

    // Expandir a tabela quando o fator de carga atinge 1
    private void expandirTabela() {
        Entrada[] tabelaAntiga = tabelaEncadeamento;
        tabelaEncadeamento = new Entrada[tabelaAntiga.length * 2];
        tamanho = 0;
        for (Entrada entrada : tabelaAntiga) {
            if (entrada != null) {
                inserirEncadeamento(entrada.chave, entrada.valor);
            }
        }

        tabelaAntiga = tabelaSondagemLinear;
        tabelaSondagemLinear = new Entrada[tabelaAntiga.length * 2];
        tamanho = 0;
        for (Entrada entrada : tabelaAntiga) {
            if (entrada != null) {
                inserirSondagemLinear(entrada.chave, entrada.valor);
            }
        }
    }

    // Busca usando encadeamento
    public Estudante buscarEncadeamento(Object chave) {
        int index = hash(chave);
        Entrada entrada = tabelaEncadeamento[index];
        while (entrada != null) {
            if (entrada.chave.equals(chave)) {
                return entrada.valor;
            }
            entrada = entrada.proximo;
        }
        return null;
    }

    // Busca usando sondagem linear
    public Estudante buscarSondagemLinear(Object chave) {
        int index = hash(chave);
        while (tabelaSondagemLinear[index] != null) {
            if (tabelaSondagemLinear[index].chave.equals(chave)) {
                return tabelaSondagemLinear[index].valor;
            }
            index = (index + 1) % tabelaSondagemLinear.length; // Circular
        }
        return null;
    }

    public Estudante removerEncadeamento(Object chave) {
        int index = hash(chave);
        Entrada entradaAnterior = null;
        Entrada entradaAtual = tabelaEncadeamento[index];

        while (entradaAtual != null) {
            if (entradaAtual.chave.equals(chave)) {
                if (entradaAnterior == null) {
                    tabelaEncadeamento[index] = entradaAtual.proximo;
                } else {
                    entradaAnterior.proximo = entradaAtual.proximo;
                }
                tamanho--;
                return entradaAtual.valor;
            }
            entradaAnterior = entradaAtual;
            entradaAtual = entradaAtual.proximo;
        }

        return null;
    }

    public Estudante removerSondagemLinear(Object chave) {
        int index = hash(chave);
        while (tabelaSondagemLinear[index] != null) {
            if (tabelaSondagemLinear[index].chave.equals(chave)) {
                Estudante valorRemovido = tabelaSondagemLinear[index].valor;
                tabelaSondagemLinear[index] = null;
                tamanho--;
                return valorRemovido;
            }
            index = (index + 1) % tabelaSondagemLinear.length;
        }
        return null;
    }
}
