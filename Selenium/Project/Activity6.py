from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    username_field = driver.find_element(By.XPATH,"//input[contains(@name,'Username')]")
    password_field = driver.find_element(By.XPATH,"//input[contains(@name,'Password')]")
    login_button = driver.find_element(By.XPATH,"//input[@name='Submit']")
    
    username_field.send_keys("orange")
    password_field.send_keys("orangepassword123")
    login_button.click()

    directory = driver.find_element(By.XPATH,"//a[@id='menu_directory_viewDirectory']")
    if(directory.is_displayed()):
        directory.click()
        heading = driver.find_element(By.XPATH,"//div[@id='content']/div/div/h1")
        print("Heading is : "+heading.text)
        assert heading.text == 'Search Directory'

    driver.quit()
        
    