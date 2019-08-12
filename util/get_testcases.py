import json
import os
import re
import requests
from bs4 import BeautifulSoup

for file in os.listdir('../src'):
    if ".java" in file:
        problem = re.search(r"(\d+)(\w)", file)
        if problem:
            num, lev = problem.groups()
            url = "https://codeforces.com/problemset/problem/%s/%s" % (num, lev)
            page = requests.get(url)
            soup = BeautifulSoup(page.text, 'html.parser')
            xs = []
            ys = []
            for test in soup.find("div", class_="sample-test").contents:
                value = "\n".join(test.pre.find_all(text=True))
                if test.div.string == "Input":
                    xs.append(value)
                elif test.div.string == "Output":
                    ys.append(value)

            testcases = []
            for x, y in zip(xs, ys):
                testcases.append({"in": x, "out": y})

            with open("../test/P" + num + lev + "_testcase.json", "w") as f:
                json.dump(testcases, fp=f, indent=4)
