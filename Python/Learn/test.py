
# A function stores reusable instructions and returns a result.
def add(x, y):
    return x + y

print("Selecto operation")

# input() returns text, even when the user types a number.
choice = input("Enter choice")
# This tuple contains the valid menu choices.
if choice in ('1', '2', '3', '4'):
    num1= float(input("enter num1: "))
    num2= float(input("enter num2: "))

    # match compares choice with each case and runs the matching block.
    match choice:
        case "1":
            print(add(num1,num2))
else:
    print("restart")
class myclass():
    # __len__ controls what len() and bool() consider empty or non-empty.
  def __len__(self):
    return 0

myobj = myclass()
print(bool(myobj))