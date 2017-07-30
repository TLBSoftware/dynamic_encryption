package com.taylor.notetaker;

import java.util.ArrayList;


public class Encryptor {

    private String mMessage;
    private String mKey;

    private Object[] asciiTable;

    public Encryptor(String message, String key){
        mMessage = message;
        mKey = key;
        CreateTable();
    }


    //region Get-Set Methods
    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }
    //endregion


    //region Encryption Algorithms
    public String EncryptMessageWithKey(){
        //Create StringBuilder to allow creation of crypto text easily within a loop
        StringBuilder returnString = new StringBuilder();

        /*
        Loop over the length of the message
        if key.length < message.length
            message[n] is transposed with key[n % keys length]
        else
            message[n] is transposed with key[n]
         */
        for(int temporaryInt = 0; temporaryInt < mMessage.length(); temporaryInt++){

            returnString.append(
                    //append what returns from the transposition of the 2 characters
                    SingleEncrypt(mMessage.charAt(temporaryInt), mKey.charAt(temporaryInt % mKey.length()))
            );
        }
        //return the string representation of the StringBuilder
        return returnString.toString();
    }

    public String DecryptMessageWithKey(){

        StringBuilder returnString = new StringBuilder();

        for(int temporaryInt = 0; temporaryInt < mMessage.length(); temporaryInt++)
        {
            //Decrypt each character with the reverse of the transposition
            char newChar = SingleDecrypt(mMessage.charAt(temporaryInt), mKey.charAt(temporaryInt % mKey.length()));
            returnString.append(newChar);
        }

        return returnString.toString();
    }

    public char SingleEncrypt(char m, char k){

        /*
        Bulk of the encryption,
        The char is casted to an int as java supports the ascii representation
        This int is used to retrieve the row and the column of the new letter
        Since the table has no zeros, the int is reduced by one to avoid out of array exceptions
        as well as allowing an ascii of 1 and 1 to return 1 instead of 2

         */
        int[] array = (int[]) asciiTable[(int) m - 1];
        return (char) array[(int) k - 1];
    }

    public char SingleDecrypt(char encryptedMessage, char key){

        /*
        Decryption of the message,
         first you use the key to retrieve the array we will work with

        key is reduced by 1 since 0 in ascii representation represents null and the ascii table
        that was made contains 1-127 with n-1 being the index of each number
         */
        int[] array = (int[]) asciiTable[(int) key - 1];
        //find the index from the array so you can use it to reverse the transposition
        for (int i = 0; i < array.length; i++){
            if(array[i] == (int) encryptedMessage) {
                i += 1;
                return (char) i;
            }
        }
        //int index = Arrays.asList(array).indexOf(intMessage);
        //if character was not found then return null
        return (char) 0;

    }


    //Description:
    //  Creation of the ASCII (a protocol for how characters are represented) 2 dimensional table
    //  which allows the 2 values to be transposed through the SingleEncrypt/Decrypt methods,
    //  similar to a multiplication table
    //
    //TL;DR:
    //  CreateTable for SingleEncrypt/Decrypt transposition
    public void CreateTable(){
        // ArrayList object created to allow dynamic building of an array
        ArrayList table = new ArrayList();
        // int array made outside of loop to allow memory of the last array to be manipulated
        int[] previousRow = null;

        // Table creation loop
        // Run for length of 1 - 127
        for(int x = 1; x < 128; x++){
            int[] newRow = new int[127];
            // **if this is the first row**
            if( previousRow == null){
                for(int y = 0; y < 127; y++){
                    // Creation of the very first row in the table
                    // would look like [1, 2, 3, .. 127]
                    newRow[y] = y + 1;
                }
            }else{
                //use a loop to shift array to the left and then placing is first index to last index
                //this is done using the previous rows value
                for (int z = 0; z < 127; z++){
                    /*
                    * Appending the first number in the previous array to the end of the new array
                    *
                    * ie.
                    * previousRow:
                    * [1, 2, 3, 4, ... 127, 128]
                    * to
                    * newRow:
                    * [2, 3, 4, 5, ... 128, 1]*/

                    //if we are at the last row then we
                    if (z != 126){
                        newRow[z] = previousRow[z+1];
                    }else{
                        newRow[z] = previousRow[0];
                    }
                }
            }
            // add the new array to the ArrayList object
            table.add(newRow);
            // set the previousRow for the next iteration.
            previousRow = newRow;
        }

        asciiTable = table.toArray();
    }
    //endregion

}
