<?php
class Counter {
    public static $count = 0;

    public static function increment() {
        self::$count++;
    }

    public static function getCount() {
        return self::$count;
    }
}

Counter::increment();
Counter::increment();
Counter::increment();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Static Properties</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: rgb(181, 247, 211);
        }
        div {
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 50%;
            display: grid;
            place-items: center;
        }
    </style>
</head>
<body>
    <div>
        <?php
            echo "Count: " . Counter::getCount() . "<br/>";

            Counter::increment();
            Counter::increment();
            
            echo "Count: " . Counter::getCount() . "<br/>";
        ?>
    </div>
</body>
</html>
