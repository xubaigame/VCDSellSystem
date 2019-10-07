package Controller;

import Connection.RequestCode;
import Server.*;

public class BaseController {
    protected RequestCode requestCode;
    public BaseController()
    {
        requestCode = RequestCode.None;
    }
    public String DefaultHandle(String data, Client client, Server server)
    {
        return null;
    }
    //protected DBHelper dbHelper;
}
