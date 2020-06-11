import           Data.List
import           Control.Monad

main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t solve

solve :: IO ()
solve = do
    _  <- getLine
    as <- map read . words <$> getLine
    let (evens, odds) = partition even as
    putStrLn $ case mod (length evens) 2 of
        0 -> "YES"
        1 -> if or [ abs (x - y) == 1 | x <- evens, y <- odds ]
            then "YES"
            else "NO"
