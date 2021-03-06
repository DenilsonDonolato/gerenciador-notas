import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InterfaceProfessor extends JFrame {

    private static final long serialVersionUID = 2L;
    // private static final String appName = "Gerenciador de notas";
    private static final int larguraJanela = 500;
    private static final int alturaJanela = 600;
    int qtdeMaterias;
    JLabel[][] txtUsuario1;
    JButton[][] btnMenos1;
    JLabel[][] lblNumFaltas1;
    JButton[][] btnMais1;
    JTextField[][] notaP11;
    JTextField[][] notaP21;
    JLabel[][] lblNotaMedia1;

    Professor professor;
    JComboBox<String> cmbMaterias = new JComboBox<>();
    ArrayList<Turma> turma = new ArrayList<>();

    InterfaceProfessor(Professor professor) {
        setLayout(null);
        setSize(larguraJanela, alturaJanela);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(260, 115);
        setResizable(false);
        setLocationRelativeTo(null);

        this.professor = professor;
        for (String materia : professor.materias) {
            this.turma.add(new Turma(materia));
        }
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

        criaLinhaAluno();

        cmbMaterias.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mudarMateria(cmbMaterias.getSelectedIndex());
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

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(larguraJanela / 2 - 150, alturaJanela - 100, 100, 40);
        add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDados();
            }
        });
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(larguraJanela / 2 + 50, alturaJanela - 100, 100, 40);
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

    protected void salvarDados() {
        Arquivo arquivo = new Arquivo();
        arquivo.escreverArquivo(arquivo.buscarMateria(cmbMaterias.getSelectedItem().toString()),turma.get(cmbMaterias.getSelectedIndex()).alunos);
    }

    public void mudarMateria(int id) {
        boolean aFlag = false;
        for (int i = 0; i < qtdeMaterias; i++) {
            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                aFlag = (i == id) ? true : false;
                txtUsuario1[i][j].setVisible(aFlag);
                btnMenos1[i][j].setVisible(aFlag);
                lblNumFaltas1[i][j].setVisible(aFlag);
                btnMais1[i][j].setVisible(aFlag);
                notaP11[i][j].setVisible(aFlag);
                notaP21[i][j].setVisible(aFlag);
                lblNotaMedia1[i][j].setVisible(aFlag);
            }
        }
    }

    protected void sair() {
        App app = new App();
        app.inicializa();
        dispose();
    }

    public void inicializa() {
        setVisible(true);
    }

    void criaLinhaAluno() {
        int espaço = 0;
        int qtdeAlunos;
        qtdeMaterias = professor.materias.size();
        txtUsuario1 = new JLabel[qtdeMaterias][];
        btnMenos1 = new JButton[qtdeMaterias][];
        lblNumFaltas1 = new JLabel[qtdeMaterias][];
        btnMais1 = new JButton[qtdeMaterias][];
        notaP11 = new JTextField[qtdeMaterias][];
        notaP21 = new JTextField[qtdeMaterias][];
        lblNotaMedia1 = new JLabel[qtdeMaterias][];

        for (int i = 0; i < qtdeMaterias; i++) {
            qtdeAlunos = turma.get(i).alunos.size();

            txtUsuario1[i] = new JLabel[qtdeAlunos];
            btnMenos1[i] = new JButton[qtdeAlunos];
            lblNumFaltas1[i] = new JLabel[qtdeAlunos];
            btnMais1[i] = new JButton[qtdeAlunos];
            notaP11[i] = new JTextField[qtdeAlunos];
            notaP21[i] = new JTextField[qtdeAlunos];
            lblNotaMedia1[i] = new JLabel[qtdeAlunos];

            for (int j = 0; j < qtdeAlunos; j++) {
                espaço = j * 29;
                txtUsuario1[i][j] = new JLabel();
                txtUsuario1[i][j].setBounds(35, 85 + espaço, 200, 20);
                add(txtUsuario1[i][j]);
                txtUsuario1[i][j].setText(turma.get(i).alunos.get(j).nome);
                txtUsuario1[i][j].setVisible(false);

                btnMenos1[i][j] = new JButton();
                btnMenos1[i][j].setBounds(larguraJanela / 2 - 45, 87 + espaço, 15, 15);
                add(btnMenos1[i][j]);
                btnMenos1[i][j].setToolTipText("Diminuir 1 falta");
                btnMenos1[i][j].setVisible(false);
                btnMenos1[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (int i = 0; i < qtdeMaterias; i++) {
                            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                                if (ae.getSource() == btnMenos1[i][j]) {
                                    diminuirFalta(i, j);
                                }
                            }
                        }
                    }
                });

                lblNumFaltas1[i][j] = new JLabel();
                lblNumFaltas1[i][j].setBounds(larguraJanela / 2 - 23, 85 + espaço, 30, 20);
                add(lblNumFaltas1[i][j]);
                lblNumFaltas1[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).faltas));
                lblNumFaltas1[i][j].setVisible(false);

                btnMais1[i][j] = new JButton();
                btnMais1[i][j].setBounds(larguraJanela / 2 - 10, 87 + espaço, 15, 15);
                add(btnMais1[i][j]);
                btnMais1[i][j].setToolTipText("Aumentar 1 falta");
                btnMais1[i][j].setVisible(false);
                btnMais1[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for (int i = 0; i < qtdeMaterias; i++) {
                            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                                if (ae.getSource() == btnMais1[i][j]) {
                                    aumentarFalta(i, j);
                                }
                            }
                        }
                    }
                });

                notaP11[i][j] = new JTextField();
                notaP11[i][j].setBounds(295, 85 + espaço, 30, 20);
                add(notaP11[i][j]);
                notaP11[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).notas[0]));
                notaP11[i][j].setVisible(false);
                notaP11[i][j].getDocument().addDocumentListener(new DocumentListener() {

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        for (int i = 0; i < qtdeMaterias; i++) {
                            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                                if (e.getDocument() == notaP11[i][j].getDocument()) {
                                    mudarMediaTurmaAluno(i, j);
                                }
                            }
                        }
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        for (int i = 0; i < qtdeMaterias; i++) {
                            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                                if (e.getDocument() == notaP11[i][j].getDocument()) {
                                    mudarMediaTurmaAluno(i, j);
                                }
                            }
                        }
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                    }
                });

                notaP21[i][j] = new JTextField();
                notaP21[i][j].setBounds(350, 85 + espaço, 30, 20);
                add(notaP21[i][j]);
                notaP21[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).notas[1]));
                notaP21[i][j].setVisible(false);
                notaP21[i][j].getDocument().addDocumentListener(new DocumentListener() {

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        for (int i = 0; i < qtdeMaterias; i++) {
                            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                                if (e.getDocument() == notaP21[i][j].getDocument()) {
                                    mudarMediaTurmaAluno(i, j);
                                }
                            }
                        }
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        for (int i = 0; i < qtdeMaterias; i++) {
                            for (int j = 0; j < turma.get(i).alunos.size(); j++) {
                                if (e.getDocument() == notaP21[i][j].getDocument()) {
                                    mudarMediaTurmaAluno(i, j);
                                }
                            }
                        }
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                    }
                });

                lblNotaMedia1[i][j] = new JLabel();
                lblNotaMedia1[i][j].setBounds(415, 85 + espaço, 200, 20);
                add(lblNotaMedia1[i][j]);
                lblNotaMedia1[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).notas[2]));
                lblNotaMedia1[i][j].setVisible(false);
            }
            espaço = 0;
        }
    }

    protected void mudarMediaTurmaAluno(int i, int j) {
        double n0, n1;
        try {
            n0 = Double.parseDouble(notaP11[i][j].getText());
        } catch (Exception e) {
            n0 = 0;
        }
        try {
            n1 = Double.parseDouble(notaP21[i][j].getText());
        } catch (Exception e) {
            n1 = 0;
        }

        turma.get(i).alunos.get(j).notas[0] = n0;
        turma.get(i).alunos.get(j).notas[1] = n1;
        turma.get(i).alunos.get(j).notas[2] = turma.get(i).alunos.get(j).calcularMedia();
        lblNotaMedia1[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).notas[2]));
    }

    protected void aumentarFalta(int i, int j) {
        turma.get(i).alunos.get(j).faltas++;
        lblNumFaltas1[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).faltas));
    }

    protected void diminuirFalta(int i, int j) {
        if (turma.get(i).alunos.get(j).faltas > 0) {
            turma.get(i).alunos.get(j).faltas--;
            lblNumFaltas1[i][j].setText(String.valueOf(turma.get(i).alunos.get(j).faltas));
        }
    }
}