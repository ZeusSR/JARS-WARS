package in.neuralnet.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService {

	LocalDateTime date = LocalDateTime.now();
	
	@Override
	public String generateMessage() {
   
		
		if(date.getHour()<12)
		return "Hey Goodmorning";
   else if(date.getHour()>12 && date.getHour()<20)
	    return "Hey GoodEvening";
   else return "Hey GoodNight";	
	}

	@Override
	public Integer generateHour() {
		
		int msg = date.getHour();
		
		
		return msg;
	}

	@Override
	public Integer generateMinute() {
		int msg = date.getMinute();
		return msg;
	}

}
