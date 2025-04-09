package dataproviders;

import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

import java.io.IOException;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/data-files/loginData.xlsx";
        String sheetName = "loginData";
        ExcelUtil excelUtil = new ExcelUtil(filePath, sheetName);
        return excelUtil.getData();
    }
}
