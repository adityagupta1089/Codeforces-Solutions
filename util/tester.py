import json
import os
import re
import subprocess


def prRed(skk):
    print("\033[91m{}\033[00m".format(skk))


def prGreen(skk):
    print("\033[92m{}\033[00m".format(skk))


def prPurple(skk):
    print("\033[94m{}\033[00m".format(skk))


for file in os.listdir("../bin"):
    if re.match(r"P\d+\w\.class", file):
        problem = re.search(r"(\d+)(\w)", file)
        if problem:
            num, lev = problem.groups()
            with open("../test/P%s%s_testcase.json" % (num, lev), "r") as f:
                testcases = json.load(f)
            passed = 0
            failed = 0
            for testcase in testcases:
                name = file.split(".")[0]
                p = subprocess.run(("java -cp ../bin " + str(name)).split(), stdout=subprocess.PIPE, encoding="ascii",
                                   input=testcase["in"])
                res = p.stdout.strip("\r\n")
                if res != testcase["out"]:
                    prRed("Failed testcase")
                    prPurple("Input")
                    print(testcase["in"])
                    prPurple("Expected Output")
                    print(testcase["out"])
                    prPurple("Actual Output")
                    print(res)
                    failed += 1
                else:
                    prGreen("Passed testcase")
                    prPurple("Input")
                    print(testcase["in"])
                    prPurple("Output")
                    print(testcase["out"])
                    passed += 1
            if failed == 0:
                prGreen("All Passed")
            else:
                prRed("%s Passed. %s Failed" % (passed, failed))
