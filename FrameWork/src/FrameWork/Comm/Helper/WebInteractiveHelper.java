package FrameWork.Comm.Helper;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xda on 16-6-25.
 */
public class WebInteractiveHelper
{



    public static String getServerRootPath()
    {
        return ServerRootPath;
    }

    public static void setServerRootPath(java.lang.String serverRootPath)
    {
        ServerRootPath = serverRootPath;
    }

    static String ServerRootPath;

    public static String getServerWebInfPath()
    {
        return ServerWebInfPath;
    }

    public static void setServerWebInfPath(String serverWebInfPath)
    {
        ServerWebInfPath = serverWebInfPath;
    }

    static  String ServerWebInfPath;

    public static String GetRequestParmeValue(HttpServletRequest req, String StrParmeName)
    {
        return req.getParameter(StrParmeName);
    }

    public static void ToResponseStr(HttpServletResponse res, String StrValue) throws IOException
    {
        res.setHeader("Content-type", "text/html;charset=UTF-8");
        res.getWriter().write(StrValue);
    }

    public static void SetSessionValue(HttpServletRequest req, String PName, Object Palue)
    {
        req.getSession().setAttribute(PName, Palue);
    }

    public static Object GetSessionValue(HttpServletRequest req, String PName)
    {
        return req.getSession().getAttribute(PName);
    }

    public static void RemoveSessionValue(HttpServletRequest req, String PName)
    {
        req.getSession().removeAttribute(PName);
    }

    public static void ClearSession(HttpServletRequest req)
    {
        req.getSession().setMaxInactiveInterval(0);
    }


}
