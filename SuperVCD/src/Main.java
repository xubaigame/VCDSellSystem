import Frame.*;
import Net.Client;

public class Main {
    public static void main(String[] args) {
        Client.getClient();
        Login l=new Login();
        l.setVisible(true);
        //OrderWindow o=new OrderWindow();
       // o.setVisible(true);
    }
}
