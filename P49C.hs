main :: IO ()
main = do
    n <- read <$> getLine
    putStrLn . unwords . map show $ n:[1..n-1]
