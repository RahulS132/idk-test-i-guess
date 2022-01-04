import random

print('Welcome to Dice Simulator')
while True:
    print('Do You Want to roll the Dice?')
    ans = input()
    if ans == 'y' or ans == 'Y':

        comp_roll = random.randint(1, 6)
        print('The Computer Rolled:', comp_roll)

    elif ans == 'n' or ans == 'N':
        break

    print("Do you want to Roll again? (Y/N)")
    ans1 = input()

    if ans1 == 'n' or ans1 == 'N':
        break

print("\nThanks for Trying")
