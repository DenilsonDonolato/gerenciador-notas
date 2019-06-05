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
        JLabel txtUsuario1 = new JLabel(" Nome do aluno aqui.");
        txtUsuario1.setBounds(larguraJanela/2-230, 50, 200, 30);
        add(txtUsuario1);

        JButton btnMenos1 = new JButton(" ");
        btnMenos1.setBounds(larguraJanela/2-43, 55, 15, 15);
        add(btnMenos1); 

        Jlabel txmenos = new JLabel("-");
        txtmenos.setBounds(larguraJanela/2-43, 55, 15, 15);
        add(lblmenos) ;
        
        JLabel lblNumFaltas1 = new JLabel("9");
        lblNumFaltas1.setBounds(larguraJanela/2-23, 55,15, 15);
        add(lblNumFaltas1);

        JButton btnMais1 = new JButton(" ");
        btnMais1.setBounds(larguraJanela/2-13, 55, 15, 15);
        add(btnMais1); 

        Jlabel txmais = new JLabel("+");
        txtmenos.setBounds(larguraJanela/2-13, 55, 15, 15);
        add(lblmais);

        JTextField notaP11 = new JTextField("9");
        notaP11.setBounds(295, 55, 20, 20);
        add(notaP11);

        JTextField notaP21 = new JTextField("9");
        notaP21.setBounds(350, 55, 20, 20);
        add(notaP21);
        
        JLabel lblNotaMedia1 = new JLabel("9");
        lblNotaMedia1.setBounds(415, 50, 200, 30);
        add(lblNotaMedia1);
        //Fim Aluno1
    }

    public void inicializa() {
        setVisible(true);
    }

}