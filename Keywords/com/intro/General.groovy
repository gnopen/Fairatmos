package com.intro

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.text.SimpleDateFormat
import java.util.Calendar
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.*

import org.apache.commons.io.FileUtils

public class General {

	public static def getNumericOnly(String input){
		return input.replaceAll("[^\\d]", "")
	}

	public static def getRandomNumber(){
		Random rand = new Random()
		def rand_int1 = rand.nextInt(999999);
		def rand_int2 = rand.nextInt(999999);
		def num = rand_int1 + rand_int2
		return num
	}

	public static def getDate(format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	public static def getStorage(name){
		String 	result = "",
		datafile = "Data Files/Setup/Setting/Storage/df_storage"

		for (int rowNum = 1; rowNum <= findTestData(datafile).getRowNumbers(); rowNum++) {
			String	name_exl = findTestData(datafile).getValue(1, rowNum),
			value_exl = findTestData(datafile).getValue(2, rowNum)
			if(name_exl==name){
				result =  value_exl
			}
			if(name_exl==""){
				break
			}
		}

		return result
	}

	public static def setStorage(name,value,description){
		def datafile = "Data Files/Setup/Setting/Storage/df_storage",
		excelfile = "Data Files/Setup/Setting/Storage/storage.xlsx",
		flag = 0,
		index = 0

		FileInputStream input = new FileInputStream(excelfile);
		Workbook workbook = new XSSFWorkbook(input)
		CreationHelper createHelper = workbook.getCreationHelper()
		def sheet01 = workbook.getSheet("Storage")

		for (int rowNum = 1; rowNum <= findTestData(datafile).getRowNumbers(); rowNum++) {
			flag=1
			String name_exl = findTestData(datafile).getValue(1, rowNum)
			String value_exl = findTestData(datafile).getValue(2, rowNum)
			String desc_exl = findTestData(datafile).getValue(3, rowNum)
			index = rowNum
			if(name_exl == name){
				sheet01.getRow(rowNum).createCell(1).setCellValue(value)
				sheet01.getRow(rowNum).createCell(2).setCellValue(description)
				break;
			}else if(name_exl==""){
				def temp = rowNum + 1
				sheet01.createRow(temp);
				sheet01.getRow(temp).createCell(0).setCellValue(name)
				sheet01.getRow(temp).createCell(1).setCellValue(value)
				sheet01.getRow(temp).createCell(2).setCellValue(description)
				break
			}else{
				flag=2
			}
		}

		if(flag==0){
			sheet01.createRow(1);
			sheet01.getRow(1).createCell(0).setCellValue(name)
			sheet01.getRow(1).createCell(1).setCellValue(value)
			sheet01.getRow(1).createCell(2).setCellValue(description)
		}else if (flag==2){
			index++
			sheet01.createRow(index);
			sheet01.getRow(index).createCell(0).setCellValue(name)
			sheet01.getRow(index).createCell(1).setCellValue(value)
			sheet01.getRow(index).createCell(2).setCellValue(description)
		}

		FileOutputStream out = new FileOutputStream(excelfile);
		workbook.write(out)
	}

	
}
