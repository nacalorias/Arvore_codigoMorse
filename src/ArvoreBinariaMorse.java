// Define a classe da Árvore Binária para Código Morse.
public class ArvoreBinariaMorse {
    private Node raiz;
    
// O construtor apenas inicializa a árvore, criando o nó raiz.
    public ArvoreBinariaMorse() {
        this.inicializar();
    }
// Cria o nó raiz. A raiz é vazia, serve como ponto de partida.
    public void inicializar() {
        this.raiz = new Node();  
    }
    
//Insere um caractere na árvore com base no seu código Morse. O método percorre a arvore e cria nós se necessário.
    public void inserir(String codigo, char caractere) {
        Node atual = this.raiz;
        for (int i = 0; i < codigo.length(); i++) {

            char direcao = codigo.charAt(i);
            if (direcao == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new Node());
                }
                atual = atual.getEsquerda();
            } else if (direcao == '-') {
                if (atual.getDireita() == null) {
                    atual.setDireita(new Node());
                }
                atual = atual.getDireita();
            }
        }
        atual.setCaractere(caractere);
    }

    // Decodifica uma string inteira em Morse (separada por espaços).
    public String buscar(String mensagemMorse) {
        String mensagemDecodificada = "";
        String codigoAtual = ""; // Acumula o código de UM caractere (ex: ".-")

        mensagemMorse = mensagemMorse + " ";

        for (int i = 0; i < mensagemMorse.length(); i++) {
            char c = mensagemMorse.charAt(i);
            // Se achou um espaço, o código do caractere anterior terminou.
            if (c == ' ') {
                if (codigoAtual.length() > 0) {
                    Node atual = this.raiz;
                    // Navega pela árvore usando o código acumulado
                    for (int j = 0; j < codigoAtual.length(); j++) {
                        if (atual == null) break;
                        char direcao = codigoAtual.charAt(j);
                        if (direcao == '.') {
                            atual = atual.getEsquerda();
                        } else {
                            atual = atual.getDireita();
                        }
                    }
                    // Se o nó final contém um caractere, adiciona à resposta.
                    if (atual != null && atual.getCaractere() != '\0') {
                        mensagemDecodificada = mensagemDecodificada + atual.getCaractere();
                    }
                    codigoAtual = "";
                }
            } else {
                //Se não for espaço, continua montando o código
                codigoAtual = codigoAtual + c;
            }
        }
        return mensagemDecodificada;
    }
// Remove um caractere da árvore (remoção lógica).
    public boolean remover(String codigo) {
        Node atual = this.raiz;
        for (int i = 0; i < codigo.length(); i++) {
            if (atual == null) return false;
            char direcao = codigo.charAt(i);
            if (direcao == '.') {
                atual = atual.getEsquerda();
            } else if (direcao == '-') {
                atual = atual.getDireita();
            }
        }
        // Se encontrou o nó, apenas apaga o caractere.
        // Não remove o nó para não quebrar a estrutura.
        if (atual != null && atual.getCaractere() != '\0') {
            atual.setCaractere('\0');
            return true;
        }
        return false;
    }
// Método auxiliar para carregar a árvore com o alfabeto Morse padrão.
    public void popularArvore() {
        inserir(".-", 'A');inserir("-...", 'B'); inserir("-.-.", 'C');
        inserir("-..", 'D');inserir(".", 'E'); inserir("..-.", 'F');
        inserir("--.", 'G');inserir("....", 'H');inserir("..", 'I');
        inserir(".---", 'J');inserir("-.-", 'K');inserir(".-..", 'L');
        inserir("--", 'M'); inserir("-.", 'N'); inserir("---", 'O');inserir(".--.", 'P');inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S'); inserir("-", 'T'); inserir("..-", 'U');
        inserir("...-", 'V');inserir(".--", 'W'); inserir("-..-", 'X');inserir("-.--", 'Y');
        inserir("--..", 'Z');
        inserir("-----", '0'); inserir(".----", '1');inserir("..---", '2');
        inserir("...--", '3');inserir("....-", '4');inserir(".....", '5');
        inserir("-....", '6'); inserir("--...", '7');inserir("---..", '8'); inserir("----.", '9');
    }
// Método público para iniciar a exibição em lista.
    public void exibir() {
        System.out.println("--- Conteudo da Arvore (Formato Lista) ---");
        exibirRecursivo(this.raiz, "");
    }
// Função recursiva (pré-ordem) para exibir a árvore.
    private void exibirRecursivo(Node no, String caminho) {
        if (no == null) return;
        if (no.getCaractere() != '\0') {
            System.out.println("Caractere: " + no.getCaractere() + " | Codigo: " + caminho);
        }
        exibirRecursivo(no.getEsquerda(), caminho + ".");
        exibirRecursivo(no.getDireita(), caminho + "-");
    }
// Método público para iniciar a exibição hierárquica (árvore deitada).
    public void exibirHierarquia() {
        System.out.println("\n--- Exibicao hierarquica da arvore ---");
        exibirHierarquiaRecursivo(this.raiz, "");
        System.out.println("--------------------");
    }
// Função recursiva para exibir a árvore "deitada".
    // Usa um percurso em-ordem reverso.
    private void exibirHierarquiaRecursivo(Node no, String espacamento) {
        if (no == null) return;
        String novoEspacamento = espacamento + "    ";
        // Visita a direita (aparece no topo)
        exibirHierarquiaRecursivo(no.getDireita(), novoEspacamento);
        // Processa o nó atual (imprime o caractere ou '-')
        System.out.print(espacamento);
        if (no.getCaractere() != '\0') {
            System.out.println("-> (" + no.getCaractere() + ")");
        } else {
            System.out.println("-> (-)");
        }
        // Visita a esquerda (aparece embaixo)
        exibirHierarquiaRecursivo(no.getEsquerda(), novoEspacamento);
    }
}
