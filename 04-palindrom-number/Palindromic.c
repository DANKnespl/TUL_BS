void clearString(char string[], int pocet) {

    //fill Array of chars with blank chars

    for (int i = 0; i < pocet; i++) {

        string[i] = -52;

    }

}

int numWhites(char string[], int pocet) {

    //get number of trailing white characters in array

    int k = 0;

    while (string[pocet - k] < 0) {

        k++;

    }

    return k;

}

int checkPal(char string[], int pocet) {

    //check if sequence in array is palindromic, trailing white spaces are not counted

    int k = numWhites(string, pocet);

    for (int i = 0; i < (pocet - k) / 2; i++) {

        if (string[i] == string[pocet - 1 - i - k]) {

        }

        else

        {

            return 0;

            break;

        }

    }

    return 1;

}

void increaseLeft(char string[], int pocet) {

    //increment left side of a number;

    int tmp = 0;

    int k = numWhites(string, pocet);

    int l = (k % 2 == 0) ? 1 : 0;

    for (int i = ((pocet - k) / 2) - l; i >= 0; i--) {

        tmp = 0;

        if (string[i] == '9') {

            string[i] = '0';

            tmp = 1;

        }

        else {

            string[i]++;

            break;

        }

    }

    if (tmp == 1) {

        moveInArray(string, pocet);

    }

}

void increaseRight(char string[], int pocet) {

    //set right side of a number to be the same as left

    int k = numWhites(string, pocet);

    for (int i = 0; i < (pocet - k) / 2; i++) {

        //if (string[i] != string[pocet - k - i - 1]) {

            string[pocet - k - i - 1] = string[i];

        // }

    }

}

void caseNonSensitive(char string[], int pocet) {

    //change array to have only small characters

    int k = numWhites(string, pocet);

    for (int i = 0; i <= (pocet - k); i++) {

        if (string[i] >= 'A' && string[i] <= 'Z') {

            string[i] = string[i] + 32;

        }

    }

}

void moveInArray(char string[], int pocet) {

    //move values in array by one index up and add 1 to the index 0

    for (int i = 1; i < pocet; i++) {

        string[pocet - i] = string[pocet - i - 1];

    }

    string[0] = '1';

}

void createPal(char string[], int pocet) {

    //find the first bigger palindrome - ints only

    int k = numWhites(string, pocet);

    if (checkPal(string, pocet) == 1) {

        increaseLeft(string, pocet);

        increaseRight(string, pocet);

    }

    else {

        for (int i = ((pocet - k) / 2) - 1; i >= 0; i--) {

            if (string[i] < string[pocet - k - i - 1]) {

                increaseLeft(string, pocet);

                break;

            }

            if (string[i] > string[pocet - k - i -1]) {

                break;

            }

        }

        increaseRight(string, pocet);

    }

}

