import javax.swing.*;

public class InterfaceProfessor extends JFrame {

    private static final long serialVersionUID = 2L;
    private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 500;
    private static final int alturaJanela = 600;

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
        //Area de Titulos
        JLabel lblTittle1 = new JLabel("ALUNOS");
        lblTittle1.setBounds(larguraJanela/2-190, 10 ,200,30);
        add(lblTittle1); 
        
        JLabel lblTittle2 = new JLabel("FALTAS");
        lblTittle2.setBounds(larguraJanela/2-40, 10 ,200,30);
        add(lblTittle2); 
        
        JLabel lblTittle3 = new JLabel("P1");
        lblTittle3.setBounds(300, 10 ,200,30);
        add(lblTittle3);

        JLabel lblTittle4 = new JLabel("P2");
        lblTittle4.setBounds(350, 10 ,200,30);
        add(lblTittle4);

        JLabel lblTittle5 = new JLabel("MEDIA");
        lblTittle5.setBounds(400, 10 ,200,30);
        add(lblTittle5);

        //Primeiro Aluno
        JLabel txtUsuario = new JLabel(" Nome do aluno aqui.");
        txtUsuario.setBounds(larguraJanela/2-230, 50, 200, 30);
        add(txtUsuario);

        JButton btnMenos = new JButton("-");
        btnMenos.setBounds(larguraJanela/2-43, 55, 15, 15);
        add(btnMenos);    
        
        JLabel lblNumFaltas = new JLabel("9");
        lblNumFaltas.setBounds(larguraJanela/2-23, 55, 15, 15);
        add(lblNumFaltas);

        JButton btnMais = new JButton("+");
        btnMais.setBounds(larguraJanela/2-13, 55, 15, 15);
        add(btnMais); 

        JTextField notaP1 = new JTextField("9");
        notaP1.setBounds(295, 55, 20, 20);
        add(notaP1);

        JTextField notaP2 = new JTextField("9");
        notaP2.setBounds(350, 55, 20, 20);
        add(notaP2);
        
        JLabel lblNotaMedia = new JLabel("9");
        lblNotaMedia.setBounds(415, 50, 200, 30);
        add(lblNotaMedia);
        //Fim Aluno1
        

        JButton btnLogar = new JButton("Sair");
        btnLogar.setBounds(larguraJanela/2-100, alturaJanela-100, 200 , 50);
        add(btnLogar);

    }

    public void inicializa() {
        setVisible(true);
    }

}