# dynamic_encryption
Android app with a custom encryption library written in java.

under app/src/main/java/com/taylor/notetaker you can locate the encryption class called Encryptor.java

Encryption algorithm requires 2 strings, the message to encrypt, and the private key to encrypt it with.

<h2>Example</h2>
//Encrypt message with key
Encryptor encryptionObj = new Encryptor([string] message, [string] key);
String cryptoText = encryptionObj.EncryptMessageWithKey();

or

String cryptoText = new Encryptor(message, key).EncryptMessageWithKey();

//Decrypt cryptoText with key

Encryptor encryptionObj = new Encryptor([string] cryptoText, [string] key);
String originalMessage = encryptionObj.DecryptMessageWithKey();

or

String originalMessage = new Encryptor(message, key).DecryptMessageWithKey();

<h2>Multiple uses</h2>
if you will be needing to use the encryption algorithm multiple times and need to save
resources from the creation of encryption objects then use the setMessage() and setKey() methods
to set the new messages and keys in the object and then you can use either the encrypt or decrypt methods.

However storing the encryption object in memory means that the original message/cryptotext and key
will be stored in memory as well. use the second options above to avoid this issue.

<h2>Future improvements</h2>

Will improve encryptor to be instantiated without arguments and the encryption/decryption to take arguments.
This would be a good use for those that need to use the class to encrypt several different messages as the
tables creation might impact performance if you are encrypting several messages.

Will also add a static way to encrypt message and keys together in order to avoid creation of an object for the
encryptor.

