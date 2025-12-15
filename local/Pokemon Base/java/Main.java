import java.util.Scanner;
import java.util.ArrayList;

// ==================================================================================
// PASSO 1: CLASSE BASE (POKEMON)
// ==================================================================================
class Pokemon {
    protected String nome;
    protected int hp;
    protected int energia;
    protected boolean desmaiado;

    public Pokemon(String nome) {
        this.nome = nome;
        this.hp = 100;
        this.energia = 50;
        this.desmaiado = false;
    }

    public String getNome() {
        return this.nome;
    }

    // Ligação Precoce (Early Binding): Método comum a todos
    public String tackle() {
        if(!desmaiado){
            energia -= 5;
            return nome + " usou Tackle!";
         } else {
            return nome + " esta desmaiado e nao pode atacar.";
         }
    }


    public String receberDano(int dano) {
        hp -= dano;
        if(hp <= 0){
            desmaiado = true;
            hp = 0;
            return nome + " desmaiou!";
        } else {
            return nome + " recebeu dano. HP: " + hp;
        }
    }

    // Ligação Tardia (Late Binding): Será sobrescrito
    public String ataqueEspecial() {
        return this.nome + " não sabe ataques especiais.";
    }
}

// ==================================================================================
// PASSO 2: SUBCLASSES (HERANÇA)
// ==================================================================================
class Pikachu extends Pokemon {
    public Pikachu(String nome) {
        super(nome);
    }
    
    public String ataqueEspecial(){
        if(!desmaiado){
            energia -= 15;
            return "Pikachu " + nome + " usou Thunder Shock!";
        } else { 
            return nome + " esta desmaiado e nao pode atacar.";
        }
    }
}

class Bulbasaur extends Pokemon {
    public Bulbasaur(String nome) {
        super(nome);
    }
   
   public String ataqueEspecial(){
        if(!desmaiado){
            energia -= 15;
            return "Bulbasaur " + nome + " usou Vine Whip!";
        } else { 
            return nome + " esta desmaiado e nao pode atacar.";
        }
    }
}

// ==================================================================================
// GERENCIADOR (ARENA)
// ==================================================================================
class Arena {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public void registrar(Pokemon p) {
        pokemons.add(p);
    }

    public Pokemon buscar(String nome) {
        for (Pokemon p : pokemons) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        return null;
    }

    public void batalhaEmGrupo() {
        System.out.println("--- ATAQUE EM GRUPO ---");
        for (Pokemon p : pokemons) {
            // POLIMORFISMO: O Java descobre em tempo de execução qual ataque usar
            System.out.println(p.ataqueEspecial());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arena arena = new Arena();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            if (linha.isEmpty()) continue;
            System.out.println("$" + linha);
            String[] tokens = linha.split(" ");
            String cmd = tokens[0].toLowerCase();

            try {
                switch (cmd) {
                    case "end": scanner.close(); return;
                    case "init": arena = new Arena(); break;

                    case "pokemon": // PASSO 1 (Genérico)
                        arena.registrar(new Pokemon(tokens[1]));
                        break;
                    
                    case "tackle": // PASSO 1
                        Pokemon pTackle = arena.buscar(tokens[1]);
                        if (pTackle != null) System.out.println(pTackle.tackle());
                        break;

                    case "dano": // PASSO 1 e 3
                        Pokemon pDano = arena.buscar(tokens[1]);
                        if (pDano != null) System.out.println(pDano.receberDano(Integer.parseInt(tokens[2])));
                        break;

                    case "pikachu": // PASSO 2
                        arena.registrar(new Pikachu(tokens[1]));
                        break;
                    
                    case "bulbasaur": // PASSO 2
                        arena.registrar(new Bulbasaur(tokens[1]));
                        break;

                    case "especial": // PASSO 2
                        Pokemon pEsp = arena.buscar(tokens[1]);
                        if (pEsp != null) System.out.println(pEsp.ataqueEspecial());
                        break;

                    case "batalha_grupo": // PASSO 4
                         arena.batalhaEmGrupo();
                         break;
                }
            } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
        }
    }
}