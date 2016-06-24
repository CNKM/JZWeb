package FrameWork.Comm;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import static java.util.Calendar.AM;

/**
 * Created by XDAW on 2014-06-19.
 */
public class ActionReturn {

    @JsonProperty
    Integer R;
    @JsonProperty
    String M;

    public ActionReturn(Integer actionReuslt, String actionMsg) {
        R = actionReuslt;
        M = actionMsg;
    }
    @JsonIgnore
    public Integer getR() {
        return R;
    }
    @JsonIgnore
    public void setR(Integer actionReuslt) {
        R = actionReuslt;
    }
    @JsonIgnore
    public String getM() {
        return M;
    }
    @JsonIgnore
    public void setM(String actionMsg) {
        M = actionMsg;
    }

    @Override
    public String toString() {
        return CommHelper.ToJsonString(this);
    }
}
