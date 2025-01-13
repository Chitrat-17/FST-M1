from selenium import webdriver
from selenium.webdriver.common.by import By
import time

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    username_field = driver.find_element(By.XPATH,"//input[contains(@name,'Username')]")
    password_field = driver.find_element(By.XPATH,"//input[contains(@name,'Password')]")
    login_button = driver.find_element(By.XPATH,"//input[@name='Submit']")
    
    username_field.send_keys("orange")
    password_field.send_keys("orangepassword123")
    login_button.click()

    my_info = driver.find_element(By.XPATH,"//a[@id='menu_pim_viewMyDetails']")
    my_info.click()

    time.sleep(10)
    qualification = driver.find_element(By.XPATH,"//a[contains(@href,'viewQualifications')]")
    qualification.click()

    add = driver.find_element(By.XPATH,"//input[@id='addWorkExperience']")
    add.click()

    company = driver.find_element(By.XPATH,"//input[contains(@name,'employer')]")
    job_title = driver.find_element(By.XPATH,"//input[contains(@name,'jobtitle')]")

    company.send_keys("Infy")
    job_title.send_keys("Test Engineer")

    driver.find_element(By.XPATH,"//input[@id='btnWorkExpSave']").click()

    driver.quit()