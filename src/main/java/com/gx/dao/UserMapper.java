package com.gx.dao;

/**
 * Created by app on 16/9/1.
 */
import com.gx.model.ObjUser;
import com.gx.model.User;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Select;

import java.util.Map;


public interface UserMapper {

    /**
     * 方法名必须与映射文件中的id一致！
     * 方法名上面注释的那条语句就是用注解的实例
     * @param id 需要查找的id
     * @return 直接返回User对象！
     */
    //  @Select("select * from userinfo where id=#{id}")
    public ObjUser selectUserById(int id);



    public int pro_regist_p(Map param);

    public int pro_regist_b(Map param);


    public int pro_change_pwd(Map param);




}
