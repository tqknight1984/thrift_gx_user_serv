package com.gx.model;

public class ObjUserComplaintEnt {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_complaint_ent.id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_complaint_ent.eid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private Long eid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_complaint_ent.status
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column obj_user_complaint_ent.remark
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_complaint_ent.id
     *
     * @return the value of obj_user_complaint_ent.id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_complaint_ent.id
     *
     * @param id the value for obj_user_complaint_ent.id
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_complaint_ent.eid
     *
     * @return the value of obj_user_complaint_ent.eid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Long getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_complaint_ent.eid
     *
     * @param eid the value for obj_user_complaint_ent.eid
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setEid(Long eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_complaint_ent.status
     *
     * @return the value of obj_user_complaint_ent.status
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_complaint_ent.status
     *
     * @param status the value for obj_user_complaint_ent.status
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column obj_user_complaint_ent.remark
     *
     * @return the value of obj_user_complaint_ent.remark
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column obj_user_complaint_ent.remark
     *
     * @param remark the value for obj_user_complaint_ent.remark
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_complaint_ent
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
        sb.append(", eid=").append(eid);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}