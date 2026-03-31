
package BridgeLabz_Training.jUnit;
public class PasswordValidator {
    public boolean isValid(String p){
        return p!=null && p.matches("(?=.*[A-Z])(?=.*\\d).{8,}");
    }
}
