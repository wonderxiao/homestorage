package cn.wonderxiao.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
@Component
@Data
public class UserModel {
    @Size(max = 50)
    private String name;

    @Max(30)
    @Min(20)
    private Integer age;
}
