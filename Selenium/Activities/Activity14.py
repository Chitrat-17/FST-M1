from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/tables")
    print("Title of the page is : "+driver.title)

    rows = driver.find_elements(By.XPATH,"//table/tbody/tr")
    print("Number of rows : ",len(rows))
    cols = driver.find_elements(By.XPATH,"//table/tbody/tr[1]/td")
    print("Number of columns : ",len(cols))

    cellValue = driver.find_element(By.XPATH,"//table/tbody/tr[5]/td[2]")
    print("cell value before sorting "+cellValue.text)

    driver.find_element(By.XPATH,"//table/thead/tr/th[5]").click()

    cellValue = driver.find_element(By.XPATH,"//table/tbody/tr[5]/td[2]")
    print("cell value after sorting "+cellValue.text)

    driver.quit()