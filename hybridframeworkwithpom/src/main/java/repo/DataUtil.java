package repo;

public class DataUtil {
	
	public static boolean isTestExecutable(ExcelApiTest eat, String sheetName, String testCaseName)
	{
		int rows = eat.getRowCount(sheetName);
		
		for(int rNum = 1; rNum <= rows; rNum++)
		{
			String tcName = eat.getCellData(sheetName, "TestCaseName", rNum);
			
			if(tcName.equals(testCaseName))
			{
				String runmode = eat.getCellData(sheetName, "RunMode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}

}
