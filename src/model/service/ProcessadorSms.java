package model.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.transaction.Transactional;

import model.dao.SmsDao;
import model.domain.Sms;
import model.domain.StatusSms;

//@MessageDriven(name="smsQueueEjb", 
//			mappedName="ejb/smsQueueEjb" , 
//			activationConfig = {
//		 @ActivationConfigProperty(
//				 propertyName = "acknowledgeMode" , 
//				 propertyValue = "Auto-acknowledge" ),
//		 @ActivationConfigProperty(
//				 propertyName = "destinationType" , 
//				 propertyValue = "javax.jms.Queue" ),
//		 @ActivationConfigProperty(
//				 propertyName = "destination" , 
//				 propertyValue = "java:/jms/queue/smsQueue" )
//		})
public class ProcessadorSms implements MessageListener {
	
	@Inject
	private SmsDao smsDao;

	@Override
	@Transactional
	public void onMessage(Message arg0) {
		ObjectMessage objectMessage = (ObjectMessage)arg0;
		try {
			Sms sms = (Sms)objectMessage.getObject();
			System.out.println("Processando na fila o sms"
					+ " "+sms.getCodigo());
			sms.setStatus(StatusSms.ENTREGUE);
			smsDao.atualizar(sms);
		} catch(JMSException e) {
			throw new RuntimeException("Deu pau no JMS"
					+ " "+e.getMessage());
		}
	}

}
