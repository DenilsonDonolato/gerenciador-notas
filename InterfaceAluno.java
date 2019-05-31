import javax.swing.*;

public class InterfaceAluno extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 800;
    private static final int alturaJanela = 450;

    InterfaceAluno() {
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
        JLabel lblUsuario = new JLabel("Aluno: ");
        lblUsuario.setBounds(larguraJanela/2-200+a, 20 ,200,30);
        add(lblUsuario);
        
        JLabel txtUsuario = new JLabel(" Nome do aluno aqui.");
        txtUsuario.setBounds(larguraJanela/2-a, 20, 200, 30);
        add(txtUsuario);

        JComboBox<String> cmbMaterias = new JComboBox<>();
        cmbMaterias.setBounds(larguraJanela/2-100, 50 ,200,30);
        add(cmbMaterias);
        cmbMaterias.setToolTipText("Selecione a Disciplina:");
        cmbMaterias.setEditable(true);
        cmbMaterias.setSelectedItem("Selecione a disciplina:");
        cmbMaterias.setEditable(false);
        cmbMaterias.addItem("Matemática Discreta");
        cmbMaterias.addItem("Cálculo");
        cmbMaterias.addItem("Java");
        cmbMaterias.addItem("Hardware");

        JLabel lblDisciplina = new JLabel("Disiciplina");
        lblDisciplina.setBounds(100, 150, 200, 30);
        add(lblDisciplina);
        
        JLabel lblFalta = new JLabel("Faltas:");
        lblFalta.setBounds(200, 150, 200, 30);
        add(lblFalta);
        JLabel lblNumFaltas = new JLabel("9");
        lblNumFaltas.setBounds(250, 150, 200, 30);
        add(lblNumFaltas);

        JLabel lblNota1 = new JLabel("P1:");
        lblNota1.setBounds(200, 200, 200, 30);
        add(lblNota1);
        JLabel lblValorNotaP1 = new JLabel("9");
        lblValorNotaP1.setBounds(220, 200, 200, 30);
        add(lblValorNotaP1);

        JLabel lblNota2 = new JLabel("P2:");
        lblNota2.setBounds(250, 200, 200, 30);
        add(lblNota2);
        JLabel lblValorNotaP2 = new JLabel("9");
        lblValorNotaP2.setBounds(270, 200, 200, 30);
        add(lblValorNotaP2);

        JLabel lblMedia = new JLabel("Média:");
        lblMedia.setBounds(230, 250, 200, 30);
        add(lblMedia);
        JLabel lblNotaMedia = new JLabel("9");
        lblNotaMedia.setBounds(270, 250, 200, 30);
        add(lblNotaMedia);
        

        JButton btnLogar = new JButton("Sair");
        btnLogar.setBounds(larguraJanela/2-100, alturaJanela-100, 200 , 50);
        add(btnLogar);

    }

    public void inicializa() {
        setVisible(true);
    }

}