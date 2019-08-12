new=$(find -X ../src -name "P*.java")
echo $new | xargs -I{} cp {} ../Codeforces\ Solutions/
git add --all
msg=$(find -X ../src -name "P*.java" \
  | sed -nE "s/.*\/(.*)\.java/\1/ p" \
  | awk 'BEGIN{ORS=", "} {print $1}' \
  | sed -nE 's/(.*), $/Added \1/p')
echo $msg
git commit -m "$msg"
git push