package model.service;

import java.util.Date;
import java.util.Random;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.transaction.Transactional;

import model.dao.SmsDao;
import model.domain.Sms;
import model.domain.StatusSms;

@MessageDriven(name="smsQueueEjb", 
			mappedName="ejb/smsQueueEjb" , 
			activationConfig = {
		 @ActivationConfigProperty(
				 propertyName = "acknowledgeMode" , 
				 propertyValue = "Auto-acknowledge" ),
		 @ActivationConfigProperty(
				 propertyName = "destinationType" , 
				 propertyValue = "javax.jms.Queue" ),
		 @ActivationConfigProperty(
				 propertyName = "destination" , 
				 propertyValue = "java:/jms/queue/smsQueue" )
		})
public class ProcessadorSms implements MessageListener {
	
	@Inject
	private SmsDao smsDao;

	@Override
	@Transactional
	public void onMessage(Message arg0) {
		try {
			int tempo = new Random().nextInt(10000);
			System.out.println("colocando a thread para dormir "+tempo);
			Thread.currentThread().sleep(tempo);
			
			ObjectMessage objectMessage = (ObjectMessage)arg0;				
			Sms sms = (Sms)objectMessage.getObject();
			System.out.println("Processando na fila o sms"
					+ " "+sms.getCodigo());
			sms.setStatus(StatusSms.ENTREGUE);
			sms.setDataEnvio(new Date());
			smsDao.atualizar(sms);
		} catch(Exception e) {
			throw new RuntimeException("Deu pau no JMS"
					+ " "+e.getMessage());
		}
	}

}
