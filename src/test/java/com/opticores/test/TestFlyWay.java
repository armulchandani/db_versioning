package com.opticores.test;

import static org.junit.Assert.*;

import org.flywaydb.core.Flyway;
import org.junit.Test;

public class TestFlyWay {

	
	@Test
	public void testFlyWay(){
		
		Flyway flyway= new Flyway();
		flyway.setDataSource("jdbc:mysql://localhost:3306/hibernate", "root", "anubhav");
		flyway.baseline();
		int migratedCount=flyway.migrate();
		assertEquals(2,migratedCount);
	}
	

	

}
