""" 
    Úkol 5. 
    Napište program, který načte soubor large.txt a pro každé dveře vyhodnotí,
    zda je možné je otevřít nebo ne. Tedy vyhodnotí, zda lze danou množinu uspořádat
    požadovaným způsobem. Výstup z programu uložte do souboru vysledky.txt ve
    formátu 1 výsledek =  1 řádek. Na řádek napište vždy počet slov v množině a True
    nebo False, podle toho, zda řešení existuje nebo neexistuje. 

    Podrobnější zadání včetně příkladu je jako obvykle na elearning.tul.cz
"""

def compare_dicts(dict1,dict2):
    """
    compare content of two dictionaries
    """
    znaky=set({})
    dict1=dict(dict1)
    dict2=dict(dict2)
    delta=[]
    d1d=0
    d2d=0
    for key in dict1.keys():
        znaky.add(key)
    for key in dict2.keys():
        znaky.add(key)
    for letter in znaky:
        tmp1=dict1.get(letter)
        tmp2=dict2.get(letter)
        if tmp1 is None:
            tmp1=0
        if tmp2 is None:
            tmp2=0
        delta.append(tmp1-tmp2)
    for vec in delta:
        if vec>0:
            d1d+=vec
        else:
            d2d-=vec
    if (d1d>1 or d2d>1):
        return False
    return True

def create_structures(znaky,id_znaky):
    """
    generates dictionary
    """
    pismena=[]
    for slovo in znaky:
        pismena.append(slovo[id_znaky])
    set_pismena=set(pismena)
    dict_pismena={}
    for i in set_pismena:
        dict_pismena[i]=0
    for i in pismena:
        dict_pismena[i]+=1
    return dict_pismena


def check_validity(znaky):
    """
    validity checker
    """
    if len(znaky)==1:
        return True
    dict_zacatky=create_structures(znaky,0)
    dict_konce=create_structures(znaky,1)
    return compare_dicts(dict_zacatky,dict_konce)

def doors_main(data_source,data_dest):
    """
    main function
    """
    with open(data_source,"r",encoding="utf-8") as file:
        with open(data_dest,"w",encoding="utf-8") as output:
            for _ in range(int(file.readline())):
                znaky=[]
                pocet_desek=int(file.readline())
                for _ in range(pocet_desek):
                    tmp=file.readline()
                    if not(tmp[0] == tmp[len(tmp)-2] and ([tmp[0],tmp[len(tmp)-2]])in znaky):
                        znaky.append([tmp[0],tmp[len(tmp)-2]])
                output.writelines(f"{pocet_desek} {check_validity(znaky)}\n")
    return 0

def funkce_na_zadani():
    """
    Funkce požadována zadáním
    """
    doors_main("./large.txt","./vysledky.txt")


if __name__ == '__main__':
    doors_main("./small.txt","./vysledky/vysledkySmall.txt")
    doors_main("./large.txt","./vysledky/vysledkyLarge.txt")
    funkce_na_zadani()
