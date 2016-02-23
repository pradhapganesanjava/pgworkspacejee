package com.pg.ws.rs.client.hello;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.pg.ws.rs.client.async.hello.AsyncInvocationCallback;
import com.pg.ws.rs.client.filter.hello.MyLoggingFilter;

public class RestClientUsingClientInterf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/WS_REST_Service/wsrest/singleton/");
		String response = null;
		//response = simpleInvoke(webTarget);

		//response = pathExample(webTarget);
		//response = headExample(webTarget);
		//response = cookieExample(webTarget);
		
		//register Filter
		registerExample(client, webTarget);
		
		//Asyn Call
		asynExample(webTarget);
		
		System.out.println("M 3 response "+response);
		client.close();
	}

	private static void asynExample(WebTarget webTarget) {
		Future<String> responseFuture = webTarget.request().async().get(String.class);
		responseFuture = webTarget.request().async().get(new AsyncInvocationCallback());
	}

	private static void registerExample(Client client, WebTarget webTarget) {
		//on client
		client.register(MyLoggingFilter.class);
		//on webTarget
		webTarget.register(MyLoggingFilter.class);
	}

	private static String headExample(WebTarget webTarget) {
		String response;
		MultivaluedMap<String, Object> myHeaders = 
		    new MultivaluedMapImpl();
		myHeaders.add("Authorize", "assssdafer2WEWeSaZC");

		response = webTarget.request(MediaType.TEXT_PLAIN).headers(myHeaders) 
				.get(String.class);
		return response;
	}

	private static String cookieExample(WebTarget webTarget) {
		String response;
		Cookie myCookie = new Cookie("myCookie", "The cookie value",
				"/wsrest/singleton/", "localhost:8080");
		response = webTarget.request(MediaType.TEXT_PLAIN).cookie(myCookie)
				.get(String.class);
		return response;
	}

	private static String pathExample(WebTarget webTarget) {
		String response;
		WebTarget webTargetNum1 = webTarget.path("10");
		WebTarget webTargetNum2 = webTargetNum1.path("10");
		webTarget = webTargetNum2;
		/*
		webTarget.resolveTemplate("num1", "10");
		webTarget.resolveTemplate("num2", "10");*/

		System.out.println("URI "+webTarget.getUri().toString());
		Response respObj = webTarget.request().accept(MediaType.TEXT_HTML).get(); 
		response = respObj.readEntity(String.class);
		return response;
	}

	private static String simpleInvoke(WebTarget webTarget) {
		//Builder build = webTarget.request(MediaType.TEXT_PLAIN);
		Builder build = webTarget.request().accept(MediaType.TEXT_HTML);
		String response = build.get(String.class);
		System.out.println("response "+response);
		return response;
	}

}

class MultivaluedMapImpl implements MultivaluedMap<String, Object>{
	
	@Override
	public Collection<List<Object>> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Object> remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void putAll(Map<? extends String, ? extends List<Object>> m) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Object> put(String key, List<Object> value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Object> get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<Entry<String, List<Object>>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void putSingle(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Object getFirst(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equalsIgnoreValueOrder(
			MultivaluedMap<String, Object> otherMap) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void addFirst(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addAll(String key, List<Object> valueList) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addAll(String key, Object... newValues) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
}
