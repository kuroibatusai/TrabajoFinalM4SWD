package com.devops.dxc.devops.model;

//Asserts
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DxcTests {

	@Test
	void testImpuesto() throws Exception {
		//Rango 1m a 2.5m
		Dxc clase1 = new Dxc(45000000, 2300000, "05-02-2021");
		assertEquals(349653.68, clase1.getImpuesto());

		//Rango 2.5m a 3.m
		Dxc clase2 = new Dxc(45000000, 2600000, "04-02-2021");
		assertEquals(589983.75, clase2.getImpuesto());

		//Rango 3m a 4m
		Dxc clase3 = new Dxc(45000000, 3100000, "04-02-2021");
		assertEquals(589983.75, clase3.getImpuesto());

		//Rango 4m a 5m
		Dxc clase4 = new Dxc(45000000, 4900000, "04-02-2021");
		assertEquals(1485885.0, clase4.getImpuesto());

		//Rango 5m a 6m
		Dxc clase5 = new Dxc(45000000, 5120000, "04-02-2021");
		assertEquals(1485885.0, clase5.getImpuesto());

		//Rango menor a 1m
		Dxc clase6 = new Dxc(24000000, 900000, "04-02-2021");
		assertEquals(0.0, clase6.getImpuesto());

	}
	
	
	@Test
	public void testDiezxciento() throws Exception {
		//Si el saldo es menor a 35 UF el retiro debe ser igual al saldo
		Dxc dxc1 = new Dxc(24000000, 900000, "04-02-2021");
		assertEquals(2400000, dxc1.getDxc());
		
		//El retiro no puede ser mayor a 150 UF
		Dxc dxc2 = new Dxc(45000000, 5500000, "04-02-2021");
		assertEquals(4370250, dxc2.getDxc());
		
		//La Ley estableció un mínimo de entre 0 y 35 UF
		Dxc dxc3 = new Dxc(1500000, 900000, "04-02-2021");
		assertEquals(1019725, dxc3.getDxc());
		
	}

	@Test
	public void testSaldo() throws Exception {

		Dxc c1 = new Dxc(45000000, 2300000, "04-02-2021");
		assertEquals(40629750, c1.getSaldo());

		Dxc c2 = new Dxc(1500000, 4900000, "04-02-2021");
		assertEquals(480275, c2.getSaldo());
		
	}
	
	
}
