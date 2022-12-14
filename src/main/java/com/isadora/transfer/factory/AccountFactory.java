package com.isadora.transfer.factory;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.isadora.transfer.model.dto.AccountDto;

@Component
public class AccountFactory {
	
	
	public Double rateA(AccountDto obj) {
		obj.setRate(3 + (obj.getVelue() * 0.03));
		Double rate = obj.getRate();
		return rate ;
	}
	
	public Double rateB(AccountDto obj) {
		obj.setRate(12.00);
		Double rate = obj.getRate();
		return rate ;
	}
	
	public Double rateC(AccountDto obj) {
		Double differenceDays = (double) ChronoUnit.DAYS.between(obj.getDateTransfer(),obj.getDateScheduled());
		Double rate = null;
		
		 if(differenceDays > 10 && differenceDays <= 20) {
				obj.setRate(obj.getVelue() * 0.082);
				rate = obj.getRate();
				return rate;
				
			} else if(differenceDays > 20 && differenceDays <= 30) {
				obj.setRate(obj.getVelue() * 0.069);
				rate = obj.getRate();
				return rate;
				
			} else if(differenceDays > 30 && differenceDays <= 40) {
				obj.setRate(obj.getVelue() * 0.047);
				rate = obj.getRate();
				return rate;
				
			} else if( differenceDays > 40) {
				obj.setRate(obj.getVelue() *  0.017);
				rate = obj.getRate();
				return rate;
			}
			return rate;
	}
	
	public Double rateD(AccountDto obj) {
		Double rate = null;
		
		if(obj.getVelue() <=1000.00) {
			rate = this.rateA(obj);
			
		} else if(obj.getVelue() > 1000.00 && obj.getVelue() <= 2000.00) {
			rate = this.rateB(obj);
			
		} else if(obj.getVelue() > 2000.00) {
			rate = this.rateC(obj);
		}
		return rate;
	}
}
