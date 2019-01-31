package com.mkyong;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDetail;
import com.mkyong.util.HibernateUtil;

public class App {
	private final static Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.info("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		logger.info("Done");
	}
}
