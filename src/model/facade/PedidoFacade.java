package model.facade;

public interface PedidoFacade {
	
	public Double getValorTotalPedido(Integer numeroPedido);
	
	public Double getValorTotalCompraCliente(Integer codigoCliente);
	
	public Double getValorTotalCompraProduto(Integer codigoProduto);

}
