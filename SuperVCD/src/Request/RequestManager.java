package Request;

import Connection.ActionCode;
import sun.util.resources.cldr.naq.CalendarData_naq_NA;

import java.util.*;

public class RequestManager {
    private static RequestManager _instance;

    public static RequestManager getRequestManager() {
        if(_instance==null)
            _instance=new RequestManager();
        return _instance;
    }
    private RequestManager()
    {

    }
    private Map<ActionCode, BaseRequest>requestDict=new HashMap<>();
    public void AddRequest(ActionCode actionCode,BaseRequest request)
    {
        requestDict.put(actionCode, request);
    }
    public void RemoveRequest(ActionCode actionCode)
    {
        requestDict.remove(actionCode);
    }
    public void HandleReponse(ActionCode actionCode, String data)
    {
        BaseRequest request = requestDict.get(actionCode);
        if (request == null)
        {
            System.out.println("无法得到ActionCode[" + actionCode + "]对应的Request类");
            return;
        }
        request.OnResponse(data);
    }
}
