import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

        try {
            FileReader ler = new FileReader(user);
            BufferedReader reader = new BufferedReader(ler);

            String linha;
            String dados[];

            while ((linha = reader.readLine()) != null) {
                dados = linha.split("\\|");
                nome = dados[0];
                login = dados[1];
                password = dados[2];
                tipo = dados[3];
                if(nome.equals(user)){
                    if(password.equals(senha)){
                        switch (tipo.charAt(0)) {
                            case 'A':
                                return new Aluno(nome);
                                break;
                        
                            default:
                                break;
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