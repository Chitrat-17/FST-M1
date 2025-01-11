from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/drag-drop")
    print("Title of the page is : "+driver.title)

    ball = driver.find_element(By.XPATH,"//img[@id='ball']")
    dropZone_1 = driver.find_element(By.XPATH,"//div[@id='dropzone1']")
    dropZone_2 = driver.find_element(By.XPATH,"//div[@id='dropzone2']")

    actions = webdriver.ActionChains(driver)
    actions.click_and_hold(ball).move_to_element(dropZone_1).release().perform()
    if(dropZone_1.find_element(By.CLASS_NAME,"dropzone-text").text == 'Dropped!'):
        print("Ball is dropped in drop zone 1")
    
    actions.drag_and_drop(ball,dropZone_2).perform()
    if(dropZone_2.find_element(By.CLASS_NAME,"dropzone-text").text == 'Dropped!'):
        print("Ball is dropped in drop zone 2")

    driver.quit()