#include <iostream>

#include <iterator>

#include <string>

#include <regex>

#include <math.h>

using namespace std;

struct osoba {

    char* Jmeno;

    int JmenoLength;

    char* Prijmeni;

    int PrijmeniLength;

    char* Obor;

    int OCNumber;

    char OCLetter;

};

int partition(struct osoba** arr, int start, int end)

{

    int pivot = arr[start]->OCNumber;

    int count = 0;

    for (int i = start + 1; i <= end; i++) {

        if (arr[i]->OCNumber <= pivot)

            count++;

    }

    // Giving pivot element its correct position

    int pivotIndex = start + count;

    swap(arr[pivotIndex], arr[start]);

    // Sorting left and right parts of the pivot element

    int i = start, j = end;

    while (i < pivotIndex && j > pivotIndex) {

        while (arr[i]->OCNumber <= pivot) {

            i++;

        }

        while (arr[j]->OCNumber > pivot) {

            j--;

        }

        if (i < pivotIndex && j > pivotIndex) {

            swap(arr[i++], arr[j--]);

        }

    }

    return pivotIndex;

}

void quickSort(struct osoba** arr, int start, int end)

{

    if (start >= end)

        return;

    int p = partition(arr, start, end);

    quickSort(arr, start, p - 1);

    quickSort(arr, p + 1, end);

}

void vypis(struct osoba** OArr,struct osoba** EArr,int Odd,int Even,const char* str) {

    cout << str <<":" << endl;

    int k = 1;

    for (int i = 0; i < Odd; i++) {

        if (!strcmp(OArr[i]->Obor, str)) {

            cout << string((k < 10) ? 1 : 0, ' ') << k << ": " << OArr[i]->OCLetter << " " << OArr[i]->Prijmeni << " " << OArr[i]->Jmeno << string(18 - OArr[i]->PrijmeniLength - OArr[i]->JmenoLength, ' ') << OArr[i]->Obor << string((strcmp(OArr[i]->Obor,"AVI")?2:1), ' ') << OArr[i]->OCNumber<<endl;

            k++;

        }

    }

    for (int i = 0; i < Even; i++) {

        if (!strcmp(EArr[i]->Obor, str)) {

            cout << string((k < 10) ? 1 : 0, ' ') << k << ": " << EArr[i]->OCLetter << " " << EArr[i]->Prijmeni << " " << EArr[i]->Jmeno << string(18 - EArr[i]->PrijmeniLength - EArr[i]->JmenoLength, ' ') << EArr[i]->Obor << string((strcmp(EArr[i]->Obor, "AVI") ? 2 : 1), ' ') << EArr[i]->OCNumber<<endl;

            k++;

        }

    }

    cout << endl;

}

int main()

{

    std::regex table("<tbody>",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    std::regex Prijm1("Jmeno: \"(\s*)>",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    std::regex Prijm2("<span class=\"xg_hide\">(.*)</span>",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    std::regex Jmeno1("Tituly: \"(\s*)>",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    std::regex Jmeno2("(.*)",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    std::regex OC("(.*)&nbsp;<",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    std::regex OB("Stav: \"(\s*)>(.*)<",

        std::regex_constants::ECMAScript | std::regex_constants::icase);

    smatch P;

    struct osoba** osARO = new osoba * [60];

    struct osoba** osARE = new osoba * [60];

    int Odd = 0;

    int Even = 0;

    std::string s;

    struct osoba* os = new osoba;

    //if (!std::cin) break;

    getline(cin, s);

    while (!(std::regex_search(s, table))) {

        getline(cin, s);

    }

    while (1){

        struct osoba* os = new osoba;

        while (1) {

            getline(cin, s);

            if (!std::cin) break;

            if (std::regex_search(s, Prijm1)) {

                getline(cin, s);

                if (std::regex_search(s, P, Prijm2)) {

                    int i = 0;

                    os->Prijmeni = new char[20];

                    while (P.str(1)[P.str(1).find_first_not_of(' ', 0) + i] > 0) {

                        os->Prijmeni[i] = toupper(P.str(1)[P.str(1).find_first_not_of(' ', 0) + i]);

                        //cout << P.str(1)[P.str(1).find_first_not_of(' ', 0) + i];

                        i++;

                    }

                    os->PrijmeniLength = i;

                    os->Prijmeni[i] = '\0';

                }

            }

            if (std::regex_search(s, Jmeno1)) {

                getline(cin, s);

                if (std::regex_search(s, P, Jmeno2)) {

                    int i = 0;

                    os->Jmeno = new char[20];

                    while (P.str(0)[P.str(0).find_first_not_of(' ', 0) + i] > 0) {

                        os->Jmeno[i] = P.str(0)[P.str(0).find_first_not_of(' ', 0) + i];

                        //cout << P.str(0)[P.str(0).find_first_not_of(' ', 0) + i];

                        i++;

                    }

                    os->JmenoLength = i;

                    os->Jmeno[i] = '\0';

                }

            }

            if (std::regex_search(s, P, OC)) {

                int i = 0;

                char* tmp = new char[9];

                while (P.str(1)[P.str(1).find_first_not_of(' ', 0) + i] > 0) {

                    tmp[i] = P.str(1)[P.str(1).find_first_not_of(' ', 0) + i];

                    //cout << P.str(1)[P.str(1).find_first_not_of(' ', 0) + i];

                    i++;

                }

                os->OCLetter = tmp[0];

                os->OCNumber = 0;

                for (int i = 0; i < 8; i++) {

                    os->OCNumber = os->OCNumber + (tmp[8 - i] - 48) * pow(10, i);

                }

                if (os->OCNumber % 2 == 0) {

                    osARE[Even] = os; Even++;

                }

                else { osARO[Odd] = os; Odd++; }

            }

            if (std::regex_search(s, P, OB)) {

                int i = 0;

                os->Obor = new char[5];

                while (P.str(2)[P.str(2).find_first_not_of(' ', 0) + i] > 0) {

                    os->Obor[i] = P.str(2)[P.str(2).find_first_not_of(' ', 0) + i];

                    //cout << P.str(2)[P.str(2).find_first_not_of(' ', 0) + i];

                    i++;

                }

                os->Obor[i] = '\0';

                break;

            }

        }

        if (!std::cin) break;

    }

        quickSort(osARO, 0, Odd - 1);

        quickSort(osARE, 0, Even - 1);

        vypis(osARO, osARE, Odd, Even, "AI");

        vypis(osARO, osARE, Odd, Even, "AVI");

        vypis(osARO, osARE, Odd, Even, "IS");

        vypis(osARO, osARE, Odd, Even, "IT");

        //"AI" "AVI" "IS" "IT"

}

