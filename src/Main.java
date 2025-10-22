
public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTES DA ARVORE MORSE ===");

        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        System.out.println("Arvore com o alfabeto morse...");
        arvore.popularArvore();
        System.out.println("Arvore populada.");

        arvore.exibir();
        arvore.exibirHierarquia();

        System.out.println("Testando o metodo buscar:");
        System.out.println("Buscando codigo '...': " + arvore.buscar("..."));
        System.out.println("Buscando codigo '---': " + arvore.buscar("---"));
        System.out.println("Buscando mensagem '... --- ...': " + arvore.buscar("... --- ..."));

        System.out.println("Testando o metodo remover");
        System.out.println("Removendo a letra 'S' (codigo '...')...");
        boolean removeu = arvore.remover("...");


        if (removeu) {
            System.out.println("Remocao bem-sucedida.");
        } else {
            System.out.println("Falha na remocao.");
        }

        System.out.println("Buscando novamente o codigo '...': '" + arvore.buscar("...") + "' (esperado: vazio)");
        System.out.println("Verificando se o caminho para 'H' ('....') foi preservado...");
        System.out.println("Buscando codigo '....': " + arvore.buscar("...."));

        System.out.println("\n5. Inserindo 'S' novamente...");
        arvore.inserir("...", 'S');
        System.out.println("Buscando codigo '...': " + arvore.buscar("..."));

        System.out.println("\n=== TESTES FINALIZADOS ===");
    }
}