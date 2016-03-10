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
}
