import java.net.MalformedURLException;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class tmp {
	public static void main(String...str){
HandlerWS test;
try {
test = new HandlerWS("http://java.boot.by/HandlerWS?WSDL"),
new QName("http://java.boot.by", "HandlerWS"));
} catch (MalformedURLException murl) { throw new RuntimeException(murl); }
HandlerWSPortType port = test.getHandlerWSPortTypePort();

Binding binding = ((BindingProvider)port).getBinding();

List<Handler> handlerList = binding.getHandlerChain();
handlerList.add(new ServiceAuthenticationSOAPHandler());
handlerList.add(new ServicePerformanceMonitorLogicalHandler());

binding.setHandlerChain(handlerList);
}
}
