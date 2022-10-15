public class Calculadora {
    
    /**
     * Verifica se a expressão passada como parâmetro é válida
     * @param expressao a ser analisada
     * @return true caso ela seja válida e false + mensagem de erro caso seja inválida
     */
    public static boolean verificaExpressao(String expressao) {
        int contadorParenteses = 0;
        int contadorChaves = 0;
        int contadorColchetes = 0;
        String[] separada = expressao.split(" ");

        while (true) {
            for (int i = 0; i < separada.length; i++) {
                if (separada[i] == "(") {
                    contadorParenteses++;
                }
                if (separada[i] == ")") {
                    contadorParenteses--;
                }

                if (separada[i] == "[") {
                    contadorColchetes++;
                }

                if (separada[i] == "]") {
                    contadorColchetes++;
                }

                if (separada[i] == "{") {
                    contadorChaves++;
                }

                if (separada[i] == "}") {
                    contadorChaves++;
                }
            }

            if (contadorParenteses == 0) {
                return true;
            }

            else if (contadorParenteses < 0) {
                System.out.printf("Existe(m) %d fechamento(s) de parênteses sem abertura", contadorParenteses*-1);
                return false;
            }

            else if (contadorParenteses > 0) {
                System.out.printf("Existe(m) %d abertura(s) de parênteses sem fechamento", contadorParenteses);
                return false;
            }

            if (contadorColchetes == 0) {
                return true;
            }

            else if (contadorColchetes < 0) {
                System.out.printf("Existe(m) %d fechamento(s) de colchetes sem abertura", contadorColchetes*-1);
                return false;
            }

            else if (contadorColchetes > 0) {
                System.out.printf("Existe(m) %d abertura(s) de colchetes sem fechamento", contadorColchetes);
                return false;
            }

            if (contadorChaves == 0) {
                return true;
            }

            else if (contadorChaves < 0) {
                System.out.printf("Existe(m) %d fechamento(s) de chaves sem abertura", contadorChaves*-1);
                return false;
            }

            else if (contadorChaves > 0) {
                System.out.printf("Existe(m) %d abertura(s) de chaves sem fechamento", contadorChaves);
                return false;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String teste = "{ ( 5 + 12 ) + [ ( 10 - 8 ) + 2 ] }";

        System.out.println(verificaExpressao(teste));
    }

}
