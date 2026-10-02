# input() returns text; int() converts that text to a whole number.
age = int(input("Enter Your Age:"))
tax = 10
# This adds two integer values and stores the result in now.
now = age + tax
print(now)

# float() converts input text to a number that may contain decimals.
price = float(input("Enter Your Price:"))
total = price + tax
print("Total:", total)
