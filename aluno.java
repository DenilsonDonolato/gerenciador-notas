class Aluno {
    String ra;
    String nome;
    double[] notas = new double[3];
    private String conceito;

    Aluno(String ra, String nome, double n1, double n2, double n3) {
        if (ra.length() != 4 || nome.length() > 30 || !validaNota(n1) || !validaNota(n2) || !validaNota(n3)) {
            throw new IllegalArgumentException("Dados de criação de aluno incorreto");
        } else {
            this.ra = ra;
            this.nome = nome;
            this.notas[0] = n1;
            this.notas[1] = n2;
            this.notas[2] = n3;
            this.conceito = calcularConceito(calcularMedia());
        }
    }

    private boolean validaNota(double nota) {
        return nota >= 0 && nota <= 10;
    }

     private double calcularMedia() {
        double media = 0;
        for (double nota : notas) {
            media += nota;
        }
        return media / notas.length;
    }

    private String calcularConceito(double media) {
        if (media >= 8.5) {
            return "Excelente";
        } else if (media >= 7) {
            return "Bom";
        } else if (media >= 5) {
            return "Regular";
        } else {
            return "Preocupante";
        }
    }

    void mostrarDados(){
        System.out.println("RA: " + ra);
        System.out.println("Nome: " + nome);
        System.out.println("Média: " + calcularMedia());
        System.out.println("Conceito: " + conceito);
        System.out.println();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(ra).append('|').append(nome).append('|').append(notas[0]).append('|').append(notas[1]).append('|').append(notas[2]);
        return res.toString();
    }
}