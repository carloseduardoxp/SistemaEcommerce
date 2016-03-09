package model.facade.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import model.domain.Cliente;
import util.ClienteNaoEncontradoException;

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
		try {			
			return getCliente(codigo);
		} catch(ClienteNaoEncontradoException e) {
			throw new WebApplicationException(404);
		}		
	}
	
	@PUT
	public Cliente atualizarCliente(Cliente cliente) {
		int pos = clientes.indexOf(cliente);
		if (pos >= 0) {
			clientes.set(pos,cliente);
			return cliente;
		}
		throw new WebApplicationException(404);
	}
	
	@DELETE
	@Path("/{codigo}")
	public Cliente deletarCliente(@PathParam("codigo") Integer codigo) {
		try {
			Cliente cliente = getCliente(codigo);
			clientes.remove(cliente);
			return cliente;
		} catch(ClienteNaoEncontradoException e) {
			throw new WebApplicationException(404);
		}		
	}

	private Cliente getCliente(Integer codigo) throws ClienteNaoEncontradoException{
		for (Cliente cliente: clientes) {
			if (cliente.getCodigo().equals(codigo)) {
				return cliente;
			}
		}
		throw new ClienteNaoEncontradoException(codigo);
	}

}
