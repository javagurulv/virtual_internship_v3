package org.javaguru.travel.insurance.core;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class DateTimeService {

    long getDaysBetween(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}
