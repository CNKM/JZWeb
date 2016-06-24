package FrameWork.SYS.User;

import FrameWork.Comm.ActionReturn;
import FrameWork.Comm.CommHelper;
import FrameWork.Comm.CoreServletBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by xda on 16-6-20.
 */
public class Login extends CoreServletBase
{


    private void ToFail(HttpServletResponse res) throws IOException
    {
        CommHelper.ToResponseStr(res, new ActionReturn(0, "登录失败").toString());
    }

    private void ToSuccess(HttpServletResponse res) throws IOException
    {
        CommHelper.ToResponseStr(res, new ActionReturn(0, "登陆成功").toString());
    }


    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) throws IOException
    {

        String Uname = CommHelper.GetRequestParmeValue(req, "UName");
        String Upwd = CommHelper.GetRequestParmeValue(req, "UPwd");
        if (CommHelper.IsNullorEmpty(Uname))
        {
            ToFail(res);
            return;
        }
        if (CommHelper.IsNullorEmpty(Upwd))
        {
            ToFail(res);
            return;
        }
        try
        {
/*
            DalHelper DH = new DalHelper();

            ResultSet RS = DH.ExecSQL("Select * From T_SYS_USERINFO");
            */
            if (Uname.equals("admin") && (Upwd.equals("admin")))
            {
                CommHelper.SetSessionValue(req, "IsLogined", true);
                ToSuccess(res);
            }
            else
            {
                ToFail(res);
            }
        }
        catch (Exception e)
        {


        }
        finally
        {
            return;
        }


    }
}