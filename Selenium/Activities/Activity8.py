from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/mouse-events")
    print(driver.title)

    cargoLock_Element = driver.find_element(By.XPATH,"//h1[text()='Cargo.lock']")
    actions = webdriver.ActionChains(driver)
    actions.click(cargoLock_Element).perform()

    cargoToml_Element = driver.find_element(By.XPATH,"//h1[text()='Cargo.toml']")
    actions.move_to_element(cargoToml_Element).click().perform()

    result = driver.find_element(By.XPATH,"//p[@id='result']")
    print("Confirmation message is : "+result.text)

    src = driver.find_element(By.XPATH,"//h1[text()='src']")
    actions.double_click(src).perform()

    target = driver.find_element(By.XPATH,"//h1[text()='target']")
    actions.context_click(target).perform()
    
    driver.find_element(By.XPATH,"//span[text()='Open']").click()
    print("Confirmation message is : "+result.text)

    driver.quit()
