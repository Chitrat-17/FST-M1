from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print("Title of the page : "+driver.title)

    checkbox = driver.find_element(By.ID,"checkbox")
    print("is checkbox selected : ",checkbox.is_selected())

    checkbox.click()
    print("is checkbox selected : ",checkbox.is_selected())

    driver.quit()

