import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.intro.Customize
import com.intro.General

WebUI.openBrowser("https://dev01-b20.fairatmos.dev/", FailureHandling.STOP_ON_FAILURE)
WebUI.maximizeWindow()
//WebUI.navigateToUrl("https://dev01-b20.fairatmos.dev/", FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)
Customize.elementClickableByXpath("//img[@alt = 'Flight']")
WebUI.delay(3)
Customize.elementClickableByXpath("//span[(text() = 'Domestic' or . = 'Domestic')]")
WebUI.delay(3)

WebUI.delay(3)
Customize.elementClickableByXpath("//span[(text() = 'International' or . = 'International')]")
WebUI.delay(3)
Customize.elementClickableByXpath("(//span[@class = 'ant-select-selection-item'])[1]")
WebUI.delay(3)
Customize.elementClickableByXpath("//div[@class = 'ant-select-item-option-content' and (text() = 'Cyprus' or . = 'Cyprus')]")

WebUI.delay(3)
Customize.elementClickableByXpath("(//span[@class = 'ant-select-selection-item'])[2]")
WebUI.delay(3)
Customize.elementClickableByXpath("//div[@class = 'ant-select-item-option-content' and (text() = 'Bali, Indonesia' or . = 'Bali, Indonesia')]")

def fromFlight = Customize.elementGetTextByXpath("(//span[@class = 'ant-select-selection-item'])[1]")
def toFlight = Customize.elementGetTextByXpath("(//span[@class = 'ant-select-selection-item'])[2]")
WebUI.delay(3)
Customize.elementClickableByXpath("//span[(text() = 'Domestic' or . = 'Domestic')]")

