# Árvore Binária de Código Morse

## Descrição

Este projeto implementa uma árvore binária para representar o código Morse.

Cada caminho da raiz até um nó representa o código Morse de uma letra ou número.

- `.` representa um movimento para o filho esquerdo da árvore.
- `-` representa um movimento para o filho direito da árvore.

A árvore possui todas as letras de A até Z e todos os números de 0 até 9.

## Funcionalidades

O programa permite:

- inserir caracteres na árvore;
- buscar uma letra ou número e retornar seu código Morse;
- buscar um caractere utilizando seu código Morse;
- exibir a árvore de maneira hierárquica;
- converter uma mensagem para código Morse;
- converter uma mensagem em código Morse para texto.

## Estrutura do nó

Cada nó possui:

- um caractere;
- uma referência para o filho esquerdo;
- uma referência para o filho direito.

## Funcionamento da árvore

Para percorrer a árvore:

- `.` = esquerda
- `-` = direita

Exemplo:

`A = .-`

Para encontrar a letra A:

1. parte da raiz;
2. ponto (`.`) segue para esquerda;
3. traço (`-`) segue para direita;
4. o nó encontrado contém a letra A.

## Exemplo de codificação

Entrada:

```text
SOS
```

Saída:

```text
... --- ...
```

## Exemplo de decodificação

Entrada:

```text
... --- ...
```

Saída:

```text
SOS
```

## Como compilar

No terminal, dentro da pasta do projeto:

```bash
javac ArvoreBinariaMorse.java
```

## Como executar

```bash
java ArvoreBinariaMorse
```

## Arquivos do projeto

```text
codigo-morse/
├── ArvoreBinariaMorse.java
└── README.md
```

## Tecnologias utilizadas

- Java
- Árvore binária
- Recursividade
- Scanner
- StringBuilder
