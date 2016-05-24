package model.facade;

import java.util.List;

import model.domain.Pedido;
import model.domain.StatusPedido;

public interface PedidoFacade {
	
	public Double getValorTotalPedido(Integer numeroPedido);
	
	public Double getValorTotalCompraCliente(Integer codigoCliente);
	
	public Double getValorTotalCompraProduto(Integer codigoProduto);
	
	public void faturarPedidos();
	
	public void cancelarPedido(Integer numeroPedido);

	Pedido getPedidoPorId(Integer numeroPedido);

	List<Pedido> getPedidoPorStatus(StatusPedido statusPedido);

}
