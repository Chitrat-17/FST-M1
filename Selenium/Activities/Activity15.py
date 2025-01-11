from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    print("Title of the page : ",driver.title)

    wait = WebDriverWait(driver, timeout=10)

    driver.find_element(By.XPATH,"//input[contains(@name,'full-name')]").send_keys("Harry Potter")
    driver.find_element(By.XPATH,"//input[contains(@name,'email')]").send_keys("harry@gmail.com")
    driver.find_element(By.XPATH,"//input[contains(@name,'event-date')]").send_keys("2025-06-26")
    driver.find_element(By.XPATH, "//textarea[contains(@id, 'additional-details')]").send_keys("NA")
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("message is : "+message)
    driver.quit()