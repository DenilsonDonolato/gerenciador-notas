import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblUsuario, lblSenha;
    private JTextField txtUsuario, txtSenha;
    private JButton btnLogar;
    private JRadioButton btnAluno,btnProfessor;

    public Interface() {
        setTitle("Gerenciador de Notas");
        lblUsuario = new JLabel("Usuário: ");
        lblSenha = new JLabel("Senha: ");
        txtSenha = new JTextField("");
        txtUsuario = new JTextField("");
        btnLogar = new JButton("Logar");

        btnAluno = new JRadioButton("Aluno");
        btnProfessor = new JRadioButton("Professor");

        JPanel janela = new JPanel();
        janela.setLayout(new GridLayout(4,2,20,10));

        janela.add(lblUsuario);
        janela.add(txtUsuario);
        janela.add(lblSenha);
        janela.add(txtSenha);

        janela.add(btnAluno);
        janela.add(btnProfessor);

        janela.add(btnLogar);

        setContentPane(janela);

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnLogar.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                exibeMensagem();
            }
        });
    }

    private void exibeMensagem() {
        JOptionPane.showMessageDialog(null, "Logado com sucesso", "Gerenciador de Notas", JOptionPane.PLAIN_MESSAGE);
    }

}
