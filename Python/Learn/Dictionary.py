# A dictionary stores data as key-value pairs: key -> value.
dict1 = {"Anime": "Japanese Animation", "Manga": "Japanese Comic"}
# print(dict1)

print("Welcome To My Dictionary!")
# while True repeats this menu until the break statement is reached.
while True:
    # .keys() gives a view of all available dictionary keys.
    print("Which Words' Definition Do You Want?", dict1.keys())
    # input() always returns text (a string).
    ans = input("Word:")
    # The key inside [] is used to look up its matching value.
    print(dict1[ans])

    print("Do you want to use the Dictionary again? (Y/N)")
    ans = input()
    # or means either condition may be True; break exits the loop.
    if ans == "n" or ans == "N":
        break
