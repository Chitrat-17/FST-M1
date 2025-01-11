from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print("Title of the page is : "+driver.title)

    checkbox = driver.find_element(By.ID,"checkbox")
    print("Checkbox is visible? ",checkbox.is_displayed())

    toggle_checkbox = driver.find_element(By.XPATH,"//button[text()='Toggle Checkbox']")
    toggle_checkbox.click()

    wait = WebDriverWait(driver, 10)
    wait.until(EC.invisibility_of_element(checkbox))
    print("Checkbox is visible? ",checkbox.is_displayed())

    toggle_checkbox.click()
    wait.until(EC.element_to_be_clickable(checkbox)).click()
    print("Checkbox is selected? :",checkbox.is_selected())

    driver.quit()