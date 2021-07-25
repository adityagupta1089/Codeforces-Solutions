import           Control.Monad

main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t solve

solve :: IO ()
solve = do
    [n, k] <- map read . words <$> getLine
    print $ f n k

f :: Int -> Int -> Int
f n k =
    minimum
        . filter (\x -> div n x <= k)
        . concatMap (\x -> [x, div n x])
        . filter (\x -> mod n x == 0)
        $ takeWhile (\x -> x * x <= n) [1 ..]
