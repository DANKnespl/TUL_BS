#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

#include <stdlib.h>

int numWhites(char *string, int length) {

	//get number of trailing white characters in array

	//printf("%d\n", length);

	int k = 0;

	while (string[length - k] <= 0) {

		k++;

	}

	return k;

}

void UpperCase(char *c,int length) {

	int tmp = 32;

	for (int i = 0; i < length; i++) {

		if (tmp == 32 && *(c + i) >= 97 && *(c + i) <= 122) {

			*(c + i) = (*(c + i) - 32);

		}

	tmp = *(c + i);

	}

	//printf("%d\n", length);

}

struct StackItem

{

	int length=300;

	char* string= (char*)malloc(sizeof(char) * length);

	struct StackItem* previousItem;

};

int StackPush(struct StackItem** zasobnik) {

	int i = 0;

	struct StackItem* p = (struct StackItem*)malloc(sizeof(struct StackItem));

	if (p == NULL) return 1;

	struct StackItem item;

	if (scanf("%[^\n]%*c", (item.string)) == EOF) i = 2;

	if (i == 0){

		p->length = item.length;

		p->string = item.string;

		p->previousItem = *zasobnik;

		*zasobnik = p;

	}

	else {

		free(item.string);

		free(p);

	}

	return i;

}

void StackPop(struct StackItem** zasobnik) {

	struct StackItem* tmp = *zasobnik;

	UpperCase((*zasobnik)->string, (*zasobnik)->length);

	printf("%s\n", (*zasobnik)->string);

	*zasobnik = tmp->previousItem;

	free(tmp->string);

	free(tmp);

}

struct Queue

{

	struct QueueItem* first=NULL;

	struct QueueItem* last=NULL;

};

struct QueueItem

{

	int length = 200;

	char* string = (char*)malloc(sizeof(char) * length);

	struct QueueItem* nextItem=NULL;

	struct QueueItem* previousItem=NULL;

};

int QueuePush(struct Queue** fronta) {

	int i = 0;

	struct QueueItem* p = (struct QueueItem*)malloc(sizeof(struct QueueItem));

	if (p == NULL) return 1;

	struct QueueItem item;

	if (scanf("%[^\n]%*c", (item.string)) == EOF) i = 2;

	if (i == 0) {

		p->length = item.length;

		p->string = item.string;

		p->previousItem = (*fronta)->last;

		if ((*fronta)->last == NULL) {

			(*fronta)->first = p;

		}

		else {

			((*fronta)->last)->nextItem = p;

		}

		(*fronta)->last = p;

	}

	else {

		free(item.string);

		free(p);

	}

	return i;

}

void QueuePop(struct Queue** fronta) {

	struct QueueItem* tmp = (*fronta)->first;

	UpperCase(tmp->string, tmp->length);

	printf("%s\n", (tmp)->string);

	if (tmp->nextItem != NULL){

		(tmp->nextItem)->previousItem = tmp->previousItem;

	}	

	(*fronta)->first = tmp->nextItem;

	free(tmp->string);

	free(tmp);

}

int main() {

	//struct StackItem* zasobnik = NULL;

	struct Queue fronta;

	struct Queue* p_fronta=&fronta;

	int i = 0;

	int tmp;

  	//for (int z=0;z<3;z++){

	while (1) {

		//tmp = StackPush(&zasobnik);

		tmp = QueuePush(&p_fronta);

		i++;

		if (tmp == 1) {

			return 1;

		}

		else if (tmp == 2){

			break;

		}

	}

	for (int k = 0; k < i-1; k++) {

		//StackPop(&zasobnik);

		QueuePop(&p_fronta);

	}

	return 0;

}