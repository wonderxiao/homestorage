package cn.wonderxiao.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
@Component
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -1L;
    private String username;
    private Integer age;
}
