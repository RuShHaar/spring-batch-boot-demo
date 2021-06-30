package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Sale;
import de.moscon.etl.steps.nr03_salesData.SalesReader;
import de.moscon.extern_systems.ShopSimulator;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Autowired
	private ShopSimulator shopSimulator;

	private List<Sale> saleList;


	@Override
	public Customer process(Customer item) throws Exception {
		shopSimulator.readProductPos(0);
		saleList = shopSimulator.CACHE;

		System.out.println(saleList.get(0));


		item.setPseudonym("customer_"+item.getFirstname().toLowerCase());
		item.setFirstname(null);

		if(item.getRegistrationDate() < )

		return item;
	}
}
