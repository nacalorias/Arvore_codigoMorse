// Esta classe representa um único "nó" (um ponto) dentro da árvore.
public class Node {

    
    // Guarda a letra (ex: 'A') se este nó for o fim de um código.
    private char caractere;
    // Aponta para o próximo nó se o código for '.'.
    private Node esquerda;
    // Aponta para o próximo nó se o código for '-'.
    private Node direita;

    // Construtor: é chamado quando um novo nó é criado.
    public Node() {
        this.caractere = '\0';
        // Começa sem nenhum nó filho.
        this.esquerda = null;
        this.direita = null;
    }

    // Método para pegar o caractere guardado neste nó.
    public char getCaractere() {
        return caractere;
    }

    // Método para definir o caractere guardado neste nó.
    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    // Método para pegar o nó filho da esquerda.
    public Node getEsquerda() {
        return esquerda;
    }

    // Método para definir  o nó filho da esquerda.
    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    // Método para pegar o nó filho da direita.
    public Node getDireita() {
        return direita;
    }

    // Método para definir o nó filho da direita.
    public void setDireita(Node direita) {
        this.direita = direita;
    }
}
