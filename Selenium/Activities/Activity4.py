from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

with webdriver.Firefox() as  driver:
    driver.get("https://training-support.net/webelements/target-practice")
    print(driver.title)

    third_header_text = driver.find_element(By.XPATH,"//h3[contains(text(),'#3')]").text
    print(third_header_text)
 
    fifth_heading_color = Color.from_string(driver.find_element(By.XPATH, "//h5[contains(text(), '#5')]").value_of_css_property("color"))
    print("Fifth heading colour as Hexcode: ", fifth_heading_color.hex)
    print("Fifth heading colour as RGB: ", fifth_heading_color.rgb)

    purpleButtonClass = driver.find_element(By.XPATH, "//button[text()='Purple']").get_attribute("class")
    print(purpleButtonClass)

    slateButtonText = driver.find_element(By.XPATH,"//button[contains(@class,'slate')]").text
    print(slateButtonText)
    
    driver.quit()