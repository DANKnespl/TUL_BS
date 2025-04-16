#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

#include <stdlib.h>

int checkHour(int* Arr, int num, int hod, int min, int sec) {

	int tmp = 0;

	if (hod < 0) tmp=1;

	if (tmp==1||(hod % 3 == 0 && min % 15 == 0 && sec % 15 == 0)) {

		switch (num) {

		case 1:

			if (tmp == 1) return 1;

			if (hod % 12 == 9 || min % 60 == 45 || sec % 60 == 45) Arr[0] = 1;

			if (hod % 12 == 6 || min % 60 == 30 || sec % 60 == 30) Arr[1] = 1;

			break;

		case 2:

			if (tmp == 1) return 1;

			if (hod % 12 == 0 || min % 60 == 0 || sec % 60 == 0) Arr[2] = 1;

			if (hod % 12 == 9 || min % 60 == 45 || sec % 60 == 45) Arr[3] = 1;

			break;

		case 3:

			if (tmp == 1) break;

			if (hod % 12 == 6 || min % 60 == 30 || sec % 60 == 30) Arr[4] = 1;

			if (hod % 12 == 0 || min % 60 == 0 || sec % 60 == 0) Arr[5] = 1;

			if (hod % 12 == 3 || min % 60 == 15 || sec % 60 == 15) Arr[6] = 1;

			break;

		default:

			break;

		}

	}

	else { return 1; }

	return 0;

}

int getSum(int* Arr) {

	int tmp = 0;

	for (int i = 0; i < 7; i++) {

		tmp = tmp + Arr[i];

	}

	return tmp;

}

char getNum(int* Arr,int tmp) {

	if (tmp == 1) return 0;

	switch (getSum(Arr)) {

	case 2:

		if (Arr[1] == 1 && Arr[2] == 1) return '1';

		break;

	case 3:

		if (Arr[0] == 1 && Arr[1] == 1 && Arr[2]) return '7';

		break;

	case 4:

		if (Arr[0] == 0 && Arr[3] == 0 && Arr[4]==0) return '4';

		break;

	case 5:

		if (Arr[2] == 0 && Arr[5] == 0) return '2';

		if (Arr[4] == 0 && Arr[5] == 0) return '3';

		if (Arr[1] == 0 && Arr[4] == 0) return '5';

		break;

	case 6:

		if (Arr[6] == 0) return '0';

		if (Arr[1] == 0) return '6';

		if (Arr[4] == 0) return '9';

		break;

	case 7:

		return '8';

		break;

	}

	return 0;

}

void clearArr(int* Arr) {

	for (int i = 0; i < 7; i++) {

		Arr[i] = 0; 

	}

}

int main() {

	int num, hod, min, sec;

	int tmp;

	char* str = (char*)malloc(sizeof(char) * 8);

	int* Arr = (int*)malloc(sizeof(int) * 7);

	int rep = 0;

	while (true) {

		tmp = 0;

		clearArr(Arr);

		for (int i = 0; i < 3; i++) {

			scanf("clock-%d: %s\n", &num, str);

			if (str[0] != 'b') {

				hod = atoi(str);

				min = atoi(str + 3);

				sec = atoi(str + 6);

			}

			else {

				hod = -1;

				min = -1;

				sec = -1;

			}

			if (checkHour(Arr, num, hod, min, sec) == 1) { tmp = 1; }

		}

		

		if (scanf("%s\n", str) == EOF) break;

		printf("%c", getNum(Arr, tmp));

	}

	return 0;

}

