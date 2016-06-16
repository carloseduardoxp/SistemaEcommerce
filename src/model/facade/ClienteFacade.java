package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Cliente;

public interface ClienteFacade {

	List<Cliente> getClientes();

	List<Cliente> getClientes(Integer codigo);

	@ValidateOnExecution
	Cliente salvar(@Valid Cliente cliente);

	void atualizar(Cliente cliente);

	void deletarCliente(Integer codigo);

}