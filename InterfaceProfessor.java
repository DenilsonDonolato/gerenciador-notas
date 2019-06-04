import javax.swing.*;

public class InterfaceProfessor extends JFrame {

    private static final long serialVersionUID = 2L;
    private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 400;
    private static final int alturaJanela = 450;

    InterfaceProfessor() {
        setLayout(null);
        setTitle(appName);
        setSize(larguraJanela, alturaJanela);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(260, 115);
        setResizable(false);
        setLocationRelativeTo(null);

        criaComponentes();
    }

    private void criaComponentes() {
        JLabel lblUsuario = new JLabel("Aluno: ");
        lblUsuario.setBounds(larguraJanela/2-90, 20 ,200,30);
        add(lblUsuario);
        
        JLabel txtUsuario = new JLabel(" Nome do aluno aqui.");
        txtUsuario.setBounds(larguraJanela/2-50, 20, 200, 30);
        add(txtUsuario);
        
        JLabel lblFalta = new JLabel("Faltas:");
        lblFalta.setBounds(165, 150, 200, 30);
        add(lblFalta);
        JLabel lblNumFaltas = new JLabel("9");
        lblNumFaltas.setBounds(220, 150, 200, 30);
        add(lblNumFaltas);

        JLabel lblNota1 = new JLabel("P1:");
        lblNota1.setBounds(165, 200, 200, 30);
        add(lblNota1);
        JLabel lblValorNotaP1 = new JLabel("9");
        lblValorNotaP1.setBounds(220, 200, 200, 30);
        add(lblValorNotaP1);

        JLabel lblNota2 = new JLabel("P2:");
        lblNota2.setBounds(165, 250, 200, 30);
        add(lblNota2);
        JLabel lblValorNotaP2 = new JLabel("9");
        lblValorNotaP2.setBounds(220, 250, 200, 30);
        add(lblValorNotaP2);

        JLabel lblMedia = new JLabel("Média:");
        lblMedia.setBounds(165, 300, 200, 30);
        add(lblMedia);
        JLabel lblNotaMedia = new JLabel("9");
        lblNotaMedia.setBounds(220, 300, 200, 30);
        add(lblNotaMedia);
        

        JButton btnLogar = new JButton("Sair");
        btnLogar.setBounds(larguraJanela/2-100, alturaJanela-100, 200 , 50);
        add(btnLogar);

    }

    public void inicializa() {
        setVisible(true);
    }

}