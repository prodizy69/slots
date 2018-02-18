package com.rss.services;

import com.rss.common.*;
import com.rss.config.Configuration;
import com.rss.config.PropertyKeys;
import com.rss.db.DBManager;
import com.rss.exceptions.InvalidSessionException;
import com.rss.exceptions.UniqueKeyException;
import com.rss.logger.LoggerAppenders;
import com.rss.pojo.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.logging.Logger;

@Path("/player")
public class PlayerService extends CoreService{
    private static final Logger log = Logger.getLogger(LoggerAppenders.REST_PLAYER);

    @POST
    @Path("/doRegister")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public RegistrationResponse doRegister(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:"+jsonString);
        RegistrationResponse response = new RegistrationResponse(false, Errors.TECHNICAL_ERROR);
        try {
            PlayerObject requestObj = (PlayerObject) JsonUtil.encodeToObj(jsonString, PlayerObject.class);
            ErrorObj errorObj = null;
            errorObj = this.validateString(requestObj.getUsername(),Constants.USERNAME, Constants.USERNAME_MIN_LENGTH, Constants.USERNAME_MAX_LENGTH);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            errorObj = this.validateString(requestObj.getPassword(),Constants.PASSWORD, Constants.PASSWORD_MIN_LENGTH, Constants.PASSWORD_MAX_LENGTH);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            errorObj = this.validateString(requestObj.getEmail(),Constants.EMAIL, 0,0);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            errorObj = this.validateString(requestObj.getContact(),Constants.CONTACT, 0,0);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            errorObj = this.validateString(requestObj.getFirst_name(),Constants.FIRST_NAME, Constants.USERNAME_MIN_LENGTH, Constants.USERNAME_MAX_LENGTH);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            errorObj = this.validateString(requestObj.getLast_name(),Constants.LAST_NAME, Constants.USERNAME_MIN_LENGTH, Constants.USERNAME_MAX_LENGTH);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }
            requestObj.setFe(Configuration.getInstance().get(PropertyKeys.FE));
            requestObj.setBrand(Configuration.getInstance().get(PropertyKeys.BRAND));
            requestObj.setProduct(Configuration.getInstance().get(PropertyKeys.PRODUCT));

            requestObj.setIp(this.getUserIp(req));
            requestObj.setUser_agent(this.getUserAgent(req));
            requestObj.setSource("web");
            requestObj.setUser_type(Constants.USER_TYPE_PLAYER);
            requestObj.setCreatedAt(new Date(System.currentTimeMillis()));
            requestObj.setUpdatedAt(new Date(System.currentTimeMillis()));

            ValueObjects[] values = new ValueObjects[17];
            values[0]=new ValueObjects(1, DataTypes.STRING,requestObj.getUsername());
            values[1]=new ValueObjects(2, DataTypes.STRING,requestObj.getPassword());
            values[2]=new ValueObjects(3, DataTypes.STRING,requestObj.getFirst_name());
            values[3]=new ValueObjects(4, DataTypes.STRING,requestObj.getLast_name());
            values[4]=new ValueObjects(5, DataTypes.STRING,requestObj.getContact());
            values[5]=new ValueObjects(6, DataTypes.STRING,requestObj.getEmail());
            values[6]=new ValueObjects(7, DataTypes.STRING,requestObj.getFe());
            values[7]=new ValueObjects(8, DataTypes.STRING,requestObj.getBrand());
            values[8]=new ValueObjects(9, DataTypes.STRING,requestObj.getProduct());
            values[9]=new ValueObjects(10, DataTypes.STRING,requestObj.getLanguage());
            values[10]=new ValueObjects(11, DataTypes.STRING,requestObj.getCountry());
            values[11]=new ValueObjects(12, DataTypes.STRING,requestObj.getIp());
            values[12]=new ValueObjects(13, DataTypes.STRING,requestObj.getUser_agent());
            values[13]=new ValueObjects(14, DataTypes.STRING,requestObj.getSource());
            values[14]=new ValueObjects(15, DataTypes.STRING,requestObj.getUser_type());
            values[15]=new ValueObjects(16, DataTypes.DATE,requestObj.getCreatedAt());
            values[16]=new ValueObjects(17, DataTypes.DATE,requestObj.getUpdatedAt());

            boolean status = DBManager.getInstance().executeInsert(Configuration.getInstance().get(PropertyKeys.CREATE_ACCOUNT_QUERY),values);
            if(status){
                response.setSuccess(true);
                response.setError(null);
            }
            return response;
        } catch (UniqueKeyException uke) {
            log.info("jsonString:"+jsonString+":error:"+uke.getLocalizedMessage());
            response.setError(Errors.USER_ALREADY_EXIST);
        } catch (Exception e) {
            log.info("jsonString:"+jsonString+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:"+jsonString+":response:"+response);
        return response;
    }

    @POST
    @Path("/doLogin")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public LoginResponse doLogin(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:"+jsonString);
        LoginResponse response = new LoginResponse(false, Errors.TECHNICAL_ERROR);
        try {
            LoginRequest requestObj = (LoginRequest) JsonUtil.encodeToObj(jsonString, LoginRequest.class);
            ErrorObj errorObj = null;
            errorObj = this.validateString(requestObj.getUsername(),Constants.USERNAME, Constants.USERNAME_MIN_LENGTH, Constants.USERNAME_MAX_LENGTH);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            errorObj = this.validateString(requestObj.getPassword(),Constants.PASSWORD, Constants.PASSWORD_MIN_LENGTH, Constants.PASSWORD_MAX_LENGTH);
            if( errorObj != null){
                response.setError(errorObj);
                return response;
            }

            requestObj.setFe(Configuration.getInstance().get(PropertyKeys.FE));
            requestObj.setBrand(Configuration.getInstance().get(PropertyKeys.BRAND));
            requestObj.setProduct(Configuration.getInstance().get(PropertyKeys.PRODUCT));

            requestObj.setUser_type(Constants.USER_TYPE_PLAYER);

            ValueObjects[] values = new ValueObjects[5];
            values[0]=new ValueObjects(1, DataTypes.STRING,requestObj.getUsername());
            values[1]=new ValueObjects(2, DataTypes.STRING,requestObj.getFe());
            values[2]=new ValueObjects(3, DataTypes.STRING,requestObj.getBrand());
            values[3]=new ValueObjects(4, DataTypes.STRING,requestObj.getProduct());
            values[4]=new ValueObjects(5, DataTypes.STRING,requestObj.getUser_type());

            PlayerObject obj = DBManager.getInstance().readUserObject(Configuration.getInstance().get(PropertyKeys.READ_ACCOUNT_QUERY),values);
            if(obj != null){
                if(obj.getPassword().equals(requestObj.getPassword())) {
                    response.setSuccess(true);
                    response.setError(null);
                    response.setUser(obj);
                    String existingSid = SessionService.getInstance().hasSession(obj.getId());
                    if( existingSid != null){
                        SessionService.getInstance().doLogOut(existingSid);
                    }
                    response.setSid(SessionService.getInstance().createSession(obj));
                }else{
                    response.setError(Errors.INVALID_PASSWORD);
                }
            }else{
                response.setError(Errors.USER_NOT_EXIST);
            }
            return response;

        } catch (Exception e) {
            log.info("jsonString:"+jsonString+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:"+jsonString+":response:"+response);
        return response;
    }

    @POST
    @Path("/doLogout")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public LogoutResponse doLogout(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:"+jsonString);
        LogoutResponse response = new LogoutResponse(false, Errors.TECHNICAL_ERROR);
        try {
            LogoutRequest requestObj = (LogoutRequest) JsonUtil.encodeToObj(jsonString, LogoutRequest.class);
            SessionService.getInstance().doLogOut(requestObj.getSid());
        } catch (Exception e) {
            log.info("jsonString:"+jsonString+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:"+jsonString+":response:"+response);
        return response;
    }

    @POST
    @Path("/forgotPassword")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public ForgotPasswordResponse forgotPassword(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:"+jsonString);
        ForgotPasswordResponse response = new ForgotPasswordResponse(false, Errors.TECHNICAL_ERROR);
        try {
            ForgotPasswordRequest requestObj = (ForgotPasswordRequest) JsonUtil.encodeToObj(jsonString, ForgotPasswordRequest.class);

        } catch (Exception e) {
            log.info("jsonString:"+jsonString+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:"+jsonString+":response:"+response);
        return response;
    }

    @POST
    @Path("/resetPassword")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public ResetPasswordResponse resetPassword(String jsonString, @Context final HttpServletRequest req) {
        log.info("jsonString:"+jsonString);
        ResetPasswordResponse response = new ResetPasswordResponse(false, Errors.TECHNICAL_ERROR);
        try {
            ResetPasswordRequest requestObj = (ResetPasswordRequest) JsonUtil.encodeToObj(jsonString, ResetPasswordRequest.class);

        } catch (Exception e) {
            log.info("jsonString:"+jsonString+":error:"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("jsonString:"+jsonString+":response:"+response);
        return response;
    }
}
