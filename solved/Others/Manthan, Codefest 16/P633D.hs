import           Control.Monad
import           Data.List
import           Control.Arrow
import           Data.Array
import qualified Data.Map.Strict               as Map
import           Data.Either
import           Data.Int
import           Data.Ord

($$) = flip ($)

readInts :: IO [Int]
readInts = map read . words <$> getLine

readInt :: IO Int
readInt = read <$> getLine

main :: IO ()
main = do
    _  <- readInt
    as <- readInts
    let cnts = sort as $$ group $$ map (head &&& length) $$ Map.fromList
    -- print cnts
    print $ maxFib cnts

-- maxFib :: Map.Map Int Int -> (Int, Int, Int, [Int])
maxFib cnts =
    (\xs -> if null xs then 1 else maximum xs)
        $ lefts
        $ [ foldM
                (\(mp, l) v ->
                    if Map.member v cnts && Map.findWithDefault 0 v mp < cnts Map.! v
                        then Right (Map.insertWith (+) v 1 mp, l + 1)
                        else Left l
                )
                (Map.empty, 0)
            $ map fst
            $ iterate (\(x, y) -> (y, x + y)) (x, y)
          | x <- Map.keys cnts
          , y <- Map.keys cnts
          ]

