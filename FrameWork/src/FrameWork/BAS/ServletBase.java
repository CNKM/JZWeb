package FrameWork.BAS;

import com.sun.net.httpserver.HttpHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xda on 16-6-25.
 */
public class ServletBase extends HttpServlet
{
    public void doAction(HttpServletRequest req, HttpServletResponse res) throws IOException
    {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doAction(req,res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doAction(req,res);
    }
}
