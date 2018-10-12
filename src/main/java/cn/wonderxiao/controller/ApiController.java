package cn.wonderxiao.controller;

import cn.wonderxiao.common.ReturnCode;
import cn.wonderxiao.model.UserModel;
import cn.wonderxiao.util.Result;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
@Api(tags = "API接口demo")
@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApiController {

    //get
    @ApiOperation(value = "获取用户",notes = "获取用户")
    @GetMapping("/get-user")
    public UserModel getUser(){
        UserModel userModel = new UserModel();
        userModel.setName("zhansan");
        userModel.setAge(25);
        return userModel;
    }

    @ApiOperation(value = "添加用户", notes = "通过用户姓名和年龄添加用户")
    @PostMapping("/add-user")
    public String addUser(@RequestParam("name") String name, @RequestParam("age") Integer age){
        Result result = new Result();
        result.setResult(ReturnCode.SUCCESS, name + "/" + age);
        return new Gson().toJson(result);
    }

    @ApiOperation(value = "修改用户", notes = "通过用户ID修改用户数据")
    @PutMapping("/update-user/{id}")
    public String updateUserById(@PathVariable("id") Integer id,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "age", required = false) Integer age){
        Result result = new Result();
        result.setResult(ReturnCode.SUCCESS, id + " / " + name + " / " + age);
        return new Gson().toJson(result);
    }

    @ApiOperation(value = "删除用户", notes = "通过用户ID删除用户数据")
    @DeleteMapping("/delete-user/{id}")
    public String deleteUserById (@PathVariable("id") Integer id) {
        Result result = new Result();
        result.setResult(ReturnCode.SUCCESS, id);
        return new Gson().toJson(result);
    }


}
