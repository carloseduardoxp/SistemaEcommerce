package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.domain.Sms;

public class SmsDaoImpl implements SmsDao {
	
	@PersistenceContext(unitName="SistemaEcommercePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see model.dao.SmsDao#salvar(model.domain.Sms)
	 */
	@Override
	public Sms salvar(Sms sms) {
		entityManager.persist(sms);
		return sms;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SmsDao#salvar(model.domain.Sms)
	 */
	@Override
	public void atualizar(Sms sms) {
		sms = entityManager.merge(sms);
		entityManager.persist(sms);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SmsDao#getSmss(model.domain.Sms)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Sms> getSms(Sms sms) {
		StringBuilder hql = new StringBuilder(
				"from Sms s where 1 = 1 ");
		if (sms.getCodigo() != null) {
			hql.append("and s.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (sms.getCodigo() != null) {
			query.setParameter("codigo",sms.getCodigo());
		}
		return query.getResultList();
	}

}
