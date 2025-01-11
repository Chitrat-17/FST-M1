from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/alerts")
    print("Title of the page : "+driver.title)

    driver.find_element(By.ID,"prompt").click()
    alert = driver.switch_to.alert
    print("Alert message is : "+alert.text)
    alert.send_keys("Awesome!")
    alert.accept()
    print(driver.find_element(By.ID,"result").text)

    driver.quit()
