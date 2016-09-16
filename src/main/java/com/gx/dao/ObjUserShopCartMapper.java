package com.gx.dao;

import com.gx.model.ObjUserShopCart;
import com.gx.model.ObjUserShopCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjUserShopCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int countByExample(ObjUserShopCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByExample(ObjUserShopCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insert(ObjUserShopCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insertSelective(ObjUserShopCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    List<ObjUserShopCart> selectByExample(ObjUserShopCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    ObjUserShopCart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") ObjUserShopCart record, @Param("example") ObjUserShopCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExample(@Param("record") ObjUserShopCart record, @Param("example") ObjUserShopCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByPrimaryKeySelective(ObjUserShopCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByPrimaryKey(ObjUserShopCart record);
}