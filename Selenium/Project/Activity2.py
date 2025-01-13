from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")

    logo_element = driver.find_element(By.XPATH,"//img[contains(@src,'login/logo')]")
    url_header_image = logo_element.get_dom_attribute("src")
    print("URL of header image is : "+url_header_image)

    driver.quit()