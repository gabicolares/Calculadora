
/**
 * 
 * Classe que implementa a calculadora
 * @author Gabriele Colares Severino
 * @author João Enrique Cairuga
 * @version 2022-10-21
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Calculadora {

    public static void main(String args[]) {
        BufferedReader reader;
        Path path1 = Paths.get("expressoes2.txt");
        try {
            reader = Files.newBufferedReader(path1, Charset.defaultCharset());
            String line = null;
            while ((line = reader.readLine()) != null) {

                String v[] = line.split(" "); // divide a string pelo espaco em branco
                StackLinked<String> pilha = new StackLinked<>();
                System.out.print("Expressao: "); // faz o print da expressão
                for (int i = 0; i < v.length; i++) {
                    System.out.print(v[i] + " ");
                }

                System.out.printf("%n %n");
                int tamMax = pilha.size(); // inicia com o valor da pilha vazia (0)
                boolean certo = true; // controla o print do tamanho da pilha

                for (int i = 0; i < v.length; i++) {
                    if (v[i].equals("}") || v[i].equals("]") || v[i].equals(")")) {
                        String op2 = pilha.pop();
                        String operador = pilha.pop();
                        String op1 = pilha.pop();
                        String abre = pilha.pop();
                        Double res;

                        try {
                            Double.parseDouble(op2); // verifica se op2 pode ser convertido para double
                        }

                        catch (Exception e) {
                            System.out.println("Erro de sintaxe: Era esperado um numero depois de " + op2);
                            certo = false;
                            break; // pula para a próxima expressão

                        }

                        try {
                            Double.parseDouble(op1);
                        }

                        catch (Exception e) {
                            System.out.println("Erro de sintaxe: Era esperado um numero depois de " + op1); // verifica se op1 pode ser convertido para double
                            certo = false;
                            break; // pula para a próxima expressão

                        }
                        // Testa se há erro nos pares de abre e fecha
                        if (v[i].equals(")") && !abre.equals("(") || v[i].equals("]") && !abre.equals("[")
                                || v[i].equals("}") && !abre.equals("{")) {
                            System.out.println("Erro de Sintaxe: Erro nos pares de abre e fecha");
                            certo = false;
                            break; // pula para a próxima expressão
                        }

                        // Testa se o valor do operador representa uma operação matemática válida e, se for, a realiza
                        switch (operador) {
                            case "+": // Soma
                                res = Double.parseDouble(op1) + Double.parseDouble(op2);
                                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                                if (abre.equals("{")) {
                                    System.out.printf("Resposta: %.2f%n", res);
                                }
                                break;
                            case "-": // Subtração
                                res = Double.parseDouble(op1) - Double.parseDouble(op2);
                                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                                if (abre.equals("{")) {
                                    System.out.printf("Resposta: %.2f%n", res);
                                }
                                break;
                            case "*": // Multiplicação
                                res = Double.parseDouble(op1) * Double.parseDouble(op2);
                                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                                if (abre.equals("{")) {
                                    System.out.printf("Resposta: %.2f%n", res);
                                }
                                break;
                            case "/": // Divisão
                                res = Double.parseDouble(op1) / Double.parseDouble(op2);
                                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                                if (abre.equals("{")) {
                                    System.out.printf("Resposta: %.2f%n", res);
                                }
                                break;
                            case "^": // Potenciação
                                res = Math.pow(Double.parseDouble(op1), Double.parseDouble(op2));
                                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                                if (abre.equals("{")) {
                                    System.out.printf("Resposta: %.2f%n", res);
                                }
                                break;
                            default:
                                System.out.println("Erro de Sintaxe: O operador " + operador + " não é válido");
                                break;
                        }

                    }

                    else {
                        pilha.push(v[i]); // adiciona elementos na pilha
                    }
                    // Checa se a pilha está maior do que o valor máximo anterior
                    if (tamMax < pilha.size()) {
                        tamMax = pilha.size();
                    }

                }

                if (certo == true) {
                    System.out.printf(
                            "Tamanho máximo da pilha: %d\n---------------------------------------------------------------------\n",
                            tamMax);
                }

                else {
                    System.out.printf("---------------------------------------------------------------------\n");
                }
            }

            reader.close();

        }

        catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }
}
