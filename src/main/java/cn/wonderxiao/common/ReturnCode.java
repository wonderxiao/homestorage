package cn.wonderxiao.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
public enum ReturnCode implements IReturnCode {
    ERROR(100, "Error"),
    SUCCESS(0, "Success");

    private Integer code;
    private String msg;

    ReturnCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
