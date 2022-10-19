import java.util.ArrayList;

public class Metodos{
    /**
     * Verifica se a expressão passada como parâmetro é válida
     * @param expressao a ser analisada
     * @return true caso ela seja válida e false + mensagem de erro caso seja inválida
     * @version 2022-10-17
     */
    public static boolean verificaExpressao(ArrayList <String> expressao) {
        int contadorParenteses = 0;
        int contadorChaves = 0;
        int contadorColchetes = 0;

            for (int i = 0; i < expressao.size(); i++) {
                if (expressao.get(i).equals("(")) {
                    contadorParenteses++;
                }

                if (expressao.get(i).equals(")")) {
                    contadorParenteses--;
                }

                if (expressao.get(i).equals("[")) {
                    contadorColchetes++;
                }

                if (expressao.get(i).equals("]")) {
                    contadorColchetes--;
                }

                if (expressao.get(i).equals("{")) {
                    contadorChaves++;
                }

                if (expressao.get(i).equals("}")) {
                    contadorChaves--;
                }
            }


            if (contadorParenteses == 0 && contadorChaves == 0 && contadorColchetes == 0) {
                return true;
            }

            else if (contadorParenteses < 0) {
                System.out.printf("Existe(m) %d fechamento(s) de parênteses sem abertura\n", contadorParenteses*-1);
                return false;
            }

            else if (contadorParenteses > 0) {
                System.out.printf("Existe(m) %d abertura(s) de parênteses sem fechamento\n", contadorParenteses);
                return false;
            }

            else if (contadorColchetes < 0) {
                System.out.printf("Existe(m) %d fechamento(s) de colchetes sem abertura\n", contadorColchetes*-1);
                return false;
            }

            else if (contadorColchetes > 0) {
                System.out.printf("Existe(m) %d abertura(s) de colchetes sem fechamento\n", contadorColchetes);
                return false;
            }

            else if (contadorChaves < 0) {
                System.out.printf("Existe(m) %d fechamento(s) de chaves sem abertura\n", contadorChaves*-1);
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
         * @param x,op,y operando 1, operador, operando 2
         * @return resultado do cálculo
         *
         * @version 2022-10-17
         */
         public static Double calcula(String x, String op, String y){
            double res = 0;
            
            if (op.equals("+")){
                res = Double.parseDouble(x) + Double.parseDouble(y);
            }
            else if (op.equals("-")) {
                 res = Double.parseDouble(x) - Double.parseDouble(y);
            }
            else if (op.equals("*")) {
                res = Double.parseDouble(x) * Double.parseDouble(y);
            }
            else if (op.equals("/")) {
                res = Double.parseDouble(x) / Double.parseDouble(y);
            }
            else if (op.equals("^")) {
                res = Math.pow(Double.parseDouble(x), Double.parseDouble(y));
            }
            
            return res;
         }
}