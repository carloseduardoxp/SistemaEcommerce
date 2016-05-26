package model.service;

import java.util.List;

import model.domain.Sms;

public interface SmsService {

	List<Sms> getSms(Sms sms);

	Sms salvar(Sms sms);

}
