package com.pg.ws.client.webmethod;

import javax.xml.ws.BindingProvider;

import com.pg.ws.stub.webmethod.barestyle.WSWebMethodsBareStyle;
import com.pg.ws.stub.webmethod.barestyle.WSWebMethodsBareStyleService;

public class WS_WebMethods_BareStyleClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WSWebMethodsBareStyleService sib = new WSWebMethodsBareStyleService();
		WSWebMethodsBareStyle sei = sib.getWSWebMethodsBareStylePort();
		((BindingProvider) sei).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:7777/wswebmethodbarestyle/WS_WebMethods_BareStyleService");
		sei.publicMthOverloaded("publicMthOverloaded");

	}

}
