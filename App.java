import javax.swing.*;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 800;
    private static final int alturaJanela = 450;

    App() {
        setLayout(null);
        setTitle(appName);
        setSize(larguraJanela, alturaJanela);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(260, 115);
        setResizable(false);
        setLocationRelativeTo(null);

        criaComponentes();
    }

    private void criaComponentes() {
        int a = 70;
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(larguraJanela/2-200+a, alturaJanela/6 ,200,30);
        add(lblUsuario);
        
        JTextField txtUsuario = new JTextField("");
        txtUsuario.setBounds(larguraJanela/2-a, alturaJanela/6, 200, 30);
        add(txtUsuario);
        
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(larguraJanela/2-200+a, alturaJanela/3 ,200,30);
        add(lblSenha);
        
        JPasswordField txtSenha = new JPasswordField("");
        txtSenha.setBounds(larguraJanela/2-a, alturaJanela/3, 200, 30);
        add(txtSenha);
        
        JButton btnLogar = new JButton("Logar");
        btnLogar.setBounds(larguraJanela/2-100, alturaJanela/5*3, 200 , 50);
        add(btnLogar);

    }

    public void inicializa() {
        setVisible(true);
    }

}