
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Turma turma = new Turma();
        boolean continua;

        turma.mostrarDados();
        do {
            continua = turma.modificarAlunos();//Modificar para inserir/excluir
        } while (continua);
    }
}