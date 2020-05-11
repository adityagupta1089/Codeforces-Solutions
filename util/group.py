import os
import re
import requests
from bs4 import BeautifulSoup
from shutil import copyfile
from tqdm import tqdm

for file in tqdm(os.listdir("../Codeforces Solutions/")):
    if re.match(r"P\d+[A-Z].\w+", file):
        prob, diff = re.findall(r"P(\d+)([A-Z]).\w+", file)[0]
        url = f"https://codeforces.com/problemset/problem/{prob}/{diff}"
        page = requests.get(url)
        soup = BeautifulSoup(page.text, features="html.parser")
        # table.rtable tbody tr th.left a
        contest_name = soup.find("table", class_="rtable").tbody.tr.th.a.text
        dir_name = f"../src/{contest_name}"
        if not os.path.exists(dir_name):
            os.mkdir(dir_name)
        copyfile("../Codeforces Solutions/" + file, dir_name + "/" + file)
