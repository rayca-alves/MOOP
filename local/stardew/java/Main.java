import java.util.Scanner;

import java.util.ArrayList;


// ==================================================================================

// PASSO 1: CLASSE ENTIDADE (A BASE)

// ==================================================================================

class Entidade {

    protected String nome;

    protected int idade;


    public Entidade(String nome) {

        // TODO: Inicie this.nome com o parametro e this.idade com 0

    }


    public String getNome() {

        return ""; // TODO: Retorne o nome

    }


    public String processarTurno() {

        // TODO: Aumente a idade em 1

        // TODO: Retorne a String: "Entidade [nome] tem [idade] turnos."

        return ""; 

    }

}


// ==================================================================================

// PASSO 2 & 3 & 4: CLASSE PLANTA

// ==================================================================================

class Planta extends Entidade {

    // PASSO 3: Adicione atributos: private int diasSemAgua; private boolean estaViva;

    // PASSO 4: Adicione atributo: private boolean temFruto;


    public Planta(String nome) {

        super(nome);

        // PASSO 3: inicie diasSemAgua=0, estaViva=true

        // PASSO 4: inicie temFruto=false

    }


    @Override

    public String processarTurno() {

        // PASSO 3: Se !estaViva, retorne "[nome] está morta."

        

        super.processarTurno(); // Chama o pai para aumentar a idade

        

        // PASSO 2: Apenas retorne "[nome] cresceu." (Apague isso no passo 3)

        // return this.nome + " cresceu."; 


        // --- LÓGICA DO PASSO 3 (Delete o return acima e descomente abaixo) ---

        /*

        this.diasSemAgua++;

        if (this.diasSemAgua > 2) {

            this.estaViva = false;

            return this.nome + " morreu de sede.";

        }

        */


        // --- LÓGICA DO PASSO 4 (Fruto a cada 4 turnos) ---

        /*

        if (this.estaViva && this.idade % 4 == 0) {

            this.temFruto = true;

        }

        */

        

        return this.nome + " cresceu.";

    }


    public String receberAgua() {

        // PASSO 3: zere diasSemAgua

        return this.nome + " foi regada.";

    }


    public boolean tirarFruto() {

        // PASSO 4: Se temFruto, mude para false e retorne true. Senão false.

        return false;

    }

}


// ==================================================================================

// PASSO 4: CLASSE JOGADOR

// ==================================================================================

class Jogador extends Entidade {

    public Jogador(String nome) {

        super(nome);

    }


    public String regar(Planta p) {

        // PASSO 4: Chame p.receberAgua()

        return ""; 

    }


    public String colher(Planta p) {

        // PASSO 4: Chame p.tirarFruto(). Se true, retorne que colheu.

        return "";

    }


    @Override

    public String processarTurno() {

        super.processarTurno();

        return "Jogador " + this.nome + " descansou.";

    }

}


// ==================================================================================

// CLASSE GERENCIADORA (Não precisa mexer na lógica)

// ==================================================================================

class Fazenda {

    private ArrayList<Entidade> entidades = new ArrayList<>();


    public void adicionar(Entidade e) { entidades.add(e); }


    public Entidade buscar(String nome) {

        for (Entidade e : entidades) {

            if (e.getNome().equalsIgnoreCase(nome)) return e;

        }

        return null;

    }


    public void novoDia() {

        for (Entidade e : entidades) {

            // POLIMORFISMO: O Java decide qual processarTurno chamar

            System.out.println(e.processarTurno());

        }

    }

}


// ==================================================================================

// MAIN (EXECUTÁVEL)

// ==================================================================================

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Fazenda fazenda = new Fazenda();


        while (scanner.hasNextLine()) {

            String linha = scanner.nextLine().trim();

            if (linha.isEmpty()) continue;

            System.out.println("$" + linha);

            String[] tokens = linha.split(" ");

            String cmd = tokens[0].toLowerCase();


            try {

                switch (cmd) {

                    case "end": scanner.close(); return;

                    case "init": fazenda = new Fazenda(); break;


                    // --- PASSO 1: TESTE DE ENTIDADE ---

                    case "criar_entidade": 

                        fazenda.adicionar(new Entidade(tokens[1]));

                        break;


                    // --- PASSO 2: TESTE DE PLANTA ---

                    case "plantar": 

                        // TODO: DESCOMENTE ABAIXO NO PASSO 2

                        // fazenda.adicionar(new Planta(tokens[1])); 

                        break;


                    // --- PASSO 4: TESTE DE JOGADOR ---

                    case "jogador": 

                        // TODO: DESCOMENTE ABAIXO NO PASSO 4

                        // fazenda.adicionar(new Jogador(tokens[1]));

                        break;


                    case "regar": 

                        // TODO: DESCOMENTE ABAIXO NO PASSO 4

                        /*

                        Entidade j = fazenda.buscar(tokens[1]);

                        Entidade p = fazenda.buscar(tokens[2]);

                        if (j instanceof Jogador && p instanceof Planta) {

                             System.out.println( ((Jogador)j).regar((Planta)p) );

                        }

                        */

                        break;

                        

                    case "colher":

                        // TODO: DESCOMENTE ABAIXO NO PASSO 4

                        /*

                        Entidade jog = fazenda.buscar(tokens[1]);

                        Entidade plan = fazenda.buscar(tokens[2]);

                        if (jog instanceof Jogador && plan instanceof Planta) {

                            System.out.println( ((Jogador)jog).colher((Planta)plan) );

                        }

                        */

                         break;


                    case "turno":

                        fazenda.novoDia();

                        break;

                }

            } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }

        }

    }

}