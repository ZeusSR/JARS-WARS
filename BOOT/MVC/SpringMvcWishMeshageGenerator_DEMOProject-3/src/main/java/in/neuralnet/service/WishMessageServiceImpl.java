package in.neuralnet.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateMessage() {
   LocalDateTime date = LocalDateTime.now();
		
		if(date.getHour()<12)
		return "Hey Goodmorning";
   else if(date.getHour()>12 && date.getHour()<20)
	    return "Hey GoodEvening";
   else return "Hey GoodNight";	
	}

}
