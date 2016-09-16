package com.gx.model;

import java.math.BigDecimal;
import java.util.Date;

public class ObjUserOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.pid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.p_price
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private BigDecimal p_price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.p_num
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Integer p_num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.total_amount
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private BigDecimal total_amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.uid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.eid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Long eid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.expect_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Date expect_tm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.pay_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Date pay_tm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.create_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Date create_tm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.pay_type
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private String pay_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.status
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.logistics
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private String logistics;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_order.order_id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Long order_id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.id
     *
     * @return the value of obj_user_order.id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.id
     *
     * @param id the value for obj_user_order.id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.pid
     *
     * @return the value of obj_user_order.pid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.pid
     *
     * @param pid the value for obj_user_order.pid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.p_price
     *
     * @return the value of obj_user_order.p_price
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public BigDecimal getP_price() {
        return p_price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.p_price
     *
     * @param p_price the value for obj_user_order.p_price
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setP_price(BigDecimal p_price) {
        this.p_price = p_price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.p_num
     *
     * @return the value of obj_user_order.p_num
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Integer getP_num() {
        return p_num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.p_num
     *
     * @param p_num the value for obj_user_order.p_num
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setP_num(Integer p_num) {
        this.p_num = p_num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.total_amount
     *
     * @return the value of obj_user_order.total_amount
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.total_amount
     *
     * @param total_amount the value for obj_user_order.total_amount
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.uid
     *
     * @return the value of obj_user_order.uid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.uid
     *
     * @param uid the value for obj_user_order.uid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.eid
     *
     * @return the value of obj_user_order.eid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Long getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.eid
     *
     * @param eid the value for obj_user_order.eid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setEid(Long eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.expect_tm
     *
     * @return the value of obj_user_order.expect_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Date getExpect_tm() {
        return expect_tm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.expect_tm
     *
     * @param expect_tm the value for obj_user_order.expect_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setExpect_tm(Date expect_tm) {
        this.expect_tm = expect_tm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.pay_tm
     *
     * @return the value of obj_user_order.pay_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Date getPay_tm() {
        return pay_tm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.pay_tm
     *
     * @param pay_tm the value for obj_user_order.pay_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setPay_tm(Date pay_tm) {
        this.pay_tm = pay_tm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.create_tm
     *
     * @return the value of obj_user_order.create_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Date getCreate_tm() {
        return create_tm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.create_tm
     *
     * @param create_tm the value for obj_user_order.create_tm
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setCreate_tm(Date create_tm) {
        this.create_tm = create_tm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.pay_type
     *
     * @return the value of obj_user_order.pay_type
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getPay_type() {
        return pay_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.pay_type
     *
     * @param pay_type the value for obj_user_order.pay_type
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.status
     *
     * @return the value of obj_user_order.status
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.status
     *
     * @param status the value for obj_user_order.status
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.logistics
     *
     * @return the value of obj_user_order.logistics
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getLogistics() {
        return logistics;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.logistics
     *
     * @param logistics the value for obj_user_order.logistics
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_order.order_id
     *
     * @return the value of obj_user_order.order_id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Long getOrder_id() {
        return order_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_order.order_id
     *
     * @param order_id the value for obj_user_order.order_id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_order
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", p_price=").append(p_price);
        sb.append(", p_num=").append(p_num);
        sb.append(", total_amount=").append(total_amount);
        sb.append(", uid=").append(uid);
        sb.append(", eid=").append(eid);
        sb.append(", expect_tm=").append(expect_tm);
        sb.append(", pay_tm=").append(pay_tm);
        sb.append(", create_tm=").append(create_tm);
        sb.append(", pay_type=").append(pay_type);
        sb.append(", status=").append(status);
        sb.append(", logistics=").append(logistics);
        sb.append(", order_id=").append(order_id);
        sb.append("]");
        return sb.toString();
    }
}