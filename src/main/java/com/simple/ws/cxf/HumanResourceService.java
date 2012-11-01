package com.simple.ws.cxf;


import java.util.Date;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ritchey.chapel.Absenses;

@WebService
public interface HumanResourceService {

	void bookHoliday(
			@WebParam(name="startDate")
			Date startDate, 
			@WebParam(name="endDate")
			Date endDate,
			@WebParam(name="name")
			String name);

	Integer add(@WebParam(name="param1")Integer param1, @WebParam(name="param2")Integer param2);

	Integer count();

	Absenses getAbsenses(String peopleId);

}
