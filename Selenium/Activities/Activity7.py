from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print("Title of the page : ",driver.title)

    text_field = driver.find_element(By.XPATH,"//input[@id='textInput']")
    print("Is text field enabled: ",text_field.is_enabled())

    driver.find_element(By.XPATH,"//button[@id='textInputButton']").click()
    print("Is text field enabled: ",text_field.is_enabled())

    text_field.send_keys("Example text")
    print(text_field.get_property("value"))

    driver.quit()
