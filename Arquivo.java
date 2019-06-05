import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    public static final String usuarios = "users.txt";

    public void escreverArquivo(String nomeArquivo, String conteudo) {

        try {
            File file = new File(nomeArquivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write(conteudo);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escreverArquivo(String nomeArquivo, String[] conteudo) {
        StringBuilder completa = new StringBuilder();
        for (String texto : conteudo) {
            completa.append(texto).append("|");
        }
        escreverArquivo(nomeArquivo, completa.deleteCharAt(completa.length() - 1).toString());
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
                            return new Professor(nome);
                        case 'C':
                            // return new Coordenador(nome);
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

}