/*
 * Copyright (c) 2015, COSMOS N.V. All Rights Reserved.
 *
 */
package beaninject;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "anotherBean")
public class AnotherBean
{
    public String getName()
    {
        return "James";
    }
}
