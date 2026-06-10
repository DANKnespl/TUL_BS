#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

#include <stdlib.h>

#include <string.h>

#define STRINGLNG 30

#define POCVYPIS 15

struct DicItem {

	char* string = (char*)malloc(STRINGLNG * sizeof(char));;

	int occurances = 1;

	struct DicItem* prev = NULL;

};

void LowerCase(char* c, int length) {

	for (int i = 0; i < length; i++) {

		if (*(c + i) == '\0') break;

		if (*(c + i) >= 'A' && *(c + i) <= 'Z') {

			*(c + i) = (*(c + i) + 32);

		}

	}

}

int find(struct DicItem* Dic, char* string) {

	while (Dic != NULL) {

		if (strcmp(Dic->string, string) == 0) {

			Dic->occurances++;

			return 1;

		}

		else { Dic = Dic->prev; }

	}

	return 0;

}

int Read(struct DicItem** a, struct DicItem** a2) {

	struct DicItem* p = (DicItem*)malloc(sizeof(DicItem));

	if (p == NULL) return 3;

	struct DicItem* p2 = (DicItem*)malloc(sizeof(DicItem));

	if (p2 == NULL) return 3;

	char* string = (char*)malloc(STRINGLNG * sizeof(char));

	if (string == NULL) return 3;

	//int tmp = 0;

	int tmp2;

	if (tmp2 = scanf("%s", string) == EOF) {

		free(p);

		free(p2);

		struct DicItem* tmp = *a2;

		*a2 = (*a2)->prev;

		free(tmp);

		return 1;

	}

	LowerCase(string, STRINGLNG);

	if (find(*a, string) == 0) {

		p->string = (char*)malloc(STRINGLNG * sizeof(char));

		if (p->string == NULL) return 3;

		strcpy(p->string, string);

		p->prev = *a;

		p->occurances = 1;

		*a = p;

	}

	else {

		free(p);

	}

	p2->string = (char*)malloc(STRINGLNG * sizeof(char));

	if (p2->string == NULL) return 3;

	p2->occurances = 1;

	strcpy(p2->string, string);

	strcat((*a2)->string, " ");

	strcat((*a2)->string, string);

	if (find((*a2)->prev, (*a2)->string) == 0) {

		p2->prev = *a2;

		*a2 = p2;

	}

	else {

		p2->prev = (*a2)->prev;

		free((*a2)->string);

		free(*a2);

		*a2 = p2;

	}

	free(string);

	return 0;

}

void sort(struct DicItem* DI, struct DicItem** DIA) {

	int l = 0;

	while (DI != NULL && l < POCVYPIS) {

		for (int j = 0; j <= POCVYPIS; j++) {

			if ((DIA[j] == NULL) || (DI->occurances >= (DIA[j])->occurances)) {

				if (DIA[POCVYPIS - 1] != NULL) {

					free(DIA[POCVYPIS - 1]->string);

					free(DIA[POCVYPIS - 1]);

				}

				for (int k = 1; k < POCVYPIS - j; k++) {

					DIA[POCVYPIS - k] = DIA[POCVYPIS - k - 1];

				}

				DIA[j] = DI;

				break;

			}

		}

		DI = DI->prev;

		l++;

	}

	while (DI != NULL) {

		for (int j = POCVYPIS - 1; j >= 0; j--) {

			if ((DI->occurances < (DIA[j])->occurances)) {

				if (j != POCVYPIS - 1) {

					free(DIA[POCVYPIS - 1]->string);

					free(DIA[POCVYPIS - 1]);

					for (int k = 1; k < POCVYPIS - j; k++) {

						DIA[POCVYPIS - k] = DIA[POCVYPIS - k - 1];

					}

					DIA[j + 1] = DI;

				}

				break;

			}

			if (j == 0) {

				free(DIA[POCVYPIS - 1]->string);

				free(DIA[POCVYPIS - 1]);

				for (int k = 1; k < POCVYPIS - j; k++) {

					DIA[POCVYPIS - k] = DIA[POCVYPIS - k - 1];

				}

				DIA[j] = DI;

			}

		}

		DI = DI->prev;

	}

}

void draw(struct DicItem** DIA, int pocet, int status) {

	for (int j = 0; j < POCVYPIS; j++) {

		if (DIA[j] != NULL) {

			if (status == 0) {

				printf(" - %-12s %.2f%% (%d)\n", DIA[j]->string, (float)DIA[j]->occurances / (pocet) * 100, DIA[j]->occurances);

			}

			else {

				printf(" - %-20s %.2f%% (%d)\n", DIA[j]->string, (float)DIA[j]->occurances / (pocet) * 100, DIA[j]->occurances);

			}

		}

	}

}

int main() {

	struct DicItem a;

	struct DicItem b;

	char* tmp = (char*)malloc(STRINGLNG * sizeof(char));

	if (tmp == NULL) return 1;

	if (scanf("%s", tmp) == EOF) {

		free(tmp);

		return 1;

	}

	LowerCase(tmp, STRINGLNG);;

	strcpy(a.string, tmp);

	strcpy(b.string, tmp);

	free(tmp);

	struct DicItem* p = &a;

	struct DicItem* p2 = &b;

	int i = 1;

	while (Read(&p, &p2) == 0) {

		i++;

	}

	struct DicItem** tmp2 = (struct DicItem**)malloc(POCVYPIS * sizeof(DicItem*));

	if (tmp2 == NULL) return 1;

	struct DicItem** tmp3 = (struct DicItem**)malloc(POCVYPIS * sizeof(DicItem*));

	if (tmp3 == NULL) return 1;

	for (int j = 0; j < POCVYPIS; j++) {

		tmp2[j] = NULL;

		tmp3[j] = NULL;

	}

	sort(p, tmp2);

	sort(p2, tmp3);

	printf("Word Frequency:\n");

	draw(tmp2, i, 0);

	printf("Phrase Frequency:\n");

	draw(tmp3, i, 1);

	free(tmp2);

	free(tmp3);

	return 0;

}

//why are we still here 20k slov... pain