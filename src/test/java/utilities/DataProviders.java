package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = "C:\\Users\\rajat.soodan\\IdeaProjects\\ecommerceautomation\\src\\test\\java\\testData\\Opencart_LoginData.xlsx"; //taking excel file from testdata

        ExcelUtility utility = new ExcelUtility(path);

        int total_rows = utility.getRowCount("Sheet1");
        int total_Col = utility.getCellCount("Sheet1", 1);

        String[][] loginData = new String[total_rows][total_Col];
        for (int i = 1; i <= total_rows; i++) {
            for (int j = 0; j < total_Col; j++) {
                loginData[i - 1][j] = utility.getCellData("Sheet1", i, j);
            }
        }
        return loginData;

    }
}



