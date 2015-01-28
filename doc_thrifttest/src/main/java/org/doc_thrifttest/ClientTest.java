package org.doc_thrifttest;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import thrift.ThriftService;
public class ClientTest {

		public static void main(String args[]) throws TException{
//			TTransport transport = null;
//			transport = new TSocket("127.0.0.1", 7911, 1000);
//			// 协议要和服务端一致
//			TProtocol protocol = new TBinaryProtocol(transport);
//			// TProtocol protocol = new TCompactProtocol(transport);
//			// TProtocol protocol = new TJSONProtocol(transport);
//			ThriftService.Client client = new ThriftService.Client(
//					protocol);
//			transport.open();
//			int result = client.add(22, 44);
//			System.out.println("Thrify client result =: " + result);
			 String  userName = "1234".intern();
			 String  aaa = "1234";
			 String   bbb = new String("1234").intern();
			 System.out.println(userName.equals(aaa));
			 System.out.println(userName == aaa);
			 System.out.println(userName ==bbb );
		}
}
