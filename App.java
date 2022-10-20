import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App extends Metodos {
    public static void main(String args[]) {
        BufferedReader reader;
        Path path1 = Paths.get("expressoes2.txt");
        try {
            reader = Files.newBufferedReader(path1, Charset.defaultCharset());
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("--- Inicio expressao");
                String v[] = line.split(" "); // divide a string pelo espaco em branco
                ArrayList <String> expressao = new ArrayList<>();
                for(int i = 0; i<v.length; i++){
                    expressao.add(v[i]);
                }
                System.out.println("--- Fim expressao");

                if (verificaExpressao(expressao)) {
                    StackLinkedList<String> pilha = new StackLinkedList<>();
                    int tam = pilha.size();
                    boolean auxP1 = false;
                    boolean auxCol1 = false;

                    // Calcula os valores entre parênteses
                    for (int i = 0; i < expressao.size(); i++) {
                        pilha.push(v[i]);
                        if (v[i].equals("("))
                            auxP1 = true;
                        if (auxP1 && pilha.top().equals(")")) {
                            if (tam < pilha.size()) tam = pilha.size();
                            pilha.pop(); // remove o ")"
                            String op2 = pilha.pop();
                            System.out.println(op2);
                            String operador = pilha.pop();
                            System.out.println(operador);
                            String op1 = pilha.pop();
                            System.out.println(op1);
                            pilha.pop(); // remove o "("
                            pilha.push(calcula(op1, operador, op2).toString());
                            System.out.println(calcula(op1, operador, op2).toString());
                            auxP1 = false;
                        
                    }
                }

                    StackLinkedList <String> pilhaAux = new StackLinkedList<>();
                    // Calcula os valores entre colchetes
                    for (int i = 0; i < pilha.size(); i++) {
                        String aux = pilha.pop();
                        pilhaAux.push(aux);
                        if (aux.equals("]")) {
                            auxCol1 = true;
                        }
                        if (auxCol1 && pilha.top().equals("[")) {
                            if (tam < pilha.size()) tam = pilha.size();
                            pilhaAux.pop(); // remove o "]"
                            String op2 = pilhaAux.pop();
                            System.out.println(op2);
                            String operador = pilhaAux.pop();
                            System.out.println(operador);
                            String op1 = pilhaAux.pop();
                            System.out.println(op1);
                            pilhaAux.pop(); // remove o "["
                            pilhaAux.push(calcula(op1, operador, op2).toString());
                            System.out.println(calcula(op1, operador, op2).toString());
                            auxCol1 = false;
                            
                        }
                    }
                    
                    
                    pilhaAux.pop(); // remove o "}"
                    String op2 = pilhaAux.pop();
                    String operador = pilhaAux.pop();
                    String op1 = pilhaAux.pop();
                    pilhaAux.pop(); // remove o "{"
                    double res = 
                         calcula(op1, operador, op2);

                    String exp = "";
                    for (int i = 0; i < expressao.size(); i++) {
                        exp += expressao.get(i) + " ";
                    }
                    System.out.println("Expressao" + exp);
                    System.out.printf("Resultado: %.2f\n", res);
                    System.out.printf("Tamanho máximo da pilha: %d\n", tam);

                }
            

                else {
                    System.out.print("Erro de sintaxe:");
                    verificaExpressao(expressao);
                }
            }
            reader.close();
         }
          
            catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }
}
