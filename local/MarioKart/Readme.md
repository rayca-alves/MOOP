Desafio POO: Java Kart
Objetivo: Criar um sistema de inventário para um jogo de corrida onde o gerenciamento de itens utiliza Coleções dinâmicas e regras de jogo são protegidas por Tratamento de Exceções.

Conceitos Abordados:

Coleções (ArrayList): Gerenciamento dinâmico de itens (adicionar e remover).

Encapsulamento: A lista de itens é privada e só pode ser alterada pelos métodos permitidos.

Exceções Personalizadas: Criação de erros específicos (InventarioCheio, SemItem).

Tratamento de Erro: Uso de try-catch para manter o jogo rodando mesmo quando falhas ocorrem.

📜 Roteiro do Piloto (Passo a Passo)
🟢 Passo 1: O Kart Básico (Teste 01)

Foco: Classe Kart e Inicialização de Coleção.

Na classe Kart, implemente os atributos: piloto (String), moedas (int, inicia em 0) e itens (ArrayList de Strings).

Importante: No construtor, não esqueça de instanciar a lista this.itens = new ArrayList<>().

Implemente coletarMoeda(): Aumenta moedas em 1. Retorna void, mas imprime "[piloto] pegou uma moeda! Total: [X]".

🟡 Passo 2: Exceções Personalizadas (Teste 02)

Foco: Criação de Classes de Erro.

Crie a classe InventarioCheioException que estende Exception. A mensagem deve ser: "O inventario de [piloto] esta cheio! Nao pode pegar mais itens.".

Crie a classe SemItemException que estende Exception. A mensagem deve ser: "[piloto] nao possui itens para usar!".

Nota: Apenas crie as classes neste passo, vamos usá-las no próximo.

🔵 Passo 3: Lógica do Inventário (Teste 03)

Foco: Manipulação de Lista e throw.

Implemente pegarItemBox(String item):

Verifique se itens.size() >= 3. Se sim, lance InventarioCheioException.

Se não, adicione o item à lista (add) e imprima: "[piloto] pegou [item]! Slot [tamanho]/3".

Implemente usarItem():

Verifique se a lista está vazia (isEmpty()). Se sim, lance SemItemException.

Se não, remova o item do índice 0 (remove(0)), capture o nome dele e imprima: "[piloto] usou [item]!".

🟣 Passo 4: A Pista Segura (Teste 04)

Foco: try-catch e Execução.

Na classe Main, dentro do switch, envolva as chamadas dos métodos pegarItemBox e usarItem em blocos try-catch.

Se capturar uma exceção, imprima "ERRO: " seguido da mensagem da exceção (e.getMessage()).
