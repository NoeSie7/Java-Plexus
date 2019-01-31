package com.mkyong.common;

import org.hibernate.Session;
import org.hibernate.query.Query;

public final class NativeSQLQueries {

	public static String NativeQuerySelect(Session session){
		// Método createSQLQuery deprecated sustituido por createNativeQuery
		/*Query query = session.createSQLQuery(queryString).createSQLQuery(
				"select s.stock_code from stock s where s.stock_code = :stockCode")
				.setParameter("stockCode", "4715"); */
		Query query = session.createNativeQuery(
				"select s.stock_code from stock s where s.stock_code = :stockCode")
				.setParameter("stockCode", "4715");
				String stockcode = (String) query.getSingleResult();
		return stockcode;
	}
}
