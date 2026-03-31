
package BridgeLabz_Training.jUnit;
public class UserRegistration {
    public void registerUser(String u,String e,String p){
        if(u==null||e==null||p==null)
            throw new IllegalArgumentException("Invalid input");
    }
}
