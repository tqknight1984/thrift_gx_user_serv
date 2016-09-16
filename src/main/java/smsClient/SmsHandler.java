package smsClient;

import net.gx.thrift.ResObj;
import net.gx.thrift.Sms;
import org.apache.thrift.TException;
import org.apache.thrift.TServiceClient;

/**
 * Created by app on 16/9/12.
 */
public class SmsHandler {

    public static int sendSms(final String mobile, final String msg){

        int res = 0;

        ResObj smsRes = SmsClientManager.doSomething(new SmsClientManager.ThriftHandler<ResObj>() {
            @Override
            protected ResObj handle(TServiceClient client) {
                try {
                    return ((Sms.Client) client).send_phone_msg(mobile, msg);
                } catch (TException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });


        if(smsRes!= null && smsRes.getCode() == 200) {
            res = 1;
        }else{
            res = 0;
        }

        return res;
    }
}
