
public class Main {

    // Método principal, onde o programa começa.
    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTES DA ARVORE MORSE ===");
        
// Cria uma nova árvore Morse vazia.
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        // Preenche a árvore com o alfabeto Morse padrão.
        System.out.println("Arvore com o alfabeto morse...");
        arvore.popularArvore();
        System.out.println("Arvore populada.");

        arvore.exibir();// Mostra em formato de lista (Letra: Codigo)
        arvore.exibirHierarquia();// Mostra o desenho da árvore "deitada"


        //Testa a decodificação (método buscar).
        System.out.println("Testando o metodo buscar:");
        System.out.println("Buscando codigo '...': " + arvore.buscar("..."));
        System.out.println("Buscando codigo '---': " + arvore.buscar("---"));
        System.out.println("Buscando mensagem '... --- ...': " + arvore.buscar("... --- ..."));

        // Testa a remoção.
        System.out.println("Testando o metodo remover");
        System.out.println("Removendo a letra 'S' (codigo '...')...");
        boolean removeu = arvore.remover("...");


        if (removeu) {
            System.out.println("Remocao bem-sucedida.");
        } else {
            System.out.println("Falha na remocao.");
        }

        //Verifica se a letra "S" foi realmente removida.
        System.out.println("Buscando novamente o codigo '...': '" + arvore.buscar("...") + "' (esperado: vazio)");
        System.out.println("Verificando se o caminho para 'H' ('....') foi preservado...");
        System.out.println("Buscando codigo '....': " + arvore.buscar("...."));

        //Testa inserir a letra 'S' de volta.
        System.out.println("\n5. Inserindo 'S' novamente...");
        arvore.inserir("...", 'S');
        System.out.println("Buscando codigo '...': " + arvore.buscar("..."));

        System.out.println("\n=== TESTES FINALIZADOS ===");
    }
}
