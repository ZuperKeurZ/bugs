/*
 * Copyright (c) 2015, COSMOS N.V. All Rights Reserved.
 *
 */
package dozerApiBug;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

public class DozerMappingTest
{
    final DozerBeanMapper apiMapper, xmlMapper;

    public DozerMappingTest()
    {
        xmlMapper = new DozerBeanMapper(Arrays.asList("dozerBeanMapping.xml"));
        apiMapper = new DozerBeanMapper();
        apiMapper.setCustomConverters(Arrays.<CustomConverter> asList(new DateTimeConverter()));
        apiMapper.addMapping(builder);

    }

    BeanMappingBuilder builder = new BeanMappingBuilder()
    {
        @Override
        protected void configure()
        {
            mapping(Person.class, Shadow.class);
        }
    };

    @Test
    public void onlyDatesusingXml()
    {

        doMappingStuffOnDatesOnly(xmlMapper);
    }

    @Test
    public void onlyDatesusingApi()
    {
        // ERROR custom convert not used, only constructors called
        doMappingStuffOnDatesOnly(apiMapper);
    }

    @Test
    public void complexStuffUsingXml()
    {
        doMappingStuffComplexTypes(xmlMapper);
    }

    @Test
    public void complexStuffUsingApi()
    {
        // ERROR custom convert not used, only constructors called
        doMappingStuffComplexTypes(apiMapper);
    }

    private void doMappingStuffOnDatesOnly(DozerBeanMapper mapper)
    {
        assertEquals(1980, mapper.map(getMyBirthday(), DateTime.class).getYear());
        assertEquals(111, mapper.map(getMySonsBirthDay(), Date.class).getYear());

    }

    private void doMappingStuffComplexTypes(DozerBeanMapper mapper)
    {
        final Person me = new Person();
        me.birthDay = getMyBirthday();

        final Shadow mySonsShadow = new Shadow();
        mySonsShadow.birthDay = getMySonsBirthDay();

        // throws exception if accessors are defined, null values if not defined
        final Shadow myShadow = mapper.map(me, Shadow.class);
        // throws exception if accessors are defined, null values if not defined
        final Person mySon = mapper.map(mySonsShadow, Person.class);
    }

    private Date getMyBirthday()
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1980);
        c.set(Calendar.MONTH, Calendar.OCTOBER);
        c.set(Calendar.DAY_OF_MONTH, 25);
        return c.getTime();
    }

    private DateTime getMySonsBirthDay()
    {
        return new DateTime(2011, 11, 11, 17, 36);
    }
}
