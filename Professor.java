import java.util.ArrayList;

class Professor {

    String nome;
    ArrayList<String> materias = new ArrayList<>();

    Professor(String nome, ArrayList<String> materias){
        this.nome = nome;
        this.materias = materias;
    }
    
}