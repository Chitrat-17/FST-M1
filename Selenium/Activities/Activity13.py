from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/tables")
    print("Title of the page is : "+driver.title)

    rows = driver.find_elements(By.XPATH,"//table/tbody/tr")
    print("Number of rows : ",len(rows))
    cols = driver.find_elements(By.XPATH,"//table/tbody/tr[1]/td")
    print("Number of columns : ",len(cols))

    third_row = driver.find_elements(By.XPATH, "//table/tbody/tr[3]/td")
    print("Third row elemets are : ")
    for i in third_row:
        print(i.text)

    second_row_second_element = driver.find_element(By.XPATH,"//table/tbody/tr[2]/td[2]")
    print("second_row_second_element is "+second_row_second_element.text)

    driver.quit()