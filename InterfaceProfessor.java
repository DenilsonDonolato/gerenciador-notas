import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;

public class InterfaceProfessor extends JFrame {

    private static final long serialVersionUID = 2L;
    // private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 500;
    private static final int alturaJanela = 600;
    Professor professor;
    JComboBox<String> cmbMaterias = new JComboBox<>();
    ArrayList<Aluno> alunos = new ArrayList<>();

    InterfaceProfessor(Professor professor) {
        setLayout(null);
        setSize(larguraJanela, alturaJanela);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(260, 115);
        setResizable(false);
        setLocationRelativeTo(null);

        this.professor = professor;
        setTitle(professor.nome);

        criaComponentes();
    }

    private void criaComponentes() {

        cmbMaterias.setBounds(larguraJanela / 2 - 100, 10, 200, 30);
        add(cmbMaterias);
        cmbMaterias.setToolTipText("Selecione a Disciplina:");
        cmbMaterias.setEditable(true);
        cmbMaterias.setSelectedItem("Selecione a disciplina:");
        cmbMaterias.setEditable(false);
        for (String materia : professor.materias) {
            cmbMaterias.addItem(materia);
        }
        cmbMaterias.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //buscarAlunos(cmbMaterias.getSelectedItem().toString());
            }
        });

        // Area de Titulos
        JLabel lblTittle1 = new JLabel("ALUNOS");
        lblTittle1.setBounds(larguraJanela / 2 - 190, 50, 200, 30);
        add(lblTittle1);

        JLabel lblTittle2 = new JLabel("FALTAS");
        lblTittle2.setBounds(larguraJanela / 2 - 40, 50, 200, 30);
        add(lblTittle2);

        JLabel lblTittle3 = new JLabel("P1");
        lblTittle3.setBounds(300, 50, 200, 30);
        add(lblTittle3);

        JLabel lblTittle4 = new JLabel("P2");
        lblTittle4.setBounds(350, 50, 200, 30);
        add(lblTittle4);

        JLabel lblTittle5 = new JLabel("MEDIA");
        lblTittle5.setBounds(400, 50, 200, 30);
        add(lblTittle5);

        criaLinhaAluno(0);
        criaLinhaAluno(1);
        criaLinhaAluno(2);
        criaLinhaAluno(3);
        criaLinhaAluno(4);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(larguraJanela / 2 - 100, alturaJanela - 100, 100, 50);
        add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(larguraJanela / 2 - 100, alturaJanela - 100, 100, 50);
        add(btnSair);
        btnSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                sair();
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    protected void sair() {
        App app = new App();
        app.inicializa();
        dispose();
    }

    public void inicializa() {
        setVisible(true);
    }

    void criaLinhaAluno(int linha) {
        int espaço = linha*28;
        JLabel txtUsuario1 = new JLabel("Nome do aluno aqui.");
        txtUsuario1.setBounds(35, 85+espaço, 200, 20);
        add(txtUsuario1);

        JButton btnMenos1 = new JButton("-");
        btnMenos1.setBounds(larguraJanela / 2 - 45, 87+espaço, 15, 15);
        add(btnMenos1);
        btnMenos1.setToolTipText("Diminuir 1 falta");

        JLabel lblNumFaltas1 = new JLabel("9");
        lblNumFaltas1.setBounds(larguraJanela / 2 - 23, 85+espaço, 15, 20);
        add(lblNumFaltas1);

        JButton btnMais1 = new JButton("+");
        btnMais1.setBounds(larguraJanela / 2 - 10, 87+espaço, 15, 15);
        add(btnMais1);
        btnMais1.setToolTipText("Aumentar 1 falta");

        JTextField notaP11 = new JTextField("9");
        notaP11.setBounds(295, 85+espaço, 20, 20);
        add(notaP11);

        JTextField notaP21 = new JTextField("9");
        notaP21.setBounds(350, 85+espaço, 20, 20);
        add(notaP21);

        JLabel lblNotaMedia1 = new JLabel("9");
        lblNotaMedia1.setBounds(415, 85+espaço, 200, 20);
        add(lblNotaMedia1);
    }

}