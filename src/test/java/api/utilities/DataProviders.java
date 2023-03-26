package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException {
		String path=System.getProperty("user.dir")+"//testData//UsersData.xlsx";
		ExcelUtility utility=new ExcelUtility(path);
		
		int rownum=utility.getRowCount("Sheet1");
		int columnCount=utility.getCellCount("Sheet1", 1);
		
		String apiData[][]=new String[rownum] [columnCount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<columnCount;j++){
				apiData[i-1][j]=utility.getCellData("Sheet1", i,j);
			}
		}
		return apiData;
		
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		String path=System.getProperty("user.dir")+"//testData//UsersData.xlsx";
		ExcelUtility utility=new ExcelUtility(path);
		
		int rownum=utility.getRowCount("Sheet1");
		
		String apiData[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
				apiData[i-1]=utility.getCellData("Sheet1", i,1);
			}
		
		return apiData;
		
	}
}
