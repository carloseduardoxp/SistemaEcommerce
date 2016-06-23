package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.ClienteDao;
import model.domain.Cliente;
import model.domain.Telefone;
import model.facade.ClienteFacade;

@WebService(serviceName="ws/cliente")
public class ClienteFacadeImpl implements ClienteFacade {
	
	@Inject
	private ClienteDao clienteDao;
			
	@WebMethod
	public List<Cliente> getClientes() {
		return clienteDao.getClientes(new Cliente());
	}
	
	@Override
	@WebMethod(operationName="getClienteCodigo")
	public List<Cliente> getClientes(@WebParam(name="codigoCliente") 
							Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		return clienteDao.getClientes(cliente);
	}
	
	@WebMethod
	public Cliente salvar(@WebParam(name="cliente") Cliente cliente) {
		for (Telefone telefone: cliente.getTelefones()) {
			telefone.setCliente(cliente);
		}
		return clienteDao.salvar(cliente);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="cliente") Cliente cliente) {
		for (Telefone telefone: cliente.getTelefones()) {
			telefone.setCliente(cliente);
		}
		clienteDao.atualizar(cliente);
	}
	
	@WebMethod
	public void deletarCliente(@WebParam(name="codigoCliente") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		clienteDao.excluir(cliente);
	}


}
