package com.gx.dao;

import com.gx.model.ObjEntShop;
import com.gx.model.ObjEntShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjEntShopMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int countByExample(ObjEntShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByExample(ObjEntShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int deleteByPrimaryKey(Long eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insert(ObjEntShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int insertSelective(ObjEntShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    List<ObjEntShop> selectByExample(ObjEntShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") ObjEntShop record, @Param("example") ObjEntShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_ent_shop
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    int updateByExample(@Param("record") ObjEntShop record, @Param("example") ObjEntShopExample example);
}