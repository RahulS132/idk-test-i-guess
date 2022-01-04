print('Welcome to Encrypt/Decrypt Program')
print('Do You Want to Encrypt or Decrypt?')
while True:
    print("1. Encrypt \n2. Decrypt")
    choice = int(input('Enter Choice:'))
    while choice > 2 or choice < 1:
        choice = int(input("enter valid input: "))

    if choice == 1:
        byte_array = input('What do you want to encrypt?:').encode()
        binary_int = int.from_bytes(byte_array, "big")
        binary_string = bin(binary_int)
        print(binary_string)

    else:
        binary_int = int(input('Decipher:'), 2)
        byte_number = binary_int.bit_length()
        binary_array = binary_int.to_bytes(byte_number, "big")
        ascii_text = binary_array.decode()
        print(ascii_text)

    print("Do you want to Try again? (Y/N)")
    ans = input()

    if ans == 'n' or ans == 'N':
        break

