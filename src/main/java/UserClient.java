import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.gx.thrift.User;
import util.ZKClient;

public class UserClient {
    private final static Logger logger = LoggerFactory.getLogger(UserClient.class);

    public void startClient() {

        ZKClient zkClient = new ZKClient();
        if (zkClient.init("192.168.1.251:2181", 3000) == false) {
            logger.error("connect zookeeper fail.");
            return;
        }
        String serv = zkClient.get_service("/gx/cfg/service", "GX-Service-Sms");
        String[] info = serv.split(":");

        TTransport transport;
        try {
            transport = new TSocket(info[0], Integer.parseInt(info[1]));
            TProtocol protocol = new TBinaryProtocol(transport);
            User.Client client = new User.Client(protocol);
            transport.open();
            //client.regedit_p("aaa","15026693656");
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserClient client = new UserClient();
        client.startClient();


    }
}