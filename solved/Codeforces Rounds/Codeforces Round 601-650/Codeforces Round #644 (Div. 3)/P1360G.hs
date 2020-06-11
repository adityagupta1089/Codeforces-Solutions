import           Data.List
import           Data.Array
import           Control.Monad
-- import           Debug.Trace

-- debug = flip trace


main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t $ do
        n : m : a : b : _ <- (map read . words <$> getLine) :: IO [Int]
        mapM putStrLn $ case solve n m a b of
            Just mat ->
                "YES"
                    : [ concatMap show [ mat ! (i, j) | j <- [1 .. m] ]
                      | i <- [1 .. n]
                      ]
            Nothing -> ["NO"]


-- solve :: Int -> Int -> Int -> Int -> Maybe (Array (Int, Int) Int)
solve n m a b = go
    (array (1, n) . zip [1 .. n] $ repeat 0)
    (array ((1, 1), (n, m)) [ ((i, j), 0) | i <- [1 .. n], j <- [1 .. m] ])
    1
  where
    go rowcnts mat c
        | length idxs /= b = Nothing
        | c == m = if all (== a) (elems rowcnts') then Just mat' else Nothing
        | otherwise = go rowcnts' mat' (c + 1)
      where
        idxs = take b . filter (\i -> (rowcnts ! i) < a) $ sortOn
            (rowcnts !)
            [1 .. n]
        rowcnts' = accum (+) rowcnts . zip idxs $ repeat 1 --`debug` show (elems rowcnts)
        mat'     = mat // [ ((idx, c), 1) | idx <- idxs ]
