package model.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.transaction.Transactional;

import model.dao.SmsDao;
import model.domain.Sms;

//@JMSDestinationDefinition(name = "java:/jms/queue/smsQueue", 
//destinationName = "smsQueue", description = "smsQueue", interfaceName = "javax.jms.Queue")
public class SmsServiceImpl implements SmsService {
	
	@Inject
	private SmsDao smsDao;
	
	@Inject
	private JMSContext jmsContext;
	
	@Resource(lookup="java:/jms/queue/smsQueue")
	private Queue fila;
	
	/* (non-Javadoc)
	 * @see model.service.SmsService#salvar(model.domain.Sms)
	 */
	@Override
	@Transactional
	public Sms salvar(Sms sms) {
		sms = smsDao.salvar(sms);
		jmsContext.createProducer().send(fila,sms);
		return sms;
	}
	
	/* (non-Javadoc)
	 * @see model.service.SmsService#getSmss(model.domain.Sms)
	 */
	@Override
	public List<Sms> getSms(Sms sms) {
		return smsDao.getSms(sms);
	}
	
	
	
}
