package model.facade.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.domain.Cliente;

@Path("/cliente")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class ClienteFacade {
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	
	static {
		clientes.add(new Cliente(1,"carlos","carlos@gmail.com"));
		clientes.add(new Cliente(2,"fulano","fulano@gmail.com"));
	}

	@POST
	public Cliente salvar(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}
	
	@GET
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	@GET
	@Path("/{codigo}")
	public Cliente getClientes(@PathParam("codigo") Integer codigo) {
		if (clientes.get(codigo) != null) {
			return clientes.get(codigo);
		} else {
			return new Cliente(3,"novo cliente","novo@gmail.com");
		}
	}

}
