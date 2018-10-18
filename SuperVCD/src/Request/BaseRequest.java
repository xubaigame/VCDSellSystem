package Request;

import Connection.*;
import Net.Client;

public class BaseRequest {
    protected RequestCode requestCode = RequestCode.None;
    protected ActionCode actionCode = ActionCode.None;
    protected void SendRequest(String data)
    {
        Client.getClient().sendMessage(requestCode, actionCode, data);
    }

    public void OnResponse(String data)
    {

    }
}
