public class PasswordException extends RuntimeException{
    public PasswordException(String message)
    {
        super( message);
        System.out.println( "Error Message: " + message);
    }
}