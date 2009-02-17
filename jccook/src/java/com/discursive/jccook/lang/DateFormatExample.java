/* 
 * ========================================================================
 * 
 * Copyright 2005 Tim O'Brien.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
package com.discursive.jccook.lang;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.log4j.Logger;

import com.discursive.jccook.util.LogInit;

/**
 * Include a table of the Values in DateFormatUtils
 */

public class DateFormatExample {

    private static Logger logger = Logger.getLogger(DateFormatExample.class);
    static {
        LogInit.init();
    }

    public static void main(String[] pArgs) throws Exception {
        DateFormatExample example = new DateFormatExample();
        example.testSimpleFormat();
        example.testRoundedDates();
        example.testTruncate();
        example.testIterator();
        example.testFormatUTC();
    }

    public void testSimpleFormat() throws Exception {

        Date now = new Date();
        logger.debug(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now));
    }

    public void testRoundedDates() throws Exception {
        FastDateFormat sdf = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT;
        Date now = new Date();
        Date nearestHour = DateUtils.round(now, Calendar.HOUR);
        Date nearestMonth = DateUtils.round(now, Calendar.MONTH);
        Date nearestYear = DateUtils.round(now, Calendar.YEAR);
        logger.debug("now: " + sdf.format(now));
        logger.debug("round hour: " + sdf.format(nearestHour));
        logger.debug("round month: " + sdf.format(nearestMonth));
        logger.debug("round year: " + sdf.format(nearestYear));
    }

    public void testTruncate() throws Exception {
        Date now = new Date();
        Date truncYear = DateUtils.truncate(now, Calendar.YEAR);
        Date truncMonth = DateUtils.truncate(now, Calendar.MONTH);
        logger.debug(
            "now: "
                + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now));
        logger.debug(
            "truncYear: "
                + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(
                    truncYear));
        logger.debug(
            "truncMonth: "
                + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(
                    truncMonth));

    }

    public void testIterator() throws Exception {
        Date now = new Date();
        logger.debug(
            "now: "
                + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now));
        Iterator iter = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY);
        while (iter.hasNext()) {
            Calendar cal = (Calendar) iter.next();
            Date cur = cal.getTime();
            logger.debug(
                "iterate: "
                    + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(cur));
        }
    }

    public void testFormatUTC() throws Exception {
        Date now = new Date();
        logger.debug(
            "now: "
                + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now));
        logger.debug(
            "UTC Time: "
                + DateFormatUtils.formatUTC(
                    now,
                    DateFormatUtils
                        .ISO_DATETIME_TIME_ZONE_FORMAT
                        .getPattern()));

    }

}
