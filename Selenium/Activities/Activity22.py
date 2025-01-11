from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/popups")
    print("Title of the page : "+driver.title)

    driver.find_element(By.ID,"launcher").click()

    driver.find_element(By.ID,"username").send_keys("admin")
    driver.find_element(By.ID,"password").send_keys("password")
    driver.find_element(By.XPATH,"//button[text()='Submit']").click()
    msg = driver.find_element(By.CSS_SELECTOR,"h2.mt-5").text
    print("Login Message : "+msg)

    driver.quit()