/**
*
* Exceção para expressões aritméticas inválidas
* 
* @author  Gabriele Colares Serevino / João Enrique Cairuga
* @version 2022-10-15
 */

public class ExpressaoAritmeticaInvalidaException extends Exception {

    public ExpressaoAritmeticaInvalidaException(String message){
        super(message);
    }
}