# -*- coding: utf-8 -*-

"""
Cvičení 7. - práce s daty

Vaším dnešním úkolem je spojit dohromady data, uložená ve dvou různých
souborech. První soubor obsahuje výsledky závodu - jména a časy závodníků. Druhý
pak obsahuje databázi závodníků uloženou jako JSON - mimo jiné jejich id. Cílem
je vytvořit  program, který tyto data propojí, tedy ke každému závodníkovi ve
štafetě najde jeho id. Případně také nenajde, data nejsou ideální. I tuto
situaci ale musí program korektně ošetřit.  Výsledky programu bude potřeba
zapsat do dvou souborů.

Kompletní zadání je jako vždy na https://elearning.tul.cz/

"""
import re
import json
from bs4 import BeautifulSoup

def get_data_from_text(text):
    """
    finds important parts from html text
    """
    found_patterns=re.findall(r"(\d{1,}\))(.*?)([\d)])[,.]",text)
    finished_runners=[]
    for match in found_patterns:
        finished_runners.append(match[0]+match[1]+match[2])
    return finished_runners

def partition_runners(runner_list):
    """
    splits important parts from html text
    """
    results = []
    times = []
    contestants = []
    for runner in runner_list:
        if len(re.findall(r"\(.*\)",runner))>0:
            results.extend(re.findall(r"(\d{1,})\)",runner)*3)
            times.extend(re.findall(r"\).*?(\d.*:.*\d)",runner)*3)
            tmp = re.findall(r"\((.*)\)",runner).pop()
            cont=list(re.findall(r"(.*), (.*), (.*)", tmp).pop())
            contestants.extend(cont)
        #else:
            #contestants.append(re.findall(r" (.*) .* ",runner))
    contestants = [s + " " for s in contestants]
    return results,times,contestants

def find_runners(contestants,json_file_name):
    """
    finds ids for runners
    """
    everyone = json_to_important(json_file_name)
    ids=[]
    for contestant in contestants:
        current_id = False
        for j in everyone:
            if re.search(contestant,j) is not None:
                # [a-zA-z ]*,
                current_id = re.findall(r"(.*?),",j).pop()
                break
        ids.append(current_id)
    return ids


def json_to_important(json_file):
    """
    take important parts from json_file
    """
    with open(json_file,encoding="UTF-8") as json_handle:
        lines = json_handle.readlines()
        json_singleline = ' '.join([line.strip() for line in lines])
        json_runner = re.findall(r"\{(.*?)\}",json_singleline)
        everyone = []
        for j in json_runner:
            runner_id = re.findall(r"\"id\": (.*?) ",j)
            name = re.findall(r"name\": \"(.*?)\"",j)
            j = runner_id.pop()+name[0]+" "+name[1]+" "+name[0]+" "
            everyone.append(j)
        return everyone

def create_list_dict(ids, results,times,contestants):
    """
    merges lists to dictionaries
    """
    outdict = []
    for index,item in enumerate(ids):
        tmp = {}
        tmp["id"] = item
        tmp["result"] = results[index]
        tmp["time"] = times[index]
        if not item:
            tmp["no_match"] = contestants[index]
        outdict.append(tmp.copy())
        tmp.clear()
    return outdict

def relay(html_file_name, json_file_name):
    """
    main method
    """
    with open(html_file_name,encoding="UTF-8") as html:
        beautiful_html = BeautifulSoup(html,"html.parser")
        data = beautiful_html.find_all('p')
        k="".join([line.get_text() for line in data])
        runners = get_data_from_text(k)
        results, times, contestants = partition_runners(runners)
        ids = find_runners(contestants, json_file_name)
        result_list = create_list_dict(ids,results,times,contestants)
        output_json(result_list)
        generate_compare_error_txt(result_list)

def generate_compare_error_txt(result_list):
    """
    generates txt output files
    """
    tmp = ""
    lis = []
    for result in result_list:
        if not result["id"]:
            tmp += result["no_match"] +"\n"
        if result["id"]:
            lis.append([int(result["id"]),int(result["result"])])
    with open('error.txt', 'w',encoding="UTF-8") as output:
        output.write(tmp)
    lis.sort()
    tmp=""
    for item in lis:
        tmp+=str(item[0])+" "+str(item[1]) + "\n"
    with open('compare.txt', 'w',encoding="UTF-8") as output:
        output.write(tmp)

def output_json(result_list):
    """
    Uloží list slovníků do souboru output.json tak jak je požadováno 
    v zadání.
    """
    with open('output.json', 'w',encoding="UTF-8") as output:
        output.write(json.dumps(result_list, indent=4, sort_keys=True))

if __name__ == '__main__':
    relay("result.html","competitors.json")
