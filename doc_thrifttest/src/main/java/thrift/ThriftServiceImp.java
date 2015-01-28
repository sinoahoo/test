package thrift;

import org.apache.thrift.TException;

public class ThriftServiceImp implements ThriftService.Iface{
	  @Override  
	      public int add(int a, int b) throws TException {  
	         return a + b;  
	     }  

}
