package com.fqz.skeleton.model;

import javax.naming.ConfigurationException;
import java.util.HashMap;

public enum ResultType{
    //0..-999 success, control/option info
    SUCCESS("ctl.success", 0),
    REDIRECT("ctl.redirect", -302),
    NOT_MODIFIED("ctl.not.modified", -304),

    //-1000..-1999 invalid/missing input value
    INVALID_INPUT("val.invalid.input", -1000),
    INVALID_URL_PARAM("val.invalid.param", -1001),
    INVALID_JSON("val.invalid.json", -1002),
    INVALID_PASSWORD("val.invalid.password", -1010),


    //-2000..-2999 constraint violation
    DUPLICATED_VALUE("vlt.duplicated.value",-2000),
    DUPLICATED_USER("vlt.duplicated.user",-2001),
    DUPLICATED_ACCOUNT("vlt.duplicated.account",-2002),

    //-3000..-3999 record missing/invalid
    NOT_EXIST("rcd.not.exist",-3000),
    NOT_EXIST_USER("rcd.not.exist.user", -3001),
    NOT_EXIST_ACCOUNT("rcd.not.exist.account", -3002),

    //-5000..-5999 permission violation
    SERVER_REJECTED("pms.server.reject", -5000),
    USER_DENIED("pms.user.deny", -5100),

    CUSTOM_ERROR("",-9999),

    //-10000... internal error doesn't shown to user
    INTERNAL_ERROR("int.internal.error",-10000),
    REMOTE_ERROR("int.remote.error",-10001),

    CONFIGURATION_ERROR("cfg.config.error", -20000),
    CONFIGURATION_INVALID_EXCEPTION_HANDLER("cfg.invalid.exception.handler", -20010);

    static private final HashMap<Integer, ResultType> codeMap = new HashMap<>();

    private String message;
    private int code;

    ResultType(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public static ResultType getByCode(int code) throws ConfigurationException {
        if (codeMap.isEmpty()) initCodeMap();
        ResultType resultType = codeMap.get(code);
        if (resultType==null)
            return CUSTOM_ERROR;
        return resultType;
    }

    private synchronized static void initCodeMap() throws ConfigurationException {
        if (!codeMap.isEmpty()) return;

        for (ResultType resultType : ResultType.values()){
            if (codeMap.containsKey(resultType.getCode()))
                throw new ConfigurationException("duplicated code");
            codeMap.put(resultType.getCode(), resultType);
        }
    }
}
