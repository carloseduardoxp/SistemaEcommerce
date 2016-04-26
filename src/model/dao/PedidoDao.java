package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.domain.DetalhePedido;

public class PedidoDao {
	
	@PersistenceContext(unitName="SistemaEcommercePU")
	private EntityManager entityManager;

	public Double getValorTotalPedido(Integer numeroPedido) {
		StringBuffer hql = new StringBuffer("from DetalhePedido d where d.pedido.numero = :numero");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("numero",numeroPedido);
		List<DetalhePedido> detalhes = query.getResultList();
		double somatorio = 0;
		for (DetalhePedido detalhe: detalhes) {
			somatorio += (detalhe.getPreco() * detalhe.getQuantidade()) - detalhe.getDesconto();
		}
		return somatorio;
	}

	public Double getValorTotalCompraCliente(Integer codigoCliente) {
		StringBuffer hql = new StringBuffer("from DetalhePedido d where d.pedido.cliente.codigo = :numero");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("numero",codigoCliente);
		List<DetalhePedido> detalhes = query.getResultList();
		double somatorio = 0;
		for (DetalhePedido detalhe: detalhes) {
			somatorio += (detalhe.getPreco() * detalhe.getQuantidade()) - detalhe.getDesconto();
		}
		return somatorio;
	}

	public Double getValorTotalCompraProduto(Integer codigoProduto) {
		StringBuffer hql = new StringBuffer("from DetalhePedido d where d.produto.codigo = :numero");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("numero",codigoProduto);
		List<DetalhePedido> detalhes = query.getResultList();
		double somatorio = 0;
		for (DetalhePedido detalhe: detalhes) {
			somatorio += (detalhe.getPreco() * detalhe.getQuantidade()) - detalhe.getDesconto();
		}
		return somatorio;
	}

}
