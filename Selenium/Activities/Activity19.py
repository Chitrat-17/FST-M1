from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/alerts")
    print("Title of the page : "+driver.title)

    driver.find_element(By.ID,"confirmation").click()
    alert = driver.switch_to.alert
    print("Alert message is : "+alert.text)
    alert.accept()
    print(driver.find_element(By.ID,"result").text)

    driver.find_element(By.ID,"confirmation").click()
    alert = driver.switch_to.alert
    print("Alert message is : "+alert.text)
    alert.dismiss()
    print(driver.find_element(By.ID,"result").text)


    driver.quit()
