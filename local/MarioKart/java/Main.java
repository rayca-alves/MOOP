import java.util.Scanner;
import java.util.ArrayList;

// ==================================================================================
// PASSO 2: EXCEÇÕES PERSONALIZADAS
// Objetivo: Criar erros específicos para o jogo.
// ==================================================================================

class InventarioCheioException extends Exception {
    public InventarioCheioException(String piloto) {
        // TODO: Chame o construtor da superclasse (super) com a mensagem:
        // "O inventario de " + piloto + " esta cheio! Nao pode pegar mais itens."
    }
}

class SemItemException extends Exception {
    public SemItemException(String piloto) {
        // TODO: Chame o construtor da superclasse (super) com a mensagem:
        // piloto + " nao possui itens para usar!"
    }
}

// ==================================================================================
// CLASSE KART
// Objetivo: Gerenciar o piloto, suas moedas e seus itens.
// ==================================================================================
class Kart {
    // TODO (Passo 1): Declare os atributos:
    // private String piloto;
    // private int moedas;
    // private ArrayList<String> itens;

    public Kart(String piloto) {
        // TODO (Passo 1): Inicialize o piloto com o parametro.
        // TODO (Passo 1): Inicialize moedas com 0.
        // TODO (Passo 1): Inicialize a lista itens (new ArrayList<>()) -- MUITO IMPORTANTE!
    }

    public void coletarMoeda() {
        // TODO (Passo 1): Aumente moedas em 1.
        // TODO (Passo 1): Imprima: "[piloto] pegou uma moeda! Total: [moedas]"
    }

    // TODO (Passo 3): Adicione "throws InventarioCheioException" na assinatura do método
    public void pegarItemBox(String item) {
        // TODO (Passo 3):
        // 1. Verifique se a lista 'itens' tem 3 ou mais elementos.
        //    Se sim: Lance o erro (throw new InventarioCheioException(this.piloto))
        // 2. Se não: Adicione o item à lista.
        // 3. Imprima: "[piloto] pegou [item]! Slot [tamanho_da_lista]/3"
    }

    // TODO (Passo 3): Adicione "throws SemItemException" na assinatura do método
    public void usarItem() {
        // TODO (Passo 3):
        // 1. Verifique se a lista 'itens' está vazia (isEmpty).
        //    Se sim: Lance o erro (throw new SemItemException(this.piloto))
        // 2. Se não:
        //    Remova o item do índice 0 e guarde numa variável string.
        //    Imprima: "[piloto] usou [nome_do_item]!"
    }
}

// ==================================================================================
// MAIN (EXECUTÁVEL)
// ==================================================================================
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kart kart = null;

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            if (linha.isEmpty()) continue;
            System.out.println("$" + linha);
            String[] tokens = linha.split(" ");
            String cmd = tokens[0].toLowerCase();

            try {
                switch (cmd) {
                    case "end": scanner.close(); return;
                    
                    case "init": 
                        kart = new Kart(tokens[1]); 
                        break;

                    case "moeda": // PASSO 1
                        if (kart != null) kart.coletarMoeda();
                        break;

                    case "item": // PASSO 3 e 4
                        // Ex: item CascoVerde
                        if (kart != null) {
                            // TODO (Passo 4): Envolva a linha abaixo em um bloco TRY-CATCH.
                            // No catch(InventarioCheioException e), imprima: "ERRO: " + e.getMessage()
                            
                            kart.pegarItemBox(tokens[1]);
                        }
                        break;

                    case "usar": // PASSO 3 e 4
                        if (kart != null) {
                            // TODO (Passo 4): Envolva a linha abaixo em um bloco TRY-CATCH.
                            // No catch(SemItemException e), imprima: "ERRO: " + e.getMessage()

                            kart.usarItem();
                        }
                        break;
                }
            } catch (Exception e) { 
                // Captura erros genéricos de lógica (não mexer)
                System.out.println("Erro critico: " + e.getMessage()); 
            }
        }
    }
}