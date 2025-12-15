public class Bulbasaur extends Pokemon {
    public Bulbasaur(String nome) {
        super(nome);
    }
   
   public String ataqueEspecial(){
        if(hp <= 0){
            energia -= 15;
            return "Bulbasaur " + nome + " usou Vine Whip!";
        } else { 
            return nome + " está desmaiado e não pode atacar.";
        }
    }
}