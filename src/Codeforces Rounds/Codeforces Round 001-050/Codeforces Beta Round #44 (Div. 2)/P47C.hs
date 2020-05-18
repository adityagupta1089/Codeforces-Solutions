import Control.Monad
import Data.List
import Control.Arrow
import Data.Array

main :: IO ()
main = do
    xs <- replicateM 6 getLine
    --mapM_ print . filter valid . perms $ xs
    let sols = sortOn snd . filter (valid . fst) . map (id &&& crossword) . perms $ xs
    putStrLn $ if null sols then "Impossible" else snd . head $ sols

perms :: Eq a => [a] -> [[a]]
perms [] = [[]]
perms xs = [x:y | x <- xs, y<- perms (delete x xs)]

crossword :: [String] -> String
crossword [a,b,c,d,e,f] =
    unlines [[as!(i, j)|i<-[1..length e]]| j<-[1..length b]]
    where
        as :: Array (Int, Int) Char -- (x, y)
        as = accumArray (const id) '.' ((1,1), (length e, length b))
            $  zip [(i,1)|i<-[1..]] a
            ++ zip [(length a, i)|i<-[1..]] b
            ++ zip [(i,length b)|i<-[length a..]] c
            ++ zip [(length e,i)|i<-[length f..]] d
            ++ zip [(i,length f)|i<-[1..]] e
            ++ zip [(1,i)|i<-[1..]] f
crossword _ = ""

valid :: [String] -> Bool
valid [a, b, c, d, e, f] =
    last a == head b
    && last b == head c
    && last c == last d
    && last e == head d
    && last f == head e
    && head a == head f
    && length e == length a + length c - 1
    && length b == length d + length f - 1
    && b !! (length f - 1) == e !! (length a - 1)
valid _ = False
