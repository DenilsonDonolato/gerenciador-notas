
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Turma {
    private ArrayList<Aluno> alunos;

    Turma() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String ra;
        String nome;
        double n1, n2, n3;

        try {
            // Cria arquivo no diretório do projeto
            File file = new File("aluno.txt");

            // Se o arquivo não existir, ele cria um novo
            if (!file.exists()) {
                file.createNewFile();
            }

            // Lê o arquivo
            FileReader ler = new FileReader("aluno.txt");
            BufferedReader reader = new BufferedReader(ler);
            String linha;
            String[] dados;

            // Percorre as linhas enquanto houver texto
            while ((linha = reader.readLine()) != null) {
                dados = linha.split("\\|");
                ra = dados[0];
                nome = dados[1];
                n1 = Double.parseDouble(dados[2]);
                n2 = Double.parseDouble(dados[3]);
                n3 = Double.parseDouble(dados[4]);
                alunos.add(new Aluno(ra, nome, n1, n2, n3));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.alunos = alunos;
    }

    private String paraString() {
        StringBuilder res = new StringBuilder();
        for (Aluno aluno : alunos) {
            res.append(aluno.toString()).append('\n');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void salvarDados() {
        try {
            // Conteúdo a ser gravado no arquivo
            String conteudo = paraString();

            // Cria arquivo no diretório do projeto
            File file = new File("aluno.txt");

            // Se o arquivo não existir, ele cria um novo
            if (!file.exists()) {
                file.createNewFile();
            }

            // Instanciamos a escrita do arquivo
            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(writer);

            // Escreve e fecha arquivo
            bw.write(conteudo);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void mostrarDados() {
        for (Aluno aluno : alunos) {
            aluno.mostrarDados();
        }
    }

    boolean modificarAlunos() {
        Scanner scanner = new Scanner(System.in);
        char op;
        while (true) {
            System.out.print("Deseja inserir alunos? (s/n) ");
            try {
                op = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                op = ' ';
            } switch (op) {
            case 'S':
            case 's':
                inserirAluno();
                return true;
            case 'N':
            case 'n':
                return false;
            default:
                System.out.println("Opção inválida.");
            }
        }
    }

    private void inserirAluno() {
        Aluno aluno;
        String ra;
        String nome;
        double n1, n2, n3;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o RA: ");
            ra = scanner.nextLine();
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();
            System.out.print("Digite a primeira nota: ");
            n1 = scanner.nextDouble();
            System.out.print("Digite a segunda nota: ");
            n2 = scanner.nextDouble();
            System.out.print("Digite a terceira nota: ");
            n3 = scanner.nextDouble();
            aluno = new Aluno(ra, nome, n1, n2, n3);
            aluno.mostrarDados();
            alunos.add(aluno);
            salvarDados();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Dados incorretos.");
        }
    }
}