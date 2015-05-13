/*
 * Copyright (c) 2015, COSMOS N.V. All Rights Reserved.
 *
 */
package dozerApiBug;

import org.joda.time.DateTime;

public class Shadow
{
    public DateTime birthDay;

    public DateTime getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(DateTime birthDay)
    {
        this.birthDay = birthDay;
    }

}