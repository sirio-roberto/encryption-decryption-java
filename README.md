# Encryptor/Decryptor

This is a simple Java application that allows you to encrypt and decrypt data using two different algorithms: Shift Cipher and Unicode Cipher.

## Features

- Encrypt data using the Shift Cipher algorithm.
- Encrypt data using the Unicode Cipher algorithm.
- Decrypt data using the Shift Cipher algorithm.
- Decrypt data using the Unicode Cipher algorithm.
- Support for specifying encryption/decryption key, input data, and algorithm via command-line arguments.
- Option to read input data from a file and save the output to a file.

## How to Use

The program is run from the command line. Here's the basic syntax:
```
java Main [options]
```


### Options

- `-mode`: Specifies the mode of operation. Use `enc` for encryption (default) or `dec` for decryption.
- `-key`: Specifies the encryption/decryption key as an integer.
- `-data`: Specifies the input data to be encrypted or decrypted.
- `-in`: Specifies the path to a file containing the input data.
- `-out`: Specifies the path to save the output to a file.
- `-alg`: Specifies the encryption/decryption algorithm. Use `shift` for the Shift Cipher (default) or `unicode` for the Unicode Cipher.

### Examples

1. Encrypt data using the Shift Cipher:
```
java Main -mode enc -key 5 -data "Hello World"
```
2. Decrypt data using the Unicode Cipher:
```
java Main -mode dec -key 10 -data "Ziibiv TXivj"
```
3. Encrypt data from a file and save the output to another file:
```
java Main -mode enc -key 8 -in input.txt -out output.txt
```

## Project Structure

The project contains two classes:

- `EncryptorUtil`: Contains methods for performing encryption and decryption using Shift and Unicode algorithms.
- `Main`: Handles user input, command-line arguments parsing, and file I/O.

## Dependencies

The project does not have any external dependencies and can be run using Java SE 8 or later.

## Note

This project is meant for educational purposes and may not provide strong encryption. It's recommended to use established encryption libraries for security-critical applications.

Feel free to modify the code, add more algorithms, or enhance the user interface as needed.

Enjoy encrypting and decrypting your data!