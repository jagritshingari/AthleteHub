package com.gym.AthleteHub.hubutil;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.gym.AthleteHub.dto.PageableResponse;

public class HubUtil {

		private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		private static final Random RANDOM = new SecureRandom();
	
		public static <U> PageableResponse<U> getPageableResponse(Page<U> page){
				
				
				PageableResponse<U> response = new PageableResponse<>();
				
				
				response.setContent(page.getContent());
				response.setPageNumber(page.getNumber());
				response.setPageSize(page.getSize());
				response.setTotalElements(page.getTotalElements());
				response.setTotalPages(page.getTotalPages());
				response.setLastPage(page.isLast());
				
				return response;
				
		}
		
		

	    public static String generateRandomAlphanumeric(int length) {
	        return RANDOM.ints(length, 0, ALPHANUMERIC.length())
	                .mapToObj(ALPHANUMERIC::charAt)
	                .map(String::valueOf)
	                .collect(Collectors.joining());
	    }
		
	

}
