package pojos;

import Exceptions.EmailIncorrectException;
import Exceptions.PasswordIncorrectException;
import Exceptions.UsernameIncorrectException;
import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    String username;
    String password;
    String email;
    final String exresion_email = "^\\w*@\\w*\\.\\w*$";

    public User() {
        //empty
    }

    public User(String username, String password, String email) throws UsernameIncorrectException, PasswordIncorrectException, EmailIncorrectException {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws UsernameIncorrectException {
        if(username == null ||username.length() == 0){
            throw new UsernameIncorrectException( );
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws  PasswordIncorrectException{
        if(password == null || password.length() == 0){
            throw  new PasswordIncorrectException();
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws  EmailIncorrectException{
        if(email == null || email.length() == 0){
            throw new EmailIncorrectException();
        }

        if(!Pattern.matches(this.exresion_email,email)){
            throw new EmailIncorrectException();
        }
        this.email = email;
    }
}
