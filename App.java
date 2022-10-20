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
                StackLinkedList<String> pilha = new StackLinkedList<>();
                for(int i = 0; i<v.length; i++){
                    if (v[i].equals("}") || v[i].equals("]")  || v[i].equals(")")) {
                      String op2 = pilha.pop();  
                      String operador = pilha.pop();
                      String op1 = pilha.pop();
                      String abre = pilha.pop();
                      if (!(v[i].equals("}") && abre.equals("{") || v[i].equals("]") && abre.equals("[")  
                                                                        || v[i].equals(")") && abre.equals("("))) {
                        System.out.println("Erro de sintaxe: ");
                    }
                    
                    }

                    else {
                    pilha.push(v[i]);
                    }
                }
                System.out.println("--- Fim expressao");
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
