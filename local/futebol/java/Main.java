// Cole todo este código num ficheiro chamado Main.java
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. CLASSE BASE (SUPERCLASSE)
 * (Sem alterações)
 */
class Pessoa {
    protected String nome;
    protected int idade;
    protected String cpf;

    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String aquecer() {
        return "Pessoa " + this.nome + " está a aquecer.";
    }

    public String exibirRelatorioDesempenho() {
        return "Relatório: " + this.nome + ", Idade: " + this.idade;
    }
}

/**
 * 2. CLASSE DERIVADA: JOGADOR
 * (Sem alterações)
 */
class Jogador extends Pessoa {
    private String posicao;
    private int energia;
    private int contagemFaltas;
    private int cartoesAmarelos;
    private boolean estaEmCampo;

    public Jogador(String nome, int idade, String cpf, String posicao) {
        super(nome, idade, cpf);
        this.posicao = posicao;
        this.energia = 100;
        this.contagemFaltas = 0;
        this.cartoesAmarelos = 0;
        this.estaEmCampo = true;
    }

    public boolean getEstaEmCampo() {
        return this.estaEmCampo;
    }

    public void setEstaEmCampo(boolean estaEmCampo) {
        this.estaEmCampo = estaEmCampo;
    }

    private String receberCartaoAmarelo() {
        this.cartoesAmarelos++;
        if (this.cartoesAmarelos == 2) {
            this.estaEmCampo = false;
            return "Cartão amarelo para " + this.nome + "! Foi expulso!";
        }
        return "Cartão amarelo para " + this.nome + "!";
    }

    public String darPasse() {
        if (!this.estaEmCampo) {
            return "Jogador " + this.nome + " está fora de campo.";
        }
        this.energia -= 2;
        return "Jogador " + this.nome + " deu um passe. Energia restante: " + this.energia;
    }

    public String fazerGol() {
        if (!this.estaEmCampo) {
            return "Jogador " + this.nome + " está fora de campo.";
        }
        this.energia -= 5;
        return "GOOOL! " + this.nome + " marcou! Energia restante: " + this.energia;
    }

    public String fazerFalta() {
        if (!this.estaEmCampo) {
            return "Jogador " + this.nome + " já foi expulso!";
        }
        
        this.contagemFaltas++;
        String feedback = "Jogador " + this.nome + " fez uma falta. Total de faltas: " + this.contagemFaltas;
        
        if (this.contagemFaltas % 3 == 0) {
            feedback += "\n" + receberCartaoAmarelo();
        }
        return feedback;
    }

    @Override
    public String exibirRelatorioDesempenho() {
        return super.exibirRelatorioDesempenho() + 
               ", Posição: " + this.posicao + 
               ", Energia: " + this.energia + 
               ", Cartões: " + this.cartoesAmarelos;
    }
}

/**
 * 3. CLASSE DERIVADA: TECNICO
 * (Sem alterações)
 */
class Tecnico extends Pessoa {
    private String licenca;
    private int estresse;
    private boolean estaEmCampo;

    public Tecnico(String nome, int idade, String cpf, String licenca) {
        super(nome, idade, cpf);
        this.licenca = licenca;
        this.estresse = 0;
        this.estaEmCampo = true;
    }

    private String verificarEstresse() {
        if (this.estresse > 5 && this.estaEmCampo) {
            this.estaEmCampo = false;
            return "EXPULSO! " + this.nome + " xingou o juiz e foi expulso! (Estresse: " + this.estresse + ")";
        }
        return "";
    }

    public String pedirPausa() {
        if (!this.estaEmCampo) {
            return "Técnico " + this.nome + " já foi expulso.";
        }
        
        this.estresse++;
        String feedback = "Técnico " + this.nome + " pediu pausa. Nível de estresse: " + this.estresse;
        
        String feedbackEstresse = verificarEstresse();
        if (!feedbackEstresse.isEmpty()) {
            feedback += "\n" + feedbackEstresse;
        }
        return feedback;
    }

    public String retirarJogador(Jogador j) {
        if (!this.estaEmCampo) {
            return "Técnico " + this.nome + " tentou substituir, mas já foi expulso.";
        }
        if (j == null) {
            return "Jogador não encontrado para substituição.";
        }

        j.setEstaEmCampo(false);
        this.estresse += 2;
        
        String feedback = "Técnico " + this.nome + " substituiu " + j.getNome() + ". Nível de estresse: " + this.estresse;

        String feedbackEstresse = verificarEstresse();
        if (!feedbackEstresse.isEmpty()) {
            feedback += "\n" + feedbackEstresse;
        }
        return feedback;
    }

    @Override
    public String exibirRelatorioDesempenho() {
        return super.exibirRelatorioDesempenho() + 
               ", Licença: " + this.licenca + 
               ", Estresse: " + this.estresse + 
               ", Em Campo: " + this.estaEmCampo;
    }
}

/**
 * 4. CLASSE GERENCIADORA: PARTIDA
 * Modificada para ser "silenciosa" (sem prints no construtor ou ao adicionar).
 */
class Partida {
    private String nomeEstadio;
    private ArrayList<Pessoa> participantes;

    /**
     * Construtor SILENCIOSO (não imprime nada)
     */
    public Partida(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
        this.participantes = new ArrayList<>();
    }

    /**
     * Método auxiliar para encontrar qualquer Pessoa
     */
    public Pessoa findPessoa(String nome) {
        for (Pessoa p : participantes) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Método SILENCIOSO para adicionar
     */
    public void adicionarParticipante(Pessoa p) {
        this.participantes.add(p);
    }

    /**
     * Método "sumula" modificado.
     * Imprime APENAS os relatórios, sem cabeçalho ou rodapé.
     */
    public void gerarSumula() {
        if (participantes.isEmpty()) {
            // Os testes .tio não esperam esta linha, mas é boa prática
            // System.out.println("Nenhum participante em campo.");
        }
        for (Pessoa p : participantes) {
            System.out.println(p.exibirRelatorioDesempenho());
        }
    }
}


/**
 * 5. CLASSE PRINCIPAL (EXECUTÁVEL)
 * Reescrita para funcionar como um processador de script .tio
 * 1. Lê a linha
 * 2. Imprime a linha com "$" (eco)
 * 3. Executa o comando
 * 4. Imprime o resultado do comando (se houver)
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Partida partida = null; // A Partida só existe depois do 'init'

        // Loop principal: continua lendo enquanto houver linhas na entrada
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            if (linha.isEmpty()) continue;

            // 1. ECOAR O COMANDO (Exigência do .tio)
            System.out.println("$" + linha);
            
            String[] tokens = linha.split(" ");
            String cmd = tokens[0].toLowerCase();

            // 2. EXECUTAR O COMANDO
            // Usamos try-catch para evitar que o programa quebre se
            // um comando for mal formatado (embora os testes .tio devam ser perfeitos)
            try {
                switch (cmd) {
                    case "end":
                        scanner.close();
                        return; // Termina o programa

                    case "init":
                        // Cria a ÚNICA instância da Partida
                        partida = new Partida(tokens[1]);
                        break;

                    case "criarj":
                        // Ex: criarj Messi 35 111A Atacante
                        if (partida != null) {
                            Jogador j = new Jogador(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                            partida.adicionarParticipante(j);
                        }
                        break;
                    
                    case "criart":
                        // Ex: criart Guardiola 50 222B UEFAPro
                        if (partida != null) {
                            Tecnico t = new Tecnico(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                            partida.adicionarParticipante(t);
                        }
                        break;
                    
                    case "sumula":
                        if (partida != null) {
                            // Este método JÁ imprime a saída esperada (os relatórios)
                            partida.gerarSumula();
                        }
                        break;
                    
                    case "aquecer":
                        if (partida != null) {
                            Pessoa pAq = partida.findPessoa(tokens[1]);
                            if (pAq != null) {
                                // 3. IMPRIMIR O RESULTADO DO COMANDO
                                System.out.println(pAq.aquecer()); // Ligação Precoce
                            }
                        }
                        break;

                    case "gol":
                    case "falta":
                    case "passe":
                        if (partida != null) {
                            Pessoa pJog = partida.findPessoa(tokens[1]);
                            if (pJog instanceof Jogador) {
                                Jogador jog = (Jogador) pJog;
                                // 3. IMPRIMIR O RESULTADO DO COMANDO
                                if (cmd.equals("gol")) System.out.println(jog.fazerGol());
                                if (cmd.equals("falta")) System.out.println(jog.fazerFalta());
                                if (cmd.equals("passe")) System.out.println(jog.darPasse());
                            }
                        }
                        break;
                    
                    case "pausa":
                        if (partida != null) {
                            Pessoa pTec = partida.findPessoa(tokens[1]);
                            if (pTec instanceof Tecnico) {
                                Tecnico tec = (Tecnico) pTec;
                                // 3. IMPRIMIR O RESULTADO DO COMANDO
                                System.out.println(tec.pedirPausa());
                            }
                        }
                        break;

                    case "substituir":
                        if (partida != null) {
                            Pessoa pTecSub = partida.findPessoa(tokens[1]);
                            Pessoa pJogSub = partida.findPessoa(tokens[2]);

                            if (pTecSub instanceof Tecnico && pJogSub instanceof Jogador) {
                                // 3. IMPRIMIR O RESULTADO DO COMANDO
                                System.out.println(((Tecnico) pTecSub).retirarJogador((Jogador) pJogSub));
                            }
                        }
                        break;
                    
                    // case "help" não é necessário para testes .tio

                    default:
                        // Em um teste .tio, comandos desconhecidos são ignorados ou falham o teste.
                        // Não vamos imprimir "ERRO", pois o teste não espera isso.
                        break;
                }
            } catch (Exception e) {
                // Se algo falhar (ex: 'criarj' sem args), o teste deve falhar.
                // Imprimir o erro pode ser útil para depuração, mas pode
                // sujar a saída do teste .tio.
                // System.out.println("Erro na execução: " + e.getMessage());
            }
        }
        scanner.close();
    }
}