package Controller;

import Connection.RequestCode;
import Connection.ReturnCode;
import DAO.AddressDAO;
import DAO.UserDAO;
import Model.AddressInfo;
import Server.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class AddressController extends BaseController {
    private AddressDAO addressDAO;
    public AddressController()
    {
        requestCode = RequestCode.Address;
        addressDAO=new AddressDAO();
    }

    public String GetAddressList(String data, Client client, Server server)
    {
        int UserID=JSON.parseObject(data).getInteger("UserID");
        List<AddressInfo> addressInfoList=addressDAO.GetAddressInfoList(UserID);
        if(addressInfoList!=null)
        {
            return JSON.toJSONString(addressInfoList);
        }
        else
        {
            return "";
        }

    }
    public String SetDefaultAddress(String data, Client client, Server server)
    {
        int AddressID=JSON.parseObject(data).getInteger("AddressID");
        int UserID=JSON.parseObject(data).getInteger("UserID");
        boolean result=addressDAO.SetDefaultAddress(AddressID,UserID);
        if(result)
        {
            return String.valueOf(ReturnCode.Successed.ordinal());
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
    public String AddAddress(String data, Client client, Server server)
    {
        AddressInfo address=(AddressInfo) JSON.parseObject(data,AddressInfo.class);
        boolean result=addressDAO.AddAddress(address);
        if(result)
        {
            return String.valueOf(ReturnCode.Successed.ordinal());
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
}
