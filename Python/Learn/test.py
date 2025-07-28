
def add(x, y):
    return x + y

print("Selecto operation")

choice = input("Enter choice")
if choice in ('1', '2', '3', '4'):
    num1= float(input("enter num1: "))
    num2= float(input("enter num2: "))

    match choice:
        case "1":
            print(add(num1,num2))
else:
    print("restart")