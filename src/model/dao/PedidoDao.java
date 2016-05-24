package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.DetalhePedido;
import model.domain.Pedido;
import model.domain.StatusPedido;

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

	@Transactional
	@SuppressWarnings("unchecked")
	public void faturarPedidos() {
		StringBuffer hql = new StringBuffer("from Pedido p where p.status = 'NOVO'");
		Query query = entityManager.createQuery(hql.toString());
		List<Pedido> pedidos = query.getResultList();
		for (Pedido pedido: pedidos) {
			pedido.setStatus(StatusPedido.FATURADO);
			atualizar(pedido);
		}
	}

	@Transactional
	public void atualizar(Pedido pedido) {
		pedido = entityManager.merge(pedido);
		entityManager.persist(pedido);		
	}

	@Transactional
	public void cancelarPedido(Integer numeroPedido) {
		StringBuffer hql = new StringBuffer("from Pedido p where p.numero = :numeroPedido");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("numeroPedido",numeroPedido);
		Pedido pedido = (Pedido)query.getResultList().get(0);
		pedido.setStatus(StatusPedido.CANCELADO);
		atualizar(pedido);		
	}
	
	public Pedido getPedidoPorId(Integer numeroPedido) {
		StringBuffer hql = new StringBuffer("from Pedido p where p.numero = :numeroPedido");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("numeroPedido",numeroPedido);
		Pedido pedido = (Pedido)query.getResultList().get(0);
		return pedido;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidoPorStatus(StatusPedido status) {
		StringBuffer hql = new StringBuffer("from Pedido p where p.status = :status");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("status",status);
		return query.getResultList();		
	}

}
