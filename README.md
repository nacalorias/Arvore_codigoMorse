# Trabalho de Árvore Binária em Java

Este projeto foi desenvolvido para a disciplina de **Resolução de Problemas Estruturados em Computação**, lecionada pelo professor **Andrey Cabral Meira**.

## Alunos

* Ana Carolina Curi de Sales
* Ana Carolina Afonso Meiado

---

## Sobre o Projeto

Este é um trabalho acadêmico desenvolvido em Java que aplica os conceitos de estruturas de dados. O foco principal do projeto é a implementação e manipulação de uma **Árvore Binária** para resolver a decodificação de Código Morse.

## O que o Código Faz

Este projeto usa uma estrutura de dados de Árvore Binária para criar um decodificador de Código Morse.

Imagine a árvore como um mapa de "caça ao tesouro", onde a raiz é o ponto de partida:

* Se o código Morse tem um `.` (ponto), o programa "vira à esquerda" na árvore.
* Se o código Morse tem um `-` (traço), o programa "vira à direita".

O programa primeiro **constrói** esse mapa (`popularArvore`). Por exemplo, para guardar a letra 'A' (que é `.-`), ele começa na raiz, vira à esquerda (`.`) e depois à direita (`-`), e "enterra" a letra 'A' nesse local.

Depois, para **decodificar** uma mensagem (`buscar`), ele faz o caminho inverso. Se ele recebe o código `.-`, ele refaz o caminho (esquerda, direita), encontra a letra 'A' e a adiciona à mensagem final. Ele faz isso para cada código na mensagem (separados por espaços) até traduzir tudo.

O código também inclui funções para **imprimir** o mapa no console, seja como uma lista de todos os códigos e letras (`exibir`) ou como um desenho da árvore "deitada" (`exibirHierarquia`).
