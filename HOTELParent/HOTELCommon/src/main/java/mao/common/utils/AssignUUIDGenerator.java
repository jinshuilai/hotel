/*
 * Copyright © 2016 uerp.net. All rights reserved.
 */
package mao.common.utils;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class AssignUUIDGenerator implements IdentifierGenerator, Configurable {

	@Override
	public void configure(Type type, Properties properties, Dialect dialect)
			throws MappingException {

	}

	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		return UUIDGenerator.getUID();
	}

}
