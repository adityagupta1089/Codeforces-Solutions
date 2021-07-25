import           Control.Monad
import           Control.Arrow
import           Data.List
import           System.IO
import           Data.Function
import qualified Data.Map.Strict               as Map
import qualified Data.Set                      as Set
import           Data.Maybe
-- import           Debug.Trace

-- debug = flip trace

data Point = Point {x ::Double, y:: Double}

instance Eq Point where
    p1@(Point x y) == p2@(Point x' y') = abs (x - x') < eps && abs (y - y') < eps


instance Ord Point where
    p1@(Point x y) <= p2@(Point x' y') =
        p1 == p2 || if abs (x - x') < eps then y < y' else x < x'


instance Show Point where
    show (Point x y) = "(" ++ show x ++ ", " ++ show y ++ ")"


eps :: Double
eps = 1e-5

main :: IO ()
main = do
    h         <- openFile "d.in" ReadMode
    n         <- read <$> hGetLine h
    (ps, ps') <- splitAt n <$> replicateM
        (2 * n)
        ((\[a, b] -> Point a b) . map (read :: String -> Double) . words <$> hGetLine h)
    h' <- openFile "d.out" WriteMode
    when (n == 1) $ hPrint h' 0
    when (n > 1)
        $ hPrint h'
        $ minimum
        $ catMaybes
        $ [ match (p1, p2) ps (Set.fromList ps') | p1 <- ps', p2 <- ps', p1 /= p2 ]
    hClose h'


dis :: Point -> Point -> Double
dis (Point x y) (Point x' y') =
    let dx = x' - x
        dy = y' - y
    in  dx * dx + dy * dy

move :: Double -> Double
move theta = if theta < 0 then theta + 2 * pi else theta

match :: (Point, Point) -> [Point] -> Set.Set Point -> Maybe Double
match (p1'@(Point x1' y1'), p2'@(Point x2' y2')) ps@(p1@(Point x1 y1) : p2@(Point x2 y2) : _) qs'
    = let theta = move $ atan2 (y2' - y1') (x2' - x1') - atan2 (y2 - y1) (x2 - x1)
      in  if abs (dis p1' p2' - dis p1 p2) < eps
              then match' theta (p1', p2') ps qs'
              else Nothing

rotate :: Double -> Point -> Point
rotate theta (Point x y) =
    Point (x * cos theta - y * sin theta) (x * sin theta + y * cos theta)

match' :: Double -> (Point, Point) -> [Point] -> Set.Set Point -> Maybe Double
match' theta _ [p] qs' = Just $ min theta (2 * pi - theta)
match' theta (p1'@(Point x1' y1'), p2'@(Point x2' y2')) (p1@(Point x1 y1) : p2@(Point x2 y2) : ps) qs'
    = let p3@(Point x3 y3) = head ps
          (   Point dx dy) = rotate theta $ Point (x3 - x2) (y3 - y2)
          next             = Point (x2' + dx) (y2' + dy)
          theta' = move $ atan2 (y2' - y1') (x2' - x1') - atan2 (y2 - y1) (x2 - x1)
      in  if abs (dis p1' p2' - dis p1 p2)
                 <  eps
                 && abs (theta - theta')
                 <  eps
                 && (null ps || Set.member next qs')
              then match' theta (p2', next) (p2 : ps) qs'
              else Nothing
