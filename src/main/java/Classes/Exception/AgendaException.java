package Classes.Exception;

//Clase de tratamento de exceção quando usuário tentar entrar uma data inválida
public class AgendaException extends Exception {
    public AgendaException(String message) {
        super(message);
    }
}