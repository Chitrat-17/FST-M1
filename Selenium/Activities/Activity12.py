from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/dynamic-content")
    print("Title of the page is : "+driver.title)

    driver.find_element(By.XPATH,"//button[text()='Click me!']").click()
    wait = WebDriverWait(driver, 10)
    # text_element = driver.find_element(By.XPATH,"//h2[@id='word']")
    if(wait.until(EC.text_to_be_present_in_element((By.XPATH,"//h2[@id='word']"),"release"))):
        print("Word Found : "+driver.find_element(By.XPATH,"//h2[@id='word']").text)
    
    driver.quit()