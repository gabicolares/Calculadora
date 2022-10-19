
/**
 * 
 * Classe que implementa a calculadora
 * @author Gabriele Colares Severino
 * @author João Enrique Cairuga
 * @version 2022-10-17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Calculadora {

    public static void main(String[] args) {

        BufferedReader reader;
        Path path1 = Paths.get("expressoes2.txt");
        try {
            reader = Files.newBufferedReader(path1, Charset.defaultCharset());
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("--- Inicio expressao");
                String v[] = line.split(" "); // divide a string pelo espaco em branco
                String expressao[] = v.clone();
                System.out.println("--- Fim expressao");

                if (verificaExpressao(expressao)) {
                    StackLinkedList<String> pilha = new StackLinkedList<>();
                    int tam = pilha.size();
                    boolean auxP1 = false;
                    boolean auxCol1 = false;

                    // Calcula os valores entre parênteses
                    for (int i = 0; i < v.length; i++) {
                        pilha.push(v[i]);
                        if (v[i].equals("("))
                            auxP1 = true;
                        if (auxP1 && pilha.top().equals(")")) {
                            if (tam < pilha.size())
                                tam = pilha.size();
                            pilha.pop(); // remove o ")"
                            String op2 = pilha.pop();
                            String operador = pilha.pop();
                            String op1 = pilha.pop();
                            pilha.pop(); // remove o "("
                            pilha.push(calcula(op1, operador, op2).toString());

                            auxP1 = false;
                        }
                    }
                    // Calcula os valores entre colchetes
                    for (int i = 0; i < v.length; i++) {
                        pilha.push(v[i]);
                        if (v[i].equals("["))
                            auxCol1 = true;
                        if (auxCol1 && pilha.top().equals("]")) {
                            if (tam < pilha.size())
                                tam = pilha.size();
                            pilha.pop(); // remove o "]"
                            String op2 = pilha.pop();
                            String operador = pilha.pop();
                            String op1 = pilha.pop();
                            pilha.pop(); // remove o "["
                            pilha.push(calcula(op1, operador, op2).toString());
                            auxCol1 = false;
                        }
                    }
                    pilha.pop(); // remove o "}"
                    String op2 = pilha.pop();
                    String operador = pilha.pop();
                    String op1 = pilha.pop();
                    pilha.pop(); // remove o "{"
                    double res = 0;
                    if (pilha.isEmpty())
                        res = calcula(op1, operador, op2);

                    System.out.print("Expressão: ");
                    String exp = "";
                    for (int i = 0; i < expressao.length; i++) {
                        exp += expressao[i] + " ";
                    }
                    System.out.println("Expressão" + exp);
                    System.out.printf("Resultado: %.2f\n", res);
                    System.out.printf("Tamanho máximo da pilha: %d\n", tam);

                }

                else {
                    System.out.print("Erro de sintaxe:");
                    verificaExpressao(expressao);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

    }

    /**
     * Verifica se a expressão passada como parâmetro é válida
     * 
     * @param expressao a ser analisada
     * @return true caso ela seja válida e false + mensagem de erro caso seja
     *         inválida
     * @version 2022-10-17
     */
    public static boolean verificaExpressao(String[] expressao) {
        int contadorParenteses = 0;
        int contadorChaves = 0;
        int contadorColchetes = 0;

        for (int i = 0; i < expressao.length; i++) {
            if (expressao[i].equals("(")) {
                contadorParenteses++;
            }

            if (expressao[i].equals(")")) {
                contadorParenteses--;
            }

            if (expressao[i].equals("[")) {
                contadorColchetes++;
            }

            if (expressao[i].equals("]")) {
                contadorColchetes--;
            }

            if (expressao[i].equals("{")) {
                contadorChaves++;
            }

            if (expressao[i].equals("}")) {
                contadorChaves--;
            }
        }

        if (contadorParenteses == 0 && contadorChaves == 0 && contadorColchetes == 0) {
            return true;
        }

        else if (contadorParenteses < 0) {
            System.out.printf("Existe(m) %d fechamento(s) de parênteses sem abertura\n", contadorParenteses * -1);
            return false;
        }

        else if (contadorParenteses > 0) {
            System.out.printf("Existe(m) %d abertura(s) de parênteses sem fechamento\n", contadorParenteses);
            return false;
        }

        else if (contadorColchetes < 0) {
            System.out.printf("Existe(m) %d fechamento(s) de colchetes sem abertura\n", contadorColchetes * -1);
            return false;
        }

        else if (contadorColchetes > 0) {
            System.out.printf("Existe(m) %d abertura(s) de colchetes sem fechamento\n", contadorColchetes);
            return false;
        }

        else if (contadorChaves < 0) {
            System.out.printf("Existe(m) %d fechamento(s) de chaves sem abertura\n", contadorChaves * -1);
            return false;
        }

        else if (contadorChaves > 0) {
            System.out.printf("Existe(m) %d abertura(s) de chaves sem fechamento\n", contadorChaves);
            return false;
        }
        return false;
    }

    /**
     *
     * Método que realiza os cálculos
     * 
     * @param x,op,y operando 1, operador, operando 2
     * @return resultado do cálculo
     *
     * @version 2022-10-17
     */
    public static Double calcula(String x, String op, String y) {
        double res = 0;

        if (op.equals("+")) {
            res = Double.parseDouble(x) + Double.parseDouble(y);
        } else if (op.equals("-")) {
            res = Double.parseDouble(x) - Double.parseDouble(y);
        } else if (op.equals("*")) {
            res = Double.parseDouble(x) * Double.parseDouble(y);
        } else if (op.equals("/")) {
            res = Double.parseDouble(x) / Double.parseDouble(y);
        } else if (op.equals("^")) {
            res = Math.pow(Double.parseDouble(x), Double.parseDouble(y));
        }

        return res;
    }

}
