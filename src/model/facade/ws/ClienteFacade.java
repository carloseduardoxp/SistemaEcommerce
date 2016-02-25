package model.facade.ws;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.domain.Cliente;

@WebService(serviceName="ws/cliente")
public class ClienteFacade {
	
	@WebMethod
	public List<Cliente> getClientes() {
		return Arrays.asList(new Cliente(1,"carlos","carlos@gmail.com"),
							 new Cliente(2,"fulano","fulano@gmail.com"));
	}

}
