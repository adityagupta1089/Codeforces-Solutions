import           Control.Monad
import           Data.List
import           Data.Int

main :: IO ()
main = do
    [n, px, py] <- map read . words <$> getLine :: IO [Int64]
    ps          <- map (\[x, y] -> (x - fromIntegral px, y - fromIntegral py))
        <$> replicateM (fromIntegral n) (map (fromIntegral . read) . words <$> getLine)
    let maxDis = maximum $ map (uncurry dis) ps
        minDis = minimum $ zipWith (curry getMinDis) ps (tail $ cycle ps)
    print $ pi * (maxDis - minDis)

dis :: Double -> Double -> Double
dis x y = x ^ 2 + y ^ 2

getMinDis ((x, y), (x', y'))
    | lambda <= 0 = dis x y
    | lambda >= 1 = dis x' y'
    | otherwise   = dis (x + lambda * (x' - x)) (y + lambda * (y' - y))
    where lambda = ((x - x') * x + (y - y') * y) / dis (x' - x) (y' - y)
