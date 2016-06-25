package FrameWork.DAL;



import FrameWork.Comm.Helper.StringHelper;

import java.sql.*;


/**
 * Created by xda on 16-6-24.
 * 数据访问层
 */
public class DalHelper
{
    //数据库类型枚举
    public enum DBTYPEENUM
    {
        SQLSERVER, MYSQL, ORACL
    }


    private DBTYPEENUM DBType = DBTYPEENUM.MYSQL;
    private String DBDriver = "";
    private String DBName = "";
    private String DBUser = "";
    private String DBPassWord = "";
    private String DBURL = "";
    private String ConnectString = "";

    public DBTYPEENUM getDBType()
    {
        return DBType;
    }

    public void setDBType(DBTYPEENUM DBType)
    {
        this.DBType = DBType;
        this.MakeConnectString(this.DBType);
    }


    public String getDBName()
    {
        return DBName;
    }

    public void setDBName(String DBName)
    {
        this.DBName = DBName;
        this.MakeConnectString(this.DBType);
    }


    public String getDBUser()
    {
        return DBUser;
    }

    public void setDBUser(String DBUser)
    {
        this.DBUser = DBUser;
        this.MakeConnectString(this.DBType);
    }


    public String getDBPassWord()
    {
        return DBPassWord;

    }

    public void setDBPassWord(String DBPassWord)
    {
        this.DBPassWord = DBPassWord;
        this.MakeConnectString(this.DBType);
    }

    public String getDBURL()
    {
        return DBURL;
    }

    public void setDBURL(String DBURL)
    {
        this.DBURL = DBURL;
        this.MakeConnectString(this.DBType);
    }


    public String getConnectString()
    {
        this.MakeConnectString(this.DBType);
        return ConnectString;
    }

    Connection CurrentConnect;

    void MakeConnectString(DBTYPEENUM SYSDBTYPE)
    {
        this.DBType = SYSDBTYPE;
        switch (this.DBType)
        {
            case SQLSERVER:
                this.DBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                this.ConnectString = "jdbc:sqlserver://" + this.DBURL + ":1433";
                break;
            case MYSQL:
                this.DBDriver = "com.mysql.jdbc.Driver";
                this.ConnectString = "jdbc:mysql://" + this.DBURL + "/" + this.DBName + "";
                break;
            case ORACL:
                this.DBDriver = "oracle.jdbc.driver.OracleDriver";
                this.ConnectString = "jdbc:oracle:oci:@" + this.DBName;
                break;
        }
        try
        {
            Class.forName(DBDriver);
            CurrentConnect = DriverManager.getConnection(this.ConnectString, this.DBUser, this.DBPassWord);
            if (CurrentConnect.isClosed())
            {
                System.out.println("数据库链接失败");
            }
            else
            {
                System.out.println("数据库链接成功");
            }

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public DalHelper()
    {

        this.DBURL = StringHelper.ReadWebConfig("DBURL");
        this.DBName =StringHelper.ReadWebConfig("DBName");
        this.DBUser =StringHelper.ReadWebConfig("DBUSER");
        this.DBPassWord =StringHelper.ReadWebConfig("DBPWD");

        this.MakeConnectString(this.DBType);
    }



    public ResultSet ExecSQL(String SQLCOMMAND)
    {
        Statement statement = null;
        try
        {
            statement = this.CurrentConnect.createStatement();
            return statement.executeQuery(SQLCOMMAND);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}








