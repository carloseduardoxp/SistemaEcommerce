package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_SMS")
public class Sms implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_SMS")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="CD_TELEFONE_REMETENTE",referencedColumnName="CD_TELEFONE")
	private Telefone remetente;
	
	@ManyToOne
	@JoinColumn(name="CD_TELEFONE_DESTINATARIO",referencedColumnName="CD_TELEFONE")
	private Telefone destinatario;
	
	@Column(name="CD_ASSUNTO",nullable=false,length=60)
	private String assunto;
	
	@Column(name="DS_MENSAGEM",nullable=false,length=255)
	private String mensagem;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_STATUS_SMS")
	private StatusSms status;
	
	@Column(name="DT_ENVIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvio;
	
	@Column(name="DT_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;


	public Sms() {
		this.status = StatusSms.AGUARDANDO;
		this.dataCadastro = new Date();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Telefone getRemetente() {
		return remetente;
	}

	public void setRemetente(Telefone remetente) {
		this.remetente = remetente;
	}

	public Telefone getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Telefone destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public StatusSms getStatus() {
		return status;
	}

	public void setStatus(StatusSms status) {
		this.status = status;
	}
	
	

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
		Sms other = (Sms) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
