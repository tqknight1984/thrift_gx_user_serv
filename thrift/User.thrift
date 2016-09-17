namespace java net.gx.thrift


struct ResObj {
    1: required i32 code;
    2: required string text;
    3: optional map<string, string> data;
    4: optional list<string> lsdata;
}


struct ResList {
    1: required i32 code;
    2: required string text;
    5: optional list< map<string, string> > lsdata;
}




service User
{

    void ping(),

    //生成手机验证码   1|注册；2|改密码；
    ResObj gen_phone_code(1:required string mobile, 2:required i32 type),

    //验证手机code
    ResObj check_phone_code(1:required string mobile, 2:required string code, 3:required i32 type),

	//个人注册
	ResObj regedit_p(1:required string name, 2:required string password, 3:required string mobile, 4:required string code),
	
	//企业注册
	ResObj regedit_b(1:required string name, 2:required string password, 3:required string mobile, 4:required string code, 5:required string company),

	//检查帐号有效性
	ResObj check_auth(1:string name,2:string password),

    //用户登录
	ResObj login(1:required string nameOrPhone, 2:required string password),

	//查询帐号信息
	ResObj get_user(1:string name,2:string mobile),

    //保存个人信息
    ResObj setUserInfo(1:required string name, 2:required string password),

    //获取收件地址
    ResList getUserAddress(1:required string uid),

    //新增收件地址    id, uid, consignee, areaid, address, mobile, telephone, zipcode, flag
    ResObj setUserAddress(1:required string uid, 2:required string consignee, 3:required string areaid, 4:required string address, 5:required string mobile, 6:string telephone, 7:string zipcode, 8:required byte flag),

    //修改收件地址
    ResObj updateUserAddress(1:required string id, 2:required string consignee, 3:required string areaid, 4:required string address, 5:required string mobile, 6:string telephone, 7:string zipcode),

    //删除收件地址
    ResObj delUserAddress(1:required string id, 2:required string uid),

    //修改默认地址
    ResObj changeDefaultAddress(1:required i64 uid, 2:required i32 address_id),

    //取地级市（市级）
    ResObj getAreaInfo(1:required string areaId),

    //取地区信息
    ResList getCitysInfo(),

    //取地区信息（通过fatherid）
    ResList getCountysInfo(1:required i32 cityid),

    //修改详细用户详细信息（个人）
    ResObj updateIndUser(1:required string uid, 2:required string nick, 3:required string sex, 4:required string real_name, 5:required string brithday, 6:required string email, 7:required string company, 8:required string photo),

    //修改密码
    ResObj changePwd(1:required i64 uid, 2:required string old_pwd, 3:required string new_pwd),


    //获取发票      1|普通；2|增值
    ResList getUserInvoice(1:required i64 uid, 2:required byte invoice_type),

    //新增发票    id, uid, i_type, title, flag, company, telephone, taxpayer, address, bank, bank_no
    ResObj setUserInvoice(1:required i64 uid, 2:required string i_type, 3:required string title, 4:required byte flag, 5:required string company, 6:string telephone, 7:string taxpayer, 8:required string address, 9:string bank, 10:required string bank_no),

    //修改发票
    ResObj updateUserInvoice(1:required i32 invoice_id,2:required string i_type, 3:required string title, 4:required byte flag, 5:required string company, 6:string telephone, 7:string taxpayer, 8:required string address, 9:string bank, 10:required string bank_no),

    //删除发票
    ResObj delUserInvoice(1:required i32 invoice_id, 2:required string uid, 3:required byte i_type),

    //修改默认发票
    ResObj changeDefaultInvoice(1:required i64 uid, 2:required i32 invoice_id, 3:required byte i_type),

}