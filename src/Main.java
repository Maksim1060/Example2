import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import java.util.regex.Pattern;
public class Main {
    public static final String REQUIREMEENTS = "Логин/пaроль должен содержать только латинские буквы, цифры и подчеркивания";
    public static void main(String[] args) {
        String login = "Login";
        String password = "password";
        String confirmPassword = "password";
        try {
            checkLoginAndPassword(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Проверка  логина и пароля выполнена");
        }
    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        isLogin(login);
        isPasswordCorret(password,confirmPassword);
    }
    private static void isLogin(String login) throws WrongLoginException {
        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException(String.format("Логин не подходит под требования", login, REQUIREMEENTS));
        }
    }
    private static boolean isPasswordCorret(String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException(String.format("Пароль не подходит под требования ")+REQUIREMEENTS);
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароль не совпадает");
        }return true;
    }
}