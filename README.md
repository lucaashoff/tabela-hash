
# Tabela Hash em Java

Este repositório contém uma implementação simples e eficiente de uma tabela hash. O objetivo é armazenar objetos de estudantes usando dois de seus atributos, `id` e `matricula`, como chaves.

## Características

- **Função de Espalhamento**: Utilizamos uma função hash que converte as chaves (int e String) em um índice no array.
- **Chaves Suportadas**: A tabela hash suporta chaves de tipos `int` e `String`.
- **Objeto Armazenado**: O objeto armazenado (`Estudante`) possui dois atributos principais, `id` (tipo `int`) e `matricula` (tipo `String`), que são usados como chaves.
- **Tratamento de Colisão**: Duas técnicas foram implementadas para o tratamento de colisões:
  1. **Encadeamento**: Utiliza listas encadeadas para armazenar entradas no mesmo índice.
  2. **Sondagem Linear**: Em caso de colisão, procura o próximo índice vazio.
- **Operações Básicas**:
  - **Inserção**: Insere um objeto na tabela.
  - **Busca**: Busca um objeto na tabela usando a chave.
  - **Remoção**: Remove um objeto da tabela usando a chave.

## Uso

1. Instancie a classe `TabelaHash`.
2. Use os métodos `inserirEncadeamento` ou `inserirSondagemLinear` para adicionar estudantes.
3. Busque estudantes usando os métodos `buscarEncadeamento` ou `buscarSondagemLinear`.
4. Remova estudantes usando os métodos `removerEncadeamento` ou `removerSondagemLinear`.

## Teste de Eficiência

Um teste de eficiência está incluso para comparar o desempenho entre as duas técnicas de tratamento de colisão. Ele mede o tempo necessário para buscar uma chave específica em ambas as técnicas.

## Requisitos

- Java JDK 8 ou superior.

## Como Compilar e Executar

```bash
javac Main.java
java Main
```

## Autor

[Francielly Fileto Pazello]
[Lucas Hoffmann Rosa do Nascimento]
[Luiz Ricardo Martins Junior]
