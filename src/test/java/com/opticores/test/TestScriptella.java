package com.opticores.test;

import static org.junit.Assert.*;

import org.junit.Test;

import scriptella.execution.EtlExecutor;
import scriptella.execution.EtlExecutorException;
import scriptella.execution.ExecutionStatistics;

public class TestScriptella {

	@Test
	public void testscriptella() throws EtlExecutorException {
		EtlExecutor etlExcutor = EtlExecutor.newExecutor(Thread.currentThread()
				.getContextClassLoader().getResource("etl.xml"));

		ExecutionStatistics statistics = etlExcutor.execute();

		assertNotNull(statistics);
	}
}
