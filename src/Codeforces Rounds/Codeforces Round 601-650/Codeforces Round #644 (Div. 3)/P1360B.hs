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
    let as' = sort as
    print . minimum $ zipWith (-) (tail as') as'
