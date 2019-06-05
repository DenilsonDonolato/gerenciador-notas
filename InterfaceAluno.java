import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class InterfaceAluno extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 400;
    private static final int alturaJanela = 450;
    Aluno aluno;
    JLabel lblUsuario = new JLabel("Aluno: ");
    JLabel txtUsuario;
    JComboBox<String> cmbMaterias = new JComboBox<>();
    JLabel lblFalta = new JLabel("Faltas:");
    JLabel lblNumFaltas = new JLabel("-");
    JLabel lblNota1 = new JLabel("P1:");
    JLabel lblValorNotaP1 = new JLabel("-");
    JLabel lblNota2 = new JLabel("P2:");
    JLabel lblValorNotaP2 = new JLabel("-");
    JLabel lblMedia = new JLabel("Média:");
    JLabel lblNotaMedia = new JLabel("-");
    JButton btnSair = new JButton("Sair");

    InterfaceAluno(Aluno aluno) {
        setLayout(null);
        setTitle(appName);
        setSize(larguraJanela, alturaJanela);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(260, 115);
        setResizable(false);
        setLocationRelativeTo(null);

        this.aluno = aluno;

        criaComponentes();
    }

    private void criaComponentes() {
        lblUsuario.setBounds(larguraJanela / 2 - 90, 20, 200, 30);
        add(lblUsuario);

        txtUsuario = new JLabel(aluno.nome);
        txtUsuario.setBounds(larguraJanela / 2 - 50, 20, 200, 30);
        add(txtUsuario);

        cmbMaterias.setBounds(larguraJanela / 2 - 100, 70, 200, 30);
        add(cmbMaterias);
        cmbMaterias.setToolTipText("Selecione a Disciplina:");
        cmbMaterias.setEditable(true);
        cmbMaterias.setSelectedItem("Selecione a disciplina:");
        cmbMaterias.setEditable(false);
        for (String materia : aluno.materias) {
            cmbMaterias.addItem(materia);
        }
        cmbMaterias.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarValores(cmbMaterias.getSelectedItem().toString());
            }
        });

        lblFalta.setBounds(165, 150, 200, 30);
        add(lblFalta);
        lblNumFaltas.setBounds(220, 150, 200, 30);
        add(lblNumFaltas);

        lblNota1.setBounds(165, 200, 200, 30);
        add(lblNota1);
        lblValorNotaP1.setBounds(220, 200, 200, 30);
        add(lblValorNotaP1);

        lblNota2.setBounds(165, 250, 200, 30);
        add(lblNota2);
        lblValorNotaP2.setBounds(220, 250, 200, 30);
        add(lblValorNotaP2);

        lblMedia.setBounds(165, 300, 200, 30);
        add(lblMedia);
        lblNotaMedia.setBounds(220, 300, 200, 30);
        add(lblNotaMedia);

        btnSair.setBounds(larguraJanela / 2 - 100, alturaJanela - 100, 200, 50);
        add(btnSair);

        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                App app = new App();
                app.inicializa();
                dispose();
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }
        });
    }

    protected void mudarValores(String selectedItem) {
        Arquivo arquivo = new Arquivo();
        String nomeArquivo = arquivo.buscarMateria(selectedItem);

        aluno = arquivo.buscarDadosAluno(nomeArquivo,aluno);
        lblNumFaltas.setText(String.valueOf(aluno.faltas));
        lblValorNotaP1.setText(String.valueOf(aluno.notas[0]));
        lblValorNotaP2.setText(String.valueOf(aluno.notas[1]));
        lblNotaMedia.setText(String.valueOf(aluno.notas[2]));

    }

    public void inicializa() {
        setVisible(true);
    }



}