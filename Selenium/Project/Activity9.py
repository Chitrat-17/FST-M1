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
    driver.find_element(By.XPATH,"//a[contains(@href,'viewEmergencyContacts')]").click()

    heading = driver.find_elements(By.XPATH,"//table[@id='emgcontact_list']/thead/tr")
    for head in heading:
        print(head.text)
    rows = driver.find_elements(By.XPATH,"//table[@id='emgcontact_list']/tbody/tr")
    for details in rows:
        print(details.text)
    
    driver.quit()