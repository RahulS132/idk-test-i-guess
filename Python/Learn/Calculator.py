# Program make a simple calculator

# This function adds two numbers
def add(x, y):
    return x + y

# This function subtracts two numbers
def subtract(x, y):
    return x - y

# This function multiplies two numbers
def multiply(x, y):
    return x * y


# This function divides two numbers
def divide(x, y):
    return x / y


print("Select operation.")
print("1.Add")
print("2.Subtract")
print("3.Multiply")
print("4.Divide")

while True:
    # Take input from the user
    choice = input("Enter choice(1/2/3/4): ")

    # Check if choice is one of the four options
    if choice in ('1', '2', '3', '4'):
        num1 = float(input("Enter first number: "))
        num2 = float(input("Enter second number: "))

        if choice == '1':
            print(num1, "+", num2, "=", add(num1, num2))

        elif choice == '2':
            print(num1, "-", num2, "=", subtract(num1, num2))

        elif choice == '3':
            print(num1, "*", num2, "=", multiply(num1, num2))

        elif choice == '4':
            print(num1, "/", num2, "=", divide(num1, num2))
        break
    else:
        print("Invalid Input")

# print("Welcome to My Calculator")
# print("Choose the Operation:")
# while True:
#     print("1. Division\n2. Multiplication\n3. Addition\n4. Subtraction")
#     choice = int(input("Enter Choice:"))
#     while choice > 4 or choice < 1:
#         choice = int(input("enter valid input: "))
#
#     num1 = float(input("Enter First Number:"))
#     num2 = float(input("Enter Second Number:"))
#     if choice == 1:
#         ans = num1 / num2
#         print(num1, "divided by", num2, "is", ans)
#
#     if choice == 2:
#         ans = num1 * num2
#         print(num1, "multiplied by", num2, "is", ans)
#
#     if choice == 3:
#         ans = num1 + num2
#         print(num1, "added to", num2, "is", ans)
#
#     if choice == 4:
#         ans = num1 - num2
#         print(num1, "subtracted to", num2, "is", ans)
#
#     print("Do you want to Try again? (Y/N)")
#     ans = input()
#
#     if ans == 'n' or ans == 'N':
#         break
