package com.rss.db;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.rss.common.DataTypes;
import com.rss.config.Configuration;
import com.rss.exceptions.DBException;
import com.rss.exceptions.UniqueKeyException;
import com.rss.logger.LoggerAppenders;
import com.rss.pojo.*;
import snaq.db.ConnectionPoolManager;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Logger;

public class DBManager {
    private ConnectionPoolManager cpm = null;
    private static DBManager dbPool;
    private static final Logger log = Logger.getLogger(LoggerAppenders.DB);
    private long timeout=Long.parseLong(Configuration.getInstance().get("DB_TIMEOUT","2000"));
    private int numberOfRetries=Integer.parseInt(Configuration.getInstance().get("DB_RETRY","2"));
    private String poolName=Configuration.getInstance().get("DB_POOL_NAME","pool-rss");

    private DBManager()
    {
        try
        {
            this.cpm = ConnectionPoolManager.getInstance("dbpool.properties");
        }
        catch (IOException ex)
        {
            log.info("Error While Connecting with DBPool Properties file :=> " + ex.toString());
            ex.printStackTrace();;
        }
    }

    public static DBManager getInstance()
    {
        if (dbPool == null) {
            dbPool = new DBManager();
        }
        return dbPool;
    }

    public Connection  getConnection() throws Exception {
        for(int i=0;i<numberOfRetries;i++) {
            log.info("Trying to get connetion: ");
            try {
                Connection con = cpm.getConnection(poolName, timeout);
                log.info("Connection Created: " + con);
                if (con != null) {
                    log.info("Connection Created in If: " +"::"+con.toString() +con.isClosed());
                    return con;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DBException(ex.getLocalizedMessage());
            }
        }
        throw new DBException("Unable to get DB Connection");
    }

    public PreparedStatement replace(PreparedStatement stmt,ValueObjects[] values) throws SQLException {
        for(ValueObjects obj:values){
            if(obj.getDataType() == DataTypes.STRING) {
                stmt.setString(obj.getIndex(), (String) obj.getValue());
            }else if(obj.getDataType() == DataTypes.INT){
                stmt.setInt(obj.getIndex(), (Integer) obj.getValue());
            } else if(obj.getDataType() == DataTypes.LONG){
                stmt.setLong(obj.getIndex(), (Long) obj.getValue());
            } else if(obj.getDataType() == DataTypes.DOUBLE){
                stmt.setDouble(obj.getIndex(), (Double) obj.getValue());
            } else if(obj.getDataType() == DataTypes.BOOLEAN){
                stmt.setBoolean(obj.getIndex(), (Boolean) obj.getValue());
            } else if(obj.getDataType() == DataTypes.DATE){
                stmt.setDate(obj.getIndex(), (Date) obj.getValue());
            }
        }
        return stmt;
    }

    public boolean executeInsert(String query,ValueObjects[] values) throws DBException, UniqueKeyException {
        PreparedStatement insertStmt = null;
        try{
            Connection con = getConnection();
            insertStmt = con.prepareStatement(query);
            insertStmt = replace(insertStmt,values);
            log.info("insertStmt: "+insertStmt);
            insertStmt.execute();
            insertStmt.close();
            con.close();
        }catch (MySQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            throw new UniqueKeyException(e.getLocalizedMessage());
        }catch (Exception ef){
            ef.printStackTrace();
            throw new DBException(ef.getLocalizedMessage());
        }
        return true;
    }

    public boolean executeDelete(String query,ValueObjects[] values) throws DBException {
        PreparedStatement stmt = null;
        try{
            Connection con = getConnection();
            stmt = con.prepareStatement(query);
            stmt = replace(stmt,values);
            stmt.execute();
            stmt.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return true;
    }

    public boolean executeUpdate(String query,ValueObjects[] values) throws DBException {
        PreparedStatement updateStmt = null;
        try{
            Connection con = getConnection();
            updateStmt = con.prepareStatement(query);
            updateStmt = replace(updateStmt,values);
            updateStmt.executeUpdate();
            updateStmt.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return true;
    }


    public PlayerObject readUserObject(String query, ValueObjects[] values) throws DBException {
        PreparedStatement stmt = null;
        PlayerObject obj = new PlayerObject();
        try{
            Connection con = getConnection();
            stmt = con.prepareStatement(query);
            stmt = replace(stmt,values);
            ResultSet rs = stmt.executeQuery();
            //id,username,password,first_name,last_name,contact,email,fe,brand,product,language,country,ip,user_agent,source,user_type,createdAt,updatedAt
            while (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setFirst_name(rs.getString("first_name"));
                obj.setLast_name(rs.getString("last_name"));
                obj.setContact(rs.getString("contact"));
                obj.setEmail(rs.getString("email"));
                obj.setFe(rs.getString("fe"));
                obj.setBrand(rs.getString("brand"));
                obj.setProduct(rs.getString("product"));
                obj.setLanguage(rs.getString("language"));
                obj.setCountry(rs.getString("country"));
                obj.setIp(rs.getString("ip"));
                obj.setUser_agent(rs.getString("user_agent"));
                obj.setSource(rs.getString("source"));
                obj.setUser_type(rs.getString("user_type"));
                obj.setCreatedAt(rs.getDate("createdAt"));
                obj.setUpdatedAt(rs.getDate("updatedAt"));
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return obj;
    }



    public boolean executeSelect(String query,ValueObjects[] values) throws DBException {
        PreparedStatement stmt = null;
        try{
            Connection con = getConnection();
            stmt = con.prepareStatement(query);
            stmt = replace(stmt,values);
            ResultSet rs = stmt.executeQuery();
            /*
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
                obj.setCustomerId(rs.getString("CUSTOMER_ID"));
                objects.add(obj);
            }
             */
            rs.close();
            stmt.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return true;
    }
}
