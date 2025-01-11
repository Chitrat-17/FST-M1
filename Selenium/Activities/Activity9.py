from selenium import webdriver
from selenium.webdriver import Keys, ActionChains
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/keyboard-events")
    print("Title of the page is "+driver.title)

    actions = webdriver.ActionChains(driver)
    actions.send_keys("Hello Selenium!").send_keys(Keys.RETURN).perform()
    pageText = driver.find_element(By.CSS_SELECTOR,"h1.mt-3").text
    print(pageText)

    driver.quit()