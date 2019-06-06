import java.util.ArrayList;

class Aluno {
    String ra;
    String nome;
    int faltas;
    double[] notas = new double[3];
    private String conceito;
    ArrayList<String> materias = new ArrayList<>();

    Aluno(String nome, int falta, double n1, double n2) {
        this.nome = nome;
        this.faltas = falta;
        this.notas[0] = n1;
        this.notas[1] = n2;
        this.notas[2] = calcularMedia();
    }

    Aluno(String nome, ArrayList<String> materias) {
        this.nome = nome;
        this.materias = materias;
    }

    double calcularMedia() {
        double media = 0;
        for (int i = 0; i < 2; i++) {
            media += notas[i];
        }
        return media / 2.0;
    }

    void mostrarDados() {
        System.out.println("RA: " + ra);
        System.out.println("Nome: " + nome);
        System.out.println("Média: " + calcularMedia());
        System.out.println("Conceito: " + conceito);
        System.out.println();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(ra).append('|').append(nome).append('|').append(notas[0]).append('|').append(notas[1]).append('|')
                .append(notas[2]);
        return res.toString();
    }
}