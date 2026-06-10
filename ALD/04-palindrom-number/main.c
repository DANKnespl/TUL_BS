#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 

#include "Palindromic.c" //"Palindromic.h" nefunguje :(

int main() {

    char s[100];

    while (1) {

        clearString(s, sizeof(s));

        scanf("%s", &s);

        if (s[0] == '-') {

            break;

        }

        createPal(s, sizeof(s));

        for (int i = 0; i < sizeof(s);i++) {

            if (s[i] >= '0' && s[i] <= '9') {

                printf("%c", s[i]);

            }

        }

        printf("\n");

    }

    return 0;

}