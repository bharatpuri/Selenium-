package testCases;

import org.testng.annotations.Test;

import com.base.DataStoreRepository;
import com.base.HandleException;
import com.base.IDataStoreInMap;

public class TestDemo {
  @Test
  public void demo() throws HandleException {
	  DataStoreRepository data = new DataStoreRepository("TestData", "LoginData");
      IDataStoreInMap dataStore = data.CreateDataStoreForFile();
	  System.out.println(dataStore.getValue("userName"));
  }
}
