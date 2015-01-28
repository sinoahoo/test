package org.doc_thrifttest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.transport.TMemoryBuffer;
import org.apache.thrift.transport.TTransportException;

import thrift.StringMsg;

public class StringTest {
	private static String test ="{\"firstName\":\"John\", \"lastName\":\"Doe\"}";
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, TTransportException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
	    StringMsg msg = new StringMsg();
	    msg.setFirstName("xiong");
	    msg.setLastName("sibing");
	    msg.setAge(34);
		String msg = "asdfasdf";
	    String json = buildThriftJson(msg);
	    System.out.println("json="+json);
	    StringMsg test = (StringMsg)toThriftBean(json,msg.getClass());
	    System.out.println("firstname="+test.getFirstName()+  "  age="+test.getAge());
		doshow();
	}
	
	public static String buildThriftJson(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		TMemoryBuffer buffer = new TMemoryBuffer(1024);
		TJSONProtocol proto = new TJSONProtocol(buffer);
		Method readObjectMethod = obj.getClass().getMethod("write",org.apache.thrift.protocol.TProtocol.class);
		readObjectMethod.invoke(obj, proto);
		byte[] bytes = Arrays.copyOf(buffer.getArray(), buffer.length());
		String content = new String(bytes);
		return content;
	}
	
	public static Object toThriftBean(String test,Class<?> classType) throws NoSuchMethodException, SecurityException, TTransportException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method readObjectMethod = classType.getMethod("read",org.apache.thrift.protocol.TProtocol.class);
		TMemoryBuffer t = new TMemoryBuffer(test.length());
		//test = parserChinese(test);
	    t.write(test.getBytes());
		TJSONProtocol proto = new TJSONProtocol(t);
		Object o = classType.newInstance();
		//Thrift json –Ú¡–ªØ  Thrift java bean
		readObjectMethod.invoke(o, proto);
		return o;
	}
	
	public static void doshow(){
		try{
		show();}
		catch(RuntimeException e)
		{
			
			System.out.println("aaaa:"+e.getMessage());
		}
	}
	
	public static  void show(){
		 throw new UnsupportedOperationException("Not yet implemented");
	}

}
