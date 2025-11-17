⚽ Desafio POO: Sistema de Gestão de Partida de Futebol

Crie um sistema para gerir os participantes de uma partida de futebol, utilizando a herança da classe Pessoa para modelar as classes Jogador e Tecnico. O foco é na correta manipulação de atributos herdados, sobrescrita de métodos (Ligação Tardia) e uso de métodos da superclasse (Ligação Precoce).

1. Classe Base: Pessoa (Superclasse)

Define as características comuns e os contratos de interação.

Atributos:

    nome (String)

    idade (int)

    cpf (String)

Construtor:

    Recebe nome, idade e cpf e os inicializa.

Método Comum (Ligação Precoce):

    aquecer(): Retorna uma String: "Pessoa [nome] está a aquecer."

Método para Polimorfismo (Será sobrescrito):

    exibirRelatorioDesempenho(): Retorna uma String com as informações básicas no formato: "Relatório: [nome], Idade: [idade]".

2. Classes Derivadas (Herança, Sobrescrita e Lógica de Negócio)

A. Classe Jogador

Herança:

    Herda de Pessoa.

Novos Atributos:

    posicao (String)

    energia (int) - Deve ser inicializada em 100 no construtor.

    contagemFaltas (int) - Inicializada em 0.

    cartoesAmarelos (int) - Inicializada em 0.

    estaEmCampo (boolean) - Inicializada em true.

Construtor:

    Recebe nome, idade, cpf e posicao. Deve chamar o construtor da superclasse (super(...)) e inicializar os atributos padrão (energia, faltas, cartões, estaEmCampo).

Novos Métodos:

    darPasse(): Reduz energia em 2. Retorna "Jogador [nome] deu um passe. Energia restante: [energia]".

    fazerGol(): Reduz energia em 5. Retorna "GOOOL! [nome] marcou! Energia restante: [energia]".

    fazerFalta():

        Incrementa contagemFaltas em 1.

        Verifica se contagemFaltas é múltiplo de 3 (3, 6, 9...). Se for, chama receberCartaoAmarelo().

        Se estaEmCampo for false (após receber o segundo cartão), retorna "Jogador [nome] já foi expulso!".

        Caso contrário, retorna "Jogador [nome] fez uma falta. Total de faltas: [contagemFaltas]".

    receberCartaoAmarelo() (Método auxiliar, pode ser private):

        Incrementa cartoesAmarelos em 1.

        Se cartoesAmarelos for 2, muda estaEmCampo para false.

        Retorna uma String informando o cartão (ex: "Cartão amarelo para [nome]!") e se foi expulso.

Método Sobrescrito (Ligação Tardia):

    exibirRelatorioDesempenho(): Retorna super.exibirRelatorioDesempenho() + ", Posição: [posicao], Energia: [energia], Cartões: [cartoesAmarelos]".

B. Classe Tecnico

Herança:

    Herda de Pessoa.

Novos Atributos:

    licenca (String) - Ex: "UEFA Pro", "CBF A".

    estresse (int) - Inicializada em 0.

    estaEmCampo (boolean) - Inicializada em true.

Construtor:

    Recebe nome, idade, cpf e licenca. Deve chamar o construtor da superclasse (super(...)) e inicializar estresse e estaEmCampo.

Novos Métodos:

    pedirPausa():

        Incrementa estresse em 1.

        Chama verificarEstresse().

        Se estaEmCampo for true, retorna "Técnico [nome] pediu pausa. Nível de estresse: [estresse]".

        Caso contrário, retorna "Técnico [nome] já foi expulso.".

    retirarJogador(Jogador j):

        Define j.estaEmCampo como false.

        Incrementa estresse em 2.

        Chama verificarEstresse().

        Se estaEmCampo for true, retorna "Técnico [nome] substituiu [j.nome]. Nível de estresse: [estresse]".

        Caso contrário, retorna "Técnico [nome] tentou substituir, mas já foi expulso.".

    verificarEstresse() (Método auxiliar, pode ser private):

        Verifica se estresse > 5 E se estaEmCampo é true.

        Se sim, muda estaEmCampo para false e retorna (ou imprime) "EXPULSO! [nome] xingou o juiz e foi expulso! (Estresse: [estresse])".

Método Sobrescrito (Ligação Tardia):

    exibirRelatorioDesempenho(): Retorna super.exibirRelatorioDesempenho() + ", Licença: [licenca], Estresse: [estresse], Em Campo: [estaEmCampo]".

3. Classe Partida (Gerenciadora para Polimorfismo)

Atributo:

    nomeEstadio (String)

Construtor:

    Recebe o nomeEstadio.

Método de Ligação Tardia (Polimorfismo):

    gerarSumula(Pessoa[] participantes):

        Recebe um array (ou lista) do tipo base Pessoa, que pode conter objetos Jogador ou Tecnico.

        Instrução: Itere sobre o array e, para cada p em participantes, imprima o resultado de p.exibirRelatorioDesempenho().

        (Isto demonstra a Ligação Tardia, pois a JVM decidirá em tempo de execução qual versão do método (Jogador ou Tecnico) deve ser chamada).

Método de Ligação Precoce:

    iniciarAquecimento(Pessoa p):

        Recebe um objeto do tipo Pessoa.

        Instrução: Imprima o resultado de p.aquecer().

        (Isto demonstra a Ligação Precoce, pois o método aquecer() existe apenas na superclasse e não foi sobrescrito, sendo resolvido em tempo de compilação).
