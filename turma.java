import java.util.ArrayList;

class Turma{
    ArrayList<Aluno> alunos = new ArrayList<>();

    Turma(String materia){
        Arquivo arquivo = new Arquivo();
        this.alunos = arquivo.buscarDadosTurma(materia);
    }

}