package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.ClienteDao;
import model.domain.Cliente;

@Path("/cliente")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class ClienteFacade {
	
	@Inject
	private ClienteDao clienteDao;

/*	@POST
	public Cliente salvar(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}*/
	
	@GET
	public List<Cliente> getClientes() {
		return clienteDao.getClientes(new Cliente());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Cliente>  getClientes(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		return clienteDao.getClientes(cliente);		
	}
	
	/*@PUT
	public Cliente atualizarCliente(Cliente cliente) {
		int pos = clientes.indexOf(cliente);
		if (pos >= 0) {
			clientes.set(pos,cliente);
			return cliente;
		}
		throw new WebApplicationException(404);
	}*/
	
	/*@DELETE
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
*/
}
