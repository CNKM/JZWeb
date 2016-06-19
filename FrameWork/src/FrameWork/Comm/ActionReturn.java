package FrameWork.Comm;


/**
 * Created by XDAW on 2014-06-19.
 */
public class ActionReturn {

    Integer ActionReuslt;
    String ActionMsg;

    public ActionReturn(Integer actionReuslt, String actionMsg) {
        ActionReuslt = actionReuslt;
        ActionMsg = actionMsg;
    }

    public Integer getActionReuslt() {
        return ActionReuslt;
    }

    public void setActionReuslt(Integer actionReuslt) {
        ActionReuslt = actionReuslt;
    }

    public String getActionMsg() {
        return ActionMsg;
    }

    public void setActionMsg(String actionMsg) {
        ActionMsg = actionMsg;
    }

    @Override
    public String toString() {
        return CommHelper.ToJsonString(this);
    }
}
