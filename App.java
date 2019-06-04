import java.awt.event.ActionEvent;

import javax.swing.*;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 800;
    private static final int alturaJanela = 450;

    JLabel lblUsuario = new JLabel("Usuário:");
    JTextField txtUsuario = new JTextField("");
    JLabel lblSenha = new JLabel("Senha:");
    JPasswordField txtSenha = new JPasswordField("");
    JButton btnLogar = new JButton("Logar");

    App() {
        setLayout(null);
        setTitle(appName);
        setSize(larguraJanela, alturaJanela);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(260, 115);
        setResizable(false);
        setLocationRelativeTo(null);

        criaComponentes();

        checarArquivoUsuarios();
    }

    private void criaComponentes() {
        int a = 70;
        lblUsuario.setBounds(larguraJanela / 2 - 200 + a, alturaJanela / 6, 200, 30);
        add(lblUsuario);

        txtUsuario.setBounds(larguraJanela / 2 - a, alturaJanela / 6, 200, 30);
        add(txtUsuario);

        lblSenha.setBounds(larguraJanela / 2 - 200 + a, alturaJanela / 3, 200, 30);
        add(lblSenha);

        txtSenha.setBounds(larguraJanela / 2 - a, alturaJanela / 3, 200, 30);
        add(txtSenha);

        btnLogar.setBounds(larguraJanela / 2 - 100, alturaJanela / 5 * 3, 200, 50);
        add(btnLogar);
        btnLogar.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }

        });

    }

    protected void logar() {
        Arquivo arquivo = new Arquivo();
        try {
            Object usuario = arquivo.validarLogin(txtUsuario.getText(), String.valueOf(txtSenha.getPassword()));

            switch (checarTipoUsuario(usuario)) {
            case 1:
                // InterfaceCoordenador interfaceCoordenador = new InterfaceCoordenador();
                // interfaceCoordenador.inicializa();
                break;

            case 2:
                InterfaceAluno interfaceAluno = new InterfaceAluno();
                interfaceAluno.inicializa();
                break;

            case 3:
                InterfaceProfessor interfaceProfessor = new InterfaceProfessor();
                interfaceProfessor.inicializa();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos", appName, JOptionPane.WARNING_MESSAGE);
                break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não foi possível realizar o Login", appName,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private int checarTipoUsuario(Object usuario) {
        String tipo = usuario.getClass().toString();
        System.out.println(tipo);
        if (tipo.contains("Aluno")) {
            return 2;
        } else if (tipo.contains("Professor")) {
            return 3;
        } else if (tipo.contains("Coordenador")) {
            return 1;
        } else {
            return 0;
        }
    }

    private void checarArquivoUsuarios() {
        Arquivo arquivo = new Arquivo();
        if (!arquivo.arquivoExiste(Arquivo.usuarios)) {
            JOptionPane.showMessageDialog(this, "Primeira execução do Gerenciador\nCrie um Coordenador", appName,
                    JOptionPane.INFORMATION_MESSAGE);
            String nome = JOptionPane.showInputDialog(this, "Digite o Nome Completo", appName,
                    JOptionPane.DEFAULT_OPTION);
            String user = JOptionPane.showInputDialog(this, "Digite o Login", appName, JOptionPane.DEFAULT_OPTION);
            String senha = JOptionPane.showInputDialog(this, "Digite a Senha", appName, JOptionPane.DEFAULT_OPTION);
            String[] coord = { nome, user, senha, "C" };
            arquivo.escreverArquivo(Arquivo.usuarios, coord);
        }
        ;

    }

    public void inicializa() {
        setVisible(true);
    }

}