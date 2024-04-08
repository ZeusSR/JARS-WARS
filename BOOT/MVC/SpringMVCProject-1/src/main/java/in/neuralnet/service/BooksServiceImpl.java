package in.neuralnet.service;

import org.springframework.stereotype.Service;

import in.neuralnet.bindings.Book;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BooksServiceImpl implements IBookService {



	@Override
	public Book addGST(Book bo) {

		log.info("Control in for calculating book price with 18%");
		log.debug(bo.toString());
		
		Float f = 0.18f;
		String p = bo.getBprice();
		Float result;
		result = Float.parseFloat(p)+ Float.parseFloat(p)*f;
		bo.setBprice(Float.toString(result));
		
		log.debug("Result is: "+result);
		
		return bo;
	}

}
