package core;

import java.util.Calendar;
import java.util.Date;

public class Diario implements Recorrencia {

	private int[] days;

	public Diario(int ... days) {
		this.days = days;
	}

	@Override
	public String getName() {
		return "Diário";
	}

	@Override
	public boolean occurrs(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		for (int day : days) {
			if (day == cal.get(Calendar.DAY_OF_WEEK))
				return true;
		}
		return false;
	}

}
