package model.facade.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.PedidoDao;
import model.facade.PedidoFacade;

@WebService(serviceName="ws/pedido")
public class PedidoFacadeImpl implements PedidoFacade {
	
	@Inject
	private PedidoDao pedidoDao;
				
	@Override
	@WebMethod
	public Double getValorTotalPedido(@WebParam(name="numeroPedido") Integer numeroPedido) {
		return pedidoDao.getValorTotalPedido(numeroPedido);
	}

	@Override
	@WebMethod
	public Double getValorTotalCompraCliente(@WebParam(name="codigoCliente") Integer codigoCliente) {
		return pedidoDao.getValorTotalCompraCliente(codigoCliente);
	}

	@Override
	@WebMethod
	public Double getValorTotalCompraProduto(@WebParam(name="codigoProduto") Integer codigoProduto) {
		return pedidoDao.getValorTotalCompraProduto(codigoProduto);
	}

}
