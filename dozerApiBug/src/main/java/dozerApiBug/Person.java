/*
 * Copyright (c) 2015, COSMOS N.V. All Rights Reserved.
 *
 */
package dozerApiBug;

import java.util.Date;

public class Person
{
    public Date birthDay;

    public Date getbirthDay()
    {
        return birthDay;
    }

    public void setbirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }

}