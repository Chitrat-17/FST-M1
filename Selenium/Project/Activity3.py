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

    homepage_welcome_text = driver.find_element(By.XPATH,"//a[@id='welcome']").text
    assert homepage_welcome_text == "Welcome Archana"
    print("The home page has opened")

    driver.quit()