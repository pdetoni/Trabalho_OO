/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes.Exception;

//Clase de tratamento de exceção quando usuário tentar entrar uma data inválida
public class AgendaException extends Exception {
    public AgendaException(String message) {
        super(message);
    }
}