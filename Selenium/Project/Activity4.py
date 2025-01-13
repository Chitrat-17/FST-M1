from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver import ActionChains
import time

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    wait = WebDriverWait(driver, timeout=10)
    driver.implicitly_wait(8)

    username_field = driver.find_element(By.XPATH,"//input[contains(@name,'Username')]")
    password_field = driver.find_element(By.XPATH,"//input[contains(@name,'Password')]")
    login_button = driver.find_element(By.XPATH,"//input[@name='Submit']")
    
    username_field.send_keys("orange")
    password_field.send_keys("orangepassword123")
    login_button.click()

    pimoption = driver.find_element(By.XPATH,"//a[contains(@id,'menu_pim_viewPimModule')]/b")
    pimoption.click()
    
    Add_button = wait.until(EC.visibility_of_element_located((By.XPATH,"//a[contains(@id,'addEmployee')]")))
    Add_button.click()

    firstName_field = driver.find_element(By.XPATH,"//input[@id='firstName']")
    lastName_field = driver.find_element(By.XPATH,"//input[@id='lastName']")
    save_button = driver.find_element(By.XPATH,"//input[@id='btnSave']")

    firstName_field.send_keys("Damon")
    lastName_field.send_keys("Salvatore")
    save_button.click()
    print('save button is clicked')

    Pim_option = wait.until(EC.element_to_be_clickable((By.XPATH,"//a[contains(@id,'menu_pim_viewPimModule')]")))
    Pim_option.click()
    time.sleep(10)
    emp_name_input_search = driver.find_element(By.XPATH,"//input[@id='empsearch_employee_name_empName']")
    emp_name_input_search.send_keys("Damon Salvatore")
    

    search_button = driver.find_element(By.XPATH,"//input[@id='searchBtn']")
    search_button.click()
    firstName_entry = driver.find_element(By.XPATH,"//table[@id='resultTable']/tbody/tr[1]/td[3]").text
    print(firstName_entry)
    assert firstName_entry == "Damon"
    lastName_entry = driver.find_element(By.XPATH,"//table[@id='resultTable']/tbody/tr[1]/td[4]").text
    print(lastName_entry)
    assert lastName_entry == "Salvatore"

    id = driver.find_element(By.XPATH,"//table[@id='resultTable']/tbody/tr[1]/td[2]").text
    assert id != 'null'

    driver.quit()
    