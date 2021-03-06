package Utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadEXCELFiles {
	
	
	public static List readExcel (int row) throws IOException{

	    File src=new File("C:\\Users\\mukesh\\workspace\\RestAssuredWithCucumber\\Library\\username.xlsx");
	    FileInputStream fis=new FileInputStream(src);
	    XSSFWorkbook srcBook= new XSSFWorkbook(fis);
	    XSSFSheet sourceSheet = srcBook.getSheetAt(0);

	    XSSFRow sourceRow = sourceSheet.getRow(row);
	    XSSFCell username=sourceRow.getCell(0);
	    XSSFCell password=sourceRow.getCell(1);
	    String userExcel = username.getStringCellValue();
	    String pwExcel = password.getStringCellValue();
	    List userlogin= new ArrayList();
	    userlogin.add(userExcel);
	    userlogin.add(pwExcel);
	    return userlogin;
	   

	}
}
