import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    public static final String usuarios = "users.txt";
    public static final String materias = "materias.txt";

    public void escreverArquivo(String nomeArquivo, String conteudo, boolean arquivoTodo) {

        try {
            File file = new File(nomeArquivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file.getAbsoluteFile(), !arquivoTodo);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write(conteudo);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escreverArquivo(String nomeArquivo, String[] conteudo, boolean arquivoTodo) {
        StringBuilder completa = new StringBuilder();
        for (String texto : conteudo) {
            completa.append(texto).append("|");
        }
        escreverArquivo(nomeArquivo, completa.deleteCharAt(completa.length() - 1).toString(), !arquivoTodo);
    }

    boolean arquivoExiste(String nome) {
        File file = new File(nome);
        return file.exists();
    }

    Object validarLogin(String user, String senha) {
        String nome, login, password, tipo;
        ArrayList<String> materias = new ArrayList<>();

        try {
            FileReader ler = new FileReader(usuarios);
            BufferedReader reader = new BufferedReader(ler);

            String linha;
            String dados[];

            while ((linha = reader.readLine()) != null) {
                dados = linha.split("\\|");
                login = dados[1];
                password = dados[2];
                if (login.equals(user)) {
                    if (password.equals(senha)) {
                        nome = dados[0];
                        tipo = dados[3];
                        for (int i = 4; i < dados.length; i++) {
                            materias.add(dados[i]);
                        }
                        switch (tipo.charAt(0)) {
                        case 'A':
                            return new Aluno(nome, materias);
                        case 'P':
                            return new Professor(nome,materias);
                        case 'C':
                            return new Professor(nome,materias);
                        }
                    }
                }
            }
            reader.close();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String buscarMateria(String selectedItem) {

        try {
            FileReader ler = new FileReader(materias);
            BufferedReader reader = new BufferedReader(ler);

            String linha;
            String dados[];

            while ((linha = reader.readLine()) != null) {
                dados = linha.split("\\|");
                if (selectedItem.equals(dados[0])) {
                    reader.close();
                    return dados[1];
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Aluno buscarDadosAluno(String nomeArquivo, Aluno aluno) {
        try {
            FileReader ler = new FileReader(nomeArquivo);
            BufferedReader reader = new BufferedReader(ler);

            String linha;
            String dados[];

            while ((linha = reader.readLine()) != null) {
                dados = linha.split("\\|");
                if (aluno.nome.equals(dados[0])) {
                    aluno.faltas = Integer.parseInt(dados[1]);
                    aluno.notas[0] = Double.parseDouble(dados[2]);
                    aluno.notas[1] = Double.parseDouble(dados[3]);
                    aluno.notas[2] = aluno.calcularMedia();
                    reader.close();
                    return aluno;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aluno;
    }
}