package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_CLIENTE")
	private Integer codigo;
	
	@Min(value=10,message="Nome do cliente precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name="NM_CLIENTE")
	private String nome;
	
	@NotNull(message="O campo cargo é obrigatório")
	@Column(name="DS_CARGO")
	private String cargo;
	
	@Min(value=10,message="Endereço precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo endereço é obrigatório")
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@NotNull(message="O campo cidade é obrigatório")	
	@Column(name="DS_CIDADE")
	private String cidade;
	
	@NotNull(message="O campo cep é obrigatório")
	@Pattern(regexp="\\d{5}-\\d{3}",message="Campo CEP precisa estar no padrão 00000-000")
	@Column(name="DS_CEP")
	private String cep;

	@NotNull(message="O campo país é obrigatório")
	@Column(name="DS_PAIS")
	private String pais;
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.EAGER)
	private List<Telefone> telefones;

	public Cliente() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
