package model.dao;

import java.util.List;

import model.domain.Cliente;

public interface ClienteDao {

	List<Cliente> getClientes(Cliente cliente);
	
	public void excluir(Cliente cliente);

	Cliente salvar(Cliente cliente);

	void atualizar(Cliente cliente);

}