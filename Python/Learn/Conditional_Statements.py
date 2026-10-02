# input() returns a string, so int() converts it to a whole number.
a = int(input("Enter a Number(a)="))
b = int(input("Enter a Number(b)="))
# if tests the first condition; elif means "else if"; else handles everything else.
if a>b:
    print(a, "is greater than", b)
elif a<b:    #elif is used for esle if statement.
    print(b, "is greater than", a)
else:
    print("a=b")