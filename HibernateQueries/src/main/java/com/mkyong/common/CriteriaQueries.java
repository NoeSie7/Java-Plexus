package com.mkyong.common;

import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import com.mkyong.common.Stock;

public final class CriteriaQueries {
	
	public static Stock CriteriaQuerySelect(Session session){	
		
		// Método createCriteria es deprecated y es sustituido por getCriteriaBuilder	
		// Criteria criteria = session.createCriteria(Stock.class)
		// .add(Restrictions.like("stockCode", "4715"));
		// Stock stock = (Stock) criteria.uniqueResult();
					
		 CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Stock> query = builder.createQuery(Stock.class);
         Root<Stock> root = query.from(Stock.class);
         query.select(root).where(builder.equal(root.get("stockCode"), "4715"));
         Query<Stock> q=session.createQuery(query);
         Stock stock = q.getSingleResult();
         return stock;   
	}
       
}
