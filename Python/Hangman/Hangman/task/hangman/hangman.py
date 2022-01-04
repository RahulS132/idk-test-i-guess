import random

# Write your code here
print("H A N G M A N")
word_list = ('python', 'java', 'kotlin', 'javascript')
word = random.choice(word_list)
word_length = len(word) - 2
hint = (word[:2] + ("_" * word_length))
ans = (input("Guess the word " + hint + ": "))
if ans == word:
    print("You survived!")
else:
    print("You are hanged!")
