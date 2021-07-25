import           Control.Monad
import           Data.List
import           Data.Maybe
import           Data.Array

diff xs ys = sum $ zipWith (\x y -> if x /= y then 1 else 0) xs ys

main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t $ do
        n : m : _ <- map read . words <$> getLine
        as        <- replicateM n getLine
        putStrLn
            $ case
                  filter (\xs -> all (\ys -> diff xs ys <= 1) as)
                  . cands
                  . head
                  $ as
              of
                  [] -> "-1"
                  vs -> head vs

cands :: String -> [String]
cands []       = []
cands (x : xs) = [ y : xs | y <- ['a' .. 'z'] ] ++ [ x : y | y <- cands xs ]
