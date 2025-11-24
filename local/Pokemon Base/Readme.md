🧢 Desafio POO: A Batalha Pokémon

Objetivo: Criar um sistema de batalha onde diferentes tipos de Pokémon herdam comportamentos básicos, mas implementam ataques únicos.

Conceitos Abordados:

    Encapsulamento: Vida (HP) e Energia (PP) protegidos.

    Herança: Pikachu e Bulbasaur são tipos de Pokemon.

    Polimorfismo: O método ataqueEspecial() age de forma diferente para cada um.

    Ligação Tardia (Late Binding): O Java decide qual ataque usar durante a batalha.

📜 Roteiro do Treinador (Passo a Passo)

🟢 Passo 1: O Pokémon Básico (Teste 01)

Foco: Classe Pokemon (Base) e Ligação Precoce.

    Na classe Pokemon, implemente atributos: nome (String), hp (int, inicia em 100), energia (int, inicia em 50), desmaiado (boolean).

    Implemente tackle(): Gasta 5 de energia. Retorna "[nome] usou Tackle!". Se energia < 5, retorna "[nome] está exausto.".

    Implemente receberDano(int dano): Reduz HP. Se HP <= 0, define desmaiado = true e retorna "[nome] desmaiou!".

🟡 Passo 2: Tipos Específicos (Teste 02)

Foco: Herança e Sobrescrita.

    Crie a classe Pikachu que estende Pokemon.

    Sobrescreva ataqueEspecial(): Gasta 15 energia. Retorna "Pikachu [nome] usou Thunder Shock!".

    Crie a classe Bulbasaur que estende Pokemon.

    Sobrescreva ataqueEspecial(): Gasta 15 energia. Retorna "Bulbasaur [nome] usou Vine Whip!".

    Descomente os casos de criação no Main.

🔵 Passo 3: Lógica de Dano e Estado (Teste 03)

Foco: Encapsulamento e Regras.

    Atualize os métodos de ataque (tackle e ataqueEspecial). Se o Pokémon estiver desmaiado, ele não pode atacar (Retorna "[nome] está desmaiado e não pode atacar.").

    Teste se o Pokémon desmaia corretamente ao receber dano excessivo.

🟣 Passo 4: A Arena Polimórfica (Teste 04)

Foco: Polimorfismo e Coleções.

    Na classe Arena, o método batalhaEmGrupo() percorre a lista de Pokémons.

    Para cada Pokémon, chame ataqueEspecial().

    Note que o código é o mesmo (p.ataqueEspecial()), mas o resultado muda dependendo se é Pikachu ou Bulbasaur (Isso é Polimorfismo!).
