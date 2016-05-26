package model.dao;

import java.util.List;

import model.domain.Sms;

public interface SmsDao {

	List<Sms> getSms(Sms sms);

	Sms salvar(Sms sms);
	
	public void atualizar(Sms sms);

}
