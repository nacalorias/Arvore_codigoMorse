
public class ArvoreBinariaMorse {
    private Node raiz;

    public ArvoreBinariaMorse() {
        this.inicializar();
    }

    public void inicializar() {
        this.raiz = new Node();
    }

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
    public String buscar(String mensagemMorse) {
        String mensagemDecodificada = "";
        String codigoAtual = "";

        mensagemMorse = mensagemMorse + " ";

        for (int i = 0; i < mensagemMorse.length(); i++) {
            char c = mensagemMorse.charAt(i);
            if (c == ' ') {
                if (codigoAtual.length() > 0) {
                    Node atual = this.raiz;
                    for (int j = 0; j < codigoAtual.length(); j++) {
                        if (atual == null) break;
                        char direcao = codigoAtual.charAt(j);
                        if (direcao == '.') {
                            atual = atual.getEsquerda();
                        } else {
                            atual = atual.getDireita();
                        }
                    }
                    if (atual != null && atual.getCaractere() != '\0') {
                        mensagemDecodificada = mensagemDecodificada + atual.getCaractere();
                    }
                    codigoAtual = "";
                }
            } else {
                codigoAtual = codigoAtual + c;
            }
        }
        return mensagemDecodificada;
    }

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
        if (atual != null && atual.getCaractere() != '\0') {
            atual.setCaractere('\0');
            return true;
        }
        return false;
    }

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

    public void exibir() {
        System.out.println("--- Conteudo da Arvore (Formato Lista) ---");
        exibirRecursivo(this.raiz, "");
    }

    private void exibirRecursivo(Node no, String caminho) {
        if (no == null) return;
        if (no.getCaractere() != '\0') {
            System.out.println("Caractere: " + no.getCaractere() + " | Codigo: " + caminho);
        }
        exibirRecursivo(no.getEsquerda(), caminho + ".");
        exibirRecursivo(no.getDireita(), caminho + "-");
    }

    public void exibirHierarquia() {
        System.out.println("\n--- Exibicao hierarquica da arvore ---");
        exibirHierarquiaRecursivo(this.raiz, "");
        System.out.println("--------------------");
    }

    private void exibirHierarquiaRecursivo(Node no, String espacamento) {
        if (no == null) return;
        String novoEspacamento = espacamento + "    ";
        exibirHierarquiaRecursivo(no.getDireita(), novoEspacamento);
        System.out.print(espacamento);
        if (no.getCaractere() != '\0') {
            System.out.println("-> (" + no.getCaractere() + ")");
        } else {
            System.out.println("-> (-)");
        }
        exibirHierarquiaRecursivo(no.getEsquerda(), novoEspacamento);
    }
}