import pandas

data = {
    "Usernames" : ["admin", "Charles", "Deku"],
    "Passwords" : ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(data)
dataframe.to_csv('C:/Users/CHITRA/OneDrive/Documents/Full Stack Tester/python_coding/Activities/Activity17File.csv', index=False)