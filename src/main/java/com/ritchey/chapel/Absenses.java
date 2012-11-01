package com.ritchey.chapel;

import java.util.List;

import com.ritchey.chapel.domain.Absences;

public class Absenses {
	Integer absenseCount;
	Integer tardyCount;
	List<Absences> absenses;
	List<Absences> tardies;
	
	
	public Integer getAbsenseCount() {
		return absenseCount;
	}
	public void setAbsenseCount(Integer absenseCount) {
		this.absenseCount = absenseCount;
	}
	public List<Absences> getAbsenses() {
		return absenses;
	}
	public void setAbsenses(List<Absences> absenses) {
		this.absenses = absenses;
	}
	public List<Absences> getTardies() {
		return tardies;
	}
	public void setTardies(List<Absences> tardies) {
		this.tardies = tardies;
	}
	public Integer getTardyCount() {
		return tardyCount;
	}
	public void setTardyCount(Integer tardyCount) {
		this.tardyCount = tardyCount;
	}
}
