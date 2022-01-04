dict1 = {"Anime": "Japanese Animation", "Manga": "Japanese Comic"}
# print(dict1)

print("Welcome To My Dictionary!")
while True:
    print("Which Words' Definition Do You Want?", dict1.keys())
    ans = input("Word:")
    print(dict1[ans])

    print("Do you want to use the Dictionary again? (Y/N)")
    ans = input()
    if ans == "n" or ans == "N":
        break
