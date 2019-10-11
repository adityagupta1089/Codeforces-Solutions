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