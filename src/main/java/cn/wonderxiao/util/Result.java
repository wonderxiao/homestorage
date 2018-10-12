package cn.wonderxiao.util;

import cn.wonderxiao.common.IReturnCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
@Data
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    /**
     * 设置返回码
     * @author xiaokai
     * @date 2018/10/11 16:10
     * @param [iReturnCode]
     * @return void
     */
    public void setResult(IReturnCode iReturnCode){
        common(iReturnCode);
    }
 
    /**
     * 添加数据
     * @author xiaokai
     * @date 2018/10/11 16:34
     * @param  : iReturnCode
     * @param : data
     * @return : void
     */              
    public void setResult(IReturnCode iReturnCode,Object data){
        common(iReturnCode);
        this.data = data;
    }

    private void common(IReturnCode iReturnCode){
        this.code = iReturnCode.getCode();
        this.msg = iReturnCode.getMsg();
    }
}
