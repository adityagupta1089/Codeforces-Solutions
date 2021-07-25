import           Control.Monad

main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t solve

solve :: IO ()
solve = do
    [a, b] <- map read . words <$> getLine
    print $ min (area (2 * a) b) (area a (2 * b))
  where
    area :: Int -> Int -> Int
    area x y = max x y ^ 2
