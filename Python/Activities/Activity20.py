import pandas

dataframe = pandas.read_excel("C:/Users/CHITRA/OneDrive/Documents/Full Stack Tester/python_coding/Activities/Activity19.xlsx")
print(dataframe)
print("Number of rows & columns : ", dataframe.shape)
print("Emails:",dataframe["Email"])
print(dataframe.sort_values("FirstName"))