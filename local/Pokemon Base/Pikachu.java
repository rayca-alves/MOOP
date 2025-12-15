public class Pikachu extends Pokemon {
    public Pikachu(String nome) {
        super(nome);
    }
    
    public String ataqueEspecial(){
        if(hp <= 0){
            energia -= 15;
            return "Pikachu " + nome + " usou Thunder Shock!";
        } else { 
            return nome + " está desmaiado e não pode atacar.";
        }
    }
}