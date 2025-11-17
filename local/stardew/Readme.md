🚜 Desafio POO: Stardew Valley (Sistema de Turnos)

Bem-vindo à sua fazenda! Neste exercício, você irá aplicar conceitos fundamentais de Programação Orientada a Objetos (POO) para criar um sistema simples de simulação agrícola baseado em turnos.

🎯 Objetivos de Aprendizagem

    Herança: Criar classes que herdam características de uma classe base (Entidade).

    Sobrescrita (Override): Modificar o comportamento padrão de métodos da superclasse.

    Polimorfismo: Tratar objetos de tipos diferentes (Planta, Jogador) de forma genérica.

    Lógica de Estado: Gerenciar vida, morte e produção baseada na passagem do tempo.

📜 Regras do Jogo

O sistema funciona à base de Turnos (Dias). Quando um turno passa, todas as entidades na fazenda envelhecem e sofrem efeitos do tempo.

1. Classe Base: Entidade

Tudo na fazenda é uma Entidade.

    Tem um nome e uma idade (número de turnos que existiu).

    Sabe dizer seu nome e processar o turno (apenas envelhecer).

2. Classe: Planta (Herda de Entidade)

As plantas são sensíveis e precisam de cuidado.

    Crescimento: A cada turno, ela cresce.

    Sede: Ela conta quantos dias ficou sem água (diasSemAgua).

        Se ficar mais de 2 turnos sem água, ela morre.

        Se morrer, ela não faz mais nada, apenas avisa que está morta.

    Frutos: Se a planta estiver viva e a sua idade for múltiplo de 4 (4, 8, 12...), ela produz um fruto.

    Cuidados: Ela pode receber água (zera a sede) e ter seu fruto colhido.

3. Classe: Jogador (Herda de Entidade)

O jogador cuida da fazenda.

    Ação Regar: Pode regar uma planta para salvar sua vida.

    Ação Colher: Pode colher o fruto de uma planta (se houver).

    Descanso: A cada turno, o jogador apenas descansa.

🚀 Roteiro de Implementação (Passo a Passo)

A questão foi dividida em 4 passos para facilitar o desenvolvimento. Você deve completar um passo, testar e só então avançar.

🟢 Passo 1: A Base (Teste 01)

Foco: Classe Entidade.

    Vá na classe Entidade.

    Implemente os atributos nome e idade.

    No método processarTurno(), faça a idade aumentar e retorne a frase: "Entidade [nome] tem [idade] turnos.".

    Teste: Rode o caso de teste 01.

🟡 Passo 2: O Plantio (Teste 02)

Foco: Herança simples.

    Vá na classe Planta e faça ela estender (extends) Entidade.

    Sobrescreva (@Override) o método processarTurno() para chamar o super.processarTurno() e retornar apenas "[nome] cresceu.".

    Importante: Vá no arquivo Main e descomente as linhas dentro do case "plantar".

    Teste: Rode o caso de teste 02.

🔵 Passo 3: Vida e Morte (Teste 03)

Foco: Lógica de estado e Sobrescrita.

    Na classe Planta, adicione os atributos diasSemAgua (int) e estaViva (boolean).

    Atualize o processarTurno():

        Se não estiver viva, retorne "[nome] está morta.".

        Aumente diasSemAgua.

        Se diasSemAgua > 2, mude estaViva para false e retorne "[nome] morreu de sede.".

    Crie o método receberAgua() que zera o contador de sede.

    Teste: Rode o caso de teste 03.

🟣 Passo 4: Colheita e Jogador (Teste 04)

Foco: Interação entre objetos e Polimorfismo.

    Na Planta:

        Adicione lógica para gerar fruto quando idade % 4 == 0.

        Crie o método tirarFruto() (retorna true se colheu, false se não tinha).

    No Jogador:

        Crie a classe herdando de Entidade.

        Crie o método regar(Planta p) que chama p.receberAgua().

        Crie o método colher(Planta p) que tenta tirar o fruto.

    No Main: Descomente os casos jogador, regar e colher.

    Teste: Rode o caso de teste 04.
