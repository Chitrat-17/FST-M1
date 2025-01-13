from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    username_field = driver.find_element(By.XPATH,"//input[contains(@name,'Username')]")
    password_field = driver.find_element(By.XPATH,"//input[contains(@name,'Password')]")
    login_button = driver.find_element(By.XPATH,"//input[@name='Submit']")
    
    username_field.send_keys("orange")
    password_field.send_keys("orangepassword123")
    login_button.click()

    wait = WebDriverWait(driver, timeout=10, poll_frequency=3, ignored_exceptions='NoSuchElementException' )
    
    my_info = wait.until(EC.visibility_of_element_located((By.XPATH,"//a[@id='menu_pim_viewMyDetails']")))
    my_info.click()
    edit = wait.until(EC.visibility_of_element_located((By.XPATH,"//input[@value='Edit']")))
    edit.click()

    firstName_field = driver.find_element(By.XPATH,"//input[@id='personal_txtEmpFirstName']")
    lastName_field = driver.find_element(By.XPATH,"//input[@id='personal_txtEmpLastName']")
    gender = driver.find_element(By.XPATH,"//input[@id='personal_optGender_2']")
    nationality_dropdown = driver.find_element(By.XPATH,"//select[@id='personal_cmbNation']")
    select = Select(nationality_dropdown) 
    
    firstName_field.clear()
    firstName_field.send_keys("Mary")
    lastName_field.clear()
    lastName_field.send_keys("John")
    gender.click()
    select.select_by_visible_text("Indian")

    driver.find_element(By.XPATH,"//input[@id='btnSave']").click()
    driver.quit()