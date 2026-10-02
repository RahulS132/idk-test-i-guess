# #dictionary in a dictionary
# users = {
#     'john': {
#         'first': 'John',
#         'last': 'Doe',
#         'username': 'johndoe'
#     },
#     'mary': {
#         'first': 'Mary',
#         'last': 'Smith',
#         'username': 'marysmith'
#     }
# }

# for username, user_info in users.items(): #loop through the dictionary
#     print(f"\nUsername: {username}") #print the username
#     full_name = f"{user_info['first']} {user_info['last']}" #create a full name by combining first and last name
#     print(f"\tFull Name: {full_name}") #print the full name
#     print(f"\tUsername: {user_info['username']}") #print the username


# #store information about a pizza being ordered.
# pizza = {
#     'crust': 'thick',
#     'toppings': ['mushrooms', 'extra cheese']
# }
# #summarize the order.
# print(f"You ordered a {pizza['crust']}-crust pizza "
#       "with the following toppings:")
# for topping in pizza['toppings']:
#     print(f"\t{topping}")


# #make an empty list for storing aliens
# aliens = []
# #make 10 orange aliens
# for alien_number in range(10):
#     new_alien = {'color': 'green', 'points': 5, 'speed': 'slow'}
#     aliens.append(new_alien) 
# #show the first 3 aliens
# for alien in aliens[:3]:
#     print(alien)
#     print("...")
# #show how many aliens have been created
# print("Total number of aliens:", len(aliens))


# user = {
#     'username': 'buttery', #here username is key and buttery is value. key is used to access the value.
#     'first_name': 'Butters',
#     'last_name': 'McButter'
# }
# for key, value in user.items():
#     print(f"Key: {key}, Value: {value}")


# alien = {} #empty dictionary
# alien['color'] = 'green' #adding stuff to dictionary
# alien['points'] = 5
# print(alien)
# del alien['points'] #deleting stuff from dictionary
# print(alien)



# A list stores multiple values in order and can be changed later.
# available_toppings = ['mushrooms', 'olives', 'green peppers', 'pepperoni', 'pineapple', 'extra cheese']
# # This is another list containing the toppings the customer requested.
# requested_toppings = ['mushrooms', 'french fries', 'extra cheese']

# # A for loop checks each item in the requested_toppings list one at a time.
# for requested_topping in requested_toppings:
#     # "in" checks whether an item exists inside a list.
#     if requested_topping in available_toppings:
#         print(f"Adding {requested_topping}.")
#     else:
#         print(f"Sorry we dont have {requested_topping}.")
# print("\nFinished Making your Pizza!")

# A list can be indexed (counted) from 0, and a slice gets part of the list.
# players = ["Alice", "Bob", "Charlie", "Diana", "Eve"]
# players[-2:] means "start at the second-to-last item and go to the end".
# print (players[-2:])
# for player in players[-2:]:
#     print(player.title())

# This creates a new list containing items from index 2 to the end.
# team = players[2:]
# print (team)
# A tuple is an ordered collection that cannot be changed after creation.
# size = (5,10)
# Index 0 gets the first value in the tuple.
# print (size[0])

# These are integer variables used in a comparison.
# a=10
# b=20
# "and" requires both comparisons to be True.
# if a < b and b > 15:
#     print("a is less than b and b is greater than 15")

# This checks whether the string "Alice" is inside the players list.
# if 'Alice' in players:
#     print("Alice is in the list of players.")

# An if/elif/else chain chooses one result based on a condition.
# age = 0
# if a < 4:
#     price = 0
# elif age < 18:
#     price = 5
# elif age < 65 :
#     price = 40
# else:
#     price = 20
# print(f" Your admission cost is ${price}.")