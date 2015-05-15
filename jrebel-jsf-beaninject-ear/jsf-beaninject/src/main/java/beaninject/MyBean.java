/*
 * Copyright (c) 2015, COSMOS N.V. All Rights Reserved.
 *
 */
package beaninject;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import beaninject.ejb.SomeEjb;

@ManagedBean(name = "myBean")
public class MyBean
{
    @EJB
    SomeEjb someEjb;

    public String getGreeting()
    {
        return someEjb.greeting();
    }
}
