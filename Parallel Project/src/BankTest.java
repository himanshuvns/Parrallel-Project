import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.service.BankServiceImpl;

class BankTest {

	static BankServiceImpl bsi;
	@BeforeAll
	public static void init()
	{
		bsi = new BankServiceImpl(); 
	}
	
	
	@org.junit.jupiter.api.Test
	void test() {
		assertEquals("invalid", bsi.createAccount(new Bank(115036l, "Himanu","Ajeet Singh", 9855843325l,"dsbjgluerk.gh  kadsfhaf  jkafdjuh",500.0 , "ankit")));
	}

}
