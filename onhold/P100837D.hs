module P100837D where
    
import           Control.Monad
import           Control.Arrow
import           Data.List
import           System.IO
import           System.Random
import           Debug.Trace


debug = flip trace

type Point = (Double, Double)

main :: IO ()
main = do
    g <- getStdGen
    let (xs, ys)  = splitAt 3 $ take 6 $ randomRs (1, 10) g
        x : y : _ = take 2 $ randomRs (1, 5) g
        theta     = head $ randomRs (0, pi) g :: Double
        ps        = zip xs ys :: [(Double, Double)]
        ps'       = zipWith
            (\x y -> (x * cos theta - y * sin theta, x * sin theta + y * cos theta))
            (map (+ x) xs)
            (map (+ y) ys)
    print ps
    print ps'
    print theta
    print $ solve ps ps'

solve :: [Point] -> [Point] -> Double
solve ps ps' =
    let
        qs  = getDeltas ps
        qs' = getDeltas ps'
        rs  = getDeltas' qs
        rs' = getDeltas' qs'
        idx = getMatchingIndex rs rs'
        theta =
            head qs - (qs' !! idx) `debug` ("qs = " ++ show qs ++ ", qs' = " ++ show qs')
        delta = head rs - (rs' !! idx)
    in
        if theta < 0 then theta + 2 * pi else theta `debug` ("theta = " ++ show theta)
-- main = do
--     h         <- openFile "d.in" ReadMode
--     n         <- read <$> hGetLine h
--     (ps, ps') <- splitAt n
--         <$> replicateM (2 * n) ((\[a, b] -> (a, b)) . map read . words <$> hGetLine h)
--     let qs    = getDeltas ps
--         qs'   = getDeltas ps'
--         rs    = getDeltas' qs
--         rs'   = getDeltas' qs'
--         idx   = getMatchingIndex rs rs'
--         theta = head qs - (qs' !! idx)
--         delta = head rs - (rs' !! idx)
--     when (abs delta > 1e-5) $ error "No soution"
--     h' <- openFile "d.out" WriteMode
--     hPrint h' $ if theta < 0 then theta + 2 * pi else theta
--     hClose h'

getDeltas' :: [Double] -> [Double]
getDeltas' xs = map (\theta -> if theta < 0 then theta + 2 * pi else theta)
    $ zipWith (-) (tail $ cycle xs) xs

getAngle :: Point -> Point -> Double
getAngle (x, y) (x', y') =
    let theta = atan2 y' x' - atan2 y x -- [-pi, pi] - [-pi, pi] = [-2pi, 2pi]
    in  if theta < 0 then theta + 2 * pi else theta -- [0, 2pi]

getDeltas :: [Point] -> [Double] -- [0,pi]
getDeltas xs =
    zipWith (\(x, y) (x', y') -> getAngle (1, 0) (x' - x, y' - y)) xs (tail $ cycle xs)

getMatchingIndex :: [Double] -> [Double] -> Int
getMatchingIndex xs ys = go 0 xs (ys ++ tail ys)
  where
    go k xs ys = if and (zipWith (\a b -> abs a - abs b <= 1e-5) xs ys)
        then k
        else go (k + 1) xs (tail ys)

