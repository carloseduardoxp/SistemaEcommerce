package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DETALHE_PEDIDO")
public class DetalhePedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalhePedidoPK detalhePedidoPK;
	
	@Column(name="VL_PRECO")
	private Double preco;
	
	@Column(name="QT_SOLICITADO")
	private Integer quantidade;
	
	@Column(name="VL_DESCONTO")
	private Double desconto;
	
	@ManyToOne
	@JoinColumn(name="NR_PEDIDO",referencedColumnName="NR_PEDIDO",
	insertable=false,updatable=false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name="CD_PRODUTO",referencedColumnName="CD_PRODUTO",
			insertable=false,updatable=false)
	private Produto produto;

	public DetalhePedido() {

	}

	public DetalhePedidoPK getDetalhePedidoPK() {
		return detalhePedidoPK;
	}

	public void setDetalhePedidoPK(DetalhePedidoPK detalhePedidoPK) {
		this.detalhePedidoPK = detalhePedidoPK;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalhePedidoPK == null) ? 0 : detalhePedidoPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalhePedido other = (DetalhePedido) obj;
		if (detalhePedidoPK == null) {
			if (other.detalhePedidoPK != null)
				return false;
		} else if (!detalhePedidoPK.equals(other.detalhePedidoPK))
			return false;
		return true;
	}
	
}
