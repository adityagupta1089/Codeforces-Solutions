"""
#!/usr/bin/env bash
new=$(find -X ../src -name "P*.java")
echo $new | xargs -I{} mv {} ../Codeforces\ Solutions/
git add --all
msg=$(echo $new \
  | sed -nE "s/.*\/(.*)\.java/\1/ p" \
  | awk 'BEGIN{ORS=", "} {print $1}' \
  | sed -nE 's/(.*), $/Added \1/p')
echo $msg
git commit -m "$msg"
git push
"""
import os
import subprocess

new_files = []
for file in os.listdir("../src"):
    if ".java" in file:
        new_files.append(file.split(".")[0][1:])
        os.rename('../src/{}'.format(file), '../Codeforces Solutions/{}'.format(file))

print(subprocess.run(["git", "add", "--all"]))
print(subprocess.run(["git", "status"]))
print(subprocess.run(["git", "commit", "-m", "Added {}".format(", ".join(new_files))]))
print(subprocess.run(["git", "push"]))
