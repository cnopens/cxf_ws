package com.simple.ws.cxf;


import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.ritchey.chapel.Absenses;
import com.ritchey.chapel.domain.Absences;
import com.ritchey.chapel.domain.AbsencesExample;
import com.ritchey.chapel.domain.AbsencesMapper;

@WebService(endpointInterface = "com.simple.ws.cxf.HumanResourceService")
public class HumanResourceServiceImpl implements HumanResourceService {

	
	private AbsencesMapper absencesMapper;

	@Autowired
	public void setAddressMapper(AbsencesMapper absencesMapper) {
		this.absencesMapper = absencesMapper;
	}
	
	@Override
	public void bookHoliday(Date startDate, Date endDate, String name) {
		System.out.println("Start Date:"+startDate);
		System.out.println("End Date:"+endDate);
		System.out.println("Name:"+name);
	}

	@Override
	public Integer add(Integer param1, Integer param2) {
		return param1 + param2;
	}
	
	@Override
	public Integer count() {
		AbsencesExample example = new AbsencesExample();
		example.createCriteria().andAbsencecountGreaterThanOrEqualTo(1D);
		return absencesMapper.countByExample(example);
	}

	@Override
	public Absenses getAbsenses(String peopleId) {
		AbsencesExample example = new AbsencesExample();
		example.createCriteria().andAbsencecountGreaterThanOrEqualTo(1D).andPeopleCodeIdEqualTo(peopleId);

		example.setOrderByClause("Date_Absent desc");
		Integer countAbs = absencesMapper.countByExample(example);
		List<Absences> abs = absencesMapper.selectByExample(example);
		
		example.clear();
		example.createCriteria().andTardycountGreaterThanOrEqualTo(1D).andPeopleCodeIdEqualTo(peopleId);
		Integer countTardy = absencesMapper.countByExample(example);
		List<Absences> tardies = absencesMapper.selectByExample(example);
		example.setOrderByClause("Date_Tardy desc");

		Absenses retAbs = new Absenses();
		retAbs.setAbsenseCount(countAbs);
		retAbs.setTardyCount(countTardy);
		retAbs.setAbsenses(abs);
		retAbs.setTardies(tardies);
		return retAbs;
	}

}
