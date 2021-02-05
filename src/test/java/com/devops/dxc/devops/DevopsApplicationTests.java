package com.devops.dxc.devops.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//Asserts
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevopsApplicationTests {

	@Test
	void testImpuesto() throws Exception {
		//Rango 1m a 2.5m
		Dxc clase1 = new Dxc(45000000, 2300000, 29135.0);
		assertEquals(184000.0, clase1.getImpuesto());

		//Rango 2.5m a 3.m
		Dxc clase2 = new Dxc(45000000, 2600000, 29135.0);
		assertEquals(351000.0, clase2.getImpuesto());

		//Rango 3m a 4m
		Dxc clase3 = new Dxc(45000000, 3100000, 29135.0);
		assertEquals(713000, clase3.getImpuesto());

		//Rango 4m a 5m
		Dxc clase4 = new Dxc(45000000, 4900000, 29135.0);
		assertEquals(1666000.0000000002, clase4.getImpuesto());

		//Rango 5m a 6m
		Dxc clase5 = new Dxc(45000000, 5120000, 29135.0);
		assertEquals(1792000.0, clase5.getImpuesto());

		//Rango menor a 1m
		Dxc clase6 = new Dxc(24000000, 900000, 29135.0);
		assertEquals(0.0, clase6.getImpuesto());

	}

	@Test
	public void testDiezxciento() throws Exception {
		//Si el saldo es menor a 1 millon el retiro debe ser igual al saldo
		Dxc dxc1 = new Dxc(24000000, 900000, 29135.0);
		assertEquals(2400000, dxc1.getDxc());
		
		//El retiro no puede ser mayor a 150 UF
		Dxc dxc2 = new Dxc(45000000, 5500000, 29135.0);
		assertEquals(4370250, dxc2.getDxc());
		
	}

	@Test
	public void testSaldo() throws Exception {

		Dxc c1 = new Dxc(45000000, 2300000, 29135.0);
		assertEquals(40445750, c1.getSaldo());

		Dxc c2 = new Dxc(45000000, 4900000, 29135.0);
		assertEquals(38963750, c2.getSaldo());
		
	}
	
}
