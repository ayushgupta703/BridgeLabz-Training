package regexQ;

public class IPValidator {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String regex =
            "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}" +
            "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";

        System.out.println(ip.matches(regex));
    }
}
