package FrameWork.Comm.Helper;



import java.io.*;
import java.util.Properties;

/**
 * Created by xda on 16-6-25.
 */
public class StringHelper
{
    public static Boolean IsNullorEmpty(String str)
    {
        return str == null || str.trim().length() == 0;
    }



    //读取XML文件,并处理中文乱码
    public static String ReadWebConfig(String EntryKey)
    {
        Properties properties = new Properties();
        try
        {
            String FilePath =WebInteractiveHelper.getServerWebInfPath()+"WebConfig.xml";
            InputStream inputStream = new FileInputStream(FilePath);
            properties.loadFromXML(inputStream);
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            return properties.getProperty(EntryKey);
        }

    }

    //写资源文件到XML文件，含中文
    public static void WriteWebConfig(String EntryKey, String KeyValue)
    {
        Properties properties = new Properties();
        try
        {
            OutputStream outputStream = new FileOutputStream(WebInteractiveHelper.getServerWebInfPath()+"WebConfig.xml");
            properties.setProperty(EntryKey, KeyValue);
            properties.storeToXML(outputStream, "Author: PhyosStudio");
            outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
