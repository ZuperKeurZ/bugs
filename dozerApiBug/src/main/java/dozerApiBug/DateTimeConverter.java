/*
 * Copyright (c) 2013, COSMOS N.V. All Rights Reserved.
 *
 */
package dozerApiBug;

import java.util.Date;

import org.dozer.DozerConverter;
import org.joda.time.DateTime;

public class DateTimeConverter extends DozerConverter<Date, DateTime>
{
    public DateTimeConverter()
    {
        super(Date.class, DateTime.class);
    }

    @Override
    public Date convertFrom(DateTime source, Date destination)
    {
        if (source == null)
        {
            return null;
        }
        else
        {
            return source.toDate();
        }

    }

    @Override
    public DateTime convertTo(Date source, DateTime destination)
    {
        if (source == null)
        {
            return null;
        }
        else
        {
            return new DateTime(source);
        }
    }
}
