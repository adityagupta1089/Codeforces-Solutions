import           Control.Monad
import           Data.Array
import           Data.Maybe
import           Control.Arrow

valid (v, w) = v /= '1' || w == '1'

main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t $ do
        n   <- read <$> getLine
        mat <-
            array ((1, 1), (n, n))
            .   zip [ (i, j) | i <- [1 .. n], j <- [1 .. n] ]
            .   concat
            <$> replicateM n getLine
        putStrLn
            $ if and
                      [ (\(i, j) ->
                            ((j + 1) > n || valid
                                    (mat ! (i, j), mat ! (i, j + 1))
                                )
                                || ((i + 1) > n || valid
                                       (mat ! (i, j), mat ! (i + 1, j))
                                   )
                        )
                            (i, j)
                      | i <- [1 .. n]
                      , j <- [1 .. n]
                      ]
                  then "YES"
                  else "NO"
