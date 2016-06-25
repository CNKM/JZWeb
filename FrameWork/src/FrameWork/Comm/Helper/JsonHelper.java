package FrameWork.Comm.Helper;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by xda on 16-6-25.
 */
public class JsonHelper
{

    public static ObjectMapper JacksonOM;

    static
    {
        JacksonOM = new ObjectMapper()
        {
        };
        JacksonOM.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);
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





}
