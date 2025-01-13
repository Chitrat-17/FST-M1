from selenium import webdriver

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    title = driver.title
    print("Title of the page is : "+title)

    assert title == "OrangeHRM"
    print("Tile of the page is matching")
    driver.quit()