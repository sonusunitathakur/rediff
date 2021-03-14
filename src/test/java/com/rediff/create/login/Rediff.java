package com.rediff.create.login;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Rediff {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://www.rediff.com");
		
		File f=new File("C:\\Users\\SONU\\eclipse-workspace\\Redifmailcom\\src\\test\\resources\\Testrediff\\Rediffdata.xls");
		FileInputStream Fis=new FileInputStream(f);
		
		HSSFWorkbook wb=new HSSFWorkbook(Fis);
		HSSFSheet sheet=wb.getSheet("Sheet1");
		
		String name=sheet.getRow(1).getCell(0).getStringCellValue();
		
		String id=sheet.getRow(1).getCell(1).getStringCellValue();
		String pw=sheet.getRow(1).getCell(2).getStringCellValue();
		String retype=sheet.getRow(1).getCell(3).getStringCellValue();
		
		String alt=sheet.getRow(1).getCell(4).getStringCellValue();
		String mob=sheet.getRow(1).getCell(5).toString();
		String day=sheet.getRow(1).getCell(6).toString();
		String month=sheet.getRow(1).getCell(7).getStringCellValue();
		String year=sheet.getRow(1).getCell(8).toString();
		String country=sheet.getRow(1).getCell(9).getStringCellValue();
		String captch=sheet.getRow(1).getCell(10).getStringCellValue();
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(retype);
		System.out.println(alt);
		System.out.print(mob);
		System.out.println(day);
		System.out.println(year);
		
		
		
		WebElement create=d.findElement(By.xpath("//*[@id='signin_info']/a[2]"));
		create.click();
		
		WebElement fname=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input"));
		WebElement eid=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[1]"));
		WebElement pw1=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[9]/td[3]/input"));
		WebElement pw2=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[11]/td[3]/input"));
		WebElement alt1=d.findElement(By.xpath("//*[@id='div_altemail']/table/tbody/tr[1]/td[3]/input"));
		WebElement mob1=d.findElement(By.xpath("//*[@id='mobno']"));
		WebElement day1=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[1]"));
		WebElement month1=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[2]"));
		WebElement year1=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[3]"));
		WebElement radio2=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[24]/td[3]/input[2]"));
		WebElement count1=d.findElement(By.xpath("//*[@id='country']"));
		WebElement Cap=d.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[32]/td[3]/input"));
		
		//Select dob=new Select(ddn);
		//dob.selectByIndex(23);
		
		//Select dob1=new Select(ddn1);
		//dob1.selectByIndex(1);
		
		//Select dob2=new Select(ddn2);
		//dob2.selectByVisibleText("2001");
		
		
		
		count1.sendKeys(country);
		fname.sendKeys(name);
		eid.sendKeys(id);
		pw1.sendKeys(pw);
		pw2.sendKeys(retype);
		alt1.sendKeys(alt);
		mob1.sendKeys(mob);
		day1.sendKeys(day);
		month1.sendKeys(month);
		year1.sendKeys(year);
		radio2.click();
		Cap.sendKeys(captch);
		
		wb.close();

	}

}
