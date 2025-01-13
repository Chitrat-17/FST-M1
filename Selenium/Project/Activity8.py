from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
import time

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    username_field = driver.find_element(By.XPATH,"//input[contains(@name,'Username')]")
    password_field = driver.find_element(By.XPATH,"//input[contains(@name,'Password')]")
    login_button = driver.find_element(By.XPATH,"//input[@name='Submit']")
    
    username_field.send_keys("orange")
    password_field.send_keys("orangepassword123")
    login_button.click()

    time.sleep(3)
    apply_leave = driver.find_element(By.XPATH,"//div[@class='quickLaunge']/a[contains(@href,'applyLeave')]")
    apply_leave.click()

    time.sleep(3)

    leave_type_dropdown = driver.find_element(By.XPATH,"//select[@id='applyleave_txtLeaveType']")
    select = Select(leave_type_dropdown)

    select.select_by_index(1)

    from_date = driver.find_element(By.XPATH,"//input[@id='applyleave_txtFromDate']")
    to_date = driver.find_element(By.XPATH,"//input[@id='applyleave_txtToDate']")

    from_date.clear()
    from_date.send_keys("2025-03-10")
    to_date.clear()
    to_date.send_keys("2025-03-13")

    driver.find_element(By.ID,"applyBtn").click()

    driver.find_element(By.XPATH,"//a[contains(@href,'viewMyLeaveList')]").click()
    status = driver.find_element(By.XPATH,"//table[@id='resultTable']/tbody/tr[1]/td[6]/a").text
    print("Status of my leave is : "+status)
    driver.quit()
