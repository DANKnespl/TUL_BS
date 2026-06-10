#define _CRT_SECURE_NO_WARNINGS

#define DSARR 100

#include <stdio.h>

#include <stdlib.h>

int checkArr(int* arr, int length, int num) {

	for (int i = 0; i < length; i++) {

		if (arr[i] == num) {

			return i;

		}

	}

	return -1;

}

void draw(int volba, int* arr, int* arrnum, int sarr) {

	int tmp = 0;

	switch (volba) {

	case 1:

		printf("all: ");

		for (int i = 0; i < sarr; i++) {

			//if (arrnum[i] != 0) {

				printf((tmp == 0) ? "%d" : ",%d", arr[i]);

				tmp = 1;

			//}

		}

		break;

	case 2:

		printf("\n>1x: ");

		for (int i = 0; i < sarr; i++) {

			if (arrnum[i] > 1) {

				printf((tmp == 0) ? "%d" : ",%d", arr[i]);

				tmp = 1;

			}

		}

		break;

	case 3:

		printf("\n=1x: ");

		for (int i = 0; i < sarr; i++) {

			if (arrnum[i] == 1) {

				printf((tmp == 0) ? "%d" : ",%d", arr[i]);

				tmp = 1;

			}

		}

		break;

	}

}

void fillArrs(int* arr, int* arrnum, int sarr) {

	for (int i = 0; i < sarr; i++) {

		arr[i] = -1;

		arrnum[i] = 0;

	}

}

void getFilled(int* arrnum, int* sarr) {

	int tmp = 0;

	for (int i = 0; i < *sarr; i++) {

		if (arrnum[i] == 0) {

			break;

		}

		tmp++;

	}

	*sarr = tmp;

}

int ArrBloat(int** arr, int** arrnum, int* sarr) {

	int ogsarr = *sarr;

	int* tmp1=*arr;

	int* tmp2=*arrnum;

	*sarr = (*sarr + DSARR);

	*arr = (int*)malloc(sizeof(int) * (*sarr));

	if (*arr == NULL) return 1;

	*arrnum = (int*)malloc(sizeof(int) * (*sarr));

	if (*arrnum == NULL) return 2;

	for (int i = 0; i < ogsarr; i++) {

		*arr[i] = tmp1[i];

		*arrnum[i] = tmp2[i];

	}

	free(tmp1);

	free(tmp2);

	return 0;

}

int main() {

	int sarr = 100;

	int dsarr = 100;

	int* arr = (int*)malloc(sizeof(int) * sarr);

	if (arr == NULL) return 1;

	int* arrnum = (int*)malloc(sizeof(int) * sarr);

	if (arrnum == NULL) return 2;

	fillArrs(arr, arrnum, sarr);

	

	int tmp;

	char temp;

	int tmp3 = 0;

	int a;

	int i = 0;

	while (tmp3 != EOF) {

		while ((tmp3 = scanf("%d%c", &tmp, &temp)) != EOF) {

			if ((a = checkArr(arr, sarr, tmp)) == -1) {

				arr[i] = tmp;

				arrnum[i] = 1;

				i++;

			}

			else {

				arrnum[a]++;

			}

			if (temp == '\n') {

				break;

			}

			if (i == sarr) {

				ArrBloat(&arr, &arrnum, &sarr);

			}

		}

	}

	getFilled(arrnum,&sarr);

	draw(1, arr, arrnum, sarr);

	draw(2, arr, arrnum, sarr);

	draw(3, arr, arrnum, sarr);

	free(arr);

	free(arrnum);

	return 0;

}

