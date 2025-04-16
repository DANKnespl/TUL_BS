#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 

int main() {

    for (int j = 0; j < 3;j++) {

        char s[10];

        for (int i = 0; i < 10; i++) {

            s[i] = -52;

        }

        scanf("%s", &s);

        int t = 1;

        int k = 1;

        while (s[sizeof(s) - k] == -52) {

            k++;

        }

        for (int i = 0; i <= (sizeof(s) - k); i++) {

            if (s[i] > 64 && s[i] < 91) {

                s[i] = s[i] + 32;

            }

        }

        for (int i = 0; i < (sizeof(s) - k) / 2; i++) {

            if (s[i] == s[sizeof(s) - 1 - i - k]) {

            }

            else

            {

                t = 0;

                break;

            }

        }

        printf((t == 1) ? "ano\n" : "ne\n");

    }

    return 0;

}