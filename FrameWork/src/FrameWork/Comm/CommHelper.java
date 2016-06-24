package FrameWork.Comm;

/**
 * Created by xda on 16-6-19.
 */

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by XDAW on 2014-06-17.
 */
public class CommHelper
{

    public static ObjectMapper JacksonOM;

    static
    {
        JacksonOM = new ObjectMapper()
        {
        };
        JacksonOM.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING,true);
    }

    public static String ToJsonString(Object ToJsonStringObject)
    {
        try
        {
            return JacksonOM.writeValueAsString(ToJsonStringObject);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "error from object to json  string!";
    }

    public static String GetRequestParmeValue(HttpServletRequest req, String StrParmeName)
    {
        return req.getParameter(StrParmeName);
    }

    public static Boolean IsNullorEmpty(String str)
    {
        return str == null || str.trim().length() == 0;
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
