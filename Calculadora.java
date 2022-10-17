public class Calculadora {
    
    /**
     * Verifica se a expressão passada como parâmetro é válida
     * @param expressao a ser analisada
     * @return true caso ela seja válida e false + mensagem de erro caso seja inválida
     * @version 2022-10-17
     */
    public static boolean verificaExpressao(String expressao) {
        int contadorParenteses = 0;
        int contadorChaves = 0;
        int contadorColchetes = 0;
        String[] separada = expressao.split(" ");

            for (int i = 0; i < separada.length; i++) {
                if (separada[i].equals("(")) {
                    contadorParenteses++;
                }

                if (separada[i].equals(")")) {
                    contadorParenteses--;
                }

                if (separada[i].equals("[")) {
                    contadorColchetes++;
                }

                if (separada[i].equals("]")) {
                    contadorColchetes--;
                }

                if (separada[i].equals("{")) {
                    contadorChaves++;
                }

                if (separada[i].equals("}")) {
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

    public static void main(String[] args) {
        String teste = "{ ( 5 + 12 ) + [ ( 10 - 8 ) + 2 ] }";

        System.out.println(verificaExpressao(teste));
}
}


