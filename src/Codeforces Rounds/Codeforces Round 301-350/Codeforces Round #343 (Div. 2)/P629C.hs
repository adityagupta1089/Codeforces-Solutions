import           Data.Array
import           Data.Int
import           Data.List
import           Control.Monad

main :: IO ()
main = do
    [n', m] <- map read . words <$> getLine
    s       <- getLine
    print $ if mod n' 2 == 0 then solve n' s else 0

solve n' s =
    let
        n   = n' `div` 2
        l   = length $ filter (== '(') s
        r   = length s - l
        n'' = n - min l r
        mm  = 10 ^ 9 + 7 :: Int64
        arr = array ((0, 0), (n'', n''))
                    [ ((i, j), f i j) | i <- [0 .. n''], j <- [0 .. n''] ]
        f i j
            | j == 0
            = 1
            | j > i
            = 0
            | otherwise
            = let left = if i > 0 then arr ! (i - 1, j) else 0
                  down = if j > 0 then arr ! (i, j - 1) else 0
              in  (left + down) `mod` mm
        minVal = minimum $ scanl (\v c -> if c == '(' then v + 1 else v - 1) 0 s
    in
        (`mod` mm)
        . sum
        $ [ let leftWays  = arr ! (x, y)
                rightWays = arr ! (n - y - r, n - x - l)
            in  (leftWays * rightWays) `mod` mm
          | x <- [0 .. n - l]
          , y <- [0 .. x + l - r]
          , x + minVal >= y
          ]
