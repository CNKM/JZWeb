package FrameWork.SYS.User;

import FrameWork.BAS.ServletBase;
import FrameWork.Comm.ActionReturn;
import FrameWork.Comm.Helper.StringHelper;
import FrameWork.Comm.Helper.WebInteractiveHelper;
import FrameWork.DAL.DalHelper;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;


/**
 * Created by xda on 16-6-20.
 */
public class Login extends ServletBase
{


    private void ToFail(HttpServletResponse res) throws IOException
    {
        WebInteractiveHelper.ToResponseStr(res, new ActionReturn(0, "登录失败").toString());
    }

    private void ToSuccess(HttpServletResponse res) throws IOException
    {
        WebInteractiveHelper.ToResponseStr(res, new ActionReturn(0, "登陆成功").toString());
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) throws IOException
    {

        String Uname = WebInteractiveHelper.GetRequestParmeValue(req, "UName");
        String Upwd = WebInteractiveHelper.GetRequestParmeValue(req, "UPwd");
        if (StringHelper.IsNullorEmpty(Uname))
        {
            ToFail(res);
            return;
        }
        if (StringHelper.IsNullorEmpty(Upwd))
        {
            ToFail(res);
            return;
        }
        try
        {


            DalHelper DH = new DalHelper();

            ResultSet RS = DH.ExecSQL("Select * From T_UserInfo");

            if (Uname.equals("admin") && (Upwd.equals("admin")))
            {
                WebInteractiveHelper.SetSessionValue(req, "IsLogined", true);
                ToSuccess(res);
            }
            else
            {
                ToFail(res);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return;
        }


    }
}