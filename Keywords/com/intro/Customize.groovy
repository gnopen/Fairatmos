package com.intro

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.configuration.RunConfiguration

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

import org.openqa.selenium.Keys

public class Customize {

	public static def getAttribute(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def width = WebUI.getAttribute(titleObject, "title")
			return width
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementChecked(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def flag = WebUI.verifyElementChecked(titleObject, 0)
			return 1
		}
		catch(Exception e){
			return 0
		}
	}

	public static def verifyText(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def flag = WebUI.verifyElementClickable(titleObject)
			return "Success"
		}
		catch(Exception e){
			return "Failed"
		}
	}


	public static def openBrowser(path){
		WebUI.navigateToUrl(path)
	}

	public static def clickOnPosition(xpath,width,height){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		WebUI.clickOffset(titleObject, width, height)
		return 1
	}

	public static def getWidth(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def width = WebUI.getElementWidth(titleObject)
			return width
		}catch(Exception e ){
			return 0
		}
	}

	public static def getHeight(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def height = WebUI.getElementHeight(titleObject)
			return height
		}catch(Exception e ){
			return 0
		}
	}


	public static def scrollToElement(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.waitForElementPresent(titleObject, 10)
			WebUI.scrollToElement(xpath, 0)
			return 1
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementUploadFile(xpath,namefile){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			String filePath = RunConfiguration.getProjectDir() + '/Image/' + namefile
			WebUI.uploadFile(titleObject, filePath)
			return 1
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementClickableByXpath(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{

			WebUI.waitForElementPresent(titleObject, 10)

			WebUI.click(titleObject)
			return 1
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementGetTextByXpath(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.waitForElementPresent(titleObject, 10)
			return WebUI.getText(titleObject)
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementSetTextByXpath(xpath,text){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.waitForElementPresent(titleObject, 10)
			WebUI.setText(titleObject, text)
			return 1
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementSelectByIndex(xpath,index){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.waitForElementPresent(titleObject, 10)
			WebUI.selectOptionByIndex(titleObject, index)
			return 1
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementSelectByLabel(xpath,index){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.selectOptionByLabel(titleObject, index, false)
			return 1
		}catch(Exception e ){
			return 0
		}
	}

	public static def elementSwitchToIFrame(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.switchToFrame(titleObject,3)
			return 1
		}catch(Exception e){
			return 0
		}
	}

	public static def elementSendKey(xpath,keys){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			WebUI.sendKeys(titleObject, Keys.chord(keys))
			return 1
		}catch(Exception e){
			return 0
		}
	}

	public static def verifyElement(xpath){
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def flag = WebUI.verifyElementClickable(titleObject)
			return 1
		}catch(Exception e){
			return 0
		}
	}

	public static def getValue(xpath) {
		TestObject titleObject = new TestObject("Object")
		titleObject.addProperty("xpath", ConditionType.EQUALS, xpath, true)
		try{
			def flag = WebUI.getAttribute(titleObject, 'value')
			return flag
		}catch(Exception e){
			return 0
		}
	}
}
