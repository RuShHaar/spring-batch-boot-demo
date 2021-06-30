package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Sale;
import de.moscon.etl.steps.nr03_salesData.SalesReader;
import de.moscon.extern_systems.ShopSimulator;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Autowired
	private ShopSimulator shopSimulator;

	private List<Sale> saleList;


	@Override
	public Customer process(Customer item) throws Exception {
		shopSimulator.readProductPos(0);
		saleList = shopSimulator.CACHE;
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date firstBuy = null;
//		List<Sale> saleListCutomer= (List<Sale>) saleList.get(item.getId());
		try {
			firstBuy = sdformat.parse("2099-12-30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Sale sale : saleList) {
			if (sale.getId()== item.getId() && sale.getTime().before(firstBuy)) {
				firstBuy = sale.getTime();
			}
		}
		Date registrationDate = item.getRegistrationDate();
		if (registrationDate.after(firstBuy)) {
                item.setRegistrationDate(firstBuy);
            }

//		System.out.println(saleList.get(0));


		item.setPseudonym("customer_"+item.getFirstname().toLowerCase());
		item.setFirstname(null);

//		if(item.getRegistrationDate() < saleList.get(1).getTime())

		return item;
	}
}
