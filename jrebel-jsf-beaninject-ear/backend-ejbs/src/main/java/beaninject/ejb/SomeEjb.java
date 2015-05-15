/*
 * Copyright (c) 2015, COSMOS N.V. All Rights Reserved.
 *
 */
package beaninject.ejb;

import javax.ejb.Stateless;

@Stateless
public class SomeEjb
{
    public String greeting()
    {
        return "Aloha, how are you doing";
    }
}
