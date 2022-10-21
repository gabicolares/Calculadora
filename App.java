
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
  public static void main(String args[]) {
    BufferedReader reader;
    Path path1 = Paths.get("expressoes2.txt");
    try {
      reader = Files.newBufferedReader(path1, Charset.defaultCharset());
      String line = null;
      while ((line = reader.readLine()) != null) {
        System.out.println("--- Inicio expressao");
        String v[] = line.split(" "); // divide a string pelo espaco em branco
        StackLinkedList<String> pilha = new StackLinkedList<>();
        for (int i = 0; i < v.length; i++) {
          System.out.print(v[i] + " ");
        }
        System.out.printf("%n %n");
        int tamMax = pilha.size();
        for (int i = 0; i < v.length; i++) {
          if (v[i].equals("}") || v[i].equals("]") || v[i].equals(")")) {
            String op2 = pilha.pop();
            String operador = pilha.pop();
            String op1 = pilha.pop();
            String abre = pilha.pop();
            Double res;
            
           // boolean certo = true;
            

            if (v[i].equals("}") && !abre.equals("{")) {
              System.out.println("Erro de Sintaxe: Era esperado \"{\" no lugar de " + abre);
              break; // pula para a próxima expressão
            }
            
            if (v[i].equals("]") && !abre.equals("[")) {
              System.out.println("Erro de Sintaxe: Era esperado \"[\" no lugar de " + abre);
              break; // pula para a próxima expressão
            }
            
            if (v[i].equals(")") && !abre.equals("(")) {
              System.out.println("Erro de Sintaxe: Era esperado \"(\" no lugar de " + abre);
              break; // pula para a próxima expressão
            }
            
            if (op2.matches("^[0-9]+([,.][0-9]?)?$")) { //problemas no regex [0-9]+ não aceita
                                                              //números negativos nem com virgula
             System.out.println("Erro de Sintaxe: Era esperado um número no lugar de " + op2);
              break; // pula para a próxima expressão
            }
            if (!op1.matches("^[0-9]+([,.][0-9]?)?$")) { //problemas nesse regex
              System.out.println("Erro de Sintaxe: Era esperado um número no lugar de " + op1);
              break; // pula para a próxima expressão
            }

            switch (operador) {
              case "+": // Soma
                res = Double.parseDouble(op1) + Double.parseDouble(op2);
                v[i] = Double.toString(res); // aponta pro resultado da operação
                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                if (abre.equals("{")) {
                  System.out.printf("Resposta: %.2f%n", res);
              }
                break;
              case "-": // Subtração
                res = Double.parseDouble(op1) - Double.parseDouble(op2);
                v[i] = Double.toString(res); // aponta pro resultado da operação
                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                if (abre.equals("{")) {
                  System.out.printf("Resposta: %.2f%n", res);
              }
                break;
              case "*": // Multiplicação
                res = Double.parseDouble(op1) * Double.parseDouble(op2);
                v[i] = Double.toString(res); // aponta pro resultado da operação
                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                if (abre.equals("{")) {
                  System.out.printf("Resposta: %.2f%n", res);
              }
              case "/": // Divisão
                res = Double.parseDouble(op1) / Double.parseDouble(op2);
                v[i] = Double.toString(res); // aponta pro resultado da operação
                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                if (abre.equals("{")) {
                  System.out.printf("Resposta: %.2f%n", res);              }
                break;
              case "^": // Potenciação
                res = Math.pow(Double.parseDouble(op1), Double.parseDouble(op2));
                v[i] = Double.toString(res); // aponta pro resultado da operação
                pilha.push(Double.toString(res)); // empilha o resultado na pilha
                if (abre.equals("{")) {
                  System.out.printf("Resposta: %.2f%n", res);              }
                break;

              default:
                System.out.println("Erro de Sintaxe: O operador " + operador + " não é válido");
                break;
              }


          }

          else {
            pilha.push(v[i]);
          }

          if (tamMax < pilha.size()) {
            tamMax = pilha.size();
        }
        
        }
        System.out.println("Tamanho máximo da pilha: " + tamMax);
      }

      System.out.println("--- Fim expressao");

      reader.close();

    } 
    catch (IOException e) {
      System.err.format("Erro na leitura do arquivo: ", e);
    }
  }
}
